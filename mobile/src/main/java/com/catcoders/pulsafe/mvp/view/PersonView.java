package com.catcoders.pulsafe.mvp.view;

import com.catcoders.pulsafe.model.entity.Log;
import com.catcoders.pulsafe.model.entity.User;

import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public interface PersonView extends MVPView {
    void showPerson(User person);

    void showLogGraph(List<Log> logs);

    void showLoading();

    void hideLoading();

    void showLoadingLabel();

    void showError(String error);

    void hideError();

}
