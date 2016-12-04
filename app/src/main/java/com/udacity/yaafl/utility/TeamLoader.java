package com.udacity.yaafl.utility;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;


public class TeamLoader extends AsyncTaskLoader<List<String>>
{
    public TeamLoader(Context context)
    {
        super(context);
    }

    @Override
    public List<String> loadInBackground() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(TeamInfo.getTeamNameForView(i));
        }
        return list;
    }
}
