package cn.coder.toolset.Common;

import android.graphics.ImageFormat;
import android.util.Log;

import cn.coder.toolset.BuildConfig;

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
}
