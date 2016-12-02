package com.udacity.yaafl.neuron;


import java.util.HashMap;

public class TeamValue
{
    private int team_id;
    private static HashMap<Integer,Integer> team_values;

    static
    {
        team_values = new HashMap<>();
        team_values.put(0,1616);
        team_values.put(1,451);
        team_values.put(2,318);
        team_values.put(3,1986);
        team_values.put(4,647);
        team_values.put(5,886);
        team_values.put(6,319);
        team_values.put(7,810);
        team_values.put(8,1434);
        team_values.put(9,2355);
        team_values.put(10,1979);
        team_values.put(11,384);
        team_values.put(12,737);
        team_values.put(13,638);
        team_values.put(14,378);
        team_values.put(15,427);
        team_values.put(16,1611);
        team_values.put(17,443);
        team_values.put(18,489);
        team_values.put(19,894);
    }

    public TeamValue(int team_id)
    {
        this.team_id = team_id;

    }

    public int getTeamValueScore()
    {
        if(team_id>=0 && team_id<=19)
            return team_values.get(team_id)/20;
        else
            return -1;
    }


}
