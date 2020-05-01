package com.example.materialdesigndemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {


    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList();
    Context context;
    private ClickListener clickListener;

    public NavigationAdapter(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.custom_row, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Information information = data.get(position);
        holder.title.setText(information.title);
        holder.icon.setImageResource(information.iconId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView icon;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textList);
            icon = itemView.findViewById(R.id.listIcon);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //delete(getAdapterPosition());
//            Information information = data.get(getAdapterPosition());
//            if (clickListener != null){
//                clickListener.itemClicked(v,getAdapterPosition(), information.title.toString());
//            }
        }
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    public interface ClickListener{
        public void itemClicked(View view, int position,String text);
    }
}
