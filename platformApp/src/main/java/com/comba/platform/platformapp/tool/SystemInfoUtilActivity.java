package com.comba.platform.platformapp.tool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.comba.android.combacommon.utils.SystemInfo;
import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chenhailin on 2017/9/24.
 */

public class SystemInfoUtilActivity extends AppCompatActivity {

    @BindView(R.id.tv_descrip)
    TextView tvDescrip;
    @BindView(R.id.bt_phone_type)
    Button btPhoneType;
    @BindView(R.id.bt_systemversion)
    Button btSystemversion;
    @BindView(R.id.bt_sdkversion)
    Button btSdkversion;
    @BindView(R.id.bt_softversion)
    Button btSoftversion;
    @BindView(R.id.bt_others)
    Button btOthers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.systeminfo_layout);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv_descrip, R.id.bt_phone_type, R.id.bt_systemversion, R.id.bt_sdkversion, R.id.bt_softversion, R.id.bt_others})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_descrip:

                break;
            case R.id.bt_phone_type:
                tvDescrip.setText("手机型号"+SystemInfo.getPhoneModel());
                break;
            case R.id.bt_systemversion:
                tvDescrip.setText("系统版本"+SystemInfo.getVersionRelease(this));
                break;
            case R.id.bt_sdkversion:
                tvDescrip.setText("SDK版本"+SystemInfo.getVersionSdk());
                break;
            case R.id.bt_softversion:
                tvDescrip.setText("系统版本"+SystemInfo.getTelephonyInfo(this));
                break;
            case R.id.bt_others:
                tvDescrip.setText("其它"+SystemInfo.getTelephonyInfo(this));
                break;
        }
    }
}
