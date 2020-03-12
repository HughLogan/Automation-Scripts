package com.qa.rest.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;


public class TestBase {

    public static RequestSpecification req;
    public static Response resp;

    public Logger log;

    @BeforeClass
    public void setup(){

        log = Logger.getLogger(TestBase.class);
        PropertyConfigurator.configure("log4j.properties");
        log.setLevel(Level.DEBUG);

    }
}
