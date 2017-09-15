package cn.coder.toolset.feature;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import cn.coder.toolset.Common.Constant;
import cn.coder.toolset.Common.ToolSetApplication;

/**
 * Created by Administrator on 2017/8/8.
 */

public class ForgroundAthorityFeature extends Feature {
    public ForgroundAthorityFeature() {
        super("前后台权限", "获取前后台权限流程");
    }

    @Override
    public void action(Context context) {
        requestStatAccessPermission(ToolSetApplication.getInstance().getApplicationContext());

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void requestStatAccessPermission(Context context) {
        boolean suc = true;
        try {
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.d(Constant.LOG_TAG, e.getMessage());
        }
    }
}
