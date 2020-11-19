package es.uclm.esi;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException;

import es.uclm.esi.security.jwt.JwtUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CancelarReunionStepDefinitions extends SpringIntegrationTest {
	
	ResponseEntity<String> response;
	String url = DEFAULT_URL + "reunion/cancelar/";
	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	Integer idReunion;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@When("selecciono la reunion con id {int}")
	public void selecciono_la_reunion_con_id(Integer int1) {
//	   idReunion = int1;
	}

	@Then("cancelo la reunion")
	public void cancelo_la_reunion() {
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken("admin","Admin123"));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		String token = jwtUtils.generateJwtToken(authentication);
//		headers.set("Authorization", "Bearer " + token);
//		HttpEntity<Integer> request = new HttpEntity<>(idReunion, headers);
//		try {
//			response = restTemplate.postForEntity(url, request, String.class);
//			codigo = response.getStatusCode().value();
//		} catch (HttpClientErrorException e) {
//			codigo = e.getRawStatusCode();
//		}

	}
	
	@Then("la respuesta debe ser {int}")
	public void la_respuesta_sera(Integer res) {
//		assertEquals(res, codigo);

	}

}
