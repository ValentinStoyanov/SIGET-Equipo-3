package es.uclm.esi;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import es.uclm.esi.model.Reunion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CancelarReunionStepDefinitions extends SpringIntegrationTest {
	
	@Autowired
	//RepositoryReuniones rReuniones;
	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/cancelar/";
	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	Reunion reu;
	
	
	
	
	@When("organizador es {string}")
	public void organizador_es(String organizador) {
		String org = reu.getOrganizador();
		organizador.equals(org);
	}
	
	@Then("cancelo la reunion con token {string}")
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
