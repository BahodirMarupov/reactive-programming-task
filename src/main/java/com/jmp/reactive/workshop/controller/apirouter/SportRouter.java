package com.jmp.reactive.workshop.controller.apirouter;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 06/07/2022
 */
@Configuration
public class SportRouter {

    private final static String basePath = "/api/v1/sports";

    @Bean
    public RouterFunction<ServerResponse> sportsRoute(SportHandler handler) {
        return RouterFunctions
            .route(GET(basePath).and(accept(MediaType.APPLICATION_JSON)),
                handler::getSports)
            .andRoute(POST(basePath).and(accept(MediaType.APPLICATION_JSON)),
                handler::createSport)
            .andRoute(DELETE(basePath.concat("/{id}")).and(accept(MediaType.APPLICATION_JSON)),
                handler::deleteSport);
    }
}
