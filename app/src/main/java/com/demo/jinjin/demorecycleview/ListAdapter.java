package com.demo.jinjin.demorecycleview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by linkmax on 2016/8/3.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {


    private ArrayList<String> mStrings;

    private Context mContext;

    public ListAdapter(ArrayList<String> strings, Context context) {
        mStrings = strings;
        mContext = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListViewHolder holder = new ListViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.mTxtList.setText(mStrings.get(position));
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.txt_list)
        TextView mTxtList;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
