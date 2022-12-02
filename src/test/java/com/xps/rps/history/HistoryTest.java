package com.xps.rps.history;

import com.xps.rps.play.PlayRequestBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HistoryTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void noRoundsPlayed_returns0() {
        ResponseEntity<String> response = restTemplate.getForEntity("/count", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("No rounds have been played", response.getBody());
    }

    @Test
    void count_returnsNumberOfRoundsPlayed() {
        ResponseEntity<String> beforePlay = restTemplate.getForEntity("/count", String.class);

        assertEquals(HttpStatus.OK, beforePlay.getStatusCode());
        assertEquals("No rounds have been played", beforePlay.getBody());

        restTemplate.postForEntity("/play", new PlayRequestBody("ROCK", "SCISSORS"), String.class);

        ResponseEntity<String> afterPlay = restTemplate.getForEntity("/count", String.class);

        assertEquals(HttpStatus.OK, afterPlay.getStatusCode());
        assertEquals("1 rounds have been played", afterPlay.getBody());
    }

}
