package com.catcoders.pulsesafe.mvp.view;

import com.catcoders.pulsesafe.model.entity.Person;

import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public interface PersonsView extends MVPView {
    void showPersons(List<Person> persons);

    void showLoading();

    void hideLoading();

    void showError(String error);

    void hideError();

    boolean isTheListEmpty();
}
