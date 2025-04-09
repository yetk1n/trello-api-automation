package com.trelloapi.base;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected String key = "your_api_key_here";
    protected String token = "your_api_token_here";

    protected String baseURI = "https://api.trello.com/1";

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseURI;
    }
}
