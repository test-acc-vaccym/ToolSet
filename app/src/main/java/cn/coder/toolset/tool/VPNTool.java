package cn.coder.toolset.tool;

import android.content.Intent;

import cn.coder.toolset.Common.ToolSetApplication;
import cn.coder.toolset.Util.IntentUtil;

/**
 * Created by Administrator on 2017/8/15.
 */

public class VPNTool extends Tool {
    public VPNTool() {
        super("VPN设置", "打开VPN设置界面");
    }

    @Override
    public void action() {
        Intent intent = IntentUtil.getIntent("android.net.vpn.SETTINGS");
        startActivity(intent);
    }
}
