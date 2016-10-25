package com.asyraf.cleanlist.data;

import com.asyraf.cleanlist.data.base.DataUtil;
import com.asyraf.cleanlist.core.environment.Environment;
import com.asyraf.cleanlist.data.base.RxUtil;
import com.asyraf.cleanlist.data.base.ServiceFactory;
import com.asyraf.cleanlist.data.di.DataModule;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import retrofit.RestAdapter;

/**
 * Created by tway on 5/22/16.
 */
public class DevDataModule extends DataModule {
    public DevDataModule(File cacheDir, RxUtil rxUtil) {
        super(cacheDir, rxUtil);
    }

    @Override
    public List<Environment> provideEnvironments() {
        return Arrays.asList(
                Environment.create("mock", "Mocks", null, null),
                Environment.create("stage", "Stage", "https://example.com", "https://example.com")
        );
    }

    @Override
    public ServiceFactory provideServiceFactory(DataUtil dataUtil) {
        return new DevServiceFactory(dataUtil, RestAdapter.LogLevel.FULL);
    }
}
