package com.huangfra.picker;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;

/**
 * Created by root on 24/1/17.
 */

public class DatePickerFragment extends Fragment {

    private DatePicker mDatePicker;
    private ImageView mNext;

    private static final String TAG = "DatePickerFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_setting, container, false);

        mDatePicker = (DatePicker) view.findViewById(R.id.datePicker);
        mNext= (ImageView) view.findViewById(R.id.next);

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

            }
        });

        mDatePicker.setCalendarViewShown(false);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = MainActivity.FRAGMENT_PAGE_TWO;
                ((MainActivity) getActivity()).pageChangeHandler.sendMessage(msg);
                Log.d(TAG, "onClick: send msg FRAGMENT_PAGE_TWO");
            }
        });

    }
}
