package es.uclm.esi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import es.uclm.esi.model.Asistente;
import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.RepositoryCalendarioPersonal;
import es.uclm.esi.repository.RoleRepository;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModificarReunionStepDefinitions extends SpringIntegrationTest {
	
	@Autowired
	RepositoryCalendarioPersonal rcp;
    ResponseEntity<String> response ;
    String url = DEFAULT_URL + "reunion/modificar/";
    Map<String, String> params = new HashMap<String, String>();
    Integer codigo;
    HttpHeaders headers = new HttpHeaders();
    Reunion reu;
    Asistente[] arrayAsistentes;
    
    @When("Modifico la reunion {int} con el token de usuario {string}")
    public void modifico_la_reunion_con_el_token_de_usuario(Integer int1, String string) {
    	Optional<Reunion> r = rcp.findById(int1.toString());
    	
    	if(r.isPresent()) reu = r.get();
    	else reu = new Reunion();
    	headers.set ("Autorization", "Bearer " + string);	
    	
    }

    @When("cambio el titulo a {string}")
    public void cambio_el_titulo_a(String string) {
    	if(!string.equals("")) {
    		reu.setTitulo(string);
    	}
        
    }
    @When("cambio la fecha a {string}")
    public void cambio_la_fecha_a(String string) {
    	if(!string.equals("")) {
        try {
        	reu.setDia(Integer.parseInt(string.substring(0, 2)));
        	reu.setMes(Integer.parseInt(string.substring(3, 5)));
        	reu.setAno(Integer.parseInt(string.substring(6, 10)));
        	
        }catch(Exception e) {}
    	}
    }
    @When("cambio la hora a {string}")
    public void cambio_la_hora_a(String string) {
    	if(!string.equals("")) {
    	try {
        	reu.setHora(string);
        }catch(Exception e) {}
    	}
    }
    @When("cambio los asistentes a {string}")
    public void cambio_los_asistentes_a(String string) {
    	if(!string.equals("")) {
    		String[] arrayNombresAsistentes = string.split(",");
    		
    		arrayAsistentes = new Asistente[arrayNombresAsistentes.length];
    		for (int i = 0; i < arrayAsistentes.length; i++) {
    			String[] asistente =arrayNombresAsistentes[i].split(":");
    			arrayAsistentes[i].setUsuario(asistente[0]);
    			arrayAsistentes[i].setEstado(asistente[1]);
			}
    	}
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