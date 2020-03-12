package com.qa.rest.test;

import com.qa.rest.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Test1_Get extends TestBase {

    //  Logger log = LoggerFactory.getLogger(Test1_Get.class);

    @BeforeClass
    void getData() {

        log.info("************ Fetching all data ***************");
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
        req = RestAssured.given();
        resp = req.request(Method.GET, "/Chennai");
    }

    @Test
    void CheckRespBody() {
        log.info("************* Checking Response Body **************");
        String respo = resp.getBody().asString();
        log.info("Response Body: " + respo);
        Assert.assertNotNull(respo);
    }

    @Test
    void CheckStatusCode() {
        log.info("************* Checking Status Code **************");
        int status = resp.getStatusCode();
        log.info("Status Code: " + status);
        Assert.assertEquals(status, 200);
    }
}
