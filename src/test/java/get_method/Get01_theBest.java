package get_method;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.BookingDatesPojo;
import pojo.InfoPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get01_theBest extends HerOkuAppBaseUrl {

    /* Test Case:

        Given
            https://restful-booker.herokuapp.com/booking/14
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like
              {
                    "firstname": "Esen",
                    "lastname": "Akyol",
                    "totalprice": 400,
                    "depositpaid": true,
                    "bookingdates": {
                                "checkin": "2021-09-21",
                                "checkout": "2021-09-25"
                               },
                    "additionalneeds": "Dinner"
                }
     */

    @Test
    public void testToGet(){

        //1.Step : Set the url
        spec.pathParams("first","booking", "second",14);

        //2.Step: expected data
        BookingDatesPojo bookingdates = new BookingDatesPojo("2021-09-21","2021-09-25");
        InfoPojo expectedData = new InfoPojo("Esen", "Akyol", 400, true, bookingdates, "Dinner");
        System.out.println(expectedData);

        //3.Step: "Hey, API. Listen to me. Now I SEND to you my REQUEST, and I want to GET the RESPONSE".
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4.step: Do assertion
        InfoPojo actualData = response.as(InfoPojo.class);
        //Test: Actual data= expected data ----> pass=>ok
        //Test: Actual data != expected data ----> fail
        System.out.println(actualData);
        assertEquals().
    }




}
