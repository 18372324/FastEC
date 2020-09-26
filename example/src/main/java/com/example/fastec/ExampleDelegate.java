package com.example.fastec;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.aisingioro_core.delegates.AisingioroDelegate;

public class ExampleDelegate extends AisingioroDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
