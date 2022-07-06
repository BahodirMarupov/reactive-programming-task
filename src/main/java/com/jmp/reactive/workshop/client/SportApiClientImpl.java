package com.jmp.reactive.workshop.client;

import com.jmp.reactive.workshop.model.Sport;
import com.jmp.reactive.workshop.model.SportData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 05/07/2022
 */
@Component
public class SportApiClientImpl implements SportApiClient {

    private final WebClient webClient;

    public SportApiClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<Sport> getAllSportData() {
        Flux<SportData> sportDataFlux = webClient
            .get()
            .uri("/sports")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(SportData.class)
            .log();

        sportDataFlux.subscribe(new SportsSubscriber());
        return sportDataFlux.flatMapIterable(SportData::getData);
    }
}
