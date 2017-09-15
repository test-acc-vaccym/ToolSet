package cn.coder.toolset.TecStorage;

import android.content.Context;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;
import cn.coder.toolset.activity.SparActivity;
import cn.coder.toolset.activity.SurfaceActivity;

/**
 * Created by Administrator on 2017/9/15.
 */

public class SparSurfaceView extends TecStorage {
    public SparSurfaceView() {
        super("SurfaceView", "星星桌面");
    }

    @Override
    public void action(Context context) {
        startActivity(IntentUtil.getActivityIntent(ToolSetApplication.getInstance(), SparActivity.class));

    }
}
