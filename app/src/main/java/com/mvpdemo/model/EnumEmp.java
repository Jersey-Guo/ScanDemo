package com.mvpdemo.model;

/**
 * Created by guojiadong
 * on 2017/3/23.
 */

public enum EnumEmp {
    全部{
        @Override
        public String value() {
            return null;
        }
    },分类{
        @Override
        public String value() {
            return "1";
        }
    };
    public abstract String value();
}
