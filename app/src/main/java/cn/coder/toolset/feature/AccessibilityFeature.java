package cn.coder.toolset.feature;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.provider.Settings;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/9.
 */

public class AccessibilityFeature extends Feature {
    public AccessibilityFeature() {
        super("Accessibility权限", "开启辅助功能权限");
    }

    @Override
    public void action() {
        Intent intent = IntentUtil.getIntent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
    }
}
