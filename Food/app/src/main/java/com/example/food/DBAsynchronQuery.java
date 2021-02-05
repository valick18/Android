package com.example.food;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.food.databases.Database;
import com.example.food.databases.DishDao;

public class DBAsynchronQuery extends AsyncTask<Dish,Void,Void> {

  public static final int INSERT = 1;
  public static final int DELETE = 2;

    private Context context;
    private int action;
    private Database database = MainActivity.getInstance().getDatabase();
    private DishDao dishDao = database.DishDao();

    public DBAsynchronQuery(Context context, int action){
        this.context=context;
        this.action=action;
    }

    @Override
    protected Void doInBackground(Dish... dishes) {
        switch (action){
            case INSERT:
                dishDao.insert(dishes[0]);
                break;
            case DELETE:
                dishDao.delete(dishes[0]);
                break;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        Toast.makeText(context,"Заказ добавлен в корзину", Toast.LENGTH_LONG).show();
        for(Dish d: dishDao.getAll()){
            Log.d("Root",""+d);
        }
    }

}
