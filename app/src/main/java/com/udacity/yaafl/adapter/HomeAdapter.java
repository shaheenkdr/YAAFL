package com.udacity.yaafl.adapter;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.udacity.yaafl.R;
import com.udacity.yaafl.activities.AwayTeamSelector;
import com.udacity.yaafl.activities.HomeTeamSelector;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeTeamViewHolder>
{



    private DataHolder d1 = new DataHolder();

    public  class HomeTeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView teamName;
        private Typeface face;
        private ImageView home_teams;
        private Context mcontext;


        HomeTeamViewHolder(View itemView)
        {
            super(itemView);
            mcontext = itemView.getContext();
            home_teams = (ImageView)itemView.findViewById(R.id.homeTeamImage);
            teamName = (TextView)itemView.findViewById(R.id.homeTeamName);
            Typeface font = Typer.set(mcontext).getFont(Font.ROBOTO_MEDIUM);
            teamName.setTypeface(font);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(itemView.getContext(), AwayTeamSelector.class);
            Bundle extras = new Bundle();
            extras.putInt("HOME",getLayoutPosition());
            Log.e("TEST",""+getLayoutPosition());
            intent.putExtras(extras);
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity)mcontext, (View)home_teams, "appcard");
            itemView.getContext().startActivity(intent, options.toBundle());

            ((Activity)mcontext).finish();

        }



    }

    private static class DataHolder
    {
        ArrayList<String> teams;

    }



    public HomeAdapter(ArrayList<String> teams)
    {
        this.d1.teams = teams;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public HomeTeamViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card, viewGroup, false);
        HomeTeamViewHolder pvh = new HomeTeamViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(HomeTeamViewHolder homeTeamViewHolder, int i)
    {

        homeTeamViewHolder.teamName.setText(d1.teams.get(i));
        String x = "e"+i;
        int resourceId = homeTeamViewHolder.mcontext.getResources().getIdentifier(x, "drawable", "com.udacity.yaafl");
        homeTeamViewHolder.home_teams.setImageDrawable(ContextCompat.getDrawable(homeTeamViewHolder.mcontext,resourceId));

    }

    @Override
    public int getItemCount()
    {

        if(d1.teams!=null)
        {
            return d1.teams.size();
        }
        else
        {
            return 0;
        }
    }



}