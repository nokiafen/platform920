package com.comba.android.combacommon.hardware;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by liangchunfeng on 2017/5/15.
 * 硬件操作类
 */

public class HardwareUtils {


    /**
     * 获得CPU的使用率
     * @return
     */
//    public static int getCpuUsageRate(){
//        StringBuilder sb = new StringBuilder();
//        int rate = 0;
//        try {
//            String result = "";
//            Process p;
//            p = Runtime.getRuntime().exec("top -n l");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            while ((result = reader.readLine()) != null){
//                if(result.trim().length() < 1){
//                    continue;
//                }else{
//                    String[] CPUuse = result.split("%");
//                    sb.append("USER:"+CPUuse[0]+"/n");
//                    String[] CPUusage = CPUuse[0].split("User");
//                    String[] sysUsage = CPUuse[1].split("System");
//                    sb.append("CPU:" + CPUusage[1].trim() + " length:" + CPUusage[1].trim().length() + "\n");
//                    sb.append("SYS:" + sysUsage[1].trim() + " length:" + sysUsage[1].trim().length() + "\n");
//                    rate = Integer.parseInt(CPUusage[1].trim()) + Integer.parseInt(sysUsage[1].trim());
//                    break;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return rate;
//    }

    /**
     * 获取当前应用CPU的使用率
     * @return
     */
    public static float getProcessCpuRate()
    {

        float totalCpuTime1 = getTotalCpuTime();
        float processCpuTime1 = getAppCpuTime();
        try
        {
            Thread.sleep(360);

        }
        catch (Exception e)
        {
        }

        float totalCpuTime2 = getTotalCpuTime();
        float processCpuTime2 = getAppCpuTime();

        float cpuRate = 100 * (processCpuTime2 - processCpuTime1)
                / (totalCpuTime2 - totalCpuTime1);

        return cpuRate;
    }

    public static long getTotalCpuTime()
    { // 获取系统总CPU使用时间
        String[] cpuInfos = null;
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("/proc/stat")), 1000);
            String load = reader.readLine();
            reader.close();
            cpuInfos = load.split(" ");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        long totalCpu = Long.parseLong(cpuInfos[2])
                + Long.parseLong(cpuInfos[3]) + Long.parseLong(cpuInfos[4])
                + Long.parseLong(cpuInfos[6]) + Long.parseLong(cpuInfos[5])
                + Long.parseLong(cpuInfos[7]) + Long.parseLong(cpuInfos[8]);
        return totalCpu;
    }

    public static long getAppCpuTime()
    { // 获取应用占用的CPU时间
        String[] cpuInfos = null;
        try
        {
            int pid = android.os.Process.myPid();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("/proc/" + pid + "/stat")), 1000);
            String load = reader.readLine();
            reader.close();
            cpuInfos = load.split(" ");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        long appCpuTime = Long.parseLong(cpuInfos[13])
                + Long.parseLong(cpuInfos[14]) + Long.parseLong(cpuInfos[15])
                + Long.parseLong(cpuInfos[16]);
        return appCpuTime;
    }

//    public static String getCpuRate(){
//        CPURate rate = new CPURate();
//        return rate.getCPURate();
//    }

}
