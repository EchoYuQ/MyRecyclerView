package com.example.myrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuqing on 2016/5/31.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    protected List<String> mDatas;
    private OnItemClickListner mOnItemClickListner;

    public interface OnItemClickListner {
        void onItemClick(View view, int pos);

        void onItemLongClick(View view, int pos);
    }

    public void setOnItemClickListner(OnItemClickListner listner)
    {
        this.mOnItemClickListner=listner;
    }

    public MyAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_single_textview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv.setText(mDatas.get(position));
        setUpItemEvent(holder);
    }

    protected void setUpItemEvent(final MyViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListner!=null)
                {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListner.onItemClick(holder.itemView,layoutPosition);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (mOnItemClickListner!=null)
                {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListner.onItemLongClick(holder.itemView,layoutPosition);
                }
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addData(int pos) {
        mDatas.add(pos, "insert one");
        notifyItemInserted(pos);
    }

    public void deleteDate(int pos) {
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.id_tv);
    }
}


