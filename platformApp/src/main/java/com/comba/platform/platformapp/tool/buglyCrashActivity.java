package com.comba.platform.platformapp.tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.comba.platform.platformapp.R;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;

public class buglyCrashActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bBugly1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugly_crash);
        bBugly1 = (Button) findViewById(R.id.b_bugly_1);
        bBugly1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.b_bugly_1) {
//            ArrayList arr = null;
//            arr.get(0);
            CrashReport.testJavaCrash();
        }
    }
}
