package com.qa.rest.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2_Post {

    @Test
    void register() {

        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RequestSpecification req = RestAssured.given();
        JSONObject reqPar = new JSONObject();
        reqPar.put("FirstName", "Oliver1");
        reqPar.put("LastName", "Queen1");
        reqPar.put("UserName", "OliverQ1");
        reqPar.put("Password", "test1234");
        reqPar.put("Email", "oliver1234@arrow.com");
        System.out.println(reqPar.toJSONString());

        req.header("Content-Type", "application/json");

        req.body(reqPar.toJSONString());

        Response resp = req.request(Method.POST, "/register");

        String response = resp.getBody().asString();
        System.out.println("Request response : \n" + response);

        int status = resp.getStatusCode();
        System.out.println("Status Code :" + status);
       // Assert.assertEquals(status, 200);

        String sc = resp.jsonPath().get("SuccessCode");
        System.out.println(sc);
       // Assert.assertEquals(sc, "OPERATION_SUCCESS");


    }
}
