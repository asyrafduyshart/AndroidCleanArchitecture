package com.asyraf.cleanlist.app.settings;

import com.asyraf.cleanlist.app.base.BaseView;

/**
 * Created by Asyraf Duyshart on 5/22/16.
 */
public interface SettingsView extends BaseView {
    void populateEnvironmentLabel(String label);
    void appReset();
    void showDevSettings();
    void hideDevSettings();
}
