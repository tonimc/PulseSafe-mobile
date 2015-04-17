package com.catcoders.pulsesafe.mvp.presenter;

import com.catcoders.pulsesafe.domain.interactor.GetListPersonsInteractor;
import com.catcoders.pulsesafe.mvp.view.MVPView;
import com.catcoders.pulsesafe.mvp.view.MapView;

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
