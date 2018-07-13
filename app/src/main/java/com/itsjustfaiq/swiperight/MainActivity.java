package com.itsjustfaiq.swiperight;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

import com.itsjustfaiq.swiperight.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager myViewPager;
    PagerAdapter myPagerAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myViewPager = findViewById(R.id.vPager);
        myPagerAdapter = new PagerAdapter(getSupportFragmentManager());

        myViewPager.setAdapter(myPagerAdapter);

        tabLayout = findViewById(R.id.tLayout);
        tabLayout.setupWithViewPager(myViewPager);
        //---------------------------------------------------------------------//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.aboutPage){
            Intent intent = new Intent(MainActivity.this, AboutPage.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
