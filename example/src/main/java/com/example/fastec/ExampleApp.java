package com.example.fastec;

import android.app.Application;

import com.example.aisingioro.ec.icon.FontEcModule;
import com.example.aisingioro_core.app.Aisingioro;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Aisingioro.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
