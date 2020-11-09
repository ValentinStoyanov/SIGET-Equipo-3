package es.uclm.esi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModificarReunionStepDefinitions extends SpringIntegrationTest {
	 
    ResponseEntity<String> response ;
    String url = DEFAULT_URL + "reunion/modificar/";
    Map<String, String> params = new HashMap<String, String>();
    Integer codigo;
    
    
    @When("Modifico la reunion {int} con el token de usuario {string}")
    public void modifico_la_reunion_con_el_token_de_usuario(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("cambio el titulo a {string}")
    public void cambio_el_titulo_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("cambio la fecha a {string}")
    public void cambio_la_fecha_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("cambio la hora a {string}")
    public void cambio_la_hora_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("cambio los asistentes a {string}")
    public void cambio_los_asistentes_a(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("la repuesta sera {int}")
    public void la_repuesta_sera(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("el nuevo titulo sera {string}")
    public void el_nuevo_titulo_sera(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("la nueva fecha sera {string}")
    public void la_nueva_fecha_sera(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("la nueva hora sera {string}")
    public void la_nueva_hora_sera(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("los nuevos asistentes seran {string}")
    public void los_nuevos_asistentes_seran(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
    
    
}