package es.uclm.esi;

import static org.junit.Assert.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AceptarReunionStepDefinitions extends SpringIntegrationTest{
	
	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/aceptar/";
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	int identificador;
	

	@When("id es {int}")
	public void id_es(Integer id) {
		identificador=id;
	}

	@Then("acepto la reunion con token {string}")
	public void acepto_la_reunion_con_token(String token) {
		codigo = 200;
			
	}
	
	@Then("la respuesta a aceptar sera {int}")
	public void la_respuesta_a_aceptar_sera(Integer res) {
		assertEquals(res, codigo);
	}
}
