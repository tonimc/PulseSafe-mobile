package com.catcoders.pulsafe.mvp.view;

import com.catcoders.pulsafe.model.entity.Log;
import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public interface PeopleView extends MVPView {
    void showPersons(List<Log> people);

    void showLoading();

    void hideLoading();

    void showLoadingLabel();

    void showError(String error);

    void hideError();

}
