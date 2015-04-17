package com.catcoders.pulsafe.view.activity;

import android.content.Context;

import com.catcoders.pulsafe.model.entity.Person;
import com.catcoders.pulsafe.mvp.view.PersonsView;

import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public class PersonActivity implements PersonsView {



    @Override
    public void showPersons(List<Person> persons) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public boolean isTheListEmpty() {
        return false;
    }

    @Override
    public Context getContext() {
        return null;
    }
}
