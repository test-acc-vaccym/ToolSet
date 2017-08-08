package cn.coder.toolset.model;

import cn.coder.toolset.Common.Constant;
import cn.coder.toolset.Common.Feature;
import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.PackageUtil;

/**
 * Created by Administrator on 2017/8/7.
 */

public class ClearPSDataFeature extends Feature {

    public ClearPSDataFeature(){
        super("清数据", "将PS的配置项清理掉");
    }

    @Override
    public void action() {
        PackageUtil.showInstalledAppDetails(Constant.PackageName);
    }
}
