package com.example.classactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//import android.support.v4.view.ViewPager;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ViewPager vp;

    private TabLayout tabLayout;

    private TabsAdapter tabsAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //loading the menu on the activity
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item3:
                Toast.makeText(this, "New group selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this, "New broadcast selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Toast.makeText(this, "Linked devices", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item6:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast toast = Toast.makeText(getApplicationContext(), "Hi i have changed my position", Toast.LENGTH_LONG);
//
//        toast.setGravity(Gravity.CENTER| Gravity.CENTER, 0, 0);
//        toast.show();

        LayoutInflater inflater = getLayoutInflater();
        View toastview = inflater.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.RootLayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setView(toastview);
        toast.show();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vp = (ViewPager) findViewById(R.id.tabsPager);
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        vp.setAdapter(tabsAdapter);

        tabLayout = (TabLayout) findViewById(R.id.mainTabs);
        tabLayout.setupWithViewPager(vp);

    }
}