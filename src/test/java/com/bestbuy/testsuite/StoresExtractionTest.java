package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest extends TestBase {


    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //    1. Extract the limit
    @Test
    public void extractTheLimit() {
        int limit = response.extract().path("limit");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //2. Extract the total
    @Test
    public void extractTheTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    //3. Extract the name of 5th store
    @Test
    public void extractTheName5Store() {
        String store = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + store);
        System.out.println("------------------End of Test---------------------------");

    }

    //4. Extract the names of all the store
    @Test
    public void nameOfAllStores() {
        List<String> allStore = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allStore);
        System.out.println("------------------End of Test---------------------------");


    }

    //5. Extract the storeId of all the store
    @Test
    public void storedId() {
        List<Integer> storedIDs = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the all stores is : " + storedIDs);
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void sizeDataList() {
        List<Integer> storeList = response.extract().path("data.limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Size data is : " + storeList.size());
        System.out.println("------------------End of Test---------------------------");

    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void storeNameStCloud() {
        List<HashMap<String, ?>> stCloud = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name is : " + stCloud);
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void storeRochester() {

        String storeNameRochetser = response.extract().path("data.find{it.name=='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address is : " + storeNameRochetser);
        System.out.println("------------------End of Test---------------------------");

    }

    //9. Get all the services of 8th store
    @Test
    public void allServicesOf8ThStore() {
        List<HashMap<String, ?>> services8ThStore = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store is : " + services8ThStore);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void storeServicesOfWindowsStore() {
        List<String> windowStore = response.extract().path("data[0].services.findAll{it.name=='Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices of the store where service is : " + windowStore);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void allStoredId() {
        List<Integer> allstoredIDs = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the all stores IDs is : " + allstoredIDs);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void allStoreIds() {
        List<String> getIdOfAllStore = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the all stores IDs is : " + getIdOfAllStore);
        System.out.println("------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void storeNameNd() {
        List<HashMap<String, ?>> nameNd = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the store names Where state is : " + nameNd);
        System.out.println("------------------End of Test---------------------------");


    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void storeServicesOfRochester() {
        List<?> services8ThStore = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");

        System.out.println("The store Services Of Rochester : " + services8ThStore.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void createdAt() {
        List<?> createdAt = response.extract().path("data.find{it.services}.services.findAll{it.name == 'Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");

        System.out.println("createdAt for all services whose name : " + createdAt);
        System.out.println("------------------End of Test---------------------------");

    }
//            16. Find the name of all services Where store name = “Fargo”

//            17. Find the zip of all the store

//18. Find the zip of store name = Roseville


    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void mangolina() {
        List<?> storeServices = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");

        System.out.println("createdAt for all services whose name : " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

}
    //20. Find the lat of all the stores

