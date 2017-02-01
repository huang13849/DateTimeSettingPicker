package com.huangfra.picker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.os.Message;
/**
 * Created by root on 24/1/17.
 */

public class TimePickerFragment extends Fragment {


    private static final String TAG = "TimePickerFragment";
    private TimePicker mTimePicker;
    private ImageView mFinished;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_setting, container, false);

        mTimePicker = (TimePicker) view.findViewById(R.id.timePicker);
        mFinished = (ImageView) view.findViewById(R.id.finished);
        initView();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void initView(){

        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker arg0, int hour, int minute) {
                ((MainActivity)getActivity()).hour = hour;
                ((MainActivity)getActivity()).minute = minute;
                Log.d(TAG, "onTimeChanged: hour is " + hour + " minute is " + minute);
            }
        });
        mFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = MainActivity.FRAGMENT_PAGE_ONE;
                ((MainActivity) getActivity()).pageChangeHandler.sendMessage(msg);
                Log.d(TAG, "onClick: send msg FRAGMENT_PAGE_ONE");
            }
        });
    }


}
