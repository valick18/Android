package Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.food.AdapterDish;
import com.example.food.Dish;
import com.example.food.MainActivity;
import com.example.food.OrderAdapter;
import com.example.food.R;

import java.util.ArrayList;

public class BasketFragment extends Fragment {
    RecyclerView rv;
    LinearLayoutManager layoutManager;
    OrderAdapter orderAdapter;
    ArrayList<Dish> orderList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.titleBar.setText("Корзина");
        View v = inflater.inflate(R.layout.fragment_recycle, container, false);

        rv = (RecyclerView)v.findViewById(R.id.recycleViewCard);

        layoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(layoutManager);
        orderList = (ArrayList<Dish>) MainActivity.getInstance().getDatabase().DishDao().getAll();
        orderAdapter = new OrderAdapter(orderList);
        rv.setAdapter(orderAdapter);
        return v;
    }

    public void onResume(){
        super.onResume();
        MainActivity.titleBar.setText("Корзина");
    }


}