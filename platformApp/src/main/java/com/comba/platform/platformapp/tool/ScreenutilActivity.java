package com.comba.platform.platformapp.tool;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.comba.android.combacommon.utils.ScreenUtil;
import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chenhailin on 2017/9/24.
 */

public class ScreenutilActivity extends AppCompatActivity {

    @BindView(R.id.bt_getwith)
    Button btGetwith;
    @BindView(R.id.bt_getheight)
    Button btGetheight;
    @BindView(R.id.bt_statusheight)
    Button btStatusheight;
    @BindView(R.id.bt_navitationheight)
    Button btNavitationheight;
    @BindView(R.id.bt_getdpi)
    Button btGetdpi;
    @BindView(R.id.tv_descrip)
    TextView tvDescrip;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_util_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_getwith, R.id.bt_getheight, R.id.bt_statusheight, R.id.bt_navitationheight, R.id.bt_getdpi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_getwith:
               tvDescrip.setText("屏宽"+ScreenUtil.getDisplayWith()+"px");
                break;
            case R.id.bt_getheight:
                tvDescrip.setText("屏高"+ScreenUtil.getDisplayHeight()+"px");
                break;
            case R.id.bt_statusheight:
                tvDescrip.setText("状态栏高"+ScreenUtil.getStatusBarHeight(this)+"px");

                break;
            case R.id.bt_navitationheight:
                tvDescrip.setText("导航栏高"+ScreenUtil.getNavBarHeight(this)+"px");
                break;
            case R.id.bt_getdpi:
                tvDescrip.setText("屏幕像素密度"+ScreenUtil.densityDpi+"px");
                break;
        }
    }


}
