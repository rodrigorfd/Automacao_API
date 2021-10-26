package br.com.restassuredapitesting.tests.booking.tests;


import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.runners.AcceptanceTests;
import br.com.restassuredapitesting.runners.AllTests;
import br.com.restassuredapitesting.runners.E2eTests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeleteBookingTest extends BaseTest {

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    PostAuthRequest postAuthRequest = new PostAuthRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Deletar uma reserva ")
    public void DeletarUmaReserva(){

        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[3].bookingid");

        deleteBookingRequest.deletaUmaReserva(id,postAuthRequest.getToken())
                .then()
                .statusCode(201);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Deletar uma reserva que não existe")
    public void DeletarReservaQueNaoExiste(){

        deleteBookingRequest.deletaUmaReserva(999,postAuthRequest.getToken())
                .then()
                .statusCode(201);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Deletar uma reserva sem autorização")
    public void DeletarReservaQueSemAutorizacao(){

        deleteBookingRequest.deletaUmaReserva(59,"token=abc123")
                .then()
                .statusCode(201);
    }
}
