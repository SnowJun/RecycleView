package com.demo.jinjin.demorecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by linkmax on 2016/8/3.
 */
public class PullAdapter extends RecyclerView.Adapter<PullAdapter.ListViewHolder> {


    private ArrayList<String> mStrings;

    private Context mContext;

    public PullAdapter(ArrayList<String> strings, Context context) {
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
        int width = 300;
        int height = (int) (300+20*(position%3));
        Logger.e(width+"\t" + height);
        holder.mTxtList.setLayoutParams(new LinearLayout.LayoutParams(width,height));
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
