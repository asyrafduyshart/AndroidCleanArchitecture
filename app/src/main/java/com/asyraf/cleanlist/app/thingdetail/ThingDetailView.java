package com.asyraf.cleanlist.app.thingdetail;

import com.asyraf.cleanlist.app.base.BaseView;
import com.asyraf.cleanlist.core.things.ThingEntity;

/**
 * Created by Asyraf Duyshart on 5/12/16.
 */
public interface ThingDetailView extends BaseView {
    void populateDetails(ThingEntity thingEntity);
}
