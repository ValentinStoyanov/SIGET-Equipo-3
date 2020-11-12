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
		System.out.println("Pues mira me ha llegao esto: "+ jso);
		System.out.println(calendarioRepository.findById(1).getTitulo());
		
        return calendarioRepository.findById(1).getTitulo();
    }
	
	@PostMapping("/getDetallesReunion")
    public String getDetallesReunion(@RequestBody Map<String, Object> entrada){
		JSONObject jso=new JSONObject(entrada);
		System.out.println("Pues mira me ha llegao esto: "+ jso);

		
        return calendarioRepository.findById(1).getTitulo();
    }
	
	

}
