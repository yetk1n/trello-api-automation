package com.trelloapi.tests;

import com.trelloapi.base.BaseTest;
import com.trelloapi.pages.BoardPage;
import com.trelloapi.pages.CardPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TrelloWorkflowTest extends BaseTest {

    BoardPage boardPage = new BoardPage();
    CardPage cardPage = new CardPage();

    @Test
    public void testTrelloWorkflow() {
        // Step 1: Create a board
        Response createBoardResponse = boardPage.createBoard("Test Board", key, token);
        createBoardResponse.then().statusCode(200);
        String boardId = createBoardResponse.jsonPath().getString("id");
        Assert.assertNotNull(boardId);
        logger.info("Board created with ID: {}", boardId);

        // Get the lists on the board
        Response listsResponse = boardPage.getLists(boardId, key, token);
        listsResponse.then().statusCode(200);
        String idList = listsResponse.jsonPath().getString("[0].id");  // First list ID
        Assert.assertNotNull(idList);
        logger.info("List ID: {}", idList);

        // Step 2: Create two cards on the board
        Response createCard1Response = cardPage.createCard("Card 1", idList, key, token);
        createCard1Response.then().statusCode(200);
        String card1Id = createCard1Response.jsonPath().getString("id");
        Assert.assertNotNull(card1Id);

        Response createCard2Response = cardPage.createCard("Card 2", idList, key, token);
        createCard2Response.then().statusCode(200);
        String card2Id = createCard2Response.jsonPath().getString("id");
        Assert.assertNotNull(card2Id);

        // Step 3: Update one of the cards randomly
        String[] cardIds = {card1Id, card2Id};
        int randomIndex = new Random().nextInt(2);
        String randomCardId = cardIds[randomIndex];

        Response updateCardResponse = cardPage.updateCard(randomCardId, "Updated Card", key, token);
        updateCardResponse.then().statusCode(200);
        String updatedCardName = updateCardResponse.jsonPath().getString("name");
        Assert.assertEquals(updatedCardName, "Updated Card");
        logger.info("Updated card with ID: {}", randomCardId);

        // Step 4: Delete the created cards
        cardPage.deleteCard(card1Id, key, token).then().statusCode(200);
        cardPage.deleteCard(card2Id, key, token).then().statusCode(200);

        // Step 5: Delete the board
        boardPage.deleteBoard(boardId, key, token).then().statusCode(200);
        logger.info("Test completed successfully");
    }
}