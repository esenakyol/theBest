package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void setUpBaseUrl(){
        spec =new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/booking/13").build();

    }

}
