package com.comba.platform.platformapp.tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.comba.android.combacommon.toast.ToastUtil;
import com.comba.platform.platformapp.R;

public class ToastUtilActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bToast1;
    private Button bToast2;
    private Button bToast3;
    private Button bToast4;
    private Button bToast5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_util);
        bToast1 = (Button) findViewById(R.id.b_toast_1);
        bToast2 = (Button) findViewById(R.id.b_toast_2);
        bToast3 = (Button) findViewById(R.id.b_toast_3);
        bToast4 = (Button) findViewById(R.id.b_toast_4);
        bToast5 = (Button) findViewById(R.id.b_toast_5);
        bToast1.setOnClickListener(this);
        bToast2.setOnClickListener(this);
        bToast3.setOnClickListener(this);
        bToast4.setOnClickListener(this);
        bToast5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.b_toast_1) {
            ToastUtil.showToastShort(this,"测试-showToastShort");
        }else if(view.getId()== R.id.b_toast_2){
            ToastUtil.showToastLong(this,"测试-showToastLong");
        }else if(view.getId()== R.id.b_toast_3){
            ToastUtil.showToast(this,"显示一个toast，在这个toast没有完全消失之前，不会再显示同样的toast", Toast.LENGTH_SHORT);
        }else if(view.getId()== R.id.b_toast_4){
            ToastUtil.showToastWithAlertPic(this,"测试-showToastWithAlertPic");
        }else if(view.getId()== R.id.b_toast_5){
            ToastUtil.showToastWithOkPic(this,"测试-showToastWithOkPic");
        }
    }
}
