package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.fragmentRecycle, R.id.userAccount, R.id.basketFragment, R.id.aboutMeFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.navFragment);

        NavigationUI.setupWithNavController(navigationView, navController);


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
}