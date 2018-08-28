package com.wahab.vox.cinema;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.wahab.vox.cinema.adapters.MovieAdapter;
import com.wahab.vox.cinema.adapters.TabFragmentAdapter;
import com.wahab.vox.cinema.fragments.TimingListFragment;
import com.wahab.vox.cinema.models.Movie;

public class MovieDetailsActivity extends AppCompatActivity implements TimingListFragment.OnFragmentInteractionListener {

    public static final String TAG = MovieDetailsActivity.class.getSimpleName();

    private Spinner spinner;
    private Toolbar toolbar;
    private CollapsingToolbarLayout toolbarLayout;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageView moviePosterImageView;
    private FloatingActionButton fab;
    private NestedScrollView nestedScrollView;
    private TextView genreTextView;
    private TextView languageTextView;
    private TextView durationTextView;
    private TextView releaseDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        moviePosterImageView = (ImageView) findViewById(R.id.expandedImage);
        spinner = (Spinner) findViewById(R.id.theatreList);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        genreTextView = (TextView) findViewById(R.id.genreTextView);
        languageTextView = (TextView) findViewById(R.id.languageTextView);
        releaseDateTextView = (TextView) findViewById(R.id.releaseDateTextView);
        durationTextView = (TextView) findViewById(R.id.durationTextView);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final Movie movie = intent.getParcelableExtra(MovieAdapter.KEY_MOVIE);

        toolbarLayout.setTitle(movie.getName());
        genreTextView.setText(movie.getGenre());
        releaseDateTextView.setText(movie.getReleaseDate());
        durationTextView.setText(movie.getDuration());
        languageTextView.setText(movie.getLanguage());
        moviePosterImageView.setBackgroundResource(movie.getPoster());
        nestedScrollView.setFillViewport(true);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext().getApplicationContext(), R.array.theatres, R.layout.spinner_center_text);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(movie.getTrailerUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });
    }

    public void setupViewPager(ViewPager viewPager) {
        TabFragmentAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager());
        adapter.addTab(TimingListFragment.newInstance(), "Today");
        adapter.addTab(TimingListFragment.newInstance(), "Wed 15 Aug");
        adapter.addTab(TimingListFragment.newInstance(), "Thu 16 Aug");
        adapter.addTab(TimingListFragment.newInstance(), "Fri 17 Aug");
        adapter.addTab(TimingListFragment.newInstance(), "Sat 18 Aug");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
