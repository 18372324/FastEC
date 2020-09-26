package com.example.fastec;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.aisingioro_core.delegates.AisingioroDelegate;
import com.example.aisingioro_core.net.RestClient;
import com.example.aisingioro_core.net.callback.IError;
import com.example.aisingioro_core.net.callback.IFailure;
import com.example.aisingioro_core.net.callback.ISuccess;

public class ExampleDelegate extends AisingioroDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private  void testRestClient(){
        RestClient.builder()
                .url("https://image.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .build()
                .get();
    }
}
