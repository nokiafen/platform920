package com.comba.platform.platformapp.widget;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.comba.android.combacommon.contacts.ContactRecordListActivity;
import com.comba.android.combacommon.dialog.DialogSampleActivity;
import com.comba.platform.platformapp.R;
import com.comba.platform.platformapp.tool.ContainerUtilActivity;
import com.comba.platform.platformapp.tool.DateformatUtilActivity;
import com.comba.platform.platformapp.tool.HardwareUtilActivity;
import com.comba.platform.platformapp.tool.LogUtilActivity;
import com.comba.platform.platformapp.tool.RandomUtilActivity;
import com.comba.platform.platformapp.tool.ResourceUtilsActivity;
import com.comba.platform.platformapp.tool.ScreenutilActivity;
import com.comba.platform.platformapp.tool.SensorUtilActivity;
import com.comba.platform.platformapp.tool.ShellUtilsActivity;
import com.comba.platform.platformapp.tool.SpUtilActivity;
import com.comba.platform.platformapp.tool.StringUtilActivity;
import com.comba.platform.platformapp.tool.SystemInfoUtilActivity;
import com.comba.platform.platformapp.tool.TimerUtilsActivity;
import com.comba.platform.platformapp.tool.ToastUtilActivity;
import com.comba.platform.platformapp.tool.buglyCrashActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class ToolFragment extends Fragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    Unbinder unbinder;
    @BindView(R.id.stringUtil)
    Button stringUtil;
    @BindView(R.id.randomUtil)
    Button randomUtil;
    @BindView(R.id.containerUtil)
    Button containerUtil;
    @BindView(R.id.dateUtil)
    Button dateUtil;
    @BindView(R.id.injectUtil)
    Button injectUtil;
    @BindView(R.id.sensorUtil)
    Button sensorUtil;
    @BindView(R.id.hardwareUtil)
    Button hardwareUtil;
    @BindView(R.id.logUtil)
    Button logUtil;
    @BindView(R.id.sharepreferenceUtil)
    Button sharepreferenceUtil;
    private View mFragmentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView != null) {
            ViewGroup parent = (ViewGroup) mFragmentView.getParent();
            if (parent != null) {
                parent.removeView(mFragmentView);
            }

        } else {
            mFragmentView = inflater.inflate(R.layout.fragment_tool, container, false);
            ButterKnife.bind(this, mFragmentView);
        }
        unbinder = ButterKnife.bind(this, mFragmentView);
        initViews();
        return mFragmentView;
    }

    private void initViews() {
        tvTitle.setText("工具类");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.stringUtil, R.id.randomUtil, R.id.containerUtil, R.id.dateUtil, R.id.injectUtil,
            R.id.sensorUtil, R.id.hardwareUtil, R.id.logUtil, R.id.sharepreferenceUtil,R.id.ResourceUtils,R.id.ShellUtils,R.id.ToastUtil,R.id.buglyCrash,
            R.id.TimerUtils,R.id.push,R.id.screenUtil,R.id.sytemInfo,R.id.contactInfo,R.id.dialogUtil})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.stringUtil:
                Intent intent = new Intent(getActivity(), StringUtilActivity.class);
                startActivity(intent);
                break;
            case R.id.randomUtil:
                Intent intent1 = new Intent(getActivity(), RandomUtilActivity.class);
                startActivity(intent1);
                break;
            case R.id.containerUtil:
                Intent intent2 = new Intent(getActivity(), ContainerUtilActivity.class);
                startActivity(intent2);
                break;
            case R.id.dateUtil:
                Intent intent3 = new Intent(getActivity(), DateformatUtilActivity.class);
                startActivity(intent3);
                break;
            case R.id.injectUtil:
                break;
            case R.id.sensorUtil:
                Intent intent4 = new Intent(getActivity(), SensorUtilActivity.class);
                startActivity(intent4);
                break;
            case R.id.hardwareUtil:
                Intent intent5 = new Intent(getActivity(), HardwareUtilActivity.class);
                startActivity(intent5);
                break;
            case R.id.logUtil:
                Intent intent6 = new Intent(getActivity(), LogUtilActivity.class);
                startActivity(intent6);
                break;
            case R.id.sharepreferenceUtil:
                Intent intent7 = new Intent(getActivity(), SpUtilActivity.class);
                startActivity(intent7);
                break;
            case R.id.ResourceUtils:
                Intent intent8 = new Intent(getActivity(), ResourceUtilsActivity.class);
                startActivity(intent8);
                break;
            case R.id.ShellUtils:
                Intent intent9 = new Intent(getActivity(), ShellUtilsActivity.class);
                startActivity(intent9);
                break;
            case R.id.ToastUtil:
                Intent intent10 = new Intent(getActivity(), ToastUtilActivity.class);
                startActivity(intent10);
                break;
            case R.id.buglyCrash:
                Intent intent11 = new Intent(getActivity(), buglyCrashActivity.class);
                startActivity(intent11);
                break;
            case R.id.TimerUtils:
                Intent intent12 = new Intent(getActivity(), TimerUtilsActivity.class);
                startActivity(intent12);
                break;
            case R.id.push:

                break;
            case R.id.screenUtil:
                Intent intentScreen= new Intent(getActivity(), ScreenutilActivity.class);
                startActivity(intentScreen);
                break;
            case R.id.sytemInfo:
                Intent intentSystemInfo= new Intent(getActivity(), SystemInfoUtilActivity.class);
                startActivity(intentSystemInfo);
                break;
            case R.id.contactInfo:
                Intent intentContact= new Intent(getActivity(), ContactRecordListActivity.class);
                startActivity(intentContact);
                break;
            case R.id.dialogUtil:
                Intent intentDialog= new Intent(getActivity(), DialogSampleActivity.class);
                startActivity(intentDialog);
                break;
        }
    }
}
