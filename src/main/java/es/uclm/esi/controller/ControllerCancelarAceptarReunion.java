package es.uclm.esi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.Asistente;
import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.RepositoryReuniones;
import es.uclm.esi.security.jwt.JwtUtils;
import io.jsonwebtoken.Jwts;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/reunion")
public class ControllerCancelarAceptarReunion {
	
	@Autowired
	RepositoryReuniones rReuniones;
	
	@Autowired
	JwtUtils jwt;
	
	@Value("${siget.app.jwtSecret}")
	private String jwtSecret;
	
	
	@GetMapping("get")
    public List<Reunion> get(@RequestParam(name = "asistentes") String asistentes){
        

		List<Reunion> lista = this.rReuniones.findAll();
		
		List<Reunion> lista_aux = new ArrayList<Reunion>();
		
		for(int i = 0; i < lista.size(); i++) {
			List<Asistente> as = lista.get(i).getAsistentes();
			for(Asistente asis: as) {
				if(asis.getUsuario().equals(asistentes)) {
					lista_aux.add(lista.get(i));
				}
			}
		}
		
		
        return lista_aux;
    }
	

	@PostMapping(value = "/cancelar")
	public ResponseEntity<HttpStatus> cancelarReunion(@RequestBody Map<String, Integer> req, @RequestHeader("Authorization") String token) {
		JSONObject request = new JSONObject(req);
		Reunion reunion;
		
		reunion = rReuniones.findById(request.getInt("id"));

		String nombreOrganizadorCabecera = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token.substring(7, token.length()))
				.getBody().getSubject();

		String nombreOrganizador = reunion.getOrganizador();
		if(nombreOrganizador.equals(nombreOrganizadorCabecera)) {
			rReuniones.delete(reunion);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping(value = "/aceptar")
	public ResponseEntity<HttpStatus> aceptarReunion(@RequestBody Map<String, Integer> req, @RequestHeader("Authorization") String token) {
		return comprobacion(req, "Aceptado", token);
	}
	
	
	@PostMapping(value = "/rechazar")
	public ResponseEntity<HttpStatus> rechazarReunion(@RequestBody Map<String, Integer> req, @RequestHeader("Authorization") String token) {
		return comprobacion(req,"Rechazado",token);
	}
	
	public ResponseEntity<HttpStatus> comprobacion(Map<String, Integer> req, String estado, String token){
		boolean encontrado = false;
		JSONObject request = new JSONObject(req);
		Reunion reunion;
		reunion = rReuniones.findById(request.getInt("id"));
		String asistente = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token.substring(7, token.length())).getBody().getSubject();

		for (int i = 0; i < reunion.getAsistentes().size(); i++) {
			if (reunion.getAsistente(i).getUsuario().equals(asistente)){
				reunion.getAsistente(i).setEstado(estado);
				encontrado = true;
				rReuniones.save(reunion);
			}
		}
		
		if(encontrado) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
	}
	



}