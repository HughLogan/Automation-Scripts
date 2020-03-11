package com.qa.rest.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1_Get {

    @Test
    void GetWeaDetails(){

        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
        RequestSpecification a = RestAssured.given();
        Response r = a.request(Method.GET,"/Hyderabad");
        String resp = r.getBody().asString();
        System.out.println("Request response : \n"+resp);
        int status = r.getStatusCode();
        System.out.println("Status Code :"+status);
        Assert.assertEquals(status,200);
        String statusline = r.getStatusLine();
        System.out.println("Status Line :"+statusline);
        Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
        
    }
}
