package com.asyraf.cleanlist;

import com.toddway.shelf.Shelf;
import com.asyraf.cleanlist.core.things.ThingEntity;
import com.asyraf.cleanlist.data.things.ThingRepositoryImpl;
import com.asyraf.cleanlist.di.TestDataComponent;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import rx.observers.TestSubscriber;


public class ThingRepositoryTest {

    @Inject ThingRepositoryImpl thingRepository;
    @Inject Shelf shelf;

    @Before
    public void beforeEach() {
        TestDataComponent.Builder.build().inject(this);
        shelf.clear("");
    }

    @Test
    public void testGetThingList() {
        TestSubscriber<ThingEntity[]> subscriber = new TestSubscriber<>();
        thingRepository.getThingList().subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertValueCount(2);

        for (ThingEntity[] thingEntities : subscriber.getOnNextEvents()) {
            System.out.println(thingEntities);
        }
    }

    @Test
    public void testGetThing() {
        TestSubscriber<ThingEntity> subscriber = new TestSubscriber<>();
        ThingEntity[] things = thingRepository.getNewThingList().toBlocking().first();
        thingRepository.getThing(things[3].getId()).subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
    }
}