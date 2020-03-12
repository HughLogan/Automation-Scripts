package com.qa.rest.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test6_Basic {

    @Test
    void GetWeaDetails() {

        RestAssured.baseURI = "http://ergast.com/api/f1/2015/circuits.json";
        RequestSpecification a = RestAssured.given();
        Response r = a.request(Method.GET);
        String res = r.getBody().asString();
        System.out.println("Request response : \n" + res);

        int status = r.getStatusCode();
        System.out.println("Status Code :" + status);
        Assert.assertEquals(status, 200);

        JsonPath ex = new JsonPath(res);
        String ser = ex.get("MRData.series");
        System.out.println("Series: " + ser);

        String cir = ex.get("MRData.CircuitTable.Circuits[1].circuitId");
        System.out.println("Circuit: " + cir);

        JSONObject val = new JSONObject(res);
        double lat = val.getJSONObject("MRData").getJSONObject("CircuitTable").getJSONArray("Circuits").getJSONObject(1).getJSONObject("Location").getDouble("lat");
        System.out.println("Latitude: " + lat);
    }
}
