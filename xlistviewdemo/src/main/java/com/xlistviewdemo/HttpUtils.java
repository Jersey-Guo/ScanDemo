package com.xlistviewdemo;

import android.content.Context;

import java.io.File;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.FileDownloadCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

/**
 * Created by guojiadong
 * on 2017/3/21.
 */

public class HttpUtils {
    /**
     * 此类防止外部实例化
     */
    public HttpUtils() {

    }

    /**
     * 单利
     */
    private static class InstanceHolder {
        public static HttpUtils INSTANCE = new HttpUtils();
    }

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static HttpUtils getInstance() {
        return InstanceHolder.INSTANCE;
    }


    /**
     * psot请求
     * 访问成功后返回json串
     *
     * @param url      请求链接
     * @param params   拼接参数，可用于设置公共参
     * @param callBack 请求回调
     */
    public void post(String url, RequestParams params, final RequestCallBack callBack) {
        if(params != null){
            //TODO 设置公共参数
        }
        HttpRequest.post(url, params, new BaseHttpRequestCallback<String>() {
            @Override
            public void onStart() {
                super.onStart();
                if (callBack != null) {
                    callBack.onStart();
                }
            }

            @Override
            protected void onSuccess(String o) {
                super.onSuccess(o);
                if (callBack != null) {
                    callBack.onSuccess(o);
                }
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                if (callBack != null) {
                    callBack.onFailure(errorCode, msg);
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (callBack != null) {
                    callBack.onFinish();
                }
            }
        });
    }

    /**
     * get请求
     *
     * @param url      请求链接
     * @param callBack 请求回调
     */
    public void get(String url, final RequestCallBack callBack) {
        HttpRequest.get(url, new BaseHttpRequestCallback<String>() {
            @Override
            public void onStart() {
                super.onStart();
                if (callBack != null) {
                    callBack.onStart();
                }
            }

            @Override
            protected void onSuccess(String o) {
                super.onSuccess(o);
                if (callBack != null) {
                    callBack.onSuccess(o);
                }
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                if (callBack != null) {
                    callBack.onFailure(errorCode, msg);
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (callBack != null) {
                    callBack.onFinish();
                }
            }
        });
    }

    /**
     * 文件下载
     *
     * @param context  上下文
     * @param file     下载文件的保存
     * @param url      下载链接
     * @param callback 下载回调
     */
    public void download(Context context, File file, String url, final DownloadCallBack callback) {
        HttpRequest.download(url, file, new FileDownloadCallback() {
            @Override
            public void onStart() {
                super.onStart();
                if (callback != null) {
                    callback.onStart();
                }
            }

            @Override
            public void onProgress(int progress, long networkSpeed) {
                super.onProgress(progress, networkSpeed);
                if (callback != null) {
                    callback.onProgress(progress, networkSpeed);
                }
            }

            @Override
            public void onFailure() {
                super.onFailure();
                if (callback != null) {
                    callback.onFailure();
                }
            }

            @Override
            public void onDone() {
                super.onDone();
                if (callback != null) {
                    callback.onDone();
                }
            }
        });
    }

    public interface RequestCallBack {
        /**
         * 开始
         */
        void onStart();

        /**
         * 成功
         *
         * @param result 成功后返回值，一般为
         */
        void onSuccess(String result);

        /**
         * 失败
         */
        void onFailure(int errorCode, String error);

        /**
         * 完成
         */
        void onFinish();
    }

    public interface DownloadCallBack {
        /**
         * 开始
         */
        void onStart();

        /**
         * 下载进度
         */
        void onProgress(int progress, long networkSpeed);

        /**
         * 失败
         */
        void onFailure();

        /**
         * 完成
         */
        void onDone();
    }
}
