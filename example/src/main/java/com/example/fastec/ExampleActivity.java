package com.example.fastec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.aisingioro_core.activities.ProxyActivity;
import com.example.aisingioro_core.app.Aisingioro;
import com.example.aisingioro_core.delegates.AisingioroDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public AisingioroDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}