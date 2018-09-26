package com.lai.www.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lai on 2018/9/10.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private Context mContext;
    private List<String> mListData;

    public RecyclerAdapter(Context context, List<String> listData) {
        this.mContext = context;
        this.mListData = listData;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //生成layout
        View inflate =
                LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, parent, false);
        return new RecyclerViewHolder(inflate);
    }

    //绑定数据
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mTvItemRecycler.setText(mListData.get(position));
    }

    //计算RecyclerView的个数
    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }


    /**
     * RecyclerView 的 ViewHolder
     */
    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvItemRecycler;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            mTvItemRecycler = itemView.findViewById(R.id.tv_item_recycler);
        }
    }
}
