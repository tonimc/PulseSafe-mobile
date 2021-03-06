package com.catcoders.pulsafe.mvp.view;

import com.catcoders.pulsafe.model.entity.User;

import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public interface MapView extends MVPView {

    void showPersons(List<User> persons);

    void showDataPeson(User person);

    void hideDataPerson(User person);

    void showLoading();

    void hideLoading();

    void showError(String error);

    void hideError();

    boolean isTheListEmpty();

}
