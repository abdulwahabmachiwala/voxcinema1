package com.wahab.vox.cinema.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wahab.vox.cinema.R;
import com.wahab.vox.cinema.adapters.MovieAdapter;
import com.wahab.vox.cinema.models.Movie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MovieListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MovieListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView movieRecyclerView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MovieListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MovieListFragment newInstance() {
        MovieListFragment fragment = new MovieListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        movieRecyclerView = (RecyclerView) view.findViewById(R.id.movieRecyclerView);
        ArrayList<Movie> movies = prepareDummyData();
        MovieAdapter adapter = new MovieAdapter(getContext(), movies);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        movieRecyclerView.setAdapter(adapter);
        return view;
    }

    public ArrayList<Movie> prepareDummyData() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (int i = 0; i < 10; i++) {
            Movie movie = new Movie();
            if (i % 2 == 0) {
                movie.setName("The Meg");
                movie.setDuration("115 MIN");
                movie.setLanguage("ENGLISH");
                movie.setTrailerUrl("https://www.youtube.com/watch?v=GGYXExfKhmo");
                movie.setThumbnail(R.drawable.meg);
                movie.setPoster(R.drawable.meg_big_poster);
                movie.setGenre("Sci-Fi");
                movie.setReleaseDate("09/08/2018");
            } else {
                movie.setName("MI : Fallout");
                movie.setDuration("140 MIN");
                movie.setLanguage("ENGLISH");
                movie.setTrailerUrl("https://www.youtube.com/watch?v=wb49-oV0F78");
                movie.setThumbnail(R.drawable.mi);
                movie.setPoster(R.drawable.mission_impossible_poster);
                movie.setGenre("Action");
                movie.setReleaseDate("08/07/2018");
            }
            movies.add(movie);
        }
        return movies;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
