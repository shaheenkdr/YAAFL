package com.udacity.yaafl.widget;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.udacity.yaafl.R;
import com.udacity.yaafl.activities.HomeTeamSelector;


public class Widget extends AppWidgetProvider
{
    private static String YOUR_AWESOME_ACTION = "YourAwesomeAction";
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);

            // Create intent to launch MainActivity
            Intent intent = new Intent(context, HomeTeamSelector.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            views.setOnClickPendingIntent(R.id.widgetLayout, pendingIntent);



            // Set up collection items
            Intent clickIntentTemplate = new Intent(context, HomeTeamSelector.class);
            PendingIntent clickPendingIntentTemplate = TaskStackBuilder.create(context)
                    .addNextIntentWithParentStack(clickIntentTemplate)
                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            views.setPendingIntentTemplate(R.id.widgetLayout, clickPendingIntentTemplate);
            appWidgetManager.updateAppWidget(appWidgetId, views);

        }

    }


}