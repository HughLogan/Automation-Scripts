package com.qa.rest.test;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {

    @Test
    public void test_circuits_2008_f1() {
        given().
                when().
                get("http://ergast.com/api/f1/2015/circuits.json").
                then().
                assertThat().
                statusCode(200).
                and().
                body("MRData.CircuitTable.Circuits.circuitId", hasSize(19)).
                and().
                header("Content-Length", equalTo("4351"));
    }
}
