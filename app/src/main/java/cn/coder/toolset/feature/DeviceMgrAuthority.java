package cn.coder.toolset.feature;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;

import cn.coder.toolset.Common.ToolSetApplication;

/**
 * Created by Administrator on 2017/8/8.
 */

public class DeviceMgrAuthority extends Feature {
    public DeviceMgrAuthority() {
        super("设备管理权限", "获取设备管理权限");
    }

    @Override
    public void action() {
        deviceMgrAuthorize(ToolSetApplication.getInstance().getApplicationContext());
    }

    public void deviceMgrAuthorize(Context context) {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdminComponent);
//        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, ResourceUtil.getString(R.string.device_manager_desc_in_system));
        context.startActivity(intent);
    }
}
