package com.example.fragmentapppractice;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());

        ViewPager2 viewpager = findViewById(R.id.viewpager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);


        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        FragementCustomAdapter adapter = new FragementCustomAdapter(
                getSupportFragmentManager(),
                getLifecycle(),
                fragments

        );
        viewpager.setAdapter(adapter);

        new TabLayoutMediator(
                tabLayout,
                viewpager,
                ((tab, position) -> {
                    tab.setText("Page " + (position+1) );
                })
        ).attach();
    }
}