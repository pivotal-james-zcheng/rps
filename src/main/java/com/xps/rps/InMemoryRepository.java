package com.xps.rps;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRepository implements RoundRepository {

    private int count;

    public InMemoryRepository() {
        this.count = 0;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void increment() {
        count++;
    }
}
