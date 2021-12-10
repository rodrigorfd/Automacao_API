package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.requests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    @Step("Retorna uma nova reserva")
    public Response retornarUmaNovaReserva() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(BookingPayloads.payloadCreateBooking().toString())
                .post("booking");
    }

    @Step("Cria uma  reserva com parâmetros a mais")
    public Response criarUmaReservaComParametrosAMais() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(BookingPayloads.createBookingWithMoreParameters().toString())
                .post("booking");
    }

    @Step("Cria uma reserva com header inválido")
    public Response criarReservaComHeaderInvalido() {

        return given()
                .header("","" )
                .when()
                .body(BookingPayloads.payloadCreateBooking().toString())
                .post("booking");
    }



    @Step("Cria uma reserva com payload inválido")
    public Response criarReservaComPayloadInvalido() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(BookingPayloads.payloadInvalidCreateBooking().toString())
                .post("booking");
    }
}
