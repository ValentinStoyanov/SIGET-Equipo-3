package es.uclm.esi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ControllerConvocarReunion {
	
	@Autowired
	RepositoryReuniones rReuniones;
	
	@Autowired
	JwtUtils jwt;
	
	@Value("${siget.app.jwtSecret}")
	private String jwtSecret;
	
	@PostMapping(value="/convocar")
	public ResponseEntity<String> convocarReunion(@RequestBody Reunion reunion, @RequestHeader("Authorization") String token) {
		System.out.println(token);
		
		String nombre_organizador = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token.substring(7, token.length())).getBody().getSubject();
		System.out.println("USER: " + nombre_organizador);
		
		reunion.setOrganizador(nombre_organizador);
		reunion.setId(last());
		
		rReuniones.save(reunion);

		return ResponseEntity.ok("ok");
	}
	
	public int last() {
		Reunion reun;
		reun=rReuniones.findFirstByOrderByIdDesc();
		return reun.getId()+1;
	}

}
