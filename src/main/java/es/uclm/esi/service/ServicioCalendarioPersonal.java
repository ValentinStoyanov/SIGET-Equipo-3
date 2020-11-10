package es.uclm.esi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.RepositoryCalendarioPersonal;
import es.uclm.esi.security.jwt.JwtUtils;

/**
 * 
 * @author Víctor
 * Clase para gestionar la petición del controlador (obtener calendario personal) 
 */
public class ServicioCalendarioPersonal {
	@Autowired
	private RepositoryCalendarioPersonal rcp;
	JwtUtils jwt;
	
	/**
	 * 
	 * @param mes
	 * @param ano
	 * @return JSONObject con todos los numeros de dia que haya reunion ese mes
	 */
	public JSONObject getCalendarioPersonalMes(String token, int mes, int ano) {
		JSONObject calendario = new JSONObject();
		List<Reunion> reuniones = new ArrayList<Reunion>();
		reuniones = rcp.findAll();
		/*
		Iterator<Reunion> it = reuniones.iterator();
		 
		while (it.hasNext()) {
			System.out.println(it.next()); //Así debería funcionar, supongo, no?
		}*/
		return calendario;
	}

	
	/**
	 * 
	 * @param dia
	 * @return JSONObject con informacion detallada de todas las reuniones de ese dia
	 */
	public JSONObject getDetallesReunion(int dia) {
		List<Reunion> reuniones = rcp.findAll();
		JSONObject reunionesDia = new JSONObject();
		ArrayList<JSONObject> objetosReunion = new ArrayList<JSONObject>();
		reunionesDia.put("dia", dia);
		for(int i=0; i<reuniones.size(); i++) {
			if(reuniones.get(i).getDia()==dia) {
				JSONObject detallesReunion = new JSONObject(); 
				detallesReunion.put("id", reuniones.get(i).getId());
				detallesReunion.put("titulo", reuniones.get(i).getTitulo());
				detallesReunion.put("dia", reuniones.get(i).getDia());
				detallesReunion.put("mes", reuniones.get(i).getMes());
				detallesReunion.put("ano", reuniones.get(i).getAno());
				detallesReunion.put("hora", reuniones.get(i).getHora());
				detallesReunion.put("asistentes", reuniones.get(i).getAsistentes());
				objetosReunion.add(detallesReunion);
			}
		}
		reunionesDia.put("reuniones", objetosReunion);
		return reunionesDia;
	}
}
