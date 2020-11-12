package es.uclm.esi.controller;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/getCalendarioPersonalMes")
	public String getCalendarioPersonalMes(@RequestBody Map<String, Object> entrada) {
		JSONObject jso = new JSONObject(entrada);
		System.out.println("Pues mira me ha llegao esto: " + jso);
		int mespeticion = jso.getInt("mes");
		int anopeticion = jso.getInt("ano");

		ArrayList<Integer> dias = new ArrayList<Integer>();
		try {
			int wid = 1;
			while (calendarioRepository.findById(wid).getMes() == mespeticion) {
				dias.add(calendarioRepository.findById(wid).getDia());
				wid++;
			}
		} catch (Exception e) {
		}
		JSONObject jsoret = new JSONObject();

		int[] diasjson = new int[dias.size()];
		for (int i = 0; i < dias.size(); i++) {
			diasjson[i] = dias.get(i);
		}

		jsoret.put("reuniones", diasjson);
		jsoret.put("mes", mespeticion);
		jsoret.put("ano", anopeticion);
		
		System.out.println("Estoy enviando esto "+jsoret);
		
		return jsoret.toString();
	}

	@PostMapping("/getDetallesReunion")
	public String getDetallesReunion(@RequestBody Map<String, Object> entrada) {
		JSONObject jso = new JSONObject(entrada);
		System.out.println("Pues mira me ha llegao esto: " + jso);
		
		JSONObject jsoret = new JSONObject();
		JSONArray jsa = new JSONArray();
		JSONObject jsoreunion = new JSONObject();
		
		try {
			int contadorReuniones = 1;
			int wid = 1;
			while (wid>0) {
				if (calendarioRepository.findById(wid).getDia() == jso.getInt("dia")
						&& calendarioRepository.findById(wid).getMes() == jso.getInt("mes")) {
					jsoreunion.put("titulo", calendarioRepository.findById(wid).getTitulo());
					jsoreunion.put("id", contadorReuniones);
					jsoreunion.put("hora", calendarioRepository.findById(wid).getHora());
					jsoreunion.put("asistentes", calendarioRepository.findById(wid).getAsistentes());
					jsoreunion.put("descripcion", calendarioRepository.findById(wid).getDescripcion());
					jsa.put(jsoreunion);
					contadorReuniones++;
				} 
				wid++;
			}
		} catch (Exception e) {}
		
		jsoret.put("dia", jso.getInt("dia"));
		jsoret.put("mes", jso.getInt("mes"));
		jsoret.put("ano", jso.getInt("ano"));
		jsoret.put("reuniones", jsa);
		
		System.out.println("Estoy enviando "+jsoret);
		
		return jsoret.toString();
	}

}
