package cn.coder.toolset.manager;

import java.util.ArrayList;

import cn.coder.toolset.feature.Feature;

/**
 * Created by Administrator on 2017/8/7.
 */

public class FeatureManager {
    private static FeatureManager sInstance;

    ArrayList<Feature> mFeatureSet = new ArrayList<>();

    public static FeatureManager getInstance() {
        if (sInstance == null) {
            synchronized (FeatureManager.class) {
                if (sInstance == null) {
                    sInstance = new FeatureManager();
                }
            }
        }
        return sInstance;
    }

    private FeatureManager() {
    }

    public ArrayList getFeatureSet() {
        return mFeatureSet;
    }
}
