package es.uclm.esi.controller;



import java.util.GregorianCalendar;

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
public class ControllerConvocarReunion {
	
	@Autowired
	RepositoryReuniones rReuniones;
	
	@Autowired
	JwtUtils jwt;
	
	@Value("${siget.app.jwtSecret}")
	private String jwtSecret;

	@PostMapping(value = "/convocar")
	public ResponseEntity<?> convocarReunion(@RequestBody Reunion reunion,
			@RequestHeader("Authorization") String token) {
		String nombreOrganizador = Jwts.parser().setSigningKey(jwtSecret)
				.parseClaimsJws(token.substring(7, token.length())).getBody().getSubject();
		reunion.setOrganizador(nombreOrganizador);
		reunion.setId(last());
		reunion.setEstado("pendiente");
		if (filtroRestricciones(reunion)) {
			rReuniones.save(reunion);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public int last() {
		Reunion reun;
		reun=rReuniones.findFirstByOrderByIdDesc();
		return reun.getId()+1;
	}
	
	//FILTROS
	public boolean filtroRestricciones(Reunion reunion) {
		boolean ok=true;
		if(reunion.getTitulo().equals("")) {
			ok=false;
		}
		if(reunion.getDia() <1 || reunion.getDia() > numeroDias(reunion)) {
			ok=false;
		}
		if(reunion.getMes() <1 || reunion.getMes()>12) {
			ok=false;
		}
		if(reunion.getAno() < 2020) { 
			ok=false;
		}
		if(reunion.getHora().equals("")) { 
			ok=false;
		}
		if(reunion.getDescripcion().equals("")) { 
			ok=false;
		}
		if(reunion.getAsistentes() == null) { 
			ok=false;
		}
		return ok;
	}
	
	public int numeroDias(Reunion reunion) {
		int numeroDias = 0;
		int anioActual;
		switch (reunion.getMes()) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				numeroDias = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				numeroDias = 30;
				break;
			case 2:
				anioActual = reunion.getAno();
				if (esBisiesto(1900 + anioActual)) {
					numeroDias = 29;
				} else {
					numeroDias = 28;
				}
				break;
			default:
				break;
			}

		return numeroDias;
	}

	public static boolean esBisiesto(int anio) {

		GregorianCalendar calendar = new GregorianCalendar();
		boolean esBisiesto = false;
		if (calendar.isLeapYear(anio)) {
			esBisiesto = true;
		}
		return esBisiesto;

	}

}
