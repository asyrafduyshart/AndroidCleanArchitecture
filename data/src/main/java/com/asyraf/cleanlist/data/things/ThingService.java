package com.asyraf.cleanlist.data.things;

import com.asyraf.cleanlist.core.things.ThingEntity;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
public interface ThingService {

    @GET("/thing/list")
    Observable<ThingEntity[]> getThingList();
}
