package com.xps.rps;

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
                restTemplate.postForEntity("/play", new PlayRequestBody("rock", "scissors"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Player 1 Wins", response.getBody());
    }

    @Test
    public void scissorsVsRock_player2Wins() {
        ResponseEntity<String> response =
                restTemplate.postForEntity("/play", new PlayRequestBody("scissors", "rock"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Player 2 Wins", response.getBody());
    }
}
