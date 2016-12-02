package com.udacity.yaafl.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.udacity.yaafl.R;
import com.udacity.yaafl.activities.FinalizeActivity;
import com.udacity.yaafl.utility.TeamInfo;

import java.util.ArrayList;

public class AwayAdapter extends RecyclerView.Adapter<AwayAdapter.AwayTeamViewHolder>
{



    private DataHolder d1 = new DataHolder();
    private int home_team;


    public  class AwayTeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView teamName;
        private ImageView away_teams;
        private Context mcontext;



        AwayTeamViewHolder(View itemView)
        {
            super(itemView);
            mcontext = itemView.getContext();
            away_teams = (ImageView)itemView.findViewById(R.id.awayTeamImage);
            teamName = (TextView)itemView.findViewById(R.id.awayTeamName);
            Typeface font = Typer.set(mcontext).getFont(Font.ROBOTO_MEDIUM);
            teamName.setTypeface(font);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(itemView.getContext(), FinalizeActivity.class);
            Bundle extras = new Bundle();
            extras.putInt("HOME",home_team);
            extras.putString("AWAY",d1.teams.get(getLayoutPosition()));
            intent.putExtras(extras);
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity)mcontext, away_teams, "appcard");
            itemView.getContext().startActivity(intent,options.toBundle());
            ((Activity)mcontext).finish();
        }





    }

    private static class DataHolder
    {
        ArrayList<String> teams;

    }




    public AwayAdapter(ArrayList<String> teams,int home_team)
    {
        this.d1.teams = teams;
        this.home_team = home_team;


    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public AwayTeamViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.away_card, viewGroup, false);
        return new AwayTeamViewHolder(v);
    }



    @Override
    public void onBindViewHolder(AwayTeamViewHolder awayTeamViewHolder, int i)
    {
        awayTeamViewHolder.teamName.setText(d1.teams.get(i));
        awayTeamViewHolder.teamName.setContentDescription("Team name:"+d1.teams.get(i));
        int resourceId = awayTeamViewHolder.mcontext.getResources().getIdentifier(TeamInfo.getTeamLogo(d1.teams.get(i)), "drawable", "com.udacity.yaafl");
        awayTeamViewHolder.away_teams.setImageDrawable(ContextCompat.getDrawable(awayTeamViewHolder.mcontext,resourceId));
        awayTeamViewHolder.away_teams.setContentDescription("Team Image:"+d1.teams.get(i));
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