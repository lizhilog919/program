package com.test.demo.widget;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.test.demo.BaseActivity;
import com.test.demo.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NumberPickerActivity extends BaseActivity {

    NumberPicker mPickerMoney, mPickerTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);
        initView();
    }

    private void initView(){
        mPickerMoney = (NumberPicker) findViewById(R.id.money);
        mPickerTime = (NumberPicker) findViewById(R.id.time);
        mPickerMoney.setMaxValue(50);
        mPickerMoney.setMinValue(5);
        mPickerMoney.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        mPickerMoney.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return value+"00";
            }
        });
        mPickerMoney.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(mActivity, String.valueOf(newVal * 100), Toast.LENGTH_SHORT).show();
            }
        });
        mPickerMoney.setValue(10);
        try {
            Method method = mPickerMoney.getClass().getDeclaredMethod("changeValueByOne",boolean.class);
            method.setAccessible(true);
            method.invoke(mPickerMoney,true);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        mPickerTime.setMaxValue(50);
        mPickerTime.setMinValue(5);
        mPickerTime.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        String[] values = new String[46];
        for (int i = 5; i < 51; i++) {
            values[i-5] = i+"00";
        }
        mPickerTime.setDisplayedValues(values);
        mPickerTime.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Toast.makeText(mActivity, String.valueOf(newVal * 100), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
