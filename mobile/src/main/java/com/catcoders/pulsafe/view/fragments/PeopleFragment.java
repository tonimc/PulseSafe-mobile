package com.catcoders.pulsafe.view.fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.catcoders.pulsafe.R;
import com.catcoders.pulsafe.helper.MessageHelper;
import com.catcoders.pulsafe.model.entity.Log;
import com.catcoders.pulsafe.mvp.presenter.PeoplePresenter;
import com.catcoders.pulsafe.mvp.view.PeopleView;
import com.catcoders.pulsafe.view.activity.PersonActivity;
import com.catcoders.pulsafe.view.adapter.PeopleAdapter;
import com.catcoders.pulsafe.view.listener.RecyclerViewClickListener;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class PeopleFragment extends Fragment implements PeopleView, RecyclerViewClickListener {

    private PeopleAdapter mPeopleAdapter;
    private PeoplePresenter mPeoplePresenter;

    @InjectView(R.id.progress_bar) ProgressBar mProgressBar;
    @InjectView(R.id.people_list) RecyclerView mPeopleListRecyclerView;


    public PeopleFragment() {
        mPeoplePresenter = new PeoplePresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_people, container, false);

        ButterKnife.inject(this, view);

        mPeopleListRecyclerView.setHasFixedSize(true);
        mPeopleListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPeopleListRecyclerView.setItemAnimator(new DefaultItemAnimator());


        return view;
    }

    public void addNewDataLog(Log data) {
        mPeopleAdapter.addPerson(data);
    }

    public void addNewDataLog(String log) {
        addNewDataLog(Log.jsonDeserialized(log));
    }


    @Override
    public void showPersons(List<Log> people) {
        if(mPeopleAdapter!=null) {
            mPeopleAdapter = new PeopleAdapter(people);
            mPeopleAdapter.setRecyclerListListener(this);
            mPeopleListRecyclerView.setAdapter(mPeopleAdapter);
        }

    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoadingLabel() {
        MessageHelper.showMessage(getContext(), "Cargando");
    }


    @Override
    public void hideError() {

    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onClick(View touchedView, int position, float touchedX, float touchedY) {

        Intent personActivityIntent = new Intent (
                getContext(), PersonActivity.class);

        int id = mPeopleAdapter.getLogList().get(position).getId();
        personActivityIntent.putExtra("id", id);
    }


    @Override
    public void onStop() {

        super.onStop();
        mPeoplePresenter.start();
    }

    @Override
    public void onStart() {

        super.onStart();
        mPeoplePresenter.start();
    }

}
