package br.com.restassuredapitesting.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
public class GetBookingRequest {

    @Step("Retorna os Ids da listagem de reservas")
    public Response bookingReturnIds(){
        return given()
                .when()
                .get("booking");
    }


    @Step("Retorna a reserva com base em um id")
    public Response bookingReturnId(int id){
        return given()
                .when()
                .get("booking/"+id);
    }

    @Step("Retorna id's de reservas com base no primeiro nome")
    public Response bookingReturnByFirstname(String name){
        return given()
                .when()
                .get("booking?firstname="+ name);
    }

    @Step("Retorna id's de reservas com base no ultimo nome")
    public Response bookingReturnByLastname(String lname){
        return given()
                .when()
                .get("booking?lastname="+ lname);
    }

    @Step("Retorna id's de reservas com base no checkin")
    public Response bookingReturnByCheckin(int d,int m, int a){
        return given()
                .when()
                .get("booking?checkin="+a+"-"+m+"-"+d);
    }

    @Step("Retorna id's de reservas com base no checkout")
    public Response bookingReturnByCheckout(int d,int m, int a){
        return given()
                .when()
                .get("booking?checkout="+a+"-"+m+"-"+d);
    }

    @Step("Retorna id's de reservas com base no checkin e no checkout")
    public Response bookingReturnByCheckinAndCheckout(){
        return given()
                .when()
                .get("booking?checkin=2018-01-01&checkout=2019-01-01");
    }

    @Step("Retorna id's de reservas com base no nome, na data de checkin e checkout")
    public Response bookingReturnByNameCheckinAndCheckout(){
        return given()
                .when()
                .get("booking?firstname=Goku&checkin2018-01-01&checkout2019-01-01");
    }

    @Step("Retorna id's de reservas com base no nome, na data de checkout e checkout")
    public Response bookingReturnByCheckoutAndCheckout(){
        return given()
                .when()
                .get("booking?checkout=2014-05-21&checkout=2014-05-21");
    }
}