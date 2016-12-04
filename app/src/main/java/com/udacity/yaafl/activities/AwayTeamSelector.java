package com.udacity.yaafl.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.MenuItem;
import android.view.View;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.udacity.yaafl.R;
import com.udacity.yaafl.adapter.AwayAdapter;
import com.udacity.yaafl.utility.SpeedyLinearLayoutManager;
import com.udacity.yaafl.utility.TeamInfo;
import com.udacity.yaafl.utility.TeamLoader;

import java.util.ArrayList;
import java.util.List;

public class AwayTeamSelector extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<String>> {


    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    private RecyclerView rView;
    private int homeTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_away_team_selector);
        Bundle extras = getIntent().getExtras();
        homeTeam = extras.getInt("HOME");

        ArrayList<String> team_list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i != homeTeam)
                team_list.add(TeamInfo.getTeamNameForView(i));
        }
        setupWindowAnimations();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_away);
        final AppBarLayout abl = (AppBarLayout) findViewById(R.id.appBarAway);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_away);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.away_team));
        Typeface font = Typer.set(this).getFont(Font.ROBOTO_BOLD);
        collapsingToolbarLayout.setExpandedTitleTypeface(font);

        dynamicToolbarColor();
        toolbarTextAppearence();
        rView = (RecyclerView) findViewById(R.id.awayTeamRView);
        rView.setHasFixedSize(true);
        SpeedyLinearLayoutManager llm = new SpeedyLinearLayoutManager(AwayTeamSelector.this);
        rView.setLayoutManager(llm);
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();
        AwayAdapter awayAdapter = new AwayAdapter(team_list, homeTeam);
        rView.setAdapter(awayAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAway);
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
        return new TeamLoader(AwayTeamSelector.this);
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
        data.remove(homeTeam);
        AwayAdapter awayAdapter = new AwayAdapter(new ArrayList<String>(data), homeTeam);
        rView.setAdapter(awayAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {
        AwayAdapter awayAdapter = new AwayAdapter(new ArrayList<String>(), 0);
        rView.setAdapter(awayAdapter);
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
    }

    private void dynamicToolbarColor() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.e5);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(ContextCompat.getColor(AwayTeamSelector.this, R.color.colorPrimary)));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(ContextCompat.getColor(AwayTeamSelector.this, R.color.colorPrimary)));
            }
        });
    }

    private void toolbarTextAppearence() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(AwayTeamSelector.this, HomeTeamSelector.class);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
