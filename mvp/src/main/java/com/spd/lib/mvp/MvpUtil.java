package com.spd.lib.mvp;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

/**
 * @author :Reginer in  2019/8/21 10:12.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MvpUtil {

    /**
     * 获取activity标题
     *
     * @param context -
     * @param actName act名
     * @return 标题信息
     */
    static String getActLabel(Context context, String actName) {
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context.getPackageName(), actName);
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 0);
            return activityInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
