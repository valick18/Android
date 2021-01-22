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
    FragmentTransaction ft;
    FragmentRecycle fragmentRecycle;
    FragmentLogin fragmentLogin;
    FragmentCreateAcc fragmentCreateAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment hostFragment = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.navFragment);
        NavController controller = hostFragment.getNavController();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navigationView, controller);

        if (savedInstanceState == null) {
            ft = getSupportFragmentManager().beginTransaction();
            fragmentRecycle = new FragmentRecycle();
            fragmentLogin = new FragmentLogin();
            fragmentCreateAcc = new FragmentCreateAcc();
            ft.replace(R.id.fragment,fragmentLogin);
            ft.commit();
        }


    }


    @Override
    public void onClick(View v) {
        ft = getSupportFragmentManager().beginTransaction();
        switch(v.getId()){
            case R.id.but_createAcc:
                ft.replace(R.id.fragment,fragmentRecycle);
                break;
            case R.id.but_login:
                ft.replace(R.id.fragment,fragmentRecycle);
                break;
            case R.id.btn_signUp:
                ft.replace(R.id.fragment,fragmentCreateAcc);
                break;
            case R.id.btn_signIn:
                ft.replace(R.id.fragment,fragmentLogin);
            break;
        }
        ft.addToBackStack(null);
        ft.commit();
    }
}