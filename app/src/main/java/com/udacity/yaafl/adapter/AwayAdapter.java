package com.udacity.yaafl.adapter;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.yaafl.R;
import com.udacity.yaafl.activities.AwayTeamSelector;

import java.util.ArrayList;

public class AwayAdapter extends RecyclerView.Adapter<AwayAdapter.AwayTeamViewHolder>
{



    private DataHolder d1 = new DataHolder();

    public  class AwayTeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView teamName;
        private Typeface face;
        private ImageView away_teams;
        private Context mcontext;


        AwayTeamViewHolder(View itemView)
        {
            super(itemView);
            mcontext = itemView.getContext();
            away_teams = (ImageView)itemView.findViewById(R.id.homeTeamImage);
            teamName = (TextView)itemView.findViewById(R.id.homeTeamName);
            face = Typeface.createFromAsset(itemView.getContext().getAssets(), "Fonts/Roboto-Regular.ttf");
            teamName.setTypeface(face);
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
            itemView.getContext().startActivity(intent);
        }



    }

    private static class DataHolder
    {
        ArrayList<String> teams;

    }



    public AwayAdapter(ArrayList<String> teams)
    {
        this.d1.teams = teams;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public AwayTeamViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.away_card, viewGroup, false);
        AwayTeamViewHolder pvh = new AwayTeamViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(AwayTeamViewHolder awayTeamViewHolder, int i)
    {

        awayTeamViewHolder.teamName.setText(d1.teams.get(i));
        String x = "e"+i;
        int resourceId = awayTeamViewHolder.mcontext.getResources().getIdentifier(x, "drawable", "com.udacity.yaafl");
        awayTeamViewHolder.away_teams.setImageDrawable(ContextCompat.getDrawable(awayTeamViewHolder.mcontext,resourceId));

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