package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Atualização de Reservas")
public class PutBookingTest extends BaseTest {


    PutBookingRequest putBookingRequest = new PutBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Alterar uma reserva somente utilizando o token")
    public void validarAlteracaoDeUmaReservaUtilizandoToken(){

        int primeiroID = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingToken(primeiroID,postAuthRequest.getToken())
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Alterar uma reserva sem o token")
    public void validarAlteracaoDeUmaReservaSemToken(){

        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[2].bookingid");

        putBookingRequest.updateBookingToken(id,"")
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Alterar uma reserva com um token invalido")
    public void validarAlteracaoDeUmaReservaComTokenInvalido(){

        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[2].bookingid");

        putBookingRequest.updateBookingToken(id,"token=abc123")
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Alterar uma reserva inexistente")
    public void validarAlteracaoDeUmaReservaInexistente(){

        putBookingRequest.updateBookingToken(99999,postAuthRequest.getToken())
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Alterar uma reserva utilizando o Basic Auth")
    public void validarAlteracaoDeUmaReservaUtilizandoBasicAuth(){

        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[2].bookingid");

        putBookingRequest.updateBookingBasicAuth(id)
                .then()
                .statusCode(200)
                .log().all();
    }
}
