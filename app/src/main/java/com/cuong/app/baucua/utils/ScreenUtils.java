package com.cuong.app.baucua.utils;

import android.view.Window;
import android.view.WindowManager;

public class ScreenUtils {
    public static void setFullScreen(Window window) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
