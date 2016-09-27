package com.udacity.yaafl.utility;

/**
 *Utility class to get Team name for corresponding team ID and also to generate Team ID
 * for corresponding Team names.
 */

public class TeamInfo
{
    private static final String[] TEAM_NAME = {"Arsenal","Bournemouth","Burnley",
                                               "Chelsea","Crystal_Palace","Everton",
                                               "Hull","Leicester","Liverpool",
                                               "Manchester_City","Manchester_United","Middlesbrough",
                                               "Southampton","Stoke","Sunderland",
                                               "Swansea","Tottenham","Watford",
                                               "West_Bromwich_Albion", "West_Ham"};

    /**
     * Method to generate teamID
     * @param name of the team
     * @return Team Id of a team
     */
    public static int getTeamId(String name)
    {
        int val = -1;
        for(int i=0;i<TEAM_NAME.length;i++)
        {
            if(name.equals(TEAM_NAME[i]))
            {
                val = i;
                break;
            }
        }

        return val;
    }

    /**
     * method to generate the team name from its ID
     * @param id of the team
     * @return team name
     */

    public static String getTeamName(int id)
    {
        if(id>=20 ||id<0)
            return "";

        else
            return TEAM_NAME[id];

    }

}
