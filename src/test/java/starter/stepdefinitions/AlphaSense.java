package starter.stepdefinitions;

import com.pojos.PojoAlphaSense;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class AlphaSense {
    public Response response;
    Logger log = LogManager.getLogger(AlphaSenseDefinitioins.class);
    String baseURI;
    PojoAlphaSense pojoAlphaSense;
    List<PojoAlphaSense> keyword;
    private EnvironmentVariables environmentVariables;

    public String getBaseUri() {
        log.info("executing getBaseURI method");
        baseURI = "https://rc.alpha-sense.com/doc/PR-386ea743f2a90399fb0e4300ddf37d0697abc743t";
        log.info("baseURI [" + baseURI + "]");
        return baseURI;
    }


    @Step
    public void searchKeyword() {
        log.info("executing send request to AlphaSense Document Viewer ");
        RestAssured.defaultParser = Parser.JSON;
        response = (Response) SerenityRest

                .given()
                .contentType("application/json\r\n")
                .accept(ContentType.JSON)
                .header("Content-type", "application/json; charset=utf-8")
                .header("cache-control", "no-cache")
                .param("keyword", "AlphaSense")
                .param("slop", "15")
                .param("positiveOnly", "false")
                .param("negativeOnly", "false")
                .param("released", "1633003200000")
                .when()
                .get(getBaseUri());

//           Type type = new TypeReference<List<PojoAlphaSense>>(){}.getType();
//           List<PojoAlphaSense> pojo;
//           pojo = response.as(type);

    }


    @Step
    public void getStatusCode(int statuscode) {
        log.info("validating searchAlphaSense status code");
        log.info("Status code [" + statuscode + "]");
        restAssuredThat(response -> response.statusCode(statuscode));
    }

    @Step
    public void validateResponse() {
        log.info("displaying the response");
        restAssuredThat(response -> response.body("AlphaSense", notNullValue()));
    }


}

