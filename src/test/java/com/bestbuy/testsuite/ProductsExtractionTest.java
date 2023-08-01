package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response = given()
                .when()
                .get("/products")
                .then()
                .statusCode(200);
    }

    //21. Extract the limit
    @Test
    public void extractTheLimit() {
        int limit = response.extract().path("limit");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //22. Extract the total
    @Test
    public void extractTheTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of toal is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    //23. Extract the name of 5th product
    @Test
    public void nameOfThe5ThProduct() {
        String fifthProduct = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of toal is : " + fifthProduct);
        System.out.println("------------------End of Test---------------------------");
    }
//24. Extract the names of all the products

    @Test
    public void nameOfAllProducts() {
        List<String> allProducts = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Name Of all Products are : " + allProducts);
        System.out.println("------------------End of Test---------------------------");
    }

    //25. Extract the productId of all the products
    @Test
    public void productsIds() {
        List<String> productsIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name Of all Products IDs are : " + productsIds);
        System.out.println("------------------End of Test---------------------------");
    }

    //26. Print the size of the data list
    @Test
    public void sizeOfTheDataList() {
        List<Integer> dataList = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Size data is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");

    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void getAllTheValueOfTheProductEnergizer() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name is : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void modelOfTheProducts() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name is : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void categoriesOfTheProducts() {
        List<String> products = response.extract().path("data[8].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name is : " + products);
        System.out.println("------------------End of Test---------------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void storeId() {
        List<String> store = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store name is : " + store);
        System.out.println("------------------End of Test---------------------------");

    }

    //31. Get all the descriptions of all the products
    @Test
    public void descriptions() {
        List<HashMap<String, ?>> descriptions = response.extract().path("data.description");
        System.out.println("The store name is : " + descriptions);

    }

    //32. Get id of all the all categories of all the products
    @Test
    public void allId(){
           List<String> allId=response.extract().path("data.categories.id");
        System.out.println("The store name is : " + allId);

    }

    //33. Find the product names Where type = HardGood
    @Test
    public void findTheProductNameHardGood(){
        List<String> productName = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println(productName);
    }

     //34. Find the Total number of categories for the product where product name = Duracell - AA   1.5V CopperTop Batteries (4-Pack)
    @Test
    public void totalNumber(){
        List<HashMap<?, ?>> totalNumber = response.extract().path("data.find{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println(totalNumber.size());
    }

    //35. Find the createdAt for all products whose price < 5.49

    @Test
    public void findTheCreatedAtForProductsPrice() {
        List<HashMap<?, ?>> price = response.extract().path("data.findAll{it.price<5.49}.createdAt");
        System.out.println(price);
    }

    //   36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void nameOfAllCategoriesProductNameEnergizer(){
        List<String> productName1 = response.extract().path("data[3].categories.name");
        System.out.println(productName1);
    }

//      37. Find the manufacturer of all the products
@Test
public void findTheManufacturerOfAllProducts(){
    List<HashMap<String,?>> manufacturer = response.extract().path("data.manufacturer");
    System.out.println(manufacturer);
}
//      38. Find the image of products whose manufacturer is = Energizer

//      39. Find the createdAt for all categories products whose price > 5.99
@Test
public void findTheCreatedAtForProductsPrice1() {
    List<HashMap<?, ?>> price1 = response.extract().path("data.findAll{it.price>5.99}.createdAt");
    System.out.println(price1);
}
//      40. Find the uri of all the products
//
@Test
public void findTheUrlOfProducts(){
    List<HashMap<String,?>> url = response.extract().path("data.url");
    System.out.println(url);

}

}


