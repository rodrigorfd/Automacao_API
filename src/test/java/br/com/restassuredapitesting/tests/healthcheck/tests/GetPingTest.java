package br.com.restassuredapitesting.tests.healthcheck.tests;

import br.com.restassuredapitesting.base.BaseTest;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.HealthcheckTests;
import br.com.restassuredapitesting.tests.healthcheck.requests.GetPingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;


@Feature("Feature - API online")
public class GetPingTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, HealthcheckTests.class})
    @DisplayName("Verificar se a API está online")
    public void validaApiOnline(){
        GetPingRequest getPingRequest = new GetPingRequest();

        getPingRequest.pingReturnApi()
                .then()
                .statusCode(201);
    }

}