package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.Toast;

import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import barqsoft.footballscores.DatabaseContract;
import barqsoft.footballscores.R;
import barqsoft.footballscores.Utilities;

/**
 * Created by Elias Myronidis on 22/9/15.
 */
public class CollectionWidgetRemoteViewsService extends RemoteViewsService {

    private static final String[] SCORE_PROJECTION = {
            DatabaseContract.scores_table.HOME_COL,
            DatabaseContract.scores_table.HOME_GOALS_COL,
            DatabaseContract.scores_table.AWAY_COL,
            DatabaseContract.scores_table.AWAY_GOALS_COL,
            DatabaseContract.scores_table.TIME_COL,
            DatabaseContract.scores_table.MATCH_ID};

    // these indices must much the projection
    private static final int INDEX_HOME_COL = 0;
    private static final int INDEX_HOME_GOALS_COL = 1;
    private static final int INDEX_AWAY_COL = 2;
    private static final int INDEX_AWAY_GOALS_COL = 3;
    private static final int INDEX_TIME_COL = 4;
    private static final int INDEX_MATCH_ID = 5;

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteViewsFactory() {
            private Cursor data = null;

            @Override
            public void onCreate() {
                // Nothing to do
            }

            @Override
            public void onDataSetChanged() {
                if (data != null) {
                    data.close();
                }
                // This method is called by the app hosting the widget (e.g., the launcher)
                // However, our ContentProvider is not exported so it doesn't have access to the
                // data. Therefore we need to clear (and finally restore) the calling identity so
                // that calls use our process and permission
                final long identityToken = Binder.clearCallingIdentity();

                Date currentDate = new Date(System.currentTimeMillis());
                SimpleDateFormat mformat = new SimpleDateFormat("yyyy-MM-dd");
                String stDate = mformat.format(currentDate);

                Uri matchWithDate = DatabaseContract.scores_table.buildScoreWithDate();
                data = getContentResolver().query(matchWithDate,
                        SCORE_PROJECTION,
                        null,
                        new String[]{stDate},
                        DatabaseContract.scores_table.DATE_COL + " DESC");
                Binder.restoreCallingIdentity(identityToken);
            }

            @Override
            public void onDestroy() {
                if (data != null) {
                    data.close();
                    data = null;
                }
            }

            @Override
            public int getCount() {
                return data == null ? 0 : data.getCount();
            }

            @Override
            public RemoteViews getViewAt(int position) {
                if (position == AdapterView.INVALID_POSITION ||
                        data == null || !data.moveToPosition(position)) {
                    return null;
                }
                RemoteViews views = new RemoteViews(getPackageName(),
                        R.layout.collection_widget_list_item);
                String homeTeam = data.getString(INDEX_HOME_COL);
                String awayTeam = data.getString(INDEX_AWAY_COL);
                String homeGoals = data.getString(INDEX_HOME_GOALS_COL);
                String awayGoals = data.getString(INDEX_AWAY_GOALS_COL);
                String scores = homeGoals + " - " + awayGoals;
                String matchTime = data.getString(INDEX_TIME_COL);
                String matchId = data.getString(INDEX_MATCH_ID);

                views.setTextViewText(R.id.home_name, homeTeam);

                views.setTextViewText(R.id.away_name, awayTeam);

                if (homeGoals.equals("-1")) {
                    views.setTextViewText(R.id.score_textview, "-");
                } else
                    views.setTextViewText(R.id.score_textview, scores);

                views.setImageViewResource(R.id.home_crest, Utilities.getTeamCrestByTeamName(homeTeam));
                setRemoteContentDescriptions(views, R.id.home_crest, getString(R.string.home_crest) + homeTeam);
                views.setImageViewResource(R.id.away_crest, Utilities.getTeamCrestByTeamName(awayTeam));
                setRemoteContentDescriptions(views, R.id.away_crest, getString(R.string.away_crest) + awayTeam);
                views.setTextViewText(R.id.data_textview, matchTime);


                String pos = String.valueOf(position);
                final Intent fillInIntent = new Intent();
                fillInIntent.setAction(CollectionWidgetProvider.ACTION_MATCH_ID);
                fillInIntent.putExtra(CollectionWidgetProvider.EXTRA_STRING, matchId);
                fillInIntent.putExtra(CollectionWidgetProvider.EXTRA_POSITION, pos);
                views.setOnClickFillInIntent(R.id.widget_list_item, fillInIntent);
                return views;
            }

            private void setRemoteContentDescriptions(RemoteViews views, int viewId, String description){

                views.setContentDescription(viewId, description);
            }


            @Override
            public RemoteViews getLoadingView() {
                return new RemoteViews(getPackageName(), R.layout.collection_widget_list_item);
            }


            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public long getItemId(int position) {
                if (data.moveToPosition(position))
                    return data.getLong(INDEX_HOME_COL);
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
        };
    }
}
