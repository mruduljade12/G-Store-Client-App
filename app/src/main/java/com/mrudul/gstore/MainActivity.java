package com.mrudul.gstore;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.mrudul.gstore.fragments.CartFragment;
import com.mrudul.gstore.fragments.HistoryFragment;
import com.mrudul.gstore.fragments.HomeFragment;
import com.mrudul.gstore.fragments.ProfileFragment;
import com.mrudul.gstore.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    ImageView userImg;
    TextView userName;
    FragmentContainerView fragmentContainer;
    BottomNavigationView bottomNavigation;
    int nav_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userImg = findViewById(R.id.profile_image);
        userName = findViewById(R.id.user_name);
        fragmentContainer = findViewById(R.id.fragmentContainerView);
        bottomNavigation = findViewById(R.id.bottomNavigationView);
        int container = R.id.fragmentContainerView;

        Fragment f_home = new HomeFragment();
        Fragment f_cart = new CartFragment();
        Fragment f_search = new SearchFragment();
        Fragment f_history = new HistoryFragment();
        Fragment f_profile = new ProfileFragment();

        getSupportFragmentManager()
                .beginTransaction()
                        .add(container,f_home)
                                .commit();
        nav_count = 1;

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                int home = R.id.home;
                int cart = R.id.cart;
                int search = R.id.search;
                int history = R.id.history;
                int profile = R.id.profile;

                if (id == home){
                    if (nav_count != 1){
                        replaceFragment(container,f_home);
                        nav_count = 1;
                        return true;
                    }
                } else if (id == cart) {
                    if (nav_count != 2){
                        replaceFragment(container,f_cart);
                        nav_count = 2;
                        return true;
                    }
                } else if (id == search) {
                    if (nav_count != 3){
                        replaceFragment(container,f_search);
                        nav_count = 3;
                        return true;
                    }
                } else if (id == history) {
                    if (nav_count != 4){
                        replaceFragment(container,f_history);
                        nav_count = 4;
                        return true;
                    }
                } else if (id == profile){
                    if (nav_count != 5){
                        replaceFragment(container,f_profile);
                        nav_count = 5;
                        return true;
                    }
                } else {
                    Toast.makeText(MainActivity.this,"something went wrong",Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
    }

    private void replaceFragment(int container,Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(container,fragment)
                .addToBackStack(String.valueOf(fragment))
                .commit();

    }
}