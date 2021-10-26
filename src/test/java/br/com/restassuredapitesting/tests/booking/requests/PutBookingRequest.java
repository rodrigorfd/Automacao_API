package br.com.restassuredapitesting.tests.booking.requests;


import br.com.restassuredapitesting.tests.booking.requests.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    BookingPayloads bookingPayloads = new BookingPayloads();

    @Step("Atualiza uma reserva específica com o parâmetro token")
    public Response updateBookingToken(int id, String token){
        return given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie",token)
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+id);
    }

    @Step("Atualiza uma reserva específica com o parâmetro Basic Auth")
    public Response updateBookingBasicAuth(int id){
        return given()
                .header("Content-Type","application/json")
                .header("Authorisation","Basic YWRtaW46cGFzc3dvcmQxMjM=]")
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .put("booking/"+id);
    }
}
