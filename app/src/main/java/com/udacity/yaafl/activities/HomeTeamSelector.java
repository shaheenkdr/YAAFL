package com.udacity.yaafl.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.udacity.yaafl.R;
import com.udacity.yaafl.adapter.HomeAdapter;
import com.udacity.yaafl.utility.TeamInfo;

import java.util.ArrayList;

public class HomeTeamSelector extends AppCompatActivity
{
    private static ArrayList<String> team_list;
    private CollapsingToolbarLayout collapsingToolbarLayout = null;

    static
    {
        team_list = new ArrayList<>();
        for(int i=0;i<20;i++)
            team_list.add(TeamInfo.getTeamName(i));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_team_selector);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.user_name));

        dynamicToolbarColor();
        toolbarTextAppernce();
        RecyclerView rView = (RecyclerView)findViewById(R.id.homeTeamRView);
        rView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(HomeTeamSelector.this);
        rView.setLayoutManager(llm);
        HomeAdapter homeAdapter = new HomeAdapter(team_list);
        rView.setAdapter(homeAdapter);

    }

    private void dynamicToolbarColor() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.e5);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {

            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(ContextCompat.getColor(HomeTeamSelector.this,R.color.colorPrimary)));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(ContextCompat.getColor(HomeTeamSelector.this,R.color.colorPrimary)));
            }
        });
    }

    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }
}
