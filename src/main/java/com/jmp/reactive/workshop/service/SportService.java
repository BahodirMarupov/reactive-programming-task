package com.jmp.reactive.workshop.service;

import com.jmp.reactive.workshop.model.Sport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 06/07/2022
 */
public interface SportService {

    Flux<Sport> getSports(String keyword);

    Mono<Sport> createSport(String sportName);

    Mono<Void> deleteSport(String id);
}
