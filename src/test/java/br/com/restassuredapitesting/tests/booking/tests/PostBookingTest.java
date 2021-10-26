package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.notNullValue;

public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Retorna uma nova reserva para o usuário")
    public void validaCriacaoDeReservaParaUsuario(){
        postBookingRequest.retornaUmaNovaReserva()
                .then()
                .statusCode(200)
                .body("bookingid",notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class, E2eTests.class})
    @DisplayName("Cria duas reservas em sequencia")
    public void validaCriacaoDeDuasReservasEmSequencia(){
        postBookingRequest.retornaUmaNovaReserva()
                .then()
                .statusCode(200)
                .body("bookingid",notNullValue());

        postBookingRequest.retornaUmaNovaReserva()
                .then()
                .statusCode(200)
                .body("bookingid",notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class, E2eTests.class})
    @DisplayName("Criar uma reserva com parâmetros a mais")
    public void criarReservaComParametrosAMais(){
        postBookingRequest.criaUmaReservaComParametrosAMais()
                .then()
                .statusCode(200)
                .body("bookingid",notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class, E2eTests.class})
    @DisplayName("Cria uma reserva com header inválido")
    public void criarReservaComHeaderInvalido(){
        postBookingRequest.reservaComHeaderInvalido()
                .then()
                .statusCode(418);
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class, E2eTests.class})
    @DisplayName("Valida retorno 500 ao criar uma reserva com payload inválido")
    public void criarReservaComPayloadInvalido(){
        postBookingRequest.reservaComPayloadInvalido()
                .then()
                .statusCode(500);
    }
}