package com.minras.android.eohpoc.thepoc;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.estimote.sdk.SystemRequirementsChecker;
import com.minras.android.eohpoc.thepoc.fragment.SectionsPagerAdapter;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public static final String STORAGE_NAME = "EohStorage";
    public static final String STORAGE_KEY_LOGS = "log";

    private boolean isLogsInitialized = false;

    private BluetoothAdapter bluetoothAdapter;
    private Set<BluetoothDevice> pairedDevices;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        initBluetooth();
    }

    private void initLog() {
        getSharedPreferences(STORAGE_NAME, 0).
                edit().
                putString(STORAGE_KEY_LOGS, "").
                apply();
        isLogsInitialized = true;
    }

    public void addLog(String msg) {
        if (!isLogsInitialized) initLog();
        SharedPreferences settings = getSharedPreferences(STORAGE_NAME, 0);
        settings.edit().
            putString(
                    STORAGE_KEY_LOGS,
                    settings.getString(STORAGE_KEY_LOGS, "") + "\n" + msg).
            apply();
    }

    private void initBluetooth() {
        addLog("Bluetooth initialization started");
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        addLog("Bluetooth initialization completed");
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
        if (id == R.id.action_main) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }
}