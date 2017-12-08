package com.glen.brlogindemo;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heman on 17/12/4.
 *
 * 关闭所有Activity
 *
 */

public class ActivityCollector {
    private static List<Activity> activities = new ArrayList<Activity>();

    //添加Activity
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    //删除Activity
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //关闭所有Activity
    public static void finishAll(){
        for (Activity activity : activities)
        {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
