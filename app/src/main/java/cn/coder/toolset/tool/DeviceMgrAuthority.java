package cn.coder.toolset.tool;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;
import cn.coder.toolset.Util.Log;
import cn.coder.toolset.activity.MainActivity;
import cn.coder.toolset.receiver.ActivateDeviceAdminReceiver;
import cn.coder.toolset.tool.Tool;

/**
 * Created by Administrator on 2017/8/8.
 */

public class DeviceMgrAuthority extends Tool {
    public DeviceMgrAuthority() {
        super("设备管理权限", "获取设备管理权限");
    }

    @Override
    public void action(Context context) {
        Log.d("获取设备管理权限 : " + context.getClass().getSimpleName());
        Intent intent = IntentUtil.getIntent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        ComponentName componentName = new ComponentName(context, ActivateDeviceAdminReceiver.class);
        intent.putExtra(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN, componentName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "测试设备管理权限。");
        context.startActivity(intent);
    }
    /**
     * Android系统的设备管理器功能在一定程度上可以阻止app被卸载。一旦某个app申请了系统设备管理器权限，
     * 并且被用户授予了此权限，那么用户必须先取消该app的此项权限才能卸载这个app。
     * （此功能并不适用于所有机型，比如小米或者某些android 6.0以上的华为手机。）
     */
}
