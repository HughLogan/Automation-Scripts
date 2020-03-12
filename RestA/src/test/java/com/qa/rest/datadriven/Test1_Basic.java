package com.qa.rest.datadriven;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1_Basic {

    @Test(dataProvider = "newempdata")
    void creData(String name, String sal, String age)
    {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RequestSpecification re = RestAssured.given();

        JSONObject rec = new JSONObject();
        rec.put("Name", name);
        rec.put("Sal", sal);
        rec.put("Company", age);

        System.out.println(rec.toJSONString());
        re.header("Content-Type", "application/json");
        re.body(rec.toJSONString());
        Response resp = re.request(Method.POST, "/create");
        System.out.println(resp.getBody().asString());

    }

    @DataProvider(name="newempdata")
    Object[][] getEmpData()
    {
        String[][] empdata = {{"Oliver", "1111", "adsdads"}, {"Queen", "1122", "adsdadsdfds"}, {"Felicity", "3311", "adsasdads"}};
        return empdata;
    }
}
