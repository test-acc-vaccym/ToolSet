package cn.coder.toolset.tool;

import android.content.Intent;

import cn.coder.toolset.feature.Feature;
import cn.coder.toolset.Common.ToolSetApplication;

/**
 * Created by Administrator on 2017/8/8.
 */

public class AppMgrTool extends Tool {
    public AppMgrTool() {
        super("管理App", "Clear App Entry");
    }

    @Override
    public void action() {
        appMgr();
    }

    private void appMgr() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ToolSetApplication.getInstance().startActivity(intent);
    }
}
