package com.example.jd_oun.home.view.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jd_oun.R;
import com.example.jd_oun.base.BaseLayFragment;
import com.example.jd_oun.home.adapter.NewsAdapter;
import com.example.jd_oun.home.bean.NewsBean;
import com.example.jd_oun.home.contract.NewsFragmentContract;
import com.example.jd_oun.home.presenter.NewsPresenter;

import cn.jzvd.Jzvd;

public class NewsFragment extends BaseLayFragment<NewsPresenter> implements NewsFragmentContract.INewsView {

    private  String tabID;

    private RecyclerView recyclerView;

    private NewsAdapter newsAdapter;


    public NewsFragment(String tabID) {
        this.tabID = tabID;
    }

    @Override
    protected NewsPresenter initPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected void initLinstener() {
    }

    @Override
    protected void initData() {
        mPresenter.getRecommendList(tabID);
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.news_recycleview);
    }
    @Override
    public int getLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    public void isCurrentVisibleToUser(boolean isVisible) {
        if(newsAdapter !=null) newsAdapter.isCurrentVisibleToUser(isVisible);
    }

    @Override
    public void setRecommendList(NewsBean newsBean) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(getActivity(),newsBean);
        recyclerView.setAdapter(newsAdapter);
    }
    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

}
