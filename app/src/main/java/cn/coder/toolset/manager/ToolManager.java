package cn.coder.toolset.manager;

import java.util.ArrayList;

import cn.coder.toolset.tool.AccessibilityFeature;
import cn.coder.toolset.tool.ClearPSDataFeature;
import cn.coder.toolset.tool.DeviceMgrAuthority;
import cn.coder.toolset.tool.ForgroundAthorityFeature;
import cn.coder.toolset.tool.NotificationAthority;
import cn.coder.toolset.tool.AccessibilityTool;
import cn.coder.toolset.tool.AppMgrTool;
import cn.coder.toolset.tool.DateSetTool;
import cn.coder.toolset.tool.DevOptionTool;
import cn.coder.toolset.tool.LanguageTool;
import cn.coder.toolset.tool.Tool;
import cn.coder.toolset.tool.VPNTool;

/**
 * Created by Administrator on 2017/8/8.
 */

public class ToolManager {
    private static ToolManager sInstance;

    ArrayList<Tool> mToolSet = new ArrayList<>();
    
    public static ToolManager getInstance(){
        if (sInstance == null){
            synchronized (ToolManager.class){
                if (sInstance == null){
                    sInstance = new ToolManager();
                }
            }
        }
        return sInstance;
    }
    
    private ToolManager(){
        mToolSet.add(new ClearPSDataFeature());
        mToolSet.add(new ForgroundAthorityFeature());
        mToolSet.add(new NotificationAthority());
        mToolSet.add(new DeviceMgrAuthority());
        mToolSet.add(new AccessibilityFeature());
        mToolSet.add(new AppMgrTool());
        mToolSet.add(new VPNTool());
        mToolSet.add(new DevOptionTool());
        mToolSet.add(new DateSetTool());
        mToolSet.add(new LanguageTool());
        mToolSet.add(new AccessibilityTool());
    }

    public ArrayList getToolSet() {
        return mToolSet;
    }
}
