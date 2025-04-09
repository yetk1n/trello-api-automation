package com.trelloapi.base;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected String key = "6df6365564f8c0e3a0ca3636d6c01bba";
    protected String token = "ATTA45c68154cc02a58a1917aa55c2a1abec40f5d73af8eee28e114369f8c7e74fe8009049A0";

    protected String baseURI = "https://api.trello.com/1";

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseURI;
    }
}
