package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

@Feature("Feature - Retorno de reservas")
public class GetBookingTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTests.class})
    @DisplayName("Listar id's das reservas")
    public void validaListagemDeIdsDasReservas(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar uma reserva específica")
    public void validaUmaReservaEspecifica() {
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturnId(id)
                .then()
                .statusCode(200)
                .body("firstname",notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar id's de reservas com base no primeiro nome")
    public void validaReservasPeloPrimeiroNome(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnByFirstname("Goku")
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar id's de reservas com base no ultimo nome")
    public void validaReservasPeloUltimoNome(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnByLastname("Son")
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar id's de reservas com base na data de checkin")
    public void validaReservasPeloCheckin(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnByCheckin(01,01,2018)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar id's de reservas com base na data de checkout")
    public void validaReservasPeloCheckout(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnByCheckout(01,01,2019)
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar id's de reservas com base na data de checkin e checkout")
    public void validaReservasPeloCheckinECheckout(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnByCheckinAndCheckout()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Listar id's de reservas com baseno nome, data de checkin e  checkout")
    public void validaReservasNomeCheckinECheckout(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnByNameCheckinAndCheckout()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class, E2eTests.class})
    @DisplayName("Listar id's de reservas com base na data de checkout e checkout")
    public void validaReservasPeloCheckoutECheckout(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnByCheckoutAndCheckout()
                .then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o schema do retorno da listagem de reservas")
    public void validaSchemaDaListagemDeReservas(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","bookings"))));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class})
    @DisplayName("Garantir o schema do retorno de uma reserva específica")
    public void validaSchemaDeRetornoDeUmaReservaEspecifica(){
        GetBookingRequest getBookingRequest = new GetBookingRequest();

        int id = getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturnId(id)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking","bookingid"))));
    }
}