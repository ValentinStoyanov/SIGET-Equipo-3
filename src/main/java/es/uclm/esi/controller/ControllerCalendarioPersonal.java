package es.uclm.esi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.repository.RepositoryCalendarioPersonal;
import es.uclm.esi.repository.UserRepository;

/**
 * 
 * @author Víctor
 * Clase para recepción de mensajes http relacionados con obtener el calendario personal
 */
@RestController
public class ControllerCalendarioPersonal {
	
	@Autowired
	RepositoryCalendarioPersonal calendarioRepository;

	@PostMapping("/getCalendarioPersonalMes")
    public String getCalendarioPersonalMes(@RequestBody Map<String, Object> entrada){
		JSONObject jso=new JSONObject(entrada);
		System.out.println("Pues mira me ha llegao esto: "+ jso);
		int mespeticion = jso.getInt("mes");
		int anopeticion = jso.getInt("ano");

		ArrayList<Integer> dias = new ArrayList<Integer>();
		try {
			int wid = 1;
			while (calendarioRepository.findById(wid).getMes() == mespeticion) {
				dias.add(calendarioRepository.findById(wid).getDia());
				wid++;
			}
		} catch (Exception e) {}
		JSONObject jsoret = new JSONObject();
		
		int[] diasjson = new int[dias.size()];
		for(int i = 0; i < dias.size(); i++) {
			diasjson[i] = dias.get(i);
		}

		jsoret.put("dias", diasjson);
		jsoret.put("mes", calendarioRepository.findById(jso.getInt("mes")==calendarioRepository.findById(1).getMes()? 1 : 2).getMes());
		jsoret.put("ano", calendarioRepository.findById(1).getAno());
		
        return jsoret.toString();
    }
	
	@PostMapping("/getDetallesReunion")
    public String getDetallesReunion(@RequestBody Map<String, Object> entrada){
		JSONObject jso=new JSONObject(entrada);
		System.out.println("Pues mira me ha llegao esto: "+ jso);
		JSONObject jsoret = new JSONObject();
		jsoret.put("titulo", calendarioRepository.findById(1));

		
        return calendarioRepository.findById(1).getTitulo();
    }
	
	

}
