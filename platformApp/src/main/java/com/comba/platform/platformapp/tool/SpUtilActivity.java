package com.comba.platform.platformapp.tool;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.android.combacommon.utils.PreferencesUtils;
import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class SpUtilActivity extends Activity {

    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.inputKey)
    EditText inputKey;
    @BindView(R.id.inputValue)
    EditText inputValue;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.writeLog)
    Button writeLog;
    @BindView(R.id.readLog)
    Button readLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        llBack.setVisibility(View.VISIBLE);
        tvTitle.setText("SharePreference操作");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.ll_back, R.id.writeLog, R.id.readLog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.writeLog:
                String key = inputKey.getText().toString();
                String value = inputValue.getText().toString();
                PreferencesUtils.putString(this,key,value);
                break;
            case R.id.readLog:
                String key1 = inputKey.getText().toString();
//                String value1 = inputValue.getText().toString();
                String resu = PreferencesUtils.getString(this,key1);
                if (TextUtils.isEmpty(resu)) {
                    result.setText("不存在对应的value值");
                }else{
                    result.setText(resu);
                }

                break;
        }
    }
}
