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
	
	
	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/cancelar/";
	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	Integer idReunion;
	
	
	@When("seleciono la reunion con id {int}")
	public void seleciono_la_reunion_con_id(Integer int1) {
	   idReunion = int1;
	}

	@Then("cancelo la reunion con token {string}")
	public void cancelo_la_reunion(String token) {
		//controller /reunion/cancelar 
		headers.set("Autorization", "Bearer " + token);
		HttpEntity<Integer> request = new HttpEntity<>(idReunion, headers);
		try {
			response = restTemplate.postForEntity(url, request, String.class);
			codigo = response.getStatusCode().value();
		} catch (HttpClientErrorException e) {
			codigo = e.getRawStatusCode();
		}

	}
	
	@Then("la respuesta debe ser {int}")
	public void la_respuesta_debe_ser(Integer res) {
		assertEquals(res, codigo);

	}

}
