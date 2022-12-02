package com.xps.rps;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.xps.rps.GameResult.*;

@RestController
public class PlayController {

    private final RoundRepository roundRepository;

    public PlayController(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }


    @PostMapping("/play")
    public String play(@RequestBody PlayRequestBody requestBody) {
        roundRepository.increment();

        try {
            Throw player1Throw = Throw.valueOf(requestBody.getP1().toUpperCase());
            Throw player2Throw = Throw.valueOf(requestBody.getP2().toUpperCase());

            GameResult result = RPS.play(player1Throw, player2Throw);

            if (result == P1_WINS) {
                return "Player 1 Wins";
            } else if (result == P2_WINS) {
                return "Player 2 Wins";
            } else {
                return "The game is tied";
            }

        } catch (IllegalArgumentException exception) {
            return "Invalid input";
        }
    }
}
