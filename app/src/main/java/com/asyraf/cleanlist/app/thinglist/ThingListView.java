package com.asyraf.cleanlist.app.thinglist;

import com.asyraf.cleanlist.app.base.BaseView;
import com.asyraf.cleanlist.core.things.ThingEntity;

import java.util.List;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
public interface ThingListView extends BaseView {
    void populateThings(List<ThingEntity> thingEntities);

    void hideProgress();
}
