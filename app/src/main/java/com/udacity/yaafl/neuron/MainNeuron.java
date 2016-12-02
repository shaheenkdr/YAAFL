package com.udacity.yaafl.neuron;




import com.udacity.yaafl.cohesion.CohesionMain;
import com.udacity.yaafl.event_bus.WinEvent;
import org.greenrobot.eventbus.EventBus;


public class MainNeuron
{
    private int team_id_1;
    private int team_id_2;
    private CohesionMain data;

    public MainNeuron(CohesionMain data,int team_id_1, int team_id_2)
    {
        this.data = data;
        this.team_id_1 = team_id_1;
        this.team_id_2 = team_id_2;


    }


    public  void processData()
    {
        int home = computeHomeScore();
        int away = computeAwayScore();
        TeamHeadToHead teams_head_to_head = new TeamHeadToHead(data.getHead2Head(),team_id_1,team_id_2);
        int[] headToHead = teams_head_to_head.computeScore();
        home+= headToHead[0];
        away+= headToHead[1];
        EventBus.getDefault().post(new WinEvent(home,away,team_id_1,team_id_2));

    }
    private int computeHomeScore()
    {
        HomeAway home = new HomeAway(team_id_1,true,data.getSituational());
        int home_score = home.computeHomeAwayScore();


        TeamValue team1 = new TeamValue(team_id_1);
        int team_value_score_1 = team1.getTeamValueScore();


        TeamCohesion home_team = new TeamCohesion(team_id_1,true,home_score,data.getSummary(),data.getPasses(),data.getShots(),data.getSituational());
        int cohesion_score_1 = home_team.computeTeamCohesion();

        TeamMotivation team_motivation_1 = new TeamMotivation(data.getRecent(),team_id_1,true,home_score);
        int motivation_score_1 = team_motivation_1.calculateMotivation();


        return home_score + team_value_score_1+cohesion_score_1+motivation_score_1;

    }

    private int computeAwayScore()
    {
        HomeAway away = new HomeAway(team_id_2,false,data.getSituational());
        int away_score = away.computeHomeAwayScore();


        TeamValue team2 = new TeamValue(team_id_2);
        int team_value_score_2 = team2.getTeamValueScore();

        TeamCohesion away_team = new TeamCohesion(team_id_2,false,away_score,data.getSummary(),data.getPasses(),data.getShots(),data.getSituational());
        int cohesion_score_2 = away_team.computeTeamCohesion();


        TeamMotivation team_motivation_2 = new TeamMotivation(data.getRecent(),team_id_2,false,away_score);
        int motivation_score_2 = team_motivation_2.calculateMotivation();



        return away_score + team_value_score_2+cohesion_score_2+motivation_score_2;
    }





}
