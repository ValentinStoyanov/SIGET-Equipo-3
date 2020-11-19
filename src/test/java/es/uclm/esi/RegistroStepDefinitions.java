package es.uclm.esi;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import es.uclm.esi.payload.request.CalendarioDiaRequest;
import es.uclm.esi.payload.request.CalendarioMesRequest;
import es.uclm.esi.payload.request.SignupRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistroStepDefinitions extends SpringIntegrationTest {

	ResponseEntity<String> response;
	SignupRequest request;
	boolean borrar = false;

	@When("registro un usuario con usuario {string}, pass {string} y email {string}")
	public void registro_un_usuario_con_usuario_pass_y_email(String string, String string2, String string3) {
	    request = new SignupRequest();
	    request.setUsername(string);
	    request.setPassword(string2);
	    request.setEmail(string3);
	}

	@When("{string} es nuevo para borrarlo")
	public void es_nuevo_para_borrarlo(String string) {
	    if(string.toLowerCase().equals("si"))
	    	borrar = true;
	}
	@Then("el mensaje sera {string}")
	public void el_mensaje_sera(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}