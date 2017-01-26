package com.goertek.rio.datetimepicker;


import java.util.Calendar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;



public class MainActivity extends Activity {

    private DatePicker mDatePicker;
    private TimePicker mTimePicker;
    private EditText mEditText;
    private Button entryButton;

    // 定义5个记录当前时间的变量
    public int year;
    public int month;
    public int day;
    protected int hour;
    protected int minute;


    protected FragmentTransaction fragmentTransaction;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView();

        initListener();

    }


    private void initView() {
        setContentView(R.layout.main_activity);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        mEditText = (EditText) findViewById(R.id.show);
        entryButton = (Button) findViewById(R.id.entry);
        // 获取当前的年、月、日、小时、分钟
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);


    }

    private void initListener() {
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                fragmentTransaction.add(R.id.fragment_details,datePickerFragment);
                fragmentTransaction.commit();
            }
        });
    }

    // 定义在EditText中显示当前日期、时间的方法
    public void showDate() {
        mEditText.setText("日期为：" + year + "年" + month +1  + "月" + day + "日  "
                + hour + "时" + minute + "分");
    }
}
