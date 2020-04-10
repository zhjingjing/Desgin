package com.zj.design.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zj.design.R;
import com.zj.design.base.BaseFragment;

/**
 * create by zj on 2020/4/10
 * 热门
 */
public class HotFragment extends BaseFragment {
    View rootView;
    public static HotFragment getInstance() {
        return new HotFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null){
            rootView=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hot,null);
        }
        return rootView;
    }

    @Override
    public String getTitle() {
        return "熱門";
    }
}
