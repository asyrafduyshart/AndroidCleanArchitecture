package com.asyraf.cleanlist.data;

import com.asyraf.cleanlist.data.base.DataUtil;
import com.asyraf.cleanlist.data.base.ServiceFactory;
import com.asyraf.cleanlist.data.things.ThingService;

import retrofit.RestAdapter;

/**
 * Created by tway on 5/22/16.
 */
public class DevServiceFactory extends ServiceFactory {
    public DevServiceFactory(DataUtil dataUtil, RestAdapter.LogLevel logLevel) {
        super(dataUtil, logLevel);
    }

    private <T> T createMock(Class<T> serviceType) {
        if (serviceType == ThingService.class) {
            return (T) new MockThingService();
        } else return null;
    }

    private boolean isMockOnlyService(Class serviceType) {
        return false;
    }

    @Override
    public <T> T create(Class<T> serviceType) {
        if (dataUtil.getEnvironment().isMock() || isMockOnlyService(serviceType)) return createMock(serviceType);
        else return super.create(serviceType);
    }
}
