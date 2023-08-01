package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;

public class StoresAssertionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/stores")
                .then()
                .statusCode(200);
    }
//1. Verify the if the total is equal to 1561

    @Test
    public void VerifyTheTotal() {
        response.body("total", equalTo(1561));
    }

    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void VerifyLimit() {
        response.body("limit", equalTo(10));
    }

    //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void checkTheSingleName() {
        response.body("data.name", hasItem("Inver Grove Heights"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void MultipleNames() {
        response.body("data.name", hasItems("Roseville", "Burnsville", "Maplewood"));
    }

    //5. Verify the storied=7 inside storeservices of the third store of second services
    @Test
    public void verifyTheStored7() {

        response.body("data[2].services[1].storeservices.storeId", equalTo(7));
    }

    //6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void hasMapValue() {
        response.body("data[2]", hasKey("createdAt"));

    }


    //7. Verify the state = MN of forth store

    @Test
    public void verifyState() {
        response.body("data[0]", hasKey("state==mn"));
    }


//8. Verify the store name = Rochester of 9th store


//9. Verify the storeId = 11 for the 6th store

    @Test
    public void storeId() {
        response.body("data[5].services[0].storeservices.storeId", equalTo(11));
    }


    //10. Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void servicesId() {
        response.body("data[6].services[3].storeservices.serviceId", equalTo(4));
    }


}

