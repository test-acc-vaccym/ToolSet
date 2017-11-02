package cn.coder.toolset.tool;

import android.content.Context;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.provider.Settings;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;
import cn.coder.toolset.tool.Tool;

/**
 * Created by Administrator on 2017/8/9.
 */

public class AccessibilityFeature extends Tool {
    public AccessibilityFeature() {
        super("Accessibility权限", "开启辅助功能权限");
    }

    @Override
    public void action(Context context) {
        Intent intent = IntentUtil.getIntent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
    }
}
