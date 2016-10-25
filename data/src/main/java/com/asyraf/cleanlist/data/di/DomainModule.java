package com.asyraf.cleanlist.data.di;

import com.asyraf.cleanlist.core.environment.GetEnvironmentInteractor;
import com.asyraf.cleanlist.core.environment.GetEnvironmentsInteractor;
import com.asyraf.cleanlist.core.environment.SetEnvironmentInteractor;
import com.asyraf.cleanlist.core.things.GetThingInteractor;
import com.asyraf.cleanlist.core.things.GetThingListInteractor;
import com.asyraf.cleanlist.data.base.DataUtil;
import com.asyraf.cleanlist.data.things.ThingRepositoryImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Asyraf Duyshart on 5/13/16.
 */
@Module
public class DomainModule {

    @Provides
    GetThingListInteractor provideGetThingListInteractor(ThingRepositoryImpl thingRepository) {
        return new GetThingListInteractor(thingRepository);
    }

    @Provides
    GetThingInteractor provideGetThingInteractor(ThingRepositoryImpl thingRepository) {
        return new GetThingInteractor(thingRepository);
    }

    @Provides
    GetEnvironmentInteractor providGetEnvironmentInteractor(DataUtil dataUtil) {
        return new GetEnvironmentInteractor(dataUtil);
    }

    @Provides
    SetEnvironmentInteractor provideSetEnvironmentInteractor(DataUtil dataUtil) {
        return new SetEnvironmentInteractor(dataUtil);
    }

    @Provides
    GetEnvironmentsInteractor provideGetEnvironmentsInteractor(DataUtil dataUtil) {
        return new GetEnvironmentsInteractor(dataUtil);
    }
}
