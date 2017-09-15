package cn.coder.toolset.manager;

import java.util.ArrayList;

import cn.coder.toolset.TecStorage.SparSurfaceView;
import cn.coder.toolset.TecStorage.SurfaceViewAbout;
import cn.coder.toolset.TecStorage.TecStorage;

/**
 * Created by Administrator on 2017/8/16.
 */

public class TecStorageManager {
    private static TecStorageManager sInstance;

    ArrayList<TecStorage> tecStorages = new ArrayList<>();

    public static TecStorageManager getInstance(){
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
        tecStorages.add(new SurfaceViewAbout());
        tecStorages.add(new SparSurfaceView());
    }

    public ArrayList getTecStorages(){
        return tecStorages;
    }

}
