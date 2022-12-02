package com.xps.rps.history;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryRepositoryTest {

    @Test
    void getCount_returns0() {
        RoundRepository subject = new InMemoryRepository();

        assertEquals(0, subject.getCount());
    }

    @Test
    void getCount_oneRoundPlayed_returns1() {
        RoundRepository subject = new InMemoryRepository();

        subject.increment();

        assertEquals(1, subject.getCount());
    }
}
