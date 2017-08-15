package cn.coder.toolset.tool;

import android.content.Intent;
import android.provider.Settings;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/15.
 */

public class DevOptionTool extends Tool {
    public DevOptionTool() {
        super("Developer Options", "打开开发者设置");
    }

    @Override
    public void action() {
        Intent intent = IntentUtil.getIntent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
        startActivity(intent);
    }
}
