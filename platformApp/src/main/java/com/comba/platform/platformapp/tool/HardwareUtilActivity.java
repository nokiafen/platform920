package com.comba.platform.platformapp.tool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.android.combacommon.hardware.BluetoothUtils;
import com.comba.android.combacommon.hardware.CpuUtils;
import com.comba.android.combacommon.hardware.GPSUtils;
import com.comba.android.combacommon.hardware.MemoryUtils;
import com.comba.android.combacommon.hardware.WifiUtils;
import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class HardwareUtilActivity extends Activity {

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.wifiEnable)
    Button wifiEnable;
    @BindView(R.id.openWifi)
    Button openWifi;
    @BindView(R.id.closeWifi)
    Button closeWifi;
    @BindView(R.id.gpsEnable)
    Button gpsEnable;
    @BindView(R.id.openGps)
    Button openGps;
    @BindView(R.id.btSupport)
    Button btSupport;
    @BindView(R.id.btEnable)
    Button btEnable;
    @BindView(R.id.openBt)
    Button openBt;
    @BindView(R.id.closeBt)
    Button closeBt;
    @BindView(R.id.currMem)
    Button currMem;
    @BindView(R.id.totalMem)
    Button totalMem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        llBack.setVisibility(View.VISIBLE);
        tvTitle.setText("硬件操作工具类");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.ll_back, R.id.wifiEnable, R.id.openWifi, R.id.closeWifi, R.id.gpsEnable, R.id.openGps, R.id.btSupport, R.id.btEnable, R.id.openBt, R.id.closeBt, R.id.currMem, R.id.totalMem})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.wifiEnable:
                boolean res  = WifiUtils.isWifiEnabled(this);
                result.setText(res ? "wifi开关已打开":"wifi开关已关闭");
                break;
            case R.id.openWifi:
                WifiUtils.setWifiEnabled(this);
                break;
            case R.id.closeWifi:
                WifiUtils.setWifiDisabled(this);
                break;
            case R.id.gpsEnable:
                boolean gps = GPSUtils.isGpsEnabled(this);
                result.setText(gps ? "GPS已打开":"GPS已关闭");
                break;
            case R.id.openGps:
                GPSUtils.openGPS(this);
                break;
            case R.id.btSupport:
                boolean bt  = BluetoothUtils.isBluetoothSupported();
                result.setText(bt ? "该设备支持蓝牙":"该设备不支持蓝牙");
                break;
            case R.id.btEnable:
                boolean enable = BluetoothUtils.isBluetoothEnabled();
                result.setText(enable ? "蓝牙已打开":"蓝牙已关闭");
                break;
            case R.id.openBt:
                BluetoothUtils.turnOnBluetooth();
                break;
            case R.id.closeBt:
                BluetoothUtils.turnOffBluetooth();
                break;
            case R.id.currMem:
                long mem = MemoryUtils.getAvailMemoryWithM(this);
                result.setText(mem + "M");
                break;
            case R.id.totalMem:
                long totalM = MemoryUtils.getTotalMemoryWithM();
                result.setText(totalM +"M");
                break;
        }
    }
}
