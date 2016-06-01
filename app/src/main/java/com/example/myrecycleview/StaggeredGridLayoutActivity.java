package com.example.myrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private StaggeredAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initDatas();
        initView();
        mAdapter=new StaggeredAdapter(this,mDatas);


        mRecyclerView.setAdapter(mAdapter);
        // 设置RecyclerView的布局管理
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        mAdapter.setOnItemClickListner(new MyAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int pos) {

            }

            @Override
            public void onItemLongClick(View view, int pos) {
                mAdapter.deleteDate(pos);
            }
        });

        // 设置RecyclerView的分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
    }

    private void initDatas() {
        mDatas=new ArrayList<String>();
        for (int i='A';i<='z';i++)
        {
            mDatas.add(""+(char)i);
        }
    }
}
