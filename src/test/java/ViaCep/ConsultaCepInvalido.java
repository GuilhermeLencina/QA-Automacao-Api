package ViaCep;

import TestBase.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ConsultaCepInvalido extends TestBase{

    @DisplayName("Consulta - CEP Inválido Inexistente")
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

    @DisplayName("Consulta - CEP Inválido com Letras")
    @Test
    public void consultaCepFormatoInvalidoComLetras(){
        given()
                .pathParam("cep", "1A2B3C4D")
                .basePath(basePath)
                .when()

                .then()
                .statusCode(400);
    }

    @DisplayName("Consulta - CEP Inválido com Mais de Oito Digitos")
    @Test
    public void consultaCepFormatoInvalidoComMaisDeOitoDigitos(){
        given()
                .pathParam("cep", "000000000")
                .basePath(basePath)
                .when()

                .then()
                .statusCode(400);
    }

    @DisplayName("Consulta - CEP Inválido")
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
