package cn.coder.toolset.feature;

import android.content.Context;

import cn.coder.toolset.Common.Constant;
import cn.coder.toolset.Util.PackageUtil;

/**
 * Created by Administrator on 2017/8/7.
 */

public class ClearPSDataFeature extends Feature {

    public ClearPSDataFeature(){
        super("清数据", "将PS的配置项清理掉");
    }

    @Override
    public void action(Context context) {
        PackageUtil.showInstalledAppDetails(Constant.PackageName);
    }
}
