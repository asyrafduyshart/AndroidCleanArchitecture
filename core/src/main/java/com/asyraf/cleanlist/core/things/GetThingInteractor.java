package com.asyraf.cleanlist.core.things;

import rx.Observable;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
public class GetThingInteractor {
    ThingRepository repository;

    public GetThingInteractor(ThingRepository repository) {
        this.repository = repository;
    }

    public Observable<ThingEntity> get(String id) {
        return repository.getThing(id);
    }
}
