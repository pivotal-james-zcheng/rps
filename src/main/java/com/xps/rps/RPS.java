package com.xps.rps;

public class RPS {
    public static GameResult play(Throw p1, Throw p2) {
        if (p1 == p2) return GameResult.TIE;

        if (p1 == Throw.PAPER && p2 == Throw.SCISSORS ||
                p1 == Throw.SCISSORS && p2 == Throw.ROCK ||
                p1 == Throw.ROCK && p2 == Throw.PAPER
        ) return GameResult.P2_WINS;

        return GameResult.P1_WINS;

    }
}
