package com.example.aisingioro_core.net;

import com.example.aisingioro_core.net.callback.IError;
import com.example.aisingioro_core.net.callback.IFailure;
import com.example.aisingioro_core.net.callback.IRequest;
import com.example.aisingioro_core.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private String _url;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest _irequest;
    private ISuccess _isuccess;
    private IError _ierror;
    private IFailure _ifailure;
    private RequestBody _body;

    RestClientBuilder(){}

    public final RestClientBuilder url(String url){
        this._url = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value){
        this.PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw){
        this._body = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this._irequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess){
        this._isuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this._ifailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this._ierror = iError;
        return this;
    }

    private Map<String, Object> checkParam(){
            return PARAMS;
    }

    public final RestClient build(){
        return new RestClient(_url, PARAMS, _irequest, _isuccess, _ierror, _ifailure,_body);
    }


}
