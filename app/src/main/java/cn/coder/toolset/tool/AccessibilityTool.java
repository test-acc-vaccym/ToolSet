package cn.coder.toolset.tool;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/15.
 */

public class AccessibilityTool extends Tool {
    public AccessibilityTool() {
        super("辅助功能设置", "打开辅助功能设置界面");
    }

    @Override
    public void action(Context context) {
        startActivity(IntentUtil.getIntent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
    }
}
