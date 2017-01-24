package com.goertek.rio.datetimepicker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by root on 24/1/17.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    private static final String TAG = "TimePickerFragment";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        Log.d(TAG, "onTimeSet: hour : " + hourOfDay + " minute " + minute );
    }
}
