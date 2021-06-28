package com.example.zecure;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;
import android.widget.FrameLayout;

import android.content.Intent;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        toggleDrawer();
        initializeDefaultFragment(savedInstanceState,0);
    }

    /**
     * Initialize all widgets
     */
    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.toolbar_title);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        frameLayout = findViewById(R.id.framelayout_id);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * Checks if the savedInstanceState is null - onCreate() is ran
     * If so, display fragment of navigation drawer menu at position itemIndex and
     * set checked status as true
     * @param savedInstanceState
     * @param itemIndex
     */
    private void initializeDefaultFragment(Bundle savedInstanceState, int itemIndex){
        if (savedInstanceState == null){
            MenuItem menuItem = navigationView.getMenu().getItem(itemIndex).setChecked(true);
            onNavigationItemSelected(menuItem);
        }
    }

    /**
     * Creates an instance of the ActionBarDrawerToggle class:
     * 1) Handles opening and closing the navigation drawer
     * 2) Creates a hamburger icon in the toolbar
     * 3) Attaches listener to open/close drawer on icon clicked and rotates the icon
     */
    private void toggleDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        //Checks if the navigation drawer is open -- If so, close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        // If drawer is already close -- Do not override original functionality
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
//                Intent intent = new Intent(MainActivity.this, Home.class);
//                startActivity(intent);
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new Home())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new About())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_share:
//                Toast.makeText(this, "Share Pressed", Toast.LENGTH_SHORT).show();
//                deSelectCheckedState();
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
                startActivity(Intent.createChooser(shareIntent, "Share Using"));
                break;
        }
        return true;
    }

    /**
     * Checks if the navigation drawer is open - if so, close it
     */
    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    /**
     * Iterates through all the items in the navigation menu and deselects them:
     * removes the selection color
     */
//    private void deSelectCheckedState(){
//        int noOfItems = navigationView.getMenu().size();
//        for (int i=0; i<noOfItems;i++){
//            navigationView.getMenu().getItem(i).setChecked(false);
//        }
//    }
}