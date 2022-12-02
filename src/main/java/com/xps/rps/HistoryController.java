package com.xps.rps;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

    private final RoundRepository roundRepository;

    public HistoryController(RoundRepository roundRepository) {

        this.roundRepository = roundRepository;
    }

    @GetMapping("/count")
    public String count() {

        return roundRepository.getCount() == 0 ? "No rounds have been played" : roundRepository.getCount() + " rounds have been played";
    }
}