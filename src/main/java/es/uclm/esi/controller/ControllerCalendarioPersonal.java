package es.uclm.esi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.Asistente;
import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.RepositoryCalendarioPersonal;

/**
 * 
 * @author Víctor Clase para recepción de mensajes http relacionados con obtener
 *         el calendario personal
 */
@RestController
public class ControllerCalendarioPersonal {

	@Autowired
	RepositoryCalendarioPersonal calendarioRepository;

	
//	@GetMapping("/pruebaConsulta")
//	public String getPrueba() {
//		
//		List<Reunion> reuniones = calendarioRepository.findReunionesMes(12, 2020);
//
//		return reuniones.toString();
//	}
	@PostMapping("/getCalendarioPersonalMes")
	public String getCalendarioPersonalMes(@RequestBody Map<String, Object> entrada) {
		JSONObject jso = new JSONObject(entrada);
		int mespeticion = jso.getInt("mes");
		int anopeticion = jso.getInt("ano");
		String usuario = jso.getString("usuario");
		List<Reunion> reuniones = calendarioRepository.findReunionesMes(mespeticion, anopeticion);
		ArrayList<Integer> dias = new ArrayList<Integer>();
		int dia;
		Asistente[] asistentes;
		//Hay que controlar que no exista usuario porque no se haya pasado el token o cualquier tipo de error
		for (Reunion reunion : reuniones) {
			asistentes = reunion.getAsistentes();
			for (Asistente asistente : asistentes) {
				if(asistente.getUsuario().equalsIgnoreCase(usuario)) { //No es la mejor forma comparar por nombre de usuario, mejor DNI
					dia = reunion.getDia();
					if(!dias.contains(dia)) {
						dias.add(dia);
					}
				}
			}
		}
		JSONObject jsoret = new JSONObject();

		int[] diasjson = new int[dias.size()];
		for (int i = 0; i < dias.size(); i++) {
			diasjson[i] = dias.get(i);
		}
		
		jsoret.put("reuniones", diasjson);
		jsoret.put("mes", mespeticion);
		jsoret.put("ano", anopeticion);
		
		System.out.println("Estoy enviando "+jsoret);
		
		return jsoret.toString();
	}

	@PostMapping("/getDetallesReunion")
	public String getDetallesReunion(@RequestBody Map<String, Object> entrada) {
		JSONObject jso = new JSONObject(entrada);		
		JSONObject jsoret = new JSONObject();
		JSONArray jsa = new JSONArray();
		JSONObject jsoreunion = new JSONObject();
		
		List<Reunion> reuniones = calendarioRepository.findByDia(jso.getInt("dia"),jso.getInt("mes"),jso.getInt("ano"));
		Asistente[] asistentes;
		int contadorReuniones = 1;
		for (Reunion reunion : reuniones) {
			asistentes = reunion.getAsistentes();
			for (Asistente asistente : asistentes) {
				if (asistente.getUsuario().equalsIgnoreCase(jso.getString("usuario"))) {
					jsoreunion.put("titulo", reunion.getTitulo());
					jsoreunion.put("id", contadorReuniones);
					jsoreunion.put("hora", reunion.getHora());
					jsoreunion.put("asistentes", asistentes);
					jsoreunion.put("descripcion", reunion.getDescripcion());
					jsa.put(jsoreunion);
					contadorReuniones++;
				}
			}
		}
		
		jsoret.put("dia", jso.getInt("dia"));
		jsoret.put("mes", jso.getInt("mes"));
		jsoret.put("ano", jso.getInt("ano"));
		jsoret.put("reuniones", jsa);
		System.out.println("Me ha llegado esto "+jso);
		System.out.println("Estoy enviando "+jsoret);
		return jsoret.toString();
	}

}
