package com.qa.rest.test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test5_Auth {

    @Test
    void GetWeaDetails() {

        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("ToolsQA");
        auth.setPassword("TestPassword");
        RestAssured.authentication = auth;

        RequestSpecification a = RestAssured.given();
        Response r = a.request(Method.GET, "/");
        String resp = r.getBody().asString();
        System.out.println("Request response : \n" + resp);

        int status = r.getStatusCode();
        System.out.println("Status Code :" + status);
        Assert.assertEquals(status, 200);

    }
}
