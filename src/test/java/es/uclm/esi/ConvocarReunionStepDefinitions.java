package es.uclm.esi;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import es.uclm.esi.model.Asistente;
import es.uclm.esi.model.Reunion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConvocarReunionStepDefinitions extends SpringIntegrationTest{

	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/convocar/";
	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	Reunion reu = new Reunion();
	Asistente[] arrayAsistentes;

@When("titulo es {string}")
public void titulo_es(String titulo) {
    reu.setTitulo(titulo);

}

@When("estado es {string}")
public void estado_es(String estado) {
	reu.setEstado(estado);

}

@When("dia es {int}")
public void dia_es(Integer dia) {
	reu.setDia(dia);

}

@When("mes es {int}")
public void mes_es(Integer mes) {
	reu.setMes(mes);

}

@When("ano es {int}")
public void ano_es(Integer ano) {
	reu.setAno(ano);

}

@When("hora es {string}")
public void hora_es(String hora) {
	reu.setHora(hora);

}

@When("descripcion es {string}")
public void descripcion_es(String descripcion) {
	reu.setDescripcion(descripcion);

}

@When("asistentes son {string}")
public void asistentes_son(String cadena) {
	if (!cadena.equals("")) {
		String[] arrayNombresAsistentes = cadena.split(",");

		arrayAsistentes = new Asistente[arrayNombresAsistentes.length];
		for (int i = 0; i < arrayAsistentes.length; i++) {
			String[] asistente = arrayNombresAsistentes[i].split(":");
			
			arrayAsistentes[i] = new Asistente(asistente[0],asistente[1]);
		}
	}
	
	reu.setAsistentes(arrayAsistentes);

}

@Then("convoco la reunion con token {string}")
public void convoco_la_reunion(String token) {
	
	headers.set("Autorization", "Bearer " + token);
	
	HttpEntity<Reunion> request = new HttpEntity<>(reu, headers);
	try {
		response = restTemplate.postForEntity(url, request, String.class);
		codigo = response.getStatusCode().value();
	} catch (HttpClientErrorException e) {
		codigo = e.getRawStatusCode();
	}

}

@Then("la respuesta sera {int}")
public void la_respuesta_sera(Integer res) {
	assertEquals(res, codigo);

}

}
