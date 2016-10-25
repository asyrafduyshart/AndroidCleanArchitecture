package com.asyraf.cleanlist.app.di;

import android.content.Context;

import com.asyraf.cleanlist.BuildConfig;
import com.asyraf.cleanlist.app.settings.SettingsPresenter;
import com.asyraf.cleanlist.app.thingdetail.ThingDetailPresenter;
import com.asyraf.cleanlist.app.thinglist.ThingListPresenter;
import com.asyraf.cleanlist.core.environment.GetEnvironmentInteractor;
import com.asyraf.cleanlist.core.environment.GetEnvironmentsInteractor;
import com.asyraf.cleanlist.core.environment.SetEnvironmentInteractor;
import com.asyraf.cleanlist.core.things.GetThingInteractor;
import com.asyraf.cleanlist.core.things.GetThingListInteractor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
@Module
public class AppModule {

    Context appContext;

    public AppModule(Context context) {
        this.appContext = context;

//        try { // this fails when isInEditMode, but we don't care so we wrap in try/catch
//            LeakCanary.install((Application) appContext.getApplicationContext());
//        } catch (Exception e) {}
    }

    @Provides @Singleton
    @Named("aboutSummary")
    String provideAboutSummary() {
        return BuildConfig.VERSION_NAME + " (" + BuildConfig.GIT_SHA + ")";
    }

    @Provides
    ThingListPresenter provideThingListPresenter(GetThingListInteractor getThingListInteractor) {
        return new ThingListPresenter(getThingListInteractor);
    }

    @Provides
    ThingDetailPresenter provideThingDetailPresenter(GetThingInteractor getThingInteractor) {
        return new ThingDetailPresenter(getThingInteractor);
    }

    @Provides
    SettingsPresenter provideSettingsPresenter(GetEnvironmentInteractor getEnvironmentInteractor, SetEnvironmentInteractor setEnvironmentInteractor, GetEnvironmentsInteractor getEnvironmentsInteractor) {
        return new SettingsPresenter(getEnvironmentsInteractor, setEnvironmentInteractor, getEnvironmentInteractor);
    }
}
