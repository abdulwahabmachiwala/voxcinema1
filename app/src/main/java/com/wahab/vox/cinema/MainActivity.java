package com.wahab.vox.cinema;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.wahab.vox.cinema.fragments.MovieListFragment;
import com.wahab.vox.cinema.fragments.MoviesFragment;
import com.wahab.vox.cinema.fragments.SearchFragment;
import com.wahab.vox.cinema.fragments.WatchFragment;
import com.wahab.vox.cinema.fragments.WhatsOnFragment;
import com.wahab.vox.cinema.models.BottomNavigationViewHelper;


public class MainActivity extends AppCompatActivity implements WhatsOnFragment.OnFragmentInteractionListener, MoviesFragment.OnFragmentInteractionListener, SearchFragment.OnFragmentInteractionListener, WatchFragment.OnFragmentInteractionListener, MovieListFragment.OnFragmentInteractionListener{

    private BottomNavigationView bottomNavigationView;
    private android.support.v7.widget.Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, WhatsOnFragment.newInstance()).commit();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_bar);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.whatson:
                        fragment = WhatsOnFragment.newInstance();
                        break;
                    case R.id.movie:
                        fragment = MoviesFragment.newInstance();
                        break;
                    case R.id.search:
                        fragment = SearchFragment.newInstance();
                        break;
                    case R.id.chair:
                        fragment = WatchFragment.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contentContainer, fragment);
                transaction.commit();
                return true;
            }
        });
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

