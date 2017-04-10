package com.asynchttpclientdemo.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;

import com.asynchttpclientdemo.R;
import com.asynchttpclientdemo.base.BaseActivity;
import com.asynchttpclientdemo.bean.JokeBean;
import com.asynchttpclientdemo.view.CustomImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public class JokeDetailActivity extends BaseActivity implements View.OnClickListener {
    private CustomImageView mIcon;
    private JokeBean mBean;
    private ImageView mBackBtn;
    private int window_width, window_height;// 控件宽度
    private int state_height;// 状态栏的高度
    private ViewTreeObserver viewTreeObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);
        /** 获取可見区域高度 **/
        WindowManager manager = getWindowManager();
        window_width = manager.getDefaultDisplay().getWidth();
        window_height = manager.getDefaultDisplay().getHeight();
        getIntentValue();
        initView();
        setStateHeight();
        setModel();
    }

    private void setStateHeight() {
        /** 测量状态栏高度 **/
        viewTreeObserver = mIcon.getViewTreeObserver();
        viewTreeObserver
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        if (state_height == 0) {
                            // 获取状况栏高度
                            Rect frame = new Rect();
                            getWindow().getDecorView()
                                    .getWindowVisibleDisplayFrame(frame);
                            state_height = frame.top;
                            mIcon.setScreen_H(window_height - state_height);
                            mIcon.setScreen_W(window_width);
                        }

                    }
                });
    }

    @Override
    public void initView() {
        mIcon = (CustomImageView) findViewById(R.id.activity_detail_icon);
        mBackBtn = (ImageView) findViewById(R.id.activity_joke_back);
        mBackBtn.setOnClickListener(this);
    }

    private void getIntentValue() {
        Intent intent = getIntent();
        if (intent != null) {
            mBean = intent.getParcelableExtra("type_bean");
        }
    }

    @Override
    public void setModel() {
        if (mBean != null) {
            Glide.with(this).load(mBean.url).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    mIcon.setImageBitmap(resource);
                }
            });
        }
    }

    @Override
    public void getData() {

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
