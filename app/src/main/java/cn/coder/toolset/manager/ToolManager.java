package cn.coder.toolset.manager;

import java.util.ArrayList;

import cn.coder.toolset.tool.AppMgrTool;
import cn.coder.toolset.tool.Tool;

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
        mToolSet.add(new AppMgrTool());
    }

    public ArrayList getToolSet() {
        return mToolSet;
    }
}
