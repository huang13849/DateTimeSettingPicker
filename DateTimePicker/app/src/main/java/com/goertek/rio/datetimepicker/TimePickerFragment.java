package com.goertek.rio.datetimepicker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by root on 24/1/17.
 */

public class TimePickerFragment extends Fragment {


    private static final String TAG = "TimePickerFragment";
    private TimePicker mTimePicker;
    public int year;
    public int month;
    public int day;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.time_setting, container, false);

        mTimePicker = (TimePicker) view.findViewById(R.id.timePicker);

        initView();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTimePicker = (TimePicker) getActivity().findViewById(R.id.timePicker);

    }

    public void initView(){


        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker arg0, int hour, int minute) {
                ((MainActivity)getActivity()).hour = hour;
                ((MainActivity)getActivity()).minute = minute;
                // 显示当前日期、时间
                ((MainActivity)getActivity()).showDate();
            }
        });

    }


}
