package com.catcoders.pulsafe.view.activity;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;

import com.catcoders.pulsafe.model.entity.Log;
import com.catcoders.pulsafe.model.entity.User;
import com.catcoders.pulsafe.mvp.view.PersonView;

import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public class PersonActivity extends ActionBarActivity implements PersonView {


    @Override
    public void showPerson(User person) {

    }

    @Override
    public void showLogGraph(List<Log> logs) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoadingLabel() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public Context getContext() {
        return this;
    }
}
