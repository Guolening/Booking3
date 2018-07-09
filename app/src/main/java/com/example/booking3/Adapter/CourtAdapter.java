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

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Court court = mcourtList.get(position);   //为每个子项赋值
        holder.court_name.setText(court.getName());
        holder.court_type.setText("" + court.getType());
        holder.court_fee.setText(court.getFee());
        holder.court_opentime.setText(court.getOpentime());
        holder.court_closetime.setText("" + court.getClosetime());
    }

    @Override
    public int getItemCount() {
        return mcourtList.size();
    }

}
