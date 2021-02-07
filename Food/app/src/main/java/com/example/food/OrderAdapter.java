package com.example.food;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nameDish;
        TextView priceDish;
        ImageView imageDish;
        ImageView btDeleteOrder;
        public OrderViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nameDish =(TextView)itemView.findViewById(R.id.nameD);
            priceDish = (TextView)itemView.findViewById(R.id.priceD);
            imageDish = (ImageView)itemView.findViewById(R.id.dishesP);
            btDeleteOrder = (ImageView)itemView.findViewById(R.id.btDeleteOrder);
        }
    }

    List<Dish> orderList;

    public OrderAdapter(List<Dish> dishes) {
        this.orderList = dishes;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.basket_item_layout, parent,false);
        OrderAdapter.OrderViewHolder orderViewHolder = new OrderAdapter.OrderViewHolder(v);
        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
                holder.imageDish.setImageResource(orderList.get(position).getPhotoId());
                holder.nameDish.setText(orderList.get(position).getName());
                holder.priceDish.setText(orderList.get(position).getPrice());
                Dish order = orderList.get(position);
                    holder.btDeleteOrder.setOnClickListener(e -> {
                        Context context = holder.imageDish.getContext();
                    if (orderList.size()>1) {
                        DBAsynchronQuery dbAsynchronQuery = new DBAsynchronQuery(context, DBAsynchronQuery.DELETE);
                        dbAsynchronQuery.execute(order);
                        orderList.remove(position);
                        this.notifyItemRemoved(position);
                    }else{
                        DBAsynchronQuery dbAsynchronQuery = new DBAsynchronQuery(context, DBAsynchronQuery.DELETE);
                        orderList.remove(0);
                        dbAsynchronQuery.execute(order);
                        this.notifyItemRemoved(0);
                    }
                    });
                }



    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
