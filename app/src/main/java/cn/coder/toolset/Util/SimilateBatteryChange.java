package cn.coder.toolset.Util;

import android.app.PendingIntent;
import android.content.Intent;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.service.BatteryService;

/**
 * Created by Administrator on 2017/8/8.
 */

public class SimilateBatteryChange {
    public static String STATUS = "status";
    public static String HEALTH = "health";
    public static String PRESENT = "present";
    public static String LEVEL = "level";
    public static String SCALE = "scale";
    public static String VOL = "voltage";
    public static String TEMP = "temperature";
    public static String TECH = "technology";

    public static void send(Float battery){
//        Intent batteryIntent = IntentUtil.getBroadCastIntent(ToolSetApplication.getInstance().getApplicationContext(), Intent.ACTION_BATTERY_CHANGED);
        Intent batteryIntent = new Intent(ToolSetApplication.getInstance().getApplicationContext(), BatteryService.BroadcastReceiverImp.class);
        batteryIntent.setAction(Intent.ACTION_BATTERY_CHANGED);
        batteryIntent.putExtra(STATUS, 1000);
        batteryIntent.putExtra(HEALTH, 1000);
        batteryIntent.putExtra(PRESENT, true);
        batteryIntent.putExtra(LEVEL, 10000);
        batteryIntent.putExtra(SCALE, 1000);
        batteryIntent.putExtra(VOL, 1000);
        batteryIntent.putExtra(TEMP, 1000);
        batteryIntent.putExtra(TECH, 1000);
//        ToolSetApplication.getInstance().getApplicationContext().sendBroadcast(batteryIntent);
    }
}
