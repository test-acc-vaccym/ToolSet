package cn.coder.toolset.Util;

import cn.coder.toolset.Common.Constant;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Log {
    public static void d(String content){
        android.util.Log.d(Constant.LOG_TAG, content.toString());
    }
}
