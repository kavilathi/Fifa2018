package com.example.kavi.fifaworldcup2018;

import android.app.FragmentManager;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kavi.fifaworldcup2018.model.MyPref;
import com.example.kavi.fifaworldcup2018.model.Team;
import com.example.kavi.fifaworldcup2018.utils.TeamList;
import com.example.kavi.fifaworldcup2018.view.FixturFragment;
import com.example.kavi.fifaworldcup2018.view.GroupFragment;
import com.example.kavi.fifaworldcup2018.view.HomeFragment;
import com.example.kavi.fifaworldcup2018.view.TeamFragment;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kavi on 3/18/2018.
 */

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBar actionbar;
    private NavigationView navigationView;
    private CircleImageView navFavTeamImageView;
    private TextView  navFavteamTextView;

    // variables TIME_DELAY and back_pressed used to calculate the time difference while pressing back button
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    //toolbar title respected to selected nav menu item
    private String[] fragmentTitle;
    //index to identify current navigation menu item
    public static int navItemIndex = 0;

    // Tag to attached fragment
    private static final String TAG_HOME ="home";
    private static final String TAG_GROUP ="group";
    private static final String TAG_FIXTUR ="fixture";
    private static final String TAG_TEAM ="team";
    public static  String CURRENT_TAG =TAG_HOME;
    Runnable mPendingRunnable;
    private Handler mHandler;
    //flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragmentOnBackPress = true;
    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.toolbar_menu_launcher_icon);
        navigationView = findViewById(R.id.nav_view);
        mHandler = new Handler();
        //load toolbar title from string resources
        fragmentTitle = getResources().getStringArray(R.array.nav_item_activity_titles);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }
                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }
                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
        setNavigationView();
        setFavoriteTeamDetailsNavigationView();
        if(savedInstanceState == null )
        {
            navItemIndex=0;
            CURRENT_TAG=TAG_HOME;
            loadFragment();
        }

    }
    private void loadFragment()
    {
        selectNavigationItem();
        setToolBarTitle();
        //if user select the current navigation menu again, do not do anythinf
        //just close the navigation drawer
        if(getSupportFragmentManager().findFragmentByTag(CURRENT_TAG)!=null) {
            mDrawerLayout.closeDrawers();
            return;
        }

        //Sometimes when fragment has huge data, screen seems to hanging
        //when switching between navigation menus
        //so using runnable, the fragment is loaded with cross fade effect
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                //update the main content by replacing the fragment
                Fragment fragment = getFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_frame,fragment,CURRENT_TAG);
                fragmentTransaction.commit();
           }
        };
        //if mmPendingRunnable is not null, then add to the message queue
        if(mPendingRunnable != null)
        {
            mHandler.post(mPendingRunnable);
        }
        //closing drawers on item clicked
        mDrawerLayout.closeDrawers();
        //refresh toolbar menu
        invalidateOptionsMenu();
    }



    private Fragment getFragment()
    {
                switch (navItemIndex){
                    case 0:
                        //home
                        HomeFragment homeFragment = new HomeFragment();
                        return homeFragment;
                    case 1:
                        //Group
                        GroupFragment groupFragment = new GroupFragment();
                        return groupFragment;
                    case 2:
                        //fixture
                        FixturFragment fixturFragment = new FixturFragment();
                        return fixturFragment;
                    case 3:
                        //Team
                        TeamFragment teamFragment = new TeamFragment();
                        return teamFragment;
                    default:
                        return new HomeFragment();
                }

    }
    private void selectNavigationItem()
    {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }
    private void setToolBarTitle()
    {
        getSupportActionBar().setTitle(fragmentTitle[navItemIndex]);
    }

    //code to get item id clicked and start fragment accordingly
    private void setNavigationView()
    {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem menuItem) {


                        switch(menuItem.getItemId())
                        {
                            case R.id.home :
                                navItemIndex = 0;
                                CURRENT_TAG = TAG_HOME;
                                break;
                            case R.id.group:
                                navItemIndex = 1;
                                CURRENT_TAG = TAG_GROUP;
                                break;
                            case R.id.fixture:
                                navItemIndex = 2;
                                CURRENT_TAG = TAG_FIXTUR;
                                break;
                            case R.id.team:
                                navItemIndex = 3;
                                CURRENT_TAG = TAG_TEAM;
                                break;
                            default:
                                navItemIndex = 0;

                        }
                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()){
                    menuItem.setChecked(false);
                } else{
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                loadFragment();

                return true;
            }
        });
    }
    // Team selected is fetched from shared preferences
    private void setFavoriteTeamDetailsNavigationView()
    {
        String team= new MyPref(this).getSavedFavoriteTeam();
        for(Team t: TeamList.getTeamList())
        {
            if(t.getTeamName().contains(team))
            {
                navFavTeamImageView = findViewById(R.id.nav_view_fav_team_image);
                navFavteamTextView = findViewById(R.id.nav_view_fav_team_text);
                navFavTeamImageView.setImageResource(t.getTeamFlag());
                navFavteamTextView.setText(t.getTeamName());
            }
        }
    }

  @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

   @Override
    public void onBackPressed() {
        //moveTaskToBack(true);

       if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
           super.onBackPressed();
           Intent intent = new Intent(Intent.ACTION_MAIN);
           intent.addCategory(Intent.CATEGORY_HOME);
           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           startActivity(intent);
           finish();
           System.exit(0);
       } else {
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           Toast.makeText(getBaseContext(), "Press once again to exit!",Toast.LENGTH_SHORT).show();
           if(navItemIndex!=0)
           {
               navItemIndex=0;
               CURRENT_TAG=TAG_HOME;
               loadFragment();
               return;
           }
           super.onBackPressed();
          }
       back_pressed = System.currentTimeMillis();

    }
}
