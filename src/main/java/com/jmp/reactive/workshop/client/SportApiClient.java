package com.jmp.reactive.workshop.client;

import com.jmp.reactive.workshop.model.Sport;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 05/07/2022
 */
public interface SportApiClient {

    Flux<Sport> getAllSportData();

}
