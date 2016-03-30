package com.nutstudio.googleplus;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nutstudio.googleplus.Fragment.RecyclerFragment;
import com.nutstudio.googleplus.Fragment.Tab1Fragment;
import com.nutstudio.googleplus.Fragment.Tab2Fragment;
import com.nutstudio.googleplus.Fragment.Tab3Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private LinearLayout bottom0Lin, bottom1Lin, bottom2Lin, bottom3Lin;
    private Tab1Fragment tab1Fragment = new Tab1Fragment();
    private FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager.beginTransaction().add(R.id.main_layout_fl, new RecyclerFragment(), "0").commit();
        initView();

        initSystemView();
    }

    private void initSystemView() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initView() {
        tab1Fragment.setOnSlideLisener(new Tab1Fragment.OnViewPagerSlidLensener() {
            @Override
            public void onSlide(int position) {
                Toast.makeText(MainActivity.this, "position" + position, Toast.LENGTH_SHORT).show();
            }
        });
        bottom0Lin = (LinearLayout) findViewById(R.id.lin_bottom0);
        bottom1Lin = (LinearLayout) findViewById(R.id.lin_bottom1);
        bottom2Lin = (LinearLayout) findViewById(R.id.lin_bottom2);
        bottom3Lin = (LinearLayout) findViewById(R.id.lin_bottom3);
        bottom0Lin.setOnClickListener(new MyClick());
        bottom1Lin.setOnClickListener(new MyClick());
        bottom2Lin.setOnClickListener(new MyClick());
        bottom3Lin.setOnClickListener(new MyClick());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Created by fei on 2016/3/29.
     */
    public class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.lin_bottom0:
                    if (manager.findFragmentByTag("0") == null) {
                        manager.beginTransaction().replace(R.id.main_layout_fl, new RecyclerFragment(), "0").commit();
                    }
                    break;
                case R.id.lin_bottom1:

                    if (manager.findFragmentByTag("1") == null) {
                        manager.beginTransaction().replace(R.id.main_layout_fl, new Tab1Fragment(), "1").commit();
                    }
                    break;
                case R.id.lin_bottom2:
                    if (manager.findFragmentByTag("2") == null) {
                        manager.beginTransaction().replace(R.id.main_layout_fl, new Tab2Fragment(), "2").commit();
                    }
                    break;
                case R.id.lin_bottom3:
                    if (manager.findFragmentByTag("3") == null) {
                        manager.beginTransaction().replace(R.id.main_layout_fl, new Tab3Fragment(), "3").commit();
                    }
                    break;
            }
        }
    }
}
