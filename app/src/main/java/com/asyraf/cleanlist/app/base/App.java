package com.asyraf.cleanlist.app.base;

import android.app.Application;
import android.content.Context;

import com.asyraf.cleanlist.app.di.AppComponent;

/**
 * Created by Asyraf Duyshart on 5/12/16.
 */
public class App extends Application {

    private AppComponent component;

    public AppComponent component() {
        if (component == null) buildComponent(this);
        return component;
    }

    public static App of(Context context) {
        return (App) context.getApplicationContext();
    }

    public void buildComponent(Context context) {
         component = AppComponentBuilder.build(context.getApplicationContext());
    }
}
