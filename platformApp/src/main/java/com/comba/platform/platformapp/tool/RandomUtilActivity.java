package com.comba.platform.platformapp.tool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.android.combacommon.toast.ToastUtil;
import com.comba.android.combacommon.utils.RandomUtils;
import com.comba.android.combacommon.utils.StringUtils;
import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class RandomUtilActivity extends Activity {

    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.randomString)
    Button randomString;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.randomNum)
    Button randomNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        ButterKnife.bind(this);
        tvTitle.setText("随机数操作");
        llBack.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.ll_back,R.id.randomString,R.id.randomNum})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.ll_back:
                finish();
                break;
            case R.id.randomString:
                int len = StringUtils.stringToInt(input.getText().toString(),8);
                String res = RandomUtils.createRandomString(len);
                result.setText(res);
                break;
            case R.id.randomNum:
                String[] res1 = input.getText().toString().split("-");
                if (res1.length<2){
                    ToastUtil.showToastShort(this,"最少需要包含一个 “-” ");
                    return;
                }
                int i = StringUtils.stringToInt(res1[0],0);
                int j = StringUtils.stringToInt(res1[1],100);
                int res2 = RandomUtils.getRandomNum(i,j);
                result.setText(res2+"");
        }
    }
}
