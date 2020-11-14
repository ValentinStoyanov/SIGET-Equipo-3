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
import es.uclm.esi.repository.RepositoryReuniones;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CancelarReunionStepDefinitions extends SpringIntegrationTest {
	
	@Autowired
	RepositoryReuniones rReuniones;
	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/cancelar/";
	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	Reunion reu;
	int numReunion;
	
	
	
	@Given("el organizador quiere cancelar una reunion")
	public void el_organizador_quiere_cancelar_una_reunion() {
	    throw new io.cucumber.java.PendingException();
	}

	@When("cancelo la reunion {int} con token <token>")
	public void cancelo_la_reunion_con_token_token(Integer int1, String token) {
		numReunion = int1;
		rReuniones.delete(reu);
		headers.set("Autorization", "Bearer " + token);
	}

	@When("organizador es {string}")
	public void organizador_es(String organizador) {
		String org = reu.getOrganizador();
		organizador.equals(org);
	}

	@Then("la respuesta sera {int}")
	public void la_respuesta_sera(Integer int1) {
		HttpEntity<Reunion> request = new HttpEntity<>(reu, headers);
		try {
			response = restTemplate.postForEntity(url, request, String.class);
			codigo = response.getStatusCode().value();
		} catch (HttpClientErrorException e) {
			codigo = e.getRawStatusCode();
		}
		assertEquals(int1, codigo);
	}

}
