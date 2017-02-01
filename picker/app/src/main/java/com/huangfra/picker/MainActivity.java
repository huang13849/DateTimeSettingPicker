package com.huangfra.picker;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends FragmentActivity {

    public static final int FRAGMENT_PAGE_ONE = 1;
    public static final int FRAGMENT_PAGE_TWO = 11;
    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    private EditText mEditText;
    private Button entryButton;

    public int year;
    public int month;
    public int day;
    protected int hour;
    protected int minute;
    private ViewPager mViewpager;
    private ArrayList<Fragment> fragmentList;

    public Handler pageChangeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case FRAGMENT_PAGE_ONE:
                    mViewpager.setCurrentItem(0);
                    break;
                case FRAGMENT_PAGE_TWO:
                    mViewpager.setCurrentItem(1);
                default:
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        Fragment datepickerFragment = new DatePickerFragment();
        Fragment timepickerFragment = new TimePickerFragment();
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(datepickerFragment);
        fragmentList.add(timepickerFragment);

        mViewpager = (ViewPager) findViewById(R.id.viewPager);
        mViewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        mViewpager.setCurrentItem(0);
        mViewpager.setOnPageChangeListener(new MyPageChangeListener());
    }


    private void initView() {
        setContentView(R.layout.main_activity);


        /*entryButton = (Button) findViewById(R.id.entry);*/
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);

    }


    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Toast.makeText(MainActivity.this, "You selected the No:" + position + 1 + "page", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


      /*  private void initListener() {
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                fragmentTransaction.add(R.id.fragment_details,datePickerFragment);
                fragmentTransaction.commit();
            }
        });
    }*/
}
