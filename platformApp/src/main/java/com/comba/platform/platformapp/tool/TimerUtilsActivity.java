package com.comba.platform.platformapp.tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.comba.android.combacommon.toast.ToastUtil;
import com.comba.android.combacommon.utils.TimerUtils;
import com.comba.platform.platformapp.R;

import java.util.Date;
import java.util.TimerTask;

public class TimerUtilsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bTimer1;
    private Button bTimer2;
    private Button bTimer3;
    private Button bTimer4;
    private Button bTimer5;
    private Button bTimer6;
    private TimerUtils instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_utils);
        bTimer1 = (Button) findViewById(R.id.b_timer_1);
        bTimer2 = (Button) findViewById(R.id.b_timer_2);
        bTimer3 = (Button) findViewById(R.id.b_timer_3);
        bTimer4 = (Button) findViewById(R.id.b_timer_4);
        bTimer5 = (Button) findViewById(R.id.b_timer_5);
        bTimer6 = (Button) findViewById(R.id.b_timer_6);
        bTimer1.setOnClickListener(this);
        bTimer2.setOnClickListener(this);
        bTimer3.setOnClickListener(this);
        bTimer4.setOnClickListener(this);
        bTimer5.setOnClickListener(this);
        bTimer6.setOnClickListener(this);
        instance = new TimerUtils();
    }

    public void showToast(final String ssr){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtil.showToastShort(TimerUtilsActivity.this,ssr);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.b_timer_1) {
            instance.m_TimerSchedule(new TimerTask() {
                @Override
                public void run() {
                    showToast("定时器-1秒后-间隔1秒");
                }
            },1000,1000);
        }else if(view.getId()== R.id.b_timer_2){
            instance.m_TimerSchedule(new TimerTask() {
                @Override
                public void run() {
                    showToast("定时器-当前时间10秒后-间隔1秒");
                }
            },new Date(new Date().getTime()+10000),1000);
        }else if(view.getId()== R.id.b_timer_3){
            instance.m_TimerSchedule(new TimerTask() {
                @Override
                public void run() {
                    showToast("定时器-1秒后弹出1次");
                }
            },1000);
        }else if(view.getId()== R.id.b_timer_4){
            instance.m_TimerSchedule(new TimerTask() {
                @Override
                public void run() {
                    showToast("定时器-1秒后弹出1次");
                }
            },new Date(new Date().getTime()+10000));
        }else if(view.getId()== R.id.b_timer_5){
            instance.m_CountDownTimer(10000,1000,new TimerUtils.CountDownTimerCallBack(){

                @Override
                public void onTick(long var1) {
                    showToast("定时器-"+var1);
                }

                @Override
                public void onFinish() {
                    showToast("定时器-结束");
                }
            });
        }else if(view.getId()== R.id.b_timer_6){
            instance.m_HandlerPostDelayed(new Runnable() {
                @Override
                public void run() {
                    showToast("定时器-1秒后弹出");
                }
            },1000);
        }
    }
}
