package br.com.restassuredapitesting.tests.booking.requests.payloads;

import com.github.javafaker.Faker;
import org.json.JSONObject;

public class BookingPayloads {

    public static JSONObject payloadValidBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        payload.put("firstname","James");
        payload.put("lastname","Crown");
        payload.put("totalprice",111);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");

        return payload;
    }


    public static JSONObject payloadCreateBooking(){

        Faker faker = new Faker();
        int price = faker.number().numberBetween(1,999);

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        payload.put("firstname","Goku");
        payload.put("lastname","Son");
        payload.put("totalprice",price);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");

        return payload;
    }

    public static JSONObject createBookingWithMoreParameters(){

        Faker faker = new Faker();
        int price = faker.number().numberBetween(1,999);

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        payload.put("firstname","Goku");
        payload.put("lastname","Son");
        payload.put("totalprice",price);
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");

        //Parâmetro extra
        payload.put("idade","26");

        return payload;
    }


    public static JSONObject payloadInvalidCreateBooking(){

        Faker faker = new Faker();
        int price = faker.number().numberBetween(1,999);

        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        return payload;
    }
}
