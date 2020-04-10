package com.zj.design.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zj.design.R;

public class SettingActivity extends AppCompatActivity {

    public static void launch(Context context){
        context.startActivity(new Intent(context,SettingActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
}
