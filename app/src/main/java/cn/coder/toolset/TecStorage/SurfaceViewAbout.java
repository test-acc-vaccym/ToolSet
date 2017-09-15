package cn.coder.toolset.TecStorage;

import android.content.Context;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;
import cn.coder.toolset.activity.SurfaceActivity;

/**
 * Created by Administrator on 2017/9/2.
 */

public class SurfaceViewAbout extends TecStorage{
    public SurfaceViewAbout() {
        super("Surface应用", "图层挖洞");
    }

    @Override
    public void action(Context context) {
        startActivity(IntentUtil.getActivityIntent(ToolSetApplication.getInstance(), SurfaceActivity.class));
    }
}
