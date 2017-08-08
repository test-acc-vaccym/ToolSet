package cn.coder.toolset.Common;

import android.app.Application;

/**
 * Created by Administrator on 2017/8/8.
 */

public class ToolSetApplication extends Application{
    private static ToolSetApplication sInstance;

    public static ToolSetApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

}
