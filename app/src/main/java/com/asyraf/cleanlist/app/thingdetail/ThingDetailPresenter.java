package com.asyraf.cleanlist.app.thingdetail;

import com.asyraf.cleanlist.app.base.BasePresenter;
import com.asyraf.cleanlist.core.things.GetThingInteractor;
import com.asyraf.cleanlist.core.things.ThingEntity;

/**
 * Created by Asyraf Duyshart on 5/12/16.
 */
public class ThingDetailPresenter extends BasePresenter<ThingDetailView> {
    GetThingInteractor getThingInteractor;
    String thingId;

    public ThingDetailPresenter(GetThingInteractor getThingInteractor) {
        this.getThingInteractor = getThingInteractor;
    }


    public void attachView(ThingDetailView view, String thingId) {
        super.attachView(view);
        this.thingId = thingId;
        addSubscription(getThingInteractor.get(thingId).subscribe(this::presentDetails, view::handleGlobalError));
    }

    private void presentDetails(ThingEntity thingEntity) {
        view.populateDetails(thingEntity);
    }
}
