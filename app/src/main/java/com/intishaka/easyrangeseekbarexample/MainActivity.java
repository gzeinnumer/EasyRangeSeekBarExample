package com.intishaka.easyrangeseekbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.gzeinnumer.ers.RangeSeekBar;
import com.gzeinnumer.ers.callback.ListenerSeekBar;
import com.gzeinnumer.ers.callback.TextFormatterSeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init1();
        init2();
        init3();
    }

    private void init1() {
        RangeSeekBar rangeSeekBar = findViewById(R.id.rsb_1);
        rangeSeekBar.setMax(500);
        rangeSeekBar.setListener(new ListenerSeekBar() {
            @Override
            public void valueChanged(RangeSeekBar rangeSeekBar, float currentValue) {

            }
        });
    }

    private void init2() {
        RangeSeekBar rangeSeekBar = findViewById(R.id.rsb_2);
        rangeSeekBar.setMin(100);
        rangeSeekBar.setMax(500);
        rangeSeekBar.setCurrentValue(250);
        rangeSeekBar.setTextMax("max\nvalue");
        rangeSeekBar.setTextMin("min\nvalue");
        rangeSeekBar.setTextFormatter(new TextFormatterSeekBar() {
            @Override
            public String format(float value) {
                return String.format("Rp. %d", (int) value);
            }
        });
        rangeSeekBar.setListener(new ListenerSeekBar() {
            @Override
            public void valueChanged(RangeSeekBar rangeSeekBar, float currentValue) {
                Log.d("_TAG", "valueChanged: "+currentValue);
            }
        });
    }

    private void init3() {
        RangeSeekBar rangeSeekBar = (RangeSeekBar) findViewById(R.id.rsb_3);
        rangeSeekBar.setMax(3000);
        rangeSeekBar.setRegionTextFormatter(new RangeSeekBar.RegionTextFormatter() {
            @Override
            public String format(int region, float value) {
                return String.format("region %d : %d", region, (int) value);
            }
        });
    }
}