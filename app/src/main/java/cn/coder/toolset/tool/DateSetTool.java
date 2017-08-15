package cn.coder.toolset.tool;

import android.content.Intent;
import android.provider.Settings;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/15.
 */

public class DateSetTool extends Tool {
    public DateSetTool() {
        super("时间设置","打开时间设置界面");
    }

    @Override
    public void action() {
        Intent intent = IntentUtil.getIntent(Settings.ACTION_DATE_SETTINGS);
        startActivity(intent);
    }
}
