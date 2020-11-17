package es.uclm.esi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.RepositoryReuniones;
import es.uclm.esi.security.jwt.JwtUtils;

@RestController
public class ControllerConvocarReunion {
	
	@Autowired
	RepositoryReuniones rReuniones;
	
	@PostMapping("/convocar")
	public ResponseEntity<?> convocarReunion(@RequestBody HttpEntity<Reunion> entity) {

		JwtUtils jwt = new JwtUtils();
		System.out.println("/CONVOCAR");
		String nombre_organizador = jwt.getUserNameFromJwtToken(entity.getHeaders().get("Autorization").get(0));
		Reunion reunion = entity.getBody();
		
		reunion.setOrganizador(nombre_organizador);
		reunion.setId(9);
		
		//rReuniones.save(reunion);
		
		return ResponseEntity.ok("ok");
	}

}
