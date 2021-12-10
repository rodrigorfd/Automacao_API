package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.E2eTests;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.notNullValue;

@Feature("Feature - Criação de Reservas ")
public class PostBookingTest extends BaseTest {

    PostBookingRequest postBookingRequest = new PostBookingRequest();
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, AcceptanceTests.class})
    @DisplayName("Retorna uma nova reserva para o usuário")
    public void validaCriacaoDeReservaParaUsuario(){
        postBookingRequest.retornarUmaNovaReserva()
                .then()
                .statusCode(200)
                .body("bookingid",notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Cria varias reservas em sequencia")
    public void validaCriacaoDeVariasReservasEmSequencia(){
        for (int i=0; i<=4; i++){
            postBookingRequest.retornarUmaNovaReserva()
                    .then()
                    .statusCode(200)
                    .body("bookingid",notNullValue());
        }
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Criar uma reserva com parâmetros a mais")
    public void criarReservaComParametrosAMais(){
        postBookingRequest.criarUmaReservaComParametrosAMais()
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Cria uma reserva com header inválido")
    public void criarReservaComHeaderInvalido(){
        postBookingRequest.criarReservaComHeaderInvalido()
                .then()
                .statusCode(418);
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2eTests.class})
    @DisplayName("Valida retorno 500 ao criar uma reserva com payload inválido")
    public void criarReservaComPayloadInvalido(){
        postBookingRequest.criarReservaComPayloadInvalido()
                .then()
                .statusCode(500)
                .log().all();
    }
}