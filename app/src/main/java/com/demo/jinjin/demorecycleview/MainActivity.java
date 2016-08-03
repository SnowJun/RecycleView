package com.demo.jinjin.demorecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_list)
    Button mBtnList;
    @Bind(R.id.btn_grid)
    Button mBtnGrid;
    @Bind(R.id.btn_pull)
    Button mBtnPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_list,R.id.btn_grid,R.id.btn_pull})
    public void click(View view){
        switch (view.getId()){
            case R.id.btn_list:
                toActivity(DemoActivity.class,0);
                break;
            case R.id.btn_grid:
                toActivity(DemoActivity.class,1);
                break;
            case R.id.btn_pull:
                toActivity(DemoActivity.class,2);
                break;
            default:
                break;
        }
    }

    public void toActivity(Class<?> clazz,int type){
        Intent intent = new Intent(this,clazz);
        intent.putExtra("type",type);
        startActivity(intent);
    }


}
