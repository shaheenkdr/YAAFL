package com.udacity.yaafl.neuron;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.udacity.yaafl.event_bus.MotivationEvent;
import com.udacity.yaafl.firebase_db.Recent;
import com.udacity.yaafl.utility.TeamInfo;
import org.greenrobot.eventbus.EventBus;
import java.util.List;

/**
 *Neuron that calculates the motivation level of a team
 */
public class TeamMotivation
{
    private int team_id;
    private boolean home_away;
    private int home_away_score;
    private int motivation_score;
    private Firebase fRef;
    private static final String RECENT_GAMES_URL = "https://yaafl-f20f2.firebaseio.com/Cohesion/Situational";

    public TeamMotivation(int teamId,boolean homeAway,int homeAwayScore)
    {
        this.team_id = teamId;
        this.home_away = homeAway;
        this.home_away_score = homeAwayScore;
        motivation_score = 0;
        fRef = new Firebase(RECENT_GAMES_URL);
        calculateMotivation();
    }


    private void calculateMotivation()
    {
        fRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
               for(DataSnapshot objData:dataSnapshot.getChildren())
               {
                   Recent recent_game = objData.getValue(Recent.class);

                   if(recent_game.getTeam().equals(TeamInfo.getTeamName(team_id)))
                   {
                       List<Integer> values = recent_game.getGames();
                       int temp = 0;
                       for(int i=0;i<values.size();i++)
                           temp+=values.get(i);
                       temp = temp*10;

                       if(home_away)
                       {
                           motivation_score = temp+TeamInfo.getHomeWinAvg()+home_away_score;
                       }

                       else
                       {
                           motivation_score = temp+TeamInfo.getAwayWinAvg()+home_away_score;
                       }
                       EventBus.getDefault().post(new MotivationEvent(motivation_score));
                       break;
                   }
               }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }
        });

    }

}