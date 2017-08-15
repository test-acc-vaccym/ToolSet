package cn.coder.toolset.Util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/8/8.
 */

public class IntentUtil {

    public static Intent getActivityIntent(Context source, Activity target){
        Intent intent = new Intent(source, target.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    public static Intent getBroadCastIntent(Context source, String content){
        Intent intent = new Intent(content);
        return intent;
    }

    public static Intent getIntent(String action){
        Intent intent = new Intent(action);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }
}
