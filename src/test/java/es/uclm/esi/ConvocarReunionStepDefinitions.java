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
import es.uclm.esi.repository.RepositoryReuniones;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConvocarReunionStepDefinitions extends SpringIntegrationTest{

	@Autowired
	RepositoryReuniones rReuniones;
	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/convocar/";
	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	Reunion reu;
	Asistente[] arrayAsistentes;
	int numReunion;
	
@Given("el organizador quiere convocar una reunion")
public void el_organizador_quiere_convocar_una_reunion() {
    throw new io.cucumber.java.PendingException();
}

@When("convoco la reunion {int} con token {string}")
public void convoco_la_reunion(Integer int1, String token) {
	numReunion = int1;
	
	rReuniones.save(reu);
	
	headers.set("Autorization", "Bearer " + token);
	
    throw new io.cucumber.java.PendingException();
}

@When("organizador es {string}")
public void organizador_es(String organizador) {
    reu.setOrganizador(organizador);
    throw new io.cucumber.java.PendingException();
}

@When("titulo es {string}")
public void titulo_es(String titulo) {
    reu.setTitulo(titulo);
    throw new io.cucumber.java.PendingException();
}

@When("estado es {string}")
public void estado_es(String estado) {
	reu.setEstado(estado);
    throw new io.cucumber.java.PendingException();
}

@When("dia es {int}")
public void dia_es(Integer dia) {
	reu.setDia(dia);
    throw new io.cucumber.java.PendingException();
}

@When("mes es {int}")
public void mes_es(Integer mes) {
	reu.setMes(mes);
    throw new io.cucumber.java.PendingException();
}

@When("ano es {int}")
public void ano_es(Integer ano) {
	reu.setAno(ano);
    throw new io.cucumber.java.PendingException();
}

@When("hora es {String}")
public void hora_es(String hora) {
	reu.setHora(hora);
    throw new io.cucumber.java.PendingException();
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
    throw new io.cucumber.java.PendingException();
}

@Then("la respuesta sera {int}")
public void la_respuesta_sera(Integer res) {
	HttpEntity<Reunion> request = new HttpEntity<>(reu, headers);
	try {
		response = restTemplate.postForEntity(url, request, String.class);
		codigo = response.getStatusCode().value();
	} catch (HttpClientErrorException e) {
		codigo = e.getRawStatusCode();
	}
	assertEquals(res, codigo);
    throw new io.cucumber.java.PendingException();
}

}
