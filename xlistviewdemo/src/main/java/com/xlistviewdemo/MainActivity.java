package com.xlistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xlistviewdemo.listView.XListView;

import java.util.ArrayList;
import java.util.List;

import cn.finalteam.okhttpfinal.RequestParams;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {
    private XListView xListView;
    public static String JOKE_KEY = "0fa4cd937c5553ff49c5df199f9c1ace";
    JokeAdapter mAdapter;
    private List<JokeBean> mBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xListView = (XListView) findViewById(R.id.xlistview_mian);
        setModel();
    }

    private void setModel() {
        xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(this);
        xListView.setPullRefreshEnable(true);
        mAdapter = new JokeAdapter(this, mBeans);
        xListView.setAdapter(mAdapter);
        xListView.activeRefresh();
    }

    int page = 0;

    private void getDataFromGet() {
        RequestParams params = new RequestParams();
        params.addFormDataPart("page", page);
        params.addFormDataPart("pagesize", 10);
        params.addFormDataPart("sort", "desc");
        params.addFormDataPart("key", JOKE_KEY);
        params.addFormDataPart("time", System.currentTimeMillis() / 1000);
        HttpUtils.getInstance().post("http://japi.juhe.cn/joke/content/list.from?", params, new HttpUtils.RequestCallBack() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(String json) {
                if (Utils.getResultCode(json)) {
                    JokeModel model = new JokeModel(Utils.getResult(json));
                    List<JokeBean> currentList = model.getBeanList();
                    if (page == 0) {
                        mBeans.clear();
                    }
                    if (currentList != null && !currentList.isEmpty()) {
                        mBeans.addAll(model.getBeanList());
                    }
                    xListView.stopLoadMore();
                    xListView.stopRefresh();
                    mAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(int errorCode, String error) {

            }

            @Override
            public void onFinish() {

            }
        });
    }

    @Override
    public void onRefresh() {
        getDataFromGet();
    }

    @Override
    public void onLoadMore() {
        page++;
        getDataFromGet();
    }
}
