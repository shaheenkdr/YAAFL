package com.udacity.yaafl.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.util.Log;
import android.view.View;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.udacity.yaafl.R;
import com.udacity.yaafl.adapter.HomeAdapter;
import com.udacity.yaafl.sqlite.TeamProvider;
import com.udacity.yaafl.utility.CSVFile;
import com.udacity.yaafl.utility.MatchParser;
import com.udacity.yaafl.utility.SpeedyLinearLayoutManager;
import com.udacity.yaafl.utility.TeamLoader;

import java.io.InputStream;
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

        final SharedPreferences pref = getSharedPreferences("ActivitySession", Context.MODE_PRIVATE);
        final String Test = "";
        String abc = pref.getString("HASH", "");
        if (!abc.equals(Test)) {

            InputStream inputStream = getResources().openRawResource(R.raw.data);
            CSVFile csvFile = new CSVFile(inputStream);
            ArrayList<MatchParser> data_set = csvFile.read();

            for (MatchParser x : data_set) {
                ContentValues values = new ContentValues();
                values.put(TeamProvider.MATCH_TEAM, x.getMatchName());
                values.put(TeamProvider.MATCH_CODE, x.getMatchId());
                Log.w(x.getMatchName(), x.getMatchId());
                Uri uri = getContentResolver().insert(TeamProvider.CONTENT_URI, values);
            }
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("HASH", "DO I REALLY LOOK LIKE A GUY WITH A PLAN");
            editor.apply();

        }


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
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
        HomeAdapter homeAdapter = new HomeAdapter(new ArrayList<String>(data));
        rView.setAdapter(homeAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {
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
