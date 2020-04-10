package com.zj.design.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zj.design.R;
import com.zj.design.utils.FinalUtil;

/**
 * 个人空间（他人空间）
 *
 */
public class HomePagerActivity extends AppCompatActivity {

    public static void launch(Context context,int id){
        Intent intent=new Intent(context,HomePagerActivity.class);
        intent.putExtra(FinalUtil.USER_ID,id);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pager);
    }
}
