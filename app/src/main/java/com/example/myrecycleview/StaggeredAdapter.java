package com.example.myrecycleview;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuqing on 2016/5/31.
 */
public class StaggeredAdapter extends MyAdapter {

    private List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String> datas) {
        super(context,datas);
        mHeights=new ArrayList<Integer>();
        for (int i=0;i<mDatas.size();i++)
        {
            mHeights.add((int) (100+Math.random()*300));
        }
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height=mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));
        setUpItemEvent(holder);
    }




}



