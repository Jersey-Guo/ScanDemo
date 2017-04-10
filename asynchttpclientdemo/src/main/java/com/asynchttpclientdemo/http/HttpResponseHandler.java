package com.asynchttpclientdemo.http;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


/**
 * Created by guojiadong
 * on 2017/1/5.
 * 重写AsyncHttpResponseHandler自定义返回结果
 */

public abstract class HttpResponseHandler extends AsyncHttpResponseHandler{

    public HttpResponseHandler() {
    }


    @Override
    public void onProgress(long bytesWritten, long totalSize) {
        super.onProgress(bytesWritten, totalSize);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("开始加载-----","onStart");
    }

    @Override
    public void onFinish() {
        super.onFinish();
        Log.e("加载完成-----","onFinish");
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        //访问返回字符串
        String json = new String(responseBody);
        onResponse(json);
        Log.e("加载成功-----","onFinish");
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Log.e("加载失败-----",error.toString());
    }

    public abstract void onResponse(String json);
}
