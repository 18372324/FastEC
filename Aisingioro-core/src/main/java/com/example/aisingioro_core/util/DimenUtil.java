package com.example.aisingioro_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.aisingioro_core.app.Aisingioro;

public class DimenUtil {
    public static int getScreenWidth(){
        final Resources resources = Aisingioro.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Aisingioro.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
