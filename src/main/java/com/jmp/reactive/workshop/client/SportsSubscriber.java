package com.jmp.reactive.workshop.client;

import com.jmp.reactive.workshop.model.SportData;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Author: Bakhodirjon_Marupov
 * Date: 07/07/2022
 */
public class SportsSubscriber implements Subscriber<SportData> {
    private Subscription subscription;
    private Integer count = 0;

    @Override
    public void onNext(SportData t) {
        count++;
        if (count >= 20) {
            count = 0;
            subscription.request(20);
        }
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(20);
    }

    @Override
    public void onError(Throwable t) {
    }

    @Override
    public void onComplete() {
    }
}
