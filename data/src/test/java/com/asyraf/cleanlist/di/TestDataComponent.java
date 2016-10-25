package com.asyraf.cleanlist.di;

import com.asyraf.cleanlist.GetThingInteractorTest;
import com.asyraf.cleanlist.GetThingListInteractorTest;
import com.asyraf.cleanlist.ThingRepositoryTest;
import com.asyraf.cleanlist.data.base.RxUtil;
import com.asyraf.cleanlist.data.di.DataModule;
import com.asyraf.cleanlist.data.MockThingService;
import com.asyraf.cleanlist.data.base.ServiceFactory;
import com.asyraf.cleanlist.data.di.DomainModule;
import com.asyraf.cleanlist.data.things.ThingService;

import java.io.File;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tway on 5/10/16.
 */
@Singleton
@Component(modules = {DataModule.class, DomainModule.class})
public interface TestDataComponent {

    void inject(ThingRepositoryTest thingRepositoryTest);

    void inject(GetThingListInteractorTest getThingListInteractorTest);

    void inject(GetThingInteractorTest getThingInteractorTest);

    final class Builder {
        public static TestDataComponent build() {
            return DaggerTestDataComponent
                    .builder()
                    .domainModule(new DomainModule())
                    .dataModule(new DataModule(new File("/tmp"), new RxUtil()) {
                        @Override
                        public ThingService provideThingService(ServiceFactory serviceFactory) {
                            return new MockThingService();
                        }
                    })
                    .build();
        }
    }
}
