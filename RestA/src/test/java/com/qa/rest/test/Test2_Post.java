package com.qa.rest.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.rest.utils.*;

public class Test2_Post {

    @Test
    void register() {

        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RequestSpecification req = RestAssured.given();
        JSONObject reqPar = new JSONObject();
        reqPar.put("FirstName", userdata.fname());
        reqPar.put("LastName", userdata.lname());
        reqPar.put("UserName", userdata.uname());
        reqPar.put("Password", userdata.pass());
        reqPar.put("Email", userdata.email());
        System.out.println(reqPar.toJSONString());

        req.header("Content-Type", "application/json");

        req.body(reqPar.toJSONString());

        Response resp = req.request(Method.POST, "/register");

        String response = resp.getBody().asString();
        System.out.println("Request response : \n" + response);

        int status = resp.getStatusCode();
        System.out.println("Status Code :" + status);
        Assert.assertEquals(status, 201);

        String sc = resp.jsonPath().get("SuccessCode");
        System.out.println(sc);
        Assert.assertEquals(sc, "OPERATION_SUCCESS");


    }
}
