package com.asyraf.cleanlist.app.thinglist;

import com.asyraf.cleanlist.core.things.GetThingListInteractor;
import com.asyraf.cleanlist.core.things.ThingEntity;
import com.asyraf.cleanlist.app.base.BasePresenter;

import java.util.Arrays;

/**
 * Created by Asyraf Duyshart on 5/10/16.
 */
public class ThingListPresenter extends BasePresenter<ThingListView> {

    GetThingListInteractor getThingListInteractor;

    public ThingListPresenter(GetThingListInteractor getThingListInteractor) {
        this.getThingListInteractor = getThingListInteractor;
    }

    @Override
    public void attachView(ThingListView view) {
        super.attachView(view);
    }

    public void getThingList() {
        addSubscription(getThingListInteractor.get().subscribe(this::presentThings, this::handleError));
    }

    public void getNewThingList() {
        addSubscription(getThingListInteractor.getNew().subscribe(this::presentThings, this::handleError));
    }

    void presentThings(ThingEntity[] thingEntities) {
        view.hideProgress();
        if (thingEntities != null) view.populateThings(Arrays.asList(thingEntities));
    }

    void handleError(Throwable throwable) {
        view.hideProgress();
        view.handleGlobalError(throwable);
    }

}
