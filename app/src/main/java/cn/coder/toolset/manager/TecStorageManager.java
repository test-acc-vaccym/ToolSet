package cn.coder.toolset.manager;

/**
 * Created by Administrator on 2017/8/16.
 */

public class TecStorageManager {
    private static TecStorageManager sInstance;

    public TecStorageManager getInstance(){
        if (sInstance == null){
            synchronized (TecStorageManager.class){
                if (sInstance == null){
                    sInstance = new TecStorageManager();
                }
            }
        }
        return sInstance;
    }
    
    private TecStorageManager(){
        // TODO: 2017/8/16
    }

}
