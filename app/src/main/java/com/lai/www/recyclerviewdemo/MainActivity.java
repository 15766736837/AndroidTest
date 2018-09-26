package com.lai.www.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Recycler Demo
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        //给RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, createData());
        mRecyclerView.setAdapter(recyclerAdapter);
    }

    private List<String> createData(){
        ArrayList<String> listData = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            listData.add(i + 1 + "");
        }
        return listData;
    }
}
