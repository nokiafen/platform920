package com.comba.platform.platformapp.tool;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comba.android.combacommon.hardware.SensorUtils;
import com.comba.android.combacommon.toast.ToastUtil;
import com.comba.platform.platformapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class SensorUtilActivity extends Activity {

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.parameterInfo)
    TextView parameterInfo;
    @BindView(R.id.director)
    Button director;
    @BindView(R.id.acc)
    Button acc;
    @BindView(R.id.cichang)
    Button cichang;
    @BindView(R.id.press)
    Button press;
    @BindView(R.id.wendu)
    Button wendu;
    @BindView(R.id.juli)
    Button juli;
    @BindView(R.id.guangxian)
    Button guangxian;
    @BindView(R.id.tuoluoyi)
    Button tuoluoyi;
    @BindView(R.id.grivaty)
    Button grivaty;

    private SensorUtils sensorUtils;
    private boolean directIsOpen = false;
    private boolean accIsOpen = false;
    private boolean ccIsOpen = false;
    private boolean pressIsOpen = false;
    private boolean wenduIsOpen = false;
    private boolean juliIsOpen = false;
    private boolean gxIsOpen = false;
    private boolean tlyIsOpen = false;
    private boolean gravityIsOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        ButterKnife.bind(this);
        initView();
        sensorUtils = SensorUtils.getInstance();
    }

    private void initView(){
        llBack.setVisibility(View.VISIBLE);
        tvTitle.setText("传感器工具类");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.ll_back, R.id.director, R.id.acc, R.id.cichang, R.id.press, R.id.wendu, R.id.juli, R.id.guangxian, R.id.tuoluoyi, R.id.grivaty})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.director:
                if(accIsOpen || ccIsOpen || pressIsOpen || wenduIsOpen || juliIsOpen || gxIsOpen || tlyIsOpen || gravityIsOpen){
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!directIsOpen){
                    sensorUtils.getOrientationSensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    directIsOpen = true;
                    director.setText("停止获取方向传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    directIsOpen = false;
                    director.setText("获取方向传感器信息");
                }
                break;
            case R.id.acc:
                if(directIsOpen || ccIsOpen || pressIsOpen || wenduIsOpen || juliIsOpen || gxIsOpen || tlyIsOpen || gravityIsOpen){
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!accIsOpen){
                    if (!sensorUtils.isSupportAccelerometerSensor()) {
                        ToastUtil.showToastShort(this,"该设备没有加速度传感器");
                        return ;
                    }
                    sensorUtils.getAccelerometerSensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    accIsOpen = true;
                    acc.setText("停止获取加速度传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    accIsOpen = false;
                    acc.setText("获取加速度传感器信息");
                }
                break;
            case R.id.cichang:
                if (directIsOpen || accIsOpen || pressIsOpen || wenduIsOpen || juliIsOpen || gxIsOpen || tlyIsOpen || gravityIsOpen) {
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!ccIsOpen){
                    sensorUtils.getMagneticSensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    ccIsOpen = true;
                    cichang.setText("停止获取磁场传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    ccIsOpen = false;
                    cichang.setText("获取磁场传感器信息");
                }
                break;
            case R.id.press:
                if (directIsOpen || accIsOpen || ccIsOpen || wenduIsOpen || juliIsOpen || gxIsOpen || tlyIsOpen || gravityIsOpen) {
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!pressIsOpen){
                    sensorUtils.getPressureSensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    pressIsOpen = true;
                    press.setText("停止获取压力传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    pressIsOpen = false;
                    press.setText("获取压力传感器信息");
                }
                break;
            case R.id.wendu:
                if (directIsOpen || accIsOpen || ccIsOpen || pressIsOpen || juliIsOpen || gxIsOpen || tlyIsOpen || gravityIsOpen) {
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!wenduIsOpen){
                    if (!sensorUtils.isSupportTemperatureSensor()) {
                        ToastUtil.showToastShort(this,"该设备没有温度传感器");
                        return;
                    }
                    sensorUtils.getTemperatureSensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    wenduIsOpen = true;
                    wendu.setText("停止获取温度传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    wenduIsOpen = false;
                    wendu.setText("获取温度传感器信息");
                }
                break;
            case R.id.juli:
                if (directIsOpen || accIsOpen || ccIsOpen || pressIsOpen || wenduIsOpen || gxIsOpen || tlyIsOpen || gravityIsOpen) {
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!juliIsOpen){
                    if (!sensorUtils.isSupportProximitySensor()) {
                        ToastUtil.showToastShort(this,"该设备没有距离传感器");
                        return;
                    }
                    sensorUtils.getProximitySensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    juliIsOpen = true;
                    juli.setText("停止获取距离传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    juliIsOpen = false;
                    juli.setText("获取距离传感器信息");
                }
                break;
            case R.id.guangxian:
                if(!gxIsOpen){
                    if (directIsOpen || accIsOpen || ccIsOpen || pressIsOpen || wenduIsOpen || juliIsOpen || tlyIsOpen || gravityIsOpen) {
                        ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                        return;
                    }
                    if (!sensorUtils.isSupportLightSensor()) {
                        ToastUtil.showToastShort(this,"该设备没有光线传感器");
                        return;
                    }
                    sensorUtils.getLightSensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    gxIsOpen = true;
                    guangxian.setText("停止获取光线传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    gxIsOpen = false;
                    guangxian.setText("获取光线传感器信息");
                }
                break;
            case R.id.tuoluoyi:
                if (directIsOpen || accIsOpen || ccIsOpen || pressIsOpen || wenduIsOpen || juliIsOpen || gxIsOpen || gravityIsOpen) {
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!tlyIsOpen){
                    if (!sensorUtils.isSupportGyroscopeSensor()) {
                        ToastUtil.showToastShort(this,"该设备没有陀螺仪感应器");
                        return;
                    }
                    sensorUtils.getGyroscopeSensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    tlyIsOpen = true;
                    tuoluoyi.setText("停止获取陀螺仪传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    tlyIsOpen = false;
                    tuoluoyi.setText("获取陀螺仪传感器信息");
                }
                break;
            case R.id.grivaty:
                if (directIsOpen || accIsOpen || ccIsOpen || pressIsOpen || wenduIsOpen || juliIsOpen || gxIsOpen || tlyIsOpen) {
                    ToastUtil.showToastShort(this,"请先停止获取其他传感器信息");
                    return;
                }
                if(!gravityIsOpen){
                    sensorUtils.getGravitySensorInfo(new SensorUtils.OnSensorChangedListener() {
                        @Override
                        public void onChanged(float[] values) {
                            parameterInfo.setText("x:"+values[0]+"\r\n"+"y:"+values[1]+"\r\n"+"z:"+values[2]);
                        }
                    });
                    gravityIsOpen = true;
                    grivaty.setText("停止获取重力传感器信息");
                }else{
                    sensorUtils.unRegisterSensor();
                    gravityIsOpen = false;
                    grivaty.setText("获取重力传感器信息");
                }
                break;
        }
    }
}
