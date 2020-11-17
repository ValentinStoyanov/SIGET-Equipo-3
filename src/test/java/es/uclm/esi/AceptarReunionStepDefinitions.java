package es.uclm.esi;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AceptarReunionStepDefinitions extends SpringIntegrationTest{
	
	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/aceptar/";
	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	int identificador;

	@When("id es {int}")
	public void id_es(Integer id) {
		identificador=id;
	}

	@Then("acepto la reunion con token {string}")
	public void acepto_la_reunion_con_token(String token) {
		headers.set("Autorization", "Bearer " + token);
		
		HttpEntity<Integer> request = new HttpEntity<>(identificador, headers);
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
