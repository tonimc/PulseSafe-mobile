package com.catcoders.pulsesafe.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.catcoders.pulsesafe.R;
import com.catcoders.pulsesafe.mvp.view.MapView;

public class MainActivity extends Activity implements MapView {

    private TextView mTextView;


    @InjectView(R.id.activity_movies_toolbar)   Toolbar mToolbar;
    @InjectView(R.id.activity_movies_progress)  ProgressBar mProgressBar;
    @InjectView(R.id.recycler_popular_movies)
    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
    }

    @Override
    public Context getContext() {
        return this;
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

        // TODO
    }

    @Override
    public void hideError() {

        // TODO
    }
}
