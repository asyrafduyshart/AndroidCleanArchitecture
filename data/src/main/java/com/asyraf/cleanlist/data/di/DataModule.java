package com.asyraf.cleanlist.data.di;

import com.toddway.shelf.Shelf;
import com.asyraf.cleanlist.data.base.DataUtil;
import com.asyraf.cleanlist.core.environment.Environment;
import com.asyraf.cleanlist.data.base.RxUtil;
import com.asyraf.cleanlist.data.base.ServiceFactory;
import com.asyraf.cleanlist.data.things.ThingRepositoryImpl;
import com.asyraf.cleanlist.data.things.ThingService;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
@Module
public class DataModule {

    protected File cacheDir;
    protected RxUtil rxUtil;

    public DataModule(File cacheDir, RxUtil rxUtil) {
        this.cacheDir = cacheDir;
        this.rxUtil = rxUtil;
    }

    @Provides
    public List<Environment> provideEnvironments() {
        return Arrays.asList(
                Environment.create("stage", "Stage", "https://example.com", "https://example.com")
        );
    }

    @Provides
    public Shelf provideShelf() {
        return new Shelf(cacheDir);
    }

    @Provides @Singleton
    public DataUtil provideDataUtil(Shelf shelf, List<Environment> environments) {
        return new DataUtil(rxUtil, shelf, environments);
    }

    @Provides
    public ServiceFactory provideServiceFactory(DataUtil dataUtil) {
        return new ServiceFactory(dataUtil, RestAdapter.LogLevel.NONE);
    }


    @Provides @Singleton
    public ThingService provideThingService(ServiceFactory serviceFactory) {
        return serviceFactory.create(ThingService.class);
    }

    @Provides
    public ThingRepositoryImpl provideThingRepository(ThingService thingService, DataUtil dataUtil) {
        return new ThingRepositoryImpl(thingService, dataUtil);
    }
}
