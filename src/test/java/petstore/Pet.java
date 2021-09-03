package petstore;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    String uri = "https://petstore.swagger.io/v2/pet";

    public String readJson(String jsonPath) throws IOException{
        return new String(Files.readAllBytes(Paths.get(jsonPath)));
    }

    @Test
    public void addPet() throws IOException {
        String jsonBody = readJson("db/pet1.json");

        // Sintaxe gherkin
        //Dado - Quando - Então
        // Given - When - Then

        given() //Dado
                .contentType("application/json") //comum em API REST - antifas era "text/xml"
                .log().all()
                .body(jsonBody)
        .when() //Quando
                .post(uri)
        .then() //Então
                .log().all()
                .statusCode(200)
        ;
    }
}
