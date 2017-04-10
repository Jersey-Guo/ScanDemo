package com.xlistviewdemo;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public class Utils {
    /**
     * 获取json
     *
     * @param jsonStr
     * @return
     */
    public static JSONObject getResult(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        } else {
            try {
                JSONObject json = new JSONObject(jsonStr);
                if (json != null) {
                    JSONObject object = json.optJSONObject("result");
                    return object;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取返回码
     * @param jsonStr
     * @return
     */
    public static boolean getResultCode(String jsonStr) {
        if (TextUtils.isEmpty(jsonStr)) {
            return false;
        } else {
            try {
                JSONObject json = new JSONObject(jsonStr);
                return json.optInt("error_code") == 0 ? true : false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
