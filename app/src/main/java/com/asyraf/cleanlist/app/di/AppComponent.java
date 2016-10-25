package com.asyraf.cleanlist.app.di;

import com.asyraf.cleanlist.app.settings.SettingsActivity;
import com.asyraf.cleanlist.app.thingdetail.ThingDetailActivity;
import com.asyraf.cleanlist.app.thinglist.MainActivity;
import com.asyraf.cleanlist.app.thinglist.ThingListItemView;
import com.asyraf.cleanlist.data.di.DataModule;
import com.asyraf.cleanlist.data.di.DomainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
@Singleton
@Component(modules = {AppModule.class, DomainModule.class, DataModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(ThingDetailActivity thingDetailActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(ThingListItemView thingListItemView);
}
