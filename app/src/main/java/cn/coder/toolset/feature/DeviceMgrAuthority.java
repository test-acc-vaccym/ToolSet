package cn.coder.toolset.feature;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/8.
 */

public class DeviceMgrAuthority extends Feature {
    public DeviceMgrAuthority() {
        super("设备管理权限", "获取设备管理权限");
    }

    @Override
    public void action() {
        Intent intent = IntentUtil.getIntent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
