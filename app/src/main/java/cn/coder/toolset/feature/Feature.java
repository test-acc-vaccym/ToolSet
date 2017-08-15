package cn.coder.toolset.feature;

import android.content.Intent;
import android.graphics.ImageFormat;
import android.util.Log;

import cn.coder.toolset.BuildConfig;
import cn.coder.toolset.Common.ToolSetApplication;

/**
 * Created by Administrator on 2017/8/8.
 */

public abstract class Feature {
    public String mFeatureTitle;
    public String mFeatureDes;

    public Feature(String title, String des){
        mFeatureTitle = title;
        mFeatureDes = des;
    }

    public abstract void action();

    public void startActivity(Intent intent){
        ToolSetApplication.getInstance().startActivity(intent);
    }
}
