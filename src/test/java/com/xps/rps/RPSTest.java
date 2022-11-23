package com.xps.rps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSTest {

    @Test
    void rockVsScissors() {
        assertEquals(GameResult.P1_WINS, RPS.play(Throw.ROCK, Throw.SCISSORS));
    }

    @Test
    void scissorsVsRock() {
        assertEquals(GameResult.P2_WINS, RPS.play(Throw.SCISSORS, Throw.ROCK));
    }

    @Test
    void scissorsVsPaper() {
        assertEquals(GameResult.P1_WINS, RPS.play(Throw.SCISSORS, Throw.PAPER));
    }

    @Test
    void paperVsScissors() {
        assertEquals(GameResult.P2_WINS, RPS.play(Throw.PAPER, Throw.SCISSORS));
    }

    @Test
    void paperVsRock() {
        assertEquals(GameResult.P1_WINS, RPS.play(Throw.PAPER, Throw.ROCK));
    }

    @Test
    void rockVsPaper() {
        assertEquals(GameResult.P2_WINS, RPS.play(Throw.ROCK, Throw.PAPER));
    }

    @Test
    void scissorsVsScissors() {
        assertEquals(GameResult.TIE, RPS.play(Throw.SCISSORS, Throw.SCISSORS));
    }

    @Test
    void paperVsPaper() {
        assertEquals(GameResult.TIE, RPS.play(Throw.PAPER, Throw.PAPER));
    }

    @Test
    void rockVsRock() {
        assertEquals(GameResult.TIE, RPS.play(Throw.ROCK, Throw.ROCK));
    }

}
