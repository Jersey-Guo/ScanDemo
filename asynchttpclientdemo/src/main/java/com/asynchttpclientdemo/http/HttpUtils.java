package com.asynchttpclientdemo.http;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public class HttpUtils {
    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * get请求方式
     *
     * @param context 你懂得
     * @param urlStr  请求地址
     * @param handler 回调
     */
    public static void get(Context context, String urlStr, AsyncHttpResponseHandler handler) {
        client.get(context, urlStr, handler);
    }

    /**
     * get请求方式
     *
     * @param context 你懂得
     * @param urlStr  请求地址
     * @param handler 回调
     */
    public static void get(Context context, String urlStr, RequestParams params, AsyncHttpResponseHandler handler) {
        client.get(context, urlStr, params, handler);
    }

    /**
     * post请求
     *
     * @param context 你懂得
     * @param urlStr  请求地址
     * @param handler 回调
     */
    public static void post(Context context, String urlStr, AsyncHttpResponseHandler handler) {
        client.post(urlStr, handler);
    }

    /**
     * @param context 你懂得
     * @param urlStr  请求地址
     * @param handler 回调
     * @param params  请求参数
     */
    public static void post(Context context, RequestParams params, String urlStr, AsyncHttpResponseHandler handler) {
        client.post(context, urlStr, params, handler);
    }

}
