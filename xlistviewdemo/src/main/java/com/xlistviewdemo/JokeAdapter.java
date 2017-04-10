package com.xlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guojiadong
 * on 2017/1/5.
 */

public class JokeAdapter extends BaseAdapter {
    private Context mContext;
    private List<JokeBean> mBeans;
    private LayoutInflater mInflater;

    public JokeAdapter(Context context, List<JokeBean> beans) {
        this.mContext = context;
        this.mBeans = beans;
        this.mInflater = LayoutInflater.from(mContext);
    }


    private void setViewData(ViewHolder holder, JokeBean bean) {
        if (holder == null || bean == null) {
            return;
        }
        holder.contentTv.setText(bean.content);
    }


    @Override
    public int getCount() {
        return mBeans == null || mBeans.isEmpty() ? 0 : mBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return mBeans == null || mBeans.isEmpty() ? null : mBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = mInflater.inflate(R.layout.item_joke,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        setViewData(holder, (JokeBean) getItem(i));
        return view;
    }


    private static class ViewHolder {
        TextView contentTv;
        ImageView icon;

        public ViewHolder(View itemView) {
            contentTv = (TextView) itemView.findViewById(R.id.item_content);
        }
    }


}
