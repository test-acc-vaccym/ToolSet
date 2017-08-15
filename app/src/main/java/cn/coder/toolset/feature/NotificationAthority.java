package cn.coder.toolset.feature;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

import cn.coder.toolset.Common.Constant;
import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/8.
 */

public class NotificationAthority extends Feature {
    public static final int STAT_NOTIFICATION_PERMISSION_REQUEST = 1024 << 3;

    public NotificationAthority() {
        super("通知消息管理权限", "获取通知管理权限");
    }

    @Override
    public void action() {
        Intent intent = IntentUtil.getIntent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
        startActivity(intent);
    }
}
