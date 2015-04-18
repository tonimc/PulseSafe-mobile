package com.catcoders.pulsafe.mvp.presenter;

import com.catcoders.pulsafe.domain.interactor.GetListPeopleInteractor;
import com.catcoders.pulsafe.mvp.view.PeopleView;
import com.catcoders.pulsafe.model.entity.Log;

import java.util.List;

/**
 * Created by tonimc on 18/4/15.
 */
public class PeoplePresenter extends Presenter implements GetListPeopleInteractor.Callback {

    private PeopleView mPeopleView;
    private GetListPeopleInteractor mGetListPeopleInteractor;

    public PeoplePresenter(PeopleView peopleView) {
        mPeopleView = peopleView;
    }

    public void getPeople() {
        mGetListPeopleInteractor.getPeopleList();
    }

    @Override
    public void onUserListLoaded(List<Log> usersCollection) {
        mPeopleView.showPersons(usersCollection);
    }

    @Override
    public void start() {
        mGetListPeopleInteractor = new GetListPeopleInteractor(this);
        getPeople();
    }

    @Override
    public void stop() {
        mGetListPeopleInteractor = null;
    }
}
