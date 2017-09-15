package cn.coder.toolset.tool;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/15.
 */

public class LanguageTool extends Tool {
    public LanguageTool() {
        super("语言设置", "打开语言设置界面");
    }

    @Override
    public void action(Context context) {
        Intent intent = IntentUtil.getIntent(Settings.ACTION_INPUT_METHOD_SUBTYPE_SETTINGS);
        startActivity(intent);
    }
}
