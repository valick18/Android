package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.food.databases.Database;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration mAppBarConfiguration;
    private static MainActivity instance;
    private Database database;
    public static TextView titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleBar = (TextView) findViewById(R.id.titleText);
        instance = this;
        database = Room.databaseBuilder(this,Database.class,"database")
                .allowMainThreadQueries()
                .build();
        
         DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.fragmentRecycle, R.id.userAccount, R.id.basketFragment, R.id.aboutMeFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        ImageView burgerButton = findViewById(R.id.badge_icon_button);
        burgerButton.setOnClickListener(e->drawer.openDrawer(GravityCompat.START));

    }

    @Override
    public void onClick(View v) {
        NavController controller = Navigation.findNavController(v);
        switch(v.getId()){
            case R.id.but_createAcc:
            case R.id.but_login:
                controller.navigate(R.id.fragmentRecycle);
                break;
            case R.id.btn_signUp:
                controller.navigate(R.id.fragmentCreateAcc);
                break;
            case R.id.btn_signIn:
                controller.navigate(R.id.fragmentLogin);
            break;
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }


}