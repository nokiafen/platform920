package com.comba.platform.platformapp.tool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class LogUtilActivity extends Activity {

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.readLog)
    Button readLog;
    @BindView(R.id.writeInfoLog)
    Button writeInfoLog;
    @BindView(R.id.writeDebugLog)
    Button writeDebugLog;
    @BindView(R.id.writeWarnLog)
    Button writeWarnLog;
    @BindView(R.id.writeErrorLog)
    Button writeErrorLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(this);
        llBack.setVisibility(View.VISIBLE);
        tvTitle.setText("日志工具");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @OnClick({R.id.ll_back,R.id.writeInfoLog, R.id.writeDebugLog, R.id.writeWarnLog, R.id.writeErrorLog,R.id.readLog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.writeInfoLog:
//                LogUtils.i(input.getText().toString());
                break;
            case R.id.writeDebugLog:
//                LogUtils.d(input.getText().toString());
                break;
            case R.id.writeWarnLog:
//                LogUtils.w(input.getText().toString());
                break;
            case R.id.writeErrorLog:
//                LogUtils.e(input.getText().toString());
                break;
            case R.id.readLog:
//                result.setText(LogUtils.readLog());
                break;
        }
    }
}
