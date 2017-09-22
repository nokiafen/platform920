package com.comba.platform.platformapp.tool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.android.combacommon.utils.DateUtil;
import com.comba.platform.platformapp.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class DateformatUtilActivity extends Activity {

    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.d1)
    Button d1;
    @BindView(R.id.d2)
    Button d2;
    @BindView(R.id.d4)
    Button d4;
    @BindView(R.id.d5)
    Button d5;
    @BindView(R.id.d6)
    Button d6;
    @BindView(R.id.d7)
    Button d7;
    @BindView(R.id.d8)
    Button d8;
    @BindView(R.id.d9)
    Button d9;
    @BindView(R.id.d11)
    Button d11;
    @BindView(R.id.d12)
    Button d12;
    @BindView(R.id.d13)
    Button d13;
    @BindView(R.id.d14)
    Button d14;
    @BindView(R.id.d15)
    Button d15;
    @BindView(R.id.d16)
    Button d16;
    @BindView(R.id.d17)
    Button d17;
    @BindView(R.id.d18)
    Button d18;
    @BindView(R.id.d19)
    Button d19;
    @BindView(R.id.d20)
    Button d20;
    @BindView(R.id.ll_back)
    LinearLayout llback;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateformat);
        ButterKnife.bind(this);
        tvTitle.setText("日期转换工具类");
        llback.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.d1, R.id.d2,  R.id.d4, R.id.d5, R.id.d6, R.id.d7,
            R.id.d8, R.id.d9,  R.id.d11, R.id.d12, R.id.d13, R.id.d14, R.id.d15,
            R.id.d16, R.id.d17, R.id.d18, R.id.d19, R.id.d20,R.id.ll_back})
    public void onViewClicked(View view) {
        Date date = new Date();
        switch (view.getId()) {
            case R.id.d1:
                String res1 = DateUtil.getStringForYYYYMMDDHHMISS(date);
                result.setText(res1);
                break;
            case R.id.d2:
                String res2 = DateUtil.getStringForYYYY_MM_DD_HH_MI_SS(date);
                result.setText(res2);
                break;
            case R.id.d4:
                String res4 = DateUtil.getStringForYYYY_MM_DD_HH_MI_SS2(date);
                result.setText(res4);
                break;
            case R.id.d5:
                String res5 = DateUtil.getStringForYY_MM_DD_HH_MI_SS(date);
                result.setText(res5);
                break;
            case R.id.d6:
                result.setText(DateUtil.getStringForYYYY_MM_DD_HH_MI(date));
                break;
            case R.id.d7:
                result.setText(DateUtil.getStringForYYYYMMDD(date));
                break;
            case R.id.d8:
                result.setText(DateUtil.getStringForYYYY_MM_DD(date));
                break;
            case R.id.d9:
                result.setText(DateUtil.getStringForYYYY_MM_DD2(date));
                break;
            case R.id.d11:
                result.setText(DateUtil.getStringForYYYYMM(date));
                break;
            case R.id.d12:
                result.setText(DateUtil.getStringForYYYY_MM(date));
                break;
            case R.id.d13:
                result.setText(DateUtil.getStringForYYMMDD(date));
                break;
            case R.id.d14:
                result.setText(DateUtil.getStringForHHMISS(date));
                break;
            case R.id.d15:
                result.setText(DateUtil.getStringForHH_MI_SS(date));
                break;
            case R.id.d16:
                //getStringTimeToLong
                break;
            case R.id.d17:
                result.setText(DateUtil.getWeekday(date));
                break;
            case R.id.d18:
                result.setText(DateUtil.getShortWeekday(date));
                break;
            case R.id.d19:
                result.setText(DateUtil.formatSecond2Day(111111111));
                break;
            case R.id.d20:
                Date date1 = DateUtil.offsetDay(date,12);
                result.setText(date1.toLocaleString());
                break;
            case R.id.ll_back:
                finish();
                break;
        }
    }
}
