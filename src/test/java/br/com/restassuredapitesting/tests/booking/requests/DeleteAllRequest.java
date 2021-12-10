package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteAllRequest {

    @Step("Deleta todas as reservas")
    public Response deletarTodasAsReservas(int id, String token){

        return given()
                .header("Content-Type","application/json")
                .header("Cookie", token)
                .when()
                .delete("booking/"+id);
    }
}
