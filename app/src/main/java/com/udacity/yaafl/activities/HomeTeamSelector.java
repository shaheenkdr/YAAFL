package com.udacity.yaafl.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;


import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.udacity.yaafl.R;
import com.udacity.yaafl.adapter.HomeAdapter;

import com.udacity.yaafl.utility.SpeedyLinearLayoutManager;
import com.udacity.yaafl.utility.TeamInfo;
import com.udacity.yaafl.utility.TeamLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeTeamSelector extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<String>> {
    //private static ArrayList<String> team_list;
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    private RecyclerView rView;
/*
    static {
        team_list = new ArrayList<>();
        for (int i = 0; i < 20; i++)
            team_list.add(TeamInfo.getTeamNameForView(i));
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_team_selector);
        setupWindowAnimations();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final AppBarLayout abl = (AppBarLayout) findViewById(R.id.appbarhome);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        Typeface font = Typer.set(this).getFont(Font.ROBOTO_BOLD);
        collapsingToolbarLayout.setExpandedTitleTypeface(font);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.home_team));

        dynamicToolbarColor();
        toolbarTextAppernce();
        rView = (RecyclerView) findViewById(R.id.homeTeamRView);
        rView.setHasFixedSize(true);
        SpeedyLinearLayoutManager llm = new SpeedyLinearLayoutManager(HomeTeamSelector.this);
        rView.setLayoutManager(llm);
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abl.setExpanded(false);
                rView.smoothScrollToPosition(7);


            }
        });


    }

    @Override
    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
        return new TeamLoader(HomeTeamSelector.this);
    }
    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data)
    {
        HomeAdapter homeAdapter = new HomeAdapter(new ArrayList<String>(data));
        rView.setAdapter(homeAdapter);
    }
    @Override
    public void onLoaderReset(Loader<List<String>> loader)
    {
        HomeAdapter homeAdapter = new HomeAdapter(new ArrayList<String>());
        rView.setAdapter(homeAdapter);
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setExitTransition(fade);
        getWindow().setEnterTransition(fade);
    }

    private void dynamicToolbarColor() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.e5);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(ContextCompat.getColor(HomeTeamSelector.this, R.color.colorPrimary)));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(ContextCompat.getColor(HomeTeamSelector.this, R.color.colorPrimary)));
            }
        });
    }

    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }
}
