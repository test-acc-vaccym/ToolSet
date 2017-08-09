package cn.coder.toolset.manager;

import java.util.ArrayList;

import cn.coder.toolset.feature.AccessibilityFeature;
import cn.coder.toolset.feature.Feature;
import cn.coder.toolset.tool.AppMgrTool;
import cn.coder.toolset.feature.ClearPSDataFeature;
import cn.coder.toolset.feature.DeviceMgrAuthority;
import cn.coder.toolset.feature.ForgroundAthorityFeature;
import cn.coder.toolset.feature.NotificationAthority;

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
        mFeatureSet.add(new ClearPSDataFeature());
        mFeatureSet.add(new ForgroundAthorityFeature());
        mFeatureSet.add(new NotificationAthority());
        mFeatureSet.add(new DeviceMgrAuthority());
        mFeatureSet.add(new AccessibilityFeature());
    }

    public ArrayList getFeatureSet() {
        return mFeatureSet;
    }
}
