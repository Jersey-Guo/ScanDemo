package com.asynchttpclientdemo.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

@SuppressWarnings("deprecation")
public class BaseFragment extends Fragment {
    public BaseActivity mActivity;
    @Override
    public void onAttach(Activity activity) {
        mActivity = (BaseActivity) activity;
        super.onAttach(activity);
    }
}
