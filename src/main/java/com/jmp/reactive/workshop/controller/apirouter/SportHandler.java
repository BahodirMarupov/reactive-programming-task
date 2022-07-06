package com.jmp.reactive.workshop.controller.apirouter;

import com.jmp.reactive.workshop.model.Sport;
import com.jmp.reactive.workshop.service.SportService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 06/07/2022
 */
@Component
public class SportHandler {

    private final SportService sportService;

    public SportHandler(SportService sportService) {
        this.sportService = sportService;
    }

    public Mono<ServerResponse> getSports(ServerRequest request) {
        String keyword = request.queryParam("keyword").orElse("");
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(sportService.getSports(keyword), Sport.class);
    }

    public Mono<ServerResponse> createSport(ServerRequest request) {
        String sportName = request.pathVariable("sportName");
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(sportService.createSport(sportName), Sport.class);
    }

    public Mono<ServerResponse> deleteSport(ServerRequest request) {
        String id = request.pathVariable("id");
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(sportService.deleteSport(id), Void.class);
    }
}
