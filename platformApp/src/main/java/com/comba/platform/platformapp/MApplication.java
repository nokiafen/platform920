package com.comba.platform.platformapp;

import com.comba.android.combacommon.PlatFormApplication;
import com.comba.android.combacommon.utils.Cache;
import com.tencent.bugly.crashreport.CrashReport;
//import com.umeng.message.IUmengRegisterCallback;
//import com.umeng.message.PushAgent;

/**
 * Created by zhangjiawei on 2017/9/22.
 */

public class MApplication extends PlatFormApplication {

    @Override
    public void onCreate() {
        super.onCreate();
//        initPush();
        initBugly();
        Cache.setContext(this);

    }

    private void initPush() {
//        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回device token
////                LogUtils.i("umeng-deviceToken:" + deviceToken);
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
////                LogUtils.i("umeng-onFailure:" + s + s1);
//            }
//        });
    }

    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext(), "46bc61b281", false);
    }
}
