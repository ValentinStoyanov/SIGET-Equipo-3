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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RolesStepDefinitions {
	
	ResponseEntity<String> response;

	Map<String, String> params = new HashMap<String, String>();
	Integer codigo;
	HttpHeaders headers = new HttpHeaders();
	
	@Given("mostrar el rol que tiene el usuario dentro de la aplicacion")
	public void mostrar_el_rol_que_tiene_el_usuario_dentro_de_la_aplicacion() {
	    
	}

	@When("accedo al calendario personal con el token de usuario {string}")
	public void accedo_al_calendario_personal_con_el_token_de_usuario(String string) {
		headers.set("Authorization", "Bearer " + string);
	}

	@When("muestro el tipo de {string} que posee dicho usuario")
	public void muestro_el_tipo_de_que_posee_dicho_usuario(String string) {
	    
	}

	@Then("muestro el codigo {int}")
	public void muestro_el_codigo(Integer int1) {
		assertEquals(int1, codigo);
	}
	
	
}
