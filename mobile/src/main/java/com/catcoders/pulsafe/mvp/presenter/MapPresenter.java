package com.catcoders.pulsafe.mvp.presenter;

import com.catcoders.pulsafe.domain.interactor.GetListPersonsInteractor;
import com.catcoders.pulsafe.mvp.view.MVPView;
import com.catcoders.pulsafe.mvp.view.MapView;

/**
 * Created by tonimc on 17/4/15.
 */
public class MapPresenter extends Presenter {

    private MVPView mMapView;

    private GetListPersonsInteractor mGetListPersonsInteractor;

    private boolean isLoading = false;

    public MapPresenter(MapView mapView) {

        mMapView = mapView;
        mGetListPersonsInteractor = new GetListPersonsInteractor();

    }



    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
