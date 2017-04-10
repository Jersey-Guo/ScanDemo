package com.asynchttpclientdemo.interfaces;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public abstract class LoadMoreListener extends RecyclerView.OnScrollListener {
    private int lastVisibleItem = 0;
    private Object itemCount;

    public LoadMoreListener(Object object) {
        this.itemCount = object;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == ((RecyclerView.Adapter) itemCount).getItemCount()) {
            OnLoadMore(true);
        }else{
            OnLoadMore(false);
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        //最后一个可见的ITEM
        lastVisibleItem = layoutManager.findLastVisibleItemPosition();
    }

    public abstract void OnLoadMore(boolean isLoad);
}
