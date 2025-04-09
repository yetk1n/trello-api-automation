package com.trelloapi.pages;

import com.trelloapi.endpoints.TrelloEndpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CardPage {

    public Response createCard(String name, String idList, String key, String token) {
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .contentType("application/json")
                .body("{\"name\":\"" + name + "\",\"idList\":\"" + idList + "\"}")
                .when()
                .post(TrelloEndpoints.CREATE_CARD);
    }

    public Response getCard(String cardId, String key, String token) {
        return given()
                .pathParam("id", cardId)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get(TrelloEndpoints.GET_CARD);
    }

    public Response updateCard(String cardId, String name, String key, String token) {
        return given()
                .pathParam("id", cardId)
                .queryParam("key", key)
                .queryParam("token", token)
                .contentType("application/json")
                .body("{\"name\":\"" + name + "\"}")
                .when()
                .put(TrelloEndpoints.UPDATE_CARD);
    }

    public Response deleteCard(String cardId, String key, String token) {
        return given()
                .pathParam("id", cardId)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .delete(TrelloEndpoints.DELETE_CARD);
    }
}