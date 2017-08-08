package cn.coder.toolset.manager;

/**
 * Created by Administrator on 2017/8/8.
 */

public class ToolManager {
    private static ToolManager sInstance;
    
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
        // TODO: 2017/8/8
    }
}
