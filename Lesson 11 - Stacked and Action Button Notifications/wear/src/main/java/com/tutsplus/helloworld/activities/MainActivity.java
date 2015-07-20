package com.tutsplus.helloworld.activities;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tutsplus.helloworld.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends WearableActivity implements WearableListView.ClickListener {

    public static boolean isAmbientMode = false;
    private BoxInsetLayout mBoxInsetLayout;
    private WearableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAmbientEnabled();

        mListView = (WearableListView) findViewById( R.id.list );
        mBoxInsetLayout = (BoxInsetLayout) findViewById( R.id.parent );

        WearableListAdapter adapter = new WearableListAdapter();

        String[] items = getResources().getStringArray( R.array.list_items );
        adapter.setItems( new ArrayList( Arrays.asList(items) ) );

        mListView.setAdapter( adapter );
        mListView.setClickListener( this );
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        String title = ( (TextView) viewHolder.itemView.findViewById( R.id.text )).getText().toString();

        if( getString( R.string.delayed_confirmation_view_activity ).equalsIgnoreCase( title ) ) {
            Intent intent = new Intent( this, DelayedConfirmationViewActivity.class );
            startActivity( intent );
        } else if( getString( R.string.grid_view_pager_activity ).equalsIgnoreCase( title ) ) {
            Intent intent = new Intent( this, GridViewPagerActivity.class );
            startActivity( intent );
        } else if( getString( R.string.notification_basic ).equalsIgnoreCase( title ) ) {
            showBasicNotification();
            finish();
        } else if( getString( R.string.notification_multipage ).equalsIgnoreCase( title ) ) {
            showMultiPageNotification();
            finish();
        } else if( getString( R.string.notification_stacked ).equalsIgnoreCase( title ) ) {
            showStackedNotification();
            finish();
        } else if( getString( R.string.notification_action ).equalsIgnoreCase( title ) ) {
            showActionNotification();
            finish();
        }
    }

    private void showBasicNotification() {
        NotificationCompat.Builder builder = getBaseNotificationBuilder();
        NotificationManagerCompat.from( this ).notify( 1, builder.build() );
    }

    private NotificationCompat.Builder getBaseNotificationBuilder() {
        return new NotificationCompat.Builder( this )
                .setSmallIcon( R.mipmap.ic_launcher )
                .setContentTitle( "Notification Title" )
                .setContentText( "Notificaiton Text" );
    }

    private void showMultiPageNotification() {
        NotificationCompat.Builder builder = getBaseNotificationBuilder();

        Notification notificationPage = getBaseNotificationBuilder().build();

        NotificationManagerCompat.from( this )
                .notify( 1, builder.extend( new NotificationCompat.WearableExtender()
                .addPage(notificationPage)
                        .addPage(notificationPage)
                        .addPage(notificationPage)
                        .addPage( notificationPage )).build() );
    }

    private void showStackedNotification() {
        NotificationCompat.Builder builder = getBaseNotificationBuilder();
        builder.setGroup("key");

        Notification notification = builder.build();

        NotificationManagerCompat.from( this ).notify( 1, notification );

        builder = getBaseNotificationBuilder();
        builder.setGroup( "key" );
        notification = builder.build();

        NotificationManagerCompat.from( this ).notify( 2, notification );

        builder = getBaseNotificationBuilder();
        builder.setGroup( "key" );
        notification = builder.build();

        NotificationManagerCompat.from( this ).notify( 3, notification );

        builder = getBaseNotificationBuilder()
                .setGroup( "key" )
                .setGroupSummary( true )
                .setStyle( new NotificationCompat.InboxStyle()
                .setBigContentTitle( "title" )
                .setSummaryText( "text" )
                .addLine( "message 1" )
                .addLine( "message 2" )
                .addLine( "message 3" ) );

        NotificationManagerCompat.from( this ).notify( 4, builder.build() );
    }

    private void showActionNotification() {
        NotificationCompat.Builder builder = getBaseNotificationBuilder();

        Intent intent = new Intent( this, ConfirmationActivity.class );
        intent.putExtra( ConfirmationActivity.EXTRA_ANIMATION_TYPE, ConfirmationActivity.SUCCESS_ANIMATION );
        intent.putExtra( ConfirmationActivity.EXTRA_MESSAGE, "Success!" );

        PendingIntent pendingIntent = PendingIntent.getActivity( this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT );

        builder.addAction( new NotificationCompat.Action( R.mipmap.ic_launcher, "Action Title", pendingIntent ) );

        NotificationManagerCompat.from( this ).notify( 1, builder.build() );
    }

    @Override
    public void onTopEmptyRegionClick() {
        //no op
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        isAmbientMode = true;
        mListView.setBackgroundColor( getResources().getColor( android.R.color.black ) );
        mBoxInsetLayout.setBackgroundColor( getResources().getColor( android.R.color.black ) );
        mListView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onExitAmbient() {
        super.onExitAmbient();
        isAmbientMode = false;
        mListView.setBackgroundColor( getResources().getColor( android.R.color.white ) );
        mBoxInsetLayout.setBackgroundColor( getResources().getColor( android.R.color.white ) );
        mListView.getAdapter().notifyDataSetChanged();

    }

    private static final class WearableListAdapter extends WearableListView.Adapter {

        private List<String> items = new ArrayList<String>();

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder( LayoutInflater.from(parent.getContext()).inflate( R.layout.view_list_item, null ) );
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            ((ViewHolder) holder).textView.setText(items.get(position));
            if( MainActivity.isAmbientMode ) {
                viewHolder.textView.setTextColor( viewHolder.textView.getResources().getColor( android.R.color.white ) );
            } else {
                viewHolder.textView.setTextColor( viewHolder.textView.getResources().getColor( android.R.color.black ) );
            }
            viewHolder.itemView.setTag( position );
        }

        @Override
        public void onViewRecycled(WearableListView.ViewHolder holder) {
            super.onViewRecycled(holder);
            ViewHolder viewHolder = (ViewHolder) holder;
            if( MainActivity.isAmbientMode ) {
                viewHolder.textView.setTextColor( viewHolder.textView.getResources().getColor( android.R.color.white ) );
            }
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }

        public void addItem( String item ) {
            this.items.add( item );
        }

        public static class ViewHolder extends WearableListView.ViewHolder {

            private TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById( R.id.text );
            }
        }
    }
}
