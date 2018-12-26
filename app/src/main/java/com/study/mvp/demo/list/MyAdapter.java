package com.study.mvp.demo.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.mvp.demo.R;
import com.study.mvp.demo.list.mdole.HistoryData;

import java.util.List;

/**
 * @desc:
 * @author: yangwb
 * @date: 2018/12/25 14:52
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<HistoryData> data;
    private Context context;
    private OnItemClickListener itemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    public MyAdapter(Context context, List<HistoryData> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HistoryData historyData = data.get(position);
        holder.item_time.setText(historyData.year + "年" + historyData.month + "月" + historyData.day + "日（" + historyData.lunar + "）");
        holder.item_title.setText(historyData.title);
        holder.item_desc.setText(historyData.des);
        Glide.with(context).load(historyData.pic).error(R.mipmap.ic_launcher).into(holder.item_picture);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView item_picture;
        TextView item_time;
        TextView item_title;
        TextView item_desc;
        private OnItemClickListener listener;
        public MyViewHolder(View itemView,OnItemClickListener listener) {
            super(itemView);
            this.listener=listener;
            item_picture = itemView.findViewById(R.id.item_picture);
            item_time = itemView.findViewById(R.id.item_time);
            item_title = itemView.findViewById(R.id.item_title);
            item_desc = itemView.findViewById(R.id.item_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view,getAdapterPosition());
        }
    }

}
