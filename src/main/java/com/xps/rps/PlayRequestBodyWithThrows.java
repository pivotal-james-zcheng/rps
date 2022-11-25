package com.xps.rps;

public class PlayRequestBodyWithThrows {
    private final Throw p1;
    private final Throw p2;

    public PlayRequestBodyWithThrows(Throw p1, Throw p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Throw getP2() {
        return p2;
    }

    public Throw getP1() {
        return p1;
    }
}
