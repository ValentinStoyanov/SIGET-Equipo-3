package es.uclm.esi;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PruebaStepDefinitions extends SpringIntegrationTest {
	 
    String response = "";
    String url = DEFAULT_URL + "tareas/saludo/";
    @When("the client calls {string}")
    public void the_client_calls(String string) {
    	response = restTemplate.getForObject(url, String.class);
    }



    @Then("the client receives answer as {string}")
    public void the_client_receives_answer_as(String string) {
    	assertEquals(string, response);
    }
    
 
//    @When("the client calls \\/calc\\/sub with values {int} and {int}")
//    public void the_client_calls_calc_sub_with_values_and(Integer int1, Integer int2) {
//        response = restTemplate.getForObject(url + "sub?a=" +
//                int1 + "&b=" + int2, Integer.class);
//    }
// 
//    @When("the client calls \\/calc\\/mul with values {int} and {int}")
//    public void the_client_calls_calc_mul_with_values_and(Integer int1, Integer int2) {
//        response = restTemplate.getForObject(url + "mul?a=" +
//                int1 + "&b=" + int2, Integer.class);
//    }
// 
//    @When("the client calls \\/calc\\/div with values {int} and {int}")
//    public void the_client_calls_calc_div_with_values_and(Integer int1, Integer int2) {
//        response = restTemplate.getForObject(url + "div?a=" +
//                int1 + "&b=" + int2, Integer.class);
//    }
}