package cn.coder.toolset.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import cn.coder.toolset.BuildConfig;
import cn.coder.toolset.R;
import cn.coder.toolset.adapter.SectionsPagerAdapter;
import cn.coder.toolset.service.BatteryService;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "tab_page_fragment";

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        startService(new Intent(this, BatteryService.class));
        if (BuildConfig.DEBUG) Log.d(TAG, "MainActivity onCreate");
    }

    private void initData() {
        // TODO: 2017/8/7
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.page_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
        if (BuildConfig.DEBUG) Log.d(TAG, "MainActivity onResume");
    }

    @Override
    public void onStart(){
        super.onStart();
        if (BuildConfig.DEBUG) Log.d(TAG, "MainActivity onStart");
    }

    @Override
    public void onPause(){
        super.onPause();
        if (BuildConfig.DEBUG) Log.d(TAG, "MainActivity onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        if (BuildConfig.DEBUG) Log.d(TAG, "MainActivity onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (BuildConfig.DEBUG) Log.d(TAG, "MainActivity onDestroy");
    }


}
