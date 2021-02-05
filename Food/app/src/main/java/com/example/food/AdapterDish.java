package com.example.food;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.databases.Database;
import com.example.food.databases.DishDao;

import java.util.List;

public class AdapterDish extends RecyclerView.Adapter<AdapterDish.DishViewHolder> {
    public static class DishViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nameDish;
        TextView priceDish;
        ImageView imageDish;
        ImageView buttonAddOrder;
        public DishViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nameDish =(TextView)itemView.findViewById(R.id.name_dishes);
            priceDish = (TextView)itemView.findViewById(R.id.price_dishes);
            imageDish = (ImageView)itemView.findViewById(R.id.dishes_photo);
            buttonAddOrder = (ImageView)itemView.findViewById(R.id.ibtAddOrder);
            nameDish.setTextColor(Color.WHITE);
            priceDish.setTextColor(Color.WHITE);
        }
    }

    List<Dish> dishes;

    public AdapterDish(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public DishViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
        DishViewHolder dishViewHolder = new DishViewHolder(v);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(DishViewHolder holder, int position) {
        holder.imageDish.setImageResource(dishes.get(position).getPhotoId());
        holder.nameDish.setText(dishes.get(position).getName());
        holder.priceDish.setText(dishes.get(position).getPrice());
        holder.buttonAddOrder.setOnClickListener(e->{
            Context context = holder.imageDish.getContext();
            DBAsynchronQuery dbAsynchronQuery = new DBAsynchronQuery(context,DBAsynchronQuery.INSERT);
            dbAsynchronQuery.execute(dishes.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

}
