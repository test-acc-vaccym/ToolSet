package cn.coder.toolset.service;

import android.app.Service;

/**
 * Created by Administrator on 2017/8/8.
 */

import java.text.SimpleDateFormat;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.util.Log;

import cn.coder.toolset.Common.Constant;

public class BatteryService extends Service {

    private static final String TAG = Constant.LOG_TAG;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate--------------");
        IntentFilter batteryfilter = new IntentFilter();
        batteryfilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, batteryfilter);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand--------------");
        return Service.START_STICKY; //
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy--------------");
        super.onDestroy();
        this.unregisterReceiver(batteryReceiver);

    }

    // 接收电池信息更新的广播
    public static BroadcastReceiver batteryReceiver = new BroadcastReceiverImp();
        public static class BroadcastReceiverImp extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "BatteryReceiver--------------");
            String action = intent.getAction();
            Log.i(TAG, " 0 action:" + action);
            Log.i(TAG, "ACTION_BATTERY_CHANGED");
            int status = intent.getIntExtra("status", 0);
            int health = intent.getIntExtra("health", 0);
            boolean present = intent.getBooleanExtra("present", false);
            int level = intent.getIntExtra("level", 0);
            int scale = intent.getIntExtra("scale", 0);
            int icon_small = intent.getIntExtra("icon-small", 0);
            int plugged = intent.getIntExtra("plugged", 0);
            int voltage = intent.getIntExtra("voltage", 0);
            int temperature = intent.getIntExtra("temperature", 0);
            String technology = intent.getStringExtra("technology");

            String statusString = "";
            switch (status) {
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    statusString = "unknown";
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    statusString = "charging";
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    statusString = "discharging";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    statusString = "not charging";
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    statusString = "full";
                    break;
            }
            String acString = "";

            switch (plugged) {
                case BatteryManager.BATTERY_PLUGGED_AC:
                    acString = "plugged ac";
                    break;
                case BatteryManager.BATTERY_PLUGGED_USB:
                    acString = "plugged usb";
                    break;
            }

            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS ");
            String date = sDateFormat.format(new java.util.Date());

            Log.d(TAG, "battery: date=" + date + ",status " + statusString
                    + ",level=" + level + ",scale=" + scale
                    + ",voltage=" + voltage + ",acString=" + acString);

//            try{
//                Log.d("Battery.txt", "Battery", ":date=" + date + ",status=" + statusString + ",level=" + level + ",scale=" + scale + ",voltage=" + voltage);
//            }catch (Throwable throwable){
//
//            }

        }
    };
}
