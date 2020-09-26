package com.example.fastec;

import com.example.aisingioro_core.activities.ProxyActivity;
import com.example.aisingioro_core.delegates.AisingioroDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public AisingioroDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}