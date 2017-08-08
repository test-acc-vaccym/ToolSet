package cn.coder.toolset.Util;

import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;

import cn.coder.toolset.Common.ToolSetApplication;

/**
 * Created by Administrator on 2017/8/8.
 */

public class SimilateBatteryChange {

    public static void send(Float battery){
        Intent batteryIntent = IntentUtil.getBroadCastIntent(ToolSetApplication.getInstance().getApplicationContext(), Intent.ACTION_BATTERY_CHANGED);
//        batteryIntent.putExtra()
    }
}
