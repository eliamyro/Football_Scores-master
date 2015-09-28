package barqsoft.footballscores.widget;

import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

import barqsoft.footballscores.DatabaseContract;
import barqsoft.footballscores.MainActivity;
import barqsoft.footballscores.R;
import barqsoft.footballscores.Utilities;

/**
 * Created by Elias Myronidis on 22/9/15.
 */
public class SimpleWidgetIntentService extends IntentService {

    private static final String[] SCORE_PROJECTION = {
            DatabaseContract.scores_table.HOME_COL,
            DatabaseContract.scores_table.HOME_GOALS_COL,
            DatabaseContract.scores_table.AWAY_COL,
            DatabaseContract.scores_table.AWAY_GOALS_COL,
            DatabaseContract.scores_table.TIME_COL};

    // these indices must much the projection
    private static final int INDEX_HOME_COL = 0;
    private static final int INDEX_HOME_GOALS_COL = 1;
    private static final int INDEX_AWAY_COL = 2;
    private static final int INDEX_AWAY_GOALS_COL = 3;
    private static final int INDEX_TIME_COL = 4;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public SimpleWidgetIntentService() {
        super("SimpleWidgetIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int appWidgetIds[] = appWidgetManager.getAppWidgetIds(new ComponentName(this, SimpleWidgetProvider.class));

        Uri matchWithScore = DatabaseContract.scores_table.buildScoreWithScore();

        Cursor data = getContentResolver().query(matchWithScore,
                SCORE_PROJECTION,
                null,
                new String[]{"-1"},
                DatabaseContract.scores_table.FULL_DATE + " DESC LIMIT 1");

        if (data == null) {
            return;
        }
        if (!data.moveToFirst()) {
            data.close();
            return;
        }

        String homeTeam = data.getString(INDEX_HOME_COL);
        String awayTeam = data.getString(INDEX_AWAY_COL);
        String homeGoals = data.getString(INDEX_HOME_GOALS_COL);
        String awayGoals = data.getString(INDEX_AWAY_GOALS_COL);
        String scores = homeGoals + " - " + awayGoals;
        String matchTime = data.getString(INDEX_TIME_COL);
        data.close();

        // Perform this loop procedure for each Today widget
        for (int appWidgetId : appWidgetIds) {

            RemoteViews views = new RemoteViews(getPackageName(), R.layout.simple_widget);
            views.setTextViewText(R.id.home_name, homeTeam);
            views.setTextViewText(R.id.away_name, awayTeam);
            views.setTextViewText(R.id.score_textview, scores);
            views.setImageViewResource(R.id.home_crest, Utilities.getTeamCrestByTeamName(homeTeam));
            setRemoteContentDescriptions(views, R.id.home_crest, getString(R.string.home_crest) + homeTeam);
            views.setImageViewResource(R.id.away_crest, Utilities.getTeamCrestByTeamName(awayTeam));
            setRemoteContentDescriptions(views, R.id.away_crest, getString(R.string.home_crest) + homeTeam);
            views.setTextViewText(R.id.data_textview, matchTime);



//            Log.v("SIMPLE_TAG", "I am syncing");

            // Create an Intent to launch MainActivity
            Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
            views.setOnClickPendingIntent(R.id.widget, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    private void setRemoteContentDescriptions(RemoteViews views, int viewId, String description){

        views.setContentDescription(viewId, description);
    }


}
