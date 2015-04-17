package com.catcoders.pulsafe.mvp.view;

import com.catcoders.pulsafe.model.entity.Person;

import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public interface MapView extends MVPView {

    void showPersons(List<Person> persons);

    void showDataPeson(Person person);

    void hideDataPerson(Person person);

    void showLoading();

    void hideLoading();

    void showError(String error);

    void hideError();

    boolean isTheListEmpty();

}
