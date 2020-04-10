package com.zj.design.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zj.design.R;
import com.zj.design.activity.ArticleDetailsActivity;
import com.zj.design.adapter.ArticleListAdapter;
import com.zj.design.base.BaseFragment;
import com.zj.design.entity.ArticleEntity;
import com.zj.design.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * create by zj on 2020/4/10
 * 推荐
 */
public class RecommendFragment extends BaseFragment {
    View rootView;
    RecyclerView recyclerView;
    ArticleListAdapter mAdapter;
    List<ArticleEntity> list;

    public static RecommendFragment getInstance() {
        return new RecommendFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommend, null);
            init();
        }
        loadData();
        return rootView;
    }

    public void init(){
        recyclerView=rootView.findViewById(R.id.recommend_list);
        list=new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mAdapter=new ArticleListAdapter(getActivity(),list);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClick(int pos) {
                ArticleDetailsActivity.launch(getContext());
            }
        });
        //添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    public void loadData(){
        for (int i=0;i<20;i++){
            list.add(new ArticleEntity());
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public String getTitle() {
        return "推薦";
    }
}
