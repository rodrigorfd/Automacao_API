package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteAllRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import org.junit.Test;



public class DeleteAllTest extends BaseTest {

    DeleteAllRequest deleteAllRequest = new DeleteAllRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    public void DeletarTodasAsReservas(){


        while (getBookingRequest.bookingReturnIds().then().extract().path("[0]") != null){

                int id = getBookingRequest.bookingReturnIds()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("[0].bookingid");

                deleteAllRequest.deletarTodasAsReservas(id,postAuthRequest.getToken())
                        .then()
                        .statusCode(201)
                        .log().all();
        }
    }
}