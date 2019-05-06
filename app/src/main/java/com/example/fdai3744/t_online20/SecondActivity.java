package com.example.fdai3744.t_online20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.example.fdai3744.t_online20.R.id.container;

public class SecondActivity extends AppCompatActivity {

    private TabLayout tabToolbar;
    private ViewPager viewPager;
    private TextView topup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/century.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        topup = (TextView) findViewById(R.id.topup);

        viewPager = (ViewPager) findViewById(container);
        viewPager.setAdapter(mSectionsPagerAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabToolbar = (TabLayout) findViewById(R.id.tabToolbar);
        tabToolbar.setupWithViewPager(viewPager);

        tabToolbar.getTabAt(0).setIcon(R.mipmap.home_button);
        tabToolbar.getTabAt(1).setIcon(R.mipmap.pay_button);
        tabToolbar.getTabAt(2).setIcon(R.mipmap.video_button);
        tabToolbar.getTabAt(3).setIcon(R.mipmap.bill_button);

        tabToolbar.getTabAt(tabToolbar.getSelectedTabPosition()).getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);

        tabToolbar.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tabToolbar.getTabAt(tabToolbar.getSelectedTabPosition()).getIcon().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabToolbar.getTabAt(tabToolbar.getSelectedTabPosition()).getIcon().setColorFilter(Color.parseColor("#e40079"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putString("TOPUP", String.valueOf(topup.getText()));
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        topup.setText(savedInstanceState.getString("TOPUP"));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            Intent intent = new Intent(this, MainActivity.class);
            tabToolbar.getTabAt(tabToolbar.getSelectedTabPosition()).getIcon().setColorFilter(Color.parseColor("#e40079"), PorterDuff.Mode.SRC_IN);
            this.startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public double getAmountValue()
    {
        return Double.parseDouble(String.valueOf(topup.getText()));
    }

    public void changeAmountValue(String nValue)
    {
        Bundle savedStateInstance = new Bundle();
        savedStateInstance.putString("TOPUP", nValue);
        topup.setText(nValue);
    }
}
