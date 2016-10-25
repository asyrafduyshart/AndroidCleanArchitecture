package com.asyraf.cleanlist.core.things;

import rx.Observable;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
public interface ThingRepository {
    Observable<ThingEntity[]> getThingList();

    Observable<ThingEntity> getThing(String id);

    Observable<ThingEntity[]> getNewThingList();

}
