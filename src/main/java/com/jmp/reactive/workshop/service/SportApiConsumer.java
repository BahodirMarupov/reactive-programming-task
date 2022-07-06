package com.jmp.reactive.workshop.service;

import com.jmp.reactive.workshop.client.SportApiClient;
import com.jmp.reactive.workshop.repository.SportRepository;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 05/07/2022
 */
@Service
public class SportApiConsumer implements SmartLifecycle {

    private final SportApiClient apiClient;
    private final SportRepository sportRepository;

    public SportApiConsumer(SportApiClient apiClient, SportRepository sportRepository) {
        this.apiClient = apiClient;
        this.sportRepository = sportRepository;
    }

    @Override
    public void start() {
        sportRepository.insert(apiClient.getAllSportData()).blockLast();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
