package com.xps.rps.play;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RPSAPITest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void rockVsScissors_player1Wins() {
        ResponseEntity<String> response =
                restTemplate.postForEntity("/play", new PlayRequestBody("ROCK", "SCISSORS"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Player 1 Wins", response.getBody());
    }

    @Test
    public void scissorsVsRock_player2Wins() {
        ResponseEntity<String> response =
                restTemplate.postForEntity("/play", new PlayRequestBody("SCISSORS", "ROCK"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Player 2 Wins", response.getBody());
    }

    @Test
    public void scissorsVsScissors_ties() {
        ResponseEntity<String> response =
                restTemplate.postForEntity("/play", new PlayRequestBody("SCISSORS", "SCISSORS"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("The game is tied", response.getBody());
    }

    @Test
    public void rockVsSailboat_invalidInput() {
        ResponseEntity<String> response =
                restTemplate.postForEntity("/play", new PlayRequestBody("ROCK", "Sailboat"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Invalid input", response.getBody());
    }

    @Test
    public void rockVsScissorsWithLowerCaseROCK_player1Wins() {
        ResponseEntity<String> response =
                restTemplate.postForEntity("/play", new PlayRequestBody("rock", "SCISSORS"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Player 1 Wins", response.getBody());
    }
}
