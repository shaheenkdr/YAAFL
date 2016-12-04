package com.udacity.yaafl.utility;

import java.util.HashMap;

/**
 * Utility class to get Team name for corresponding team ID and also to generate Team ID
 * for corresponding Team names.
 */

public class TeamInfo {
    private static final String[] TEAM_NAME = {"Arsenal", "Bournemouth", "Burnley",
            "Chelsea", "Crystal_Palace", "Everton",
            "Hull", "Leicester", "Liverpool",
            "Manchester_City", "Manchester_United", "Middlesbrough",
            "Southampton", "Stoke", "Sunderland",
            "Swansea", "Tottenham", "Watford",
            "West_Bromwich_Albion", "West_Ham"};

    private static final String[] TEAM_NAME_PASS = {"Arsenal", "Bournemouth", "Burnley",
            "Chelsea", "Crystal Palace", "Everton",
            "Hull City", "Leicester City", "Liverpool",
            "Manchester City", "Manchester United", "Middlesbrough",
            "Southampton", "Stoke City", "Sunderland",
            "Swansea City", "Tottenham Hotspur", "Watford",
            "West Bromwich Albion", "West Ham United"};

    private static final String[] TEAM_DATA = {"Arsenal", "Bournemouth", "Burnley", "Chelsea", "CrystalPalace", "Everton", "Hull", "Leicester", "Liverpool", "ManchesterCity", "ManchesterUnited", "Middlesbrough", "Southampton", "Stoke", "Sunderland", "Swansea", "Tottenham", "Watford", "WestBromWich", "WestHam"};

    private static final int HOME_WIN_AVG = 46;
    private static final int AWAY_WIN_AVG = 27;
    private static HashMap<Integer, Integer> team_value;
    private static HashMap<String, String> team_logo;

    static {
        team_logo = new HashMap<>();
        team_logo.put("Arsenal", "e0");
        team_logo.put("Bournemouth", "e1");
        team_logo.put("Burnley", "e2");
        team_logo.put("Chelsea", "e3");
        team_logo.put("Crystal Palace", "e4");
        team_logo.put("Everton", "e5");
        team_logo.put("Hull City", "e6");
        team_logo.put("Leicester City", "e7");
        team_logo.put("Liverpool", "e8");
        team_logo.put("Manchester City", "e9");
        team_logo.put("Manchester United", "e10");
        team_logo.put("Middlesbrough", "e11");
        team_logo.put("Southampton", "e12");
        team_logo.put("Stoke City", "e13");
        team_logo.put("Sunderland", "e14");
        team_logo.put("Swansea City", "e15");
        team_logo.put("Tottenham Hotspur", "e16");
        team_logo.put("Watford", "e17");
        team_logo.put("West Bromwich Albion", "e18");
        team_logo.put("West Ham United", "e19");

    }


    /**
     * Method to generate teamID
     *
     * @param name of the team
     * @return Team Id of a team
     */
    public static int getTeamId(String name) {
        int val = -1;
        for (int i = 0; i < TEAM_NAME.length; i++) {
            if (name.equals(TEAM_NAME_PASS[i])) {
                val = i;
                break;
            }
        }

        return val;
    }

    public static String getTeamLogo(String id) {
        return team_logo.get(id);
    }


    /**
     * method to generate the team name from its ID
     *
     * @param id of the team
     * @return team name
     */

    public static String getTeamName(int id) {
        if (id >= 20 || id < 0)
            return "";

        else
            return TEAM_NAME[id];

    }

    public static String getTeamNameHead(int id) {
        if (id >= 20 || id < 0)
            return "";

        else
            return TEAM_DATA[id];

    }

    public static String getTeamNameForView(int id) {
        if (id >= 20 || id < 0)
            return "";

        else
            return TEAM_NAME_PASS[id];

    }

    public static int getHomeWinAvg() {
        return HOME_WIN_AVG;
    }

    public static int getAwayWinAvg() {
        return AWAY_WIN_AVG;
    }

}
