package com.qa.rest.test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3_ValHeader {

    @Test
    void Hval() {

        RestAssured.baseURI = "http://ergast.com/api/f1/2015/circuits.json";
        RequestSpecification a = RestAssured.given();
        Response r = a.request(Method.GET);
        String resp = r.getBody().asString();
        System.out.println("Request response : \n" + resp);

        String hed = r.header("Content-Type");
        Assert.assertEquals(hed, "application/json; charset=utf-8");

        int status = r.getStatusCode();
        System.out.println("Status Code :" + status);
        Assert.assertEquals(status, 200);

        String statusline = r.getStatusLine();
        System.out.println("Status Line :" + statusline);
        Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

        Headers allheaders = r.headers();
        for (Header header : allheaders) {
            System.out.println(header.getName() + ":" + header.getValue());
        }
    }
}
