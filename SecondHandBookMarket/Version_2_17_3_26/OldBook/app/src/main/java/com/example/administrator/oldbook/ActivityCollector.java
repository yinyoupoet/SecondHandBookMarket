package com.example.administrator.oldbook;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YYS on 2017/3/20.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity1 : activities) {
            if (!activity1.isFinishing()) {
                activity1.finish();
            }
        }
    }
}
