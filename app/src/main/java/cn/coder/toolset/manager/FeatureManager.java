package cn.coder.toolset.manager;

import java.util.ArrayList;

import cn.coder.toolset.Common.Feature;
import cn.coder.toolset.model.AppMgrFeature;
import cn.coder.toolset.model.ClearPSDataFeature;
import cn.coder.toolset.model.DeviceMgrAuthority;
import cn.coder.toolset.model.ForgroundAthorityFeature;
import cn.coder.toolset.model.NotificationAthority;

/**
 * Created by Administrator on 2017/8/7.
 */

public class FeatureManager {
    private static FeatureManager sInstance;

    ArrayList<Feature> mFeatureSet = new ArrayList<>();

    public static FeatureManager getsInstance() {
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
        mFeatureSet.add(new AppMgrFeature());
    }

    public ArrayList getFeatureSet() {
        return mFeatureSet;
    }
}
