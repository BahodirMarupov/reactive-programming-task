package com.jmp.reactive.workshop.repository;

import com.jmp.reactive.workshop.model.Sport;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 04/07/2022
 */
@Repository
public interface SportRepository extends ReactiveMongoRepository<Sport, String> {

    @Query(value = "{'attributes.name' : ?0}")
    Flux<Sport> findByName(String name);

    @Query(value = "{'attributes.name' : { '$regex' : ?0 , $options: 'i'}}")
    Flux<Sport> findAllByNameLike(String keyword);

}
