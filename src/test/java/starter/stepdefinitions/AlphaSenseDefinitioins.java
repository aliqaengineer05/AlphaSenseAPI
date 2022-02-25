package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;


public class AlphaSenseDefinitioins {

    @Steps
    AlphaSense alphaSense;

    @Given("I send a request to endpoint")
    public void i_send_a_request_to_endpoint() {
        alphaSense.searchKeyword();
    }

    @Then("The api should return status {int}")
    public void the_api_should_return_status(int statuscode) {
        alphaSense.getStatusCode(statuscode);
    }

    @Then("I display the response")
    public void i_display_the_response() {
        alphaSense.validateResponse();
    }

}
