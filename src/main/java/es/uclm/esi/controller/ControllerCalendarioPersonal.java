package es.uclm.esi.controller;

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
		//System.out.println("Pues mira me ha llegao esto: "+ jso);
		JSONObject jsoret = new JSONObject();
		jsoret.put("mes", 11);
		jsoret.put("ano",2020);
		int[] dias = {05,12,17,21,26};
		jsoret.put("reuniones", dias);
		
		System.out.println(calendarioRepository.findById(1).getTitulo());
		
        return jsoret.toString();
    }
	
	@PostMapping("/getDetallesReunion")
    public String getDetallesReunion(@RequestBody Map<String, Object> entrada){
		JSONObject jso=new JSONObject(entrada);
		//System.out.println("Pues mira me ha llegao esto: "+ jso);
		String[] asistentes = {"Jesus Cabanero","Victor Ramirez","German Rolando","Fatima Sanchez","Angel Villaseñor","Edilberto Pozo"};
		JSONObject jsoret = new JSONObject();
		jsoret.put("dia", 26);
		jsoret.put("mes", 11);
		jsoret.put("ano", 2020);
		
		JSONArray jsa = new JSONArray();	
		JSONObject Inforeu1 = new JSONObject();
		JSONObject Inforeu2 = new JSONObject();
		JSONObject Inforeu3 = new JSONObject();
		
		Inforeu1.put("titulo", "Frontend");
		Inforeu1.put("id", 1);
		Inforeu1.put("hora", "11:30");
		Inforeu1.put("duracion", 90);
		Inforeu1.put("asistentes", asistentes);
		Inforeu1.put("descripcion", "Una reunion para determinar el diseno del frontend"); 
		
		Inforeu2.put("titulo", "Daily");
		Inforeu2.put("id", 2);
		Inforeu2.put("hora", "22:00");
		Inforeu2.put("duracion", 15);
		Inforeu2.put("asistentes", asistentes);
		Inforeu2.put("descripcion", "Reunion daily para comentar el estado del proyecto");
		
		Inforeu3.put("titulo", "Revisión del sprint");
		Inforeu3.put("id", 3);
		Inforeu3.put("hora", "16:50");
		Inforeu3.put("duracion", 120);
		Inforeu3.put("asistentes", asistentes);
		Inforeu3.put("descripcion", "Reunion para ver los resultados del sprint");
		
		jsa.put(Inforeu1);
		jsa.put(Inforeu2);
		jsa.put(Inforeu3);
		
		jsoret.put("reuniones", jsa);
		
		//System.out.println(jsoret);
		
        return jsoret.toString();
    }
	
	

}
