package com.example.myrecycleview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initView();
        mAdapter=new MyAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);
        // 设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter.setOnItemClickListner(new MyAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int pos) {
                Toast.makeText(MainActivity.this,"click:"+pos,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int pos) {
                Toast.makeText(MainActivity.this,"Longclick:"+pos,Toast.LENGTH_SHORT).show();

            }
        });

        // 设置RecyclerView的分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        // 设置添加和删除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();
        switch (id)
        {
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_delete:
                mAdapter.deleteDate(1);
                break;
            case R.id.action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_staggered:
                Intent intent=new Intent(MainActivity.this,StaggeredGridLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.action_gridview_horizontal:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
