package cn.coder.toolset.Util;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import cn.coder.toolset.Common.Constant;
import cn.coder.toolset.Common.ToolSetApplication;

/**
 * Created by Administrator on 2017/8/8.
 */

public class PackageUtil {
    private static final String APP_PKG_NAME_21 = "com.android.settings.ApplicationPkgName";
    /**
     * 调用系统InstalledAppDetails界面所需的Extra名称(用于Android 2.2)
     */
    private static final String APP_PKG_NAME_22 = "pkg";
    /**
     * InstalledAppDetails所在包名
     */
    private static final String APP_DETAILS_PACKAGE_NAME = "com.android.settings";
    /**
     * InstalledAppDetails类名
     */
    private static final String APP_DETAILS_CLASS_NAME = "com.android.settings.InstalledAppDetails";

    public static void showInstalledAppDetails(String packageName) {
        Log.d(Constant.LOG_TAG, "showInstalledAppDetails");
        try {
            Intent intent = new Intent();
            final int apiLevel = Build.VERSION.SDK_INT;
            if (apiLevel >= 9) { // 2.3（ApiLevel 9）以上，使用SDK提供的接口
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                Uri uri = Uri.fromParts("package", packageName, null);
                intent.setData(uri);
            } else { // 2.3以下，使用非公开的接口（查看InstalledAppDetails源码）
                // 2.2和2.1中，InstalledAppDetails使用的APP_PKG_NAME不同。
                final String appPkgName = (apiLevel == 8 ? APP_PKG_NAME_22
                        : APP_PKG_NAME_21);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setClassName(APP_DETAILS_PACKAGE_NAME,
                        APP_DETAILS_CLASS_NAME);
                intent.putExtra(appPkgName, packageName);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ToolSetApplication.getInstance().startActivity(intent);
        } catch (Exception e) {
            Log.d(Constant.LOG_TAG, e.getMessage());
        }
    }
}
