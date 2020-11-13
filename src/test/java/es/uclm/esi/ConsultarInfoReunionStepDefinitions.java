package es.uclm.esi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConsultarInfoReunionStepDefinitions {

	@Given("el usuario quiere ver la información de la reunion seleccionada")
	public void el_usuario_quiere_ver_la_información_de_la_reunion_seleccionada() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("el titulo de la reunion es {string}")
	public void el_titulo_de_la_reunion_es(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("la hora de la reunion es {string}")
	public void la_hora_de_la_reunion_es(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("los asistentes son {string},{string}")
	public void los_asistentes_son(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("los asistentes son {string}")
	public void los_asistentes_son(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

}