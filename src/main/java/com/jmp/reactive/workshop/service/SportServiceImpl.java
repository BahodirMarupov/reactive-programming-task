package com.jmp.reactive.workshop.service;

import com.jmp.reactive.workshop.exception.SportAlreadyExist;
import com.jmp.reactive.workshop.model.Sport;
import com.jmp.reactive.workshop.repository.SportRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 06/07/2022
 */
@Service
public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;

    public SportServiceImpl(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public Flux<Sport> getSports(String keyword) {
        return sportRepository.findAllByNameLike(prepareKeyword(keyword));
    }

    private String prepareKeyword(String keyword) {
        return ".*".concat(keyword).concat(".*");
    }

    @Override
    public Mono<Sport> createSport(String sportName) {
        return sportRepository
            .findByName(sportName)
            .hasElements()
            .flatMap(hasElements -> {
                if (hasElements) {
                    return Mono.error(new SportAlreadyExist("Sport already exists!"));
                }
                Sport sport = new Sport("sports", Map.of("name", sportName));
                return sportRepository.insert(sport);
            });
    }

    @Override
    public Mono<Void> deleteSport(String id) {
        return sportRepository.deleteById(id);
    }
}
