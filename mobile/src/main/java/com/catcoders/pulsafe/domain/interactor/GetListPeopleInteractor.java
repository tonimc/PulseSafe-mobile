package com.catcoders.pulsafe.domain.interactor;

import android.os.AsyncTask;

import com.catcoders.pulsafe.model.entity.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonimc on 17/4/15.
 */
public class GetListPeopleInteractor implements interactor {

    Callback mCallbackPersons;

    public interface Callback {
        void onUserListLoaded(List<Log> usersCollection);
    }

    public GetListPeopleInteractor(Callback callback) {
        mCallbackPersons = callback;
    }


    public void getPeopleList() {
        new AsyncTask<Void, Void, List<Log>>() {
            @Override
            protected List<Log> doInBackground(Void... params) {


                List<Log> users = new ArrayList<Log>();
                users.add(new Log("18/4/2015", "HEARTRATE",1,"95","toni", "23"));
                users.add(new Log("18/4/2015", "HEARTRATE",2,"92","cesar", "43"));
                users.add(new Log("18/4/2015", "HEARTRATE",3,"115","adam", "23"));
                users.add(new Log("18/4/2015", "HEARTRATE",4,"65","carmen", "44"));
                users.add(new Log("18/4/2015", "HEARTRATE",5,"23","elisa", "32"));
                users.add(new Log("18/4/2015", "HEARTRATE",6,"65","manuel", "43"));
                users.add(new Log("18/4/2015", "HEARTRATE",7,"89","natalia", "35"));

                return users;
            }

            @Override
            protected void onPostExecute(List<Log> list) {

                super.onPostExecute(list);

                mCallbackPersons.onUserListLoaded(list);
            }
        }.execute();
    }

}
