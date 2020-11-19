package es.uclm.esi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.RepositoryReuniones;
import es.uclm.esi.security.jwt.JwtUtils;
import io.jsonwebtoken.Jwts;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/reunion")
public class ControllerCancelarReunion {
	
	@Autowired
	RepositoryReuniones rReuniones;
	
	@Autowired
	JwtUtils jwt;
	
	@Value("${siget.app.jwtSecret}")
	private String jwtSecret;

	@PostMapping(value = "/cancelar")
	public ResponseEntity<?> cancelarReunion(@RequestBody Integer idreunion, @RequestHeader("Authorization") String token) {
		Reunion reunion;
		reunion = rReuniones.findById(idreunion);
		String nombreOrganizador = reunion.getOrganizador();
		String nombreOrganizadorCabecera = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token.substring(7, token.length())).getBody().getSubject();
		
		if(nombreOrganizador.equals(nombreOrganizadorCabecera)) {
			rReuniones.delete(reunion);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}



}