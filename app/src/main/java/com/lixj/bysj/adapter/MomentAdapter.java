package com.lixj.bysj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lixj.bysj.R;
import com.lixj.bysj.bean.Moments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-4.
 */
public class MomentAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<Moments> data;

    public MomentAdapter(Context context, List<Moments> data) {
        this.mContext = context;
        this.data = data;
    }
    public void bindData(List<Moments> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public void addData(List<Moments> data) {
        if(this.data == null) {
            data = new ArrayList<>();
        }
        data.addAll(data);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MomentHolder(mContext, parent, R.layout.item_moment);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MomentHolder)holder).bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
