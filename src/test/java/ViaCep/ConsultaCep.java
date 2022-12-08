package ViaCep;

import TestBase.TestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ConsultaCep extends TestBase{

    @Test
    public void consultaCep(){
                given()
                        .pathParam("cep", "92700765")
                        .basePath(basePath)
                .when()

                .then()
                    .log().status()
                    .statusCode(200)
                    .body("cep", is("92700-765")).log();
    }

    @Test
    public void consultaCepValidoInexistente(){
            given()
                .pathParam("cep", "00000000")
                .basePath(basePath)
            .when()

            .then()
                .statusCode(200)
                .body("erro", is(true));
    }

    @Test
    public void consultaCepFormatoInvalidoComLetras(){
            given()
                .pathParam("cep", "1A2B3C4D")
                .basePath(basePath)
            .when()

            .then()
                .statusCode(400);
    }

    @Test
    public void consultaCepFormatoInvalidoComMaisDeOitoDigitos(){
            given()
                .pathParam("cep", "000000000")
                .basePath(basePath)
            .when()

            .then()
                .statusCode(400);
    }

    @Test
    public void consultaCepValidarCamposObrigatorios(){
            given()
                .pathParam("cep", "")
                .basePath(basePath)
            .when()

            .then()
                .statusCode(400);
    }
}
