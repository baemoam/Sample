package com.example.moambae.fragmenttestapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().findViewById(R.id.btn_start).setOnClickListener(mClickListener);
        getView().findViewById(R.id.btn_stop).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    Log.v("mabae", "click start");
                    getActivity().startService(new Intent(getActivity(), MyService.class).setAction("start"));
                    break;
                case R.id.btn_stop:
                    getActivity().startService(new Intent(getActivity(), MyService.class).setAction("stop"));
                    Log.v("mabae", "click stop");
                    break;
            }

        }
    };
}
