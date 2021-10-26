package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.requests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    @Step("Retorna uma nova reserva")
    public Response retornaUmaNovaReserva() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(BookingPayloads.payloadCreateBooking().toString())
                .post("booking");
    }

    @Step("Cria uma  reserva com parâmetros a mais")
    public Response criaUmaReservaComParametrosAMais() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(BookingPayloads.createBookingWithMoreParameters().toString())
                .post("booking");
    }

    @Step("Cria uma reserva com header inválido")
    public Response reservaComHeaderInvalido() {

        return given()
                .header("","" )
                .when()
                .body(BookingPayloads.payloadCreateBooking().toString())
                .post("booking");
    }



    @Step("Cria uma reserva com header inválido")
    public Response reservaComPayloadInvalido() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(BookingPayloads.payloadInvalidCreateBooking().toString())
                .post("booking");
    }
}
