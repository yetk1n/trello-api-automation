package com.trelloapi.pages;

import com.trelloapi.endpoints.TrelloEndpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BoardPage {

    public Response createBoard(String boardName, String key, String token) {
        return given()
                .queryParam("key", key)
                .queryParam("token", token)
                .contentType("application/json")
                .body("{\"name\":\"" + boardName + "\"}")
                .when()
                .post(TrelloEndpoints.CREATE_BOARD);
    }

    public Response getBoard(String boardId, String key, String token) {
        return given()
                .pathParam("id", boardId)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get(TrelloEndpoints.GET_BOARD);
    }

    public Response getLists(String boardId, String key, String token) {
        return given()
                .pathParam("id", boardId)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .get(TrelloEndpoints.GET_BOARD + "/lists");
    }

    public Response deleteBoard(String boardId, String key, String token) {
        return given()
                .pathParam("id", boardId)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .delete(TrelloEndpoints.DELETE_BOARD);
    }

    public Response updateBoard(String boardId, String boardName, String key, String token) {
        return given()
                .pathParam("id", boardId)
                .queryParam("name", boardName)
                .queryParam("key", key)
                .queryParam("token", token)
                .when()
                .put(TrelloEndpoints.GET_BOARD);
    }
}