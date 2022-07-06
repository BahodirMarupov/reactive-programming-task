package com.jmp.reactive.workshop.controller;

import com.jmp.reactive.workshop.model.Sport;
import com.jmp.reactive.workshop.service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 06/07/2022
 */
@RestController
@RequestMapping("/api/v1/sports")
public class SportController {

    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

//    @GetMapping
    public Flux<Sport> getSports(@RequestParam String keyword) {
        return sportService.getSports(keyword);
    }

//    @PostMapping("/{sportName}")
    public Mono<ResponseEntity<Sport>> createSport(@PathVariable String sportName) {
        return sportService.createSport(sportName).map(sport -> ResponseEntity.ok().body(sport))
            .doOnError(throwable -> ResponseEntity.badRequest());
    }

//    @DeleteMapping("/{id}")
    public Mono<Void> deleteSport(@PathVariable String id) {
        return sportService.deleteSport(id);
    }
}
