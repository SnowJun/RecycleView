package com.demo.jinjin.demorecycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by linkmax on 2016/8/3.
 */
public class DemoActivity extends AppCompatActivity {


    @Bind(R.id.rv_demo)
    RecyclerView mRvDemo;
    private int mType;

    private ArrayList<String> mStrings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mine);
        ButterKnife.bind(this);
        initType();
        initData();
        setAdapter();
    }

    private void initData() {
        mStrings = new ArrayList<String>();
        for (int i = 0;i < 50;i++){
            mStrings.add("第"+i+"个元素");
        }
    }

    private void setAdapter() {
        if (mType == 0){
            mRvDemo.setLayoutManager(new LinearLayoutManager(this));
            mRvDemo.setAdapter(new ListAdapter(mStrings,this));
            mRvDemo.setItemAnimator(new DefaultItemAnimator());
        }else if (mType == 1){
            mRvDemo.setLayoutManager(new GridLayoutManager(this,3));
            mRvDemo.setAdapter(new ListAdapter(mStrings,this));
            mRvDemo.setItemAnimator(new DefaultItemAnimator());
        }else if (mType == 2){
            mRvDemo.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            mRvDemo.setAdapter(new PullAdapter(mStrings,this));
            mRvDemo.setItemAnimator(new DefaultItemAnimator());
        }
    }

    private void initType() {
        mType = getIntent().getIntExtra("type",-1);
    }


}
