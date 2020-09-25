package com.example.fastec;

import android.app.Application;

import com.example.aisingioro_core.app.Aisingioro;

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Aisingioro.init(this).configure();
    }
}
