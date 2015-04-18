package com.catcoders.pulsafe.mvp.presenter;

import com.catcoders.pulsafe.domain.interactor.GetListPeopleInteractor;
import com.catcoders.pulsafe.mvp.view.MVPView;
import com.catcoders.pulsafe.mvp.view.MapView;

/**
 * Created by tonimc on 17/4/15.
 */
public class MapPresenter extends Presenter {

    private MVPView mMapView;

    private GetListPeopleInteractor mGetListPeopleInteractor;

    private boolean isLoading = false;

    public MapPresenter(MapView mapView) {

        mMapView = mapView;
        //mGetListPeopleInteractor = new GetListPeopleInteractor();

    }



    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
