package com.cytech.api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>
{
    private Context context;
    private List<Food> list;

    public FoodAdapter(Context context, List<Food> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_books, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = list.get(position);

        holder.textTitle.setText(food.getName());
        holder.textAuthor.setText(String.valueOf(food.getBrand_name()));
        holder.textPublisher.setText(String.valueOf(food.getSize()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, textAuthor, textPublisher;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.title);
            textAuthor = itemView.findViewById(R.id.author);
            textPublisher = itemView.findViewById(R.id.publisher);
        }
    }

}
