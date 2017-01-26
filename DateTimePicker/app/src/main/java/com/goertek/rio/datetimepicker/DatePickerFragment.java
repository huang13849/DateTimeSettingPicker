package com.goertek.rio.datetimepicker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by root on 24/1/17.
 */

public class DatePickerFragment extends Fragment {

    private DatePicker mDatePicker;


    private static final String TAG = "DatePickerFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_setting, container, false);

        mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);
        if(mDatePicker ==null){
            Log.d(TAG, "onCreateView: mDatePicker is null!!");
        }
        initView();

        return view;
    }

    public void initView(){


        mDatePicker.init(((MainActivity)getActivity()).year, ((MainActivity)getActivity()).month, ((MainActivity)getActivity()).day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker arg0, int year, int month, int day) {
                ((MainActivity)getActivity()).year = year;
                ((MainActivity)getActivity()).month = month;
                ((MainActivity)getActivity()).day = day;
                // 显示当前日期、时间
                ((MainActivity)getActivity()).showDate();
            }
        });

        mDatePicker.setCalendarViewShown(false);


    }
}
