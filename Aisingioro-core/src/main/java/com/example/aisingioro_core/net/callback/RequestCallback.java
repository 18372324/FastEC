package com.example.aisingioro_core.net.callback;

import android.os.Handler;

import com.example.aisingioro_core.ui.AisingioroLoader;
import com.example.aisingioro_core.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCallback implements Callback<String> {
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IError IERROR;
    private final IFailure IFAILURE;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = new Handler();

    public RequestCallback(IRequest IREQUEST,
                           ISuccess ISUCCESS,
                           IError IERROR,
                           IFailure IFAILURE,
                           LoaderStyle LOADER_STYLE) {
        this.IREQUEST = IREQUEST;
        this.ISUCCESS = ISUCCESS;
        this.IERROR = IERROR;
        this.IFAILURE = IFAILURE;
        this.LOADER_STYLE = LOADER_STYLE;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()){
            if(call.isExecuted()){
                if(ISUCCESS != null){
                    ISUCCESS.onSuccess(response.body());
                }
            }
        }else{
            if(IERROR != null){
                IERROR.onError(response.code(), response.message());
            }
        }

        if(LOADER_STYLE != null){
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AisingioroLoader.stopLoading();
                }
            }, 2000);
        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(IFAILURE != null){
            IFAILURE.onFailure();
        }

        if(IREQUEST != null){
            IREQUEST.onRequestEnd();
        }

    }
}
