package com.qa.rest.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test4_ValResp {

    @Test
    void GetWeaDetails() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification a = RestAssured.given();
        Response r = a.request(Method.GET, "/Chennai");
        String resp = r.getBody().asString();
        System.out.println("Request response : \n" + resp);

        int status = r.getStatusCode();
        System.out.println("Status Code :" + status);
        Assert.assertEquals(status, 200);

        Assert.assertTrue(resp.contains("Chennai"));

        JsonPath ex = new JsonPath(resp);
        String city = ex.get("City");
        System.out.println("City: " + city);

        String Hum = ex.get("Humidity");
        System.out.println("Humidity: " + Hum);

        String We = ex.get("WeatherDescription");
        System.out.println("WeatherDescription: " + We);

        Assert.assertEquals(We, "few clouds");
        Assert.assertEquals(Hum, "62 Percent");

    }
}
