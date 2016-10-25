package com.asyraf.cleanlist.app.base;

import android.content.Context;

import com.asyraf.cleanlist.app.di.AppComponent;
import com.asyraf.cleanlist.app.di.AppModule;
import com.asyraf.cleanlist.app.di.DaggerAppComponent;
import com.asyraf.cleanlist.data.di.DomainModule;
import com.asyraf.cleanlist.data.DevDataModule;
import com.asyraf.cleanlist.data.base.RxUtil;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Asyraf Duyshart on 5/12/16.
 */
public class AppComponentBuilder {
    public static AppComponent build(Context context) {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(context))
                .domainModule(new DomainModule())
                .dataModule(
                        new DevDataModule(
                                context.getCacheDir(),
                                new RxUtil(Schedulers.newThread(), AndroidSchedulers.mainThread())
                        )
                )
                .build();
    }
}
