package com.asynchttpclientdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public class JokeBean implements Parcelable {

    public String content;
    public String updatetime;
    public String url;
    public JokeBean(String content, String updatetime,String url) {
        this.content = content;
        this.updatetime = updatetime;
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
        dest.writeString(this.updatetime);
        dest.writeString(this.url);
    }

    protected JokeBean(Parcel in) {
        this.content = in.readString();
        this.updatetime = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<JokeBean> CREATOR = new Parcelable.Creator<JokeBean>() {
        @Override
        public JokeBean createFromParcel(Parcel source) {
            return new JokeBean(source);
        }

        @Override
        public JokeBean[] newArray(int size) {
            return new JokeBean[size];
        }
    };
}
