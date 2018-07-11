package com.example.booking3.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.booking3.Model.Court;
import com.example.booking3.R;
import com.example.booking3.UI.MapActivity;

import java.util.List;

/**
 * Created by t520win764zy on 2018/7/7.
 */

public class CourtAdapter extends RecyclerView.Adapter<CourtAdapter.ViewHolder> {
    private List<Court> mcourtList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View courtView;
        String courtName;
        TextView court_name;
        TextView court_type;
        TextView court_fee;
        TextView court_opentime;
        TextView court_closetime;

        /*
        函数名：ViewHolder
        函数功能：重载函数，设置recycleview的view类型
        变量说明：itemview是recycleview中的一个条目视图
        返回值说明：无
        */
        public ViewHolder(View itemView) {
            super(itemView);
            courtView = itemView;
            court_name = (TextView) itemView.findViewById(R.id.court_result_item_name);
            court_type = (TextView) itemView.findViewById(R.id.court_result_item_type);
            court_fee = (TextView) itemView.findViewById(R.id.court_result_item_fee);
            court_opentime = (TextView) itemView.findViewById(R.id.court_result_item_opentime);
            court_closetime = (TextView) itemView.findViewById(R.id.court_result_item_closetime);
            courtName=court_name.getText().toString();//????????????????????????????????????????????????????
        }
    }

    public CourtAdapter(List<Court> courtList) {
        mcourtList = courtList;
    }

    /*
    函数名：onCreateViewHolder
    函数功能：设置recycleview的显示方式
    变量说明：ViewGroup是一个视图组，viewType是一个视图类型，这两个决定recycleview的显示方式
    返回值说明：返回一个ViewHolder类型的对象
    */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.court_result_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.courtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Court court = mcourtList.get(position);

                //点击显示地图事件
                Intent intent = new Intent(view.getContext(), MapActivity.class);//注意MapActivity记得在manifest.xml中进行声明
                Bundle bundle = new Bundle();
                bundle.putString("name",court.getName());//emptyRoom即为所点击item的那个数组，.getBuild()则是得出教学楼
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);//和成功之间仅差view.getContext().！！！！！！！
            }
        });
        return holder;
    }

    /*
    函数名：onBindViewHolder
    函数功能：设置recycleview中数据的显示方式
    变量说明：ViewHolder类型的对象，以及int型的position数值确定recycleview中的哪一行
    返回值说明：无
    */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Court court = mcourtList.get(position);   //为每个子项赋值
        holder.court_name.setText(court.getName());
        holder.court_type.setText("" + court.getType());
        holder.court_fee.setText(court.getFee());
        holder.court_opentime.setText(court.getOpentime());
        holder.court_closetime.setText("" + court.getClosetime());
    }

    //输出数组的大小
    @Override
    public int getItemCount() {
        return mcourtList.size();
    }

}
