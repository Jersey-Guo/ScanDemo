package com.asynchttpclientdemo.model;

import com.asynchttpclientdemo.bean.JokeBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public class JokeModel {
    private List<JokeBean> beanList;

    public JokeModel(JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        JSONArray jsonArray = jsonObject.optJSONArray("data");
        if (jsonArray != null && jsonArray.length() > 0) {
            beanList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.optJSONObject(i);
                if (object != null) {
                    String content = object.optString("content");
                    String updateTime = object.optString("updatetime");
                    String url = object.optString("url");
                    JokeBean bean = new JokeBean(content,updateTime,url);
                    beanList.add(bean);
                }
            }
        }
    }

    public List<JokeBean> getBeanList() {
        return beanList;
    }
}
