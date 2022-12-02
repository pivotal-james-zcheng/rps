package com.xps.rps.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSParametrisedTest {

    @ParameterizedTest
    @MethodSource("rpsCases")
    void rps(Throw p1, Throw p2, GameResult result) {
        assertEquals(result, RPS.play(p1, p2));
    }

    private static Stream<Arguments> rpsCases() {
        return Stream.of(
                Arguments.of(Throw.ROCK, Throw.SCISSORS, GameResult.P1_WINS),
                Arguments.of(Throw.SCISSORS, Throw.ROCK, GameResult.P2_WINS),
                Arguments.of(Throw.SCISSORS, Throw.PAPER, GameResult.P1_WINS),
                Arguments.of(Throw.PAPER, Throw.SCISSORS, GameResult.P2_WINS),
                Arguments.of(Throw.PAPER, Throw.ROCK, GameResult.P1_WINS),
                Arguments.of(Throw.ROCK, Throw.PAPER, GameResult.P2_WINS),
                Arguments.of(Throw.SCISSORS, Throw.SCISSORS, GameResult.TIE),
                Arguments.of(Throw.PAPER, Throw.PAPER, GameResult.TIE),
                Arguments.of(Throw.ROCK, Throw.ROCK, GameResult.TIE)
        );
    }
}
