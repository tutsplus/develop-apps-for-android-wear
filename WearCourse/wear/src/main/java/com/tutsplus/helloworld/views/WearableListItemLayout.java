package com.tutsplus.helloworld.views;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tutsplus.helloworld.R;

/**
 * Created by Paul on 7/6/15.
 */
public class WearableListItemLayout extends LinearLayout implements WearableListView.OnCenterProximityListener {

    private TextView mText;

    public WearableListItemLayout(Context context) {
        super(context);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mText = (TextView) findViewById( R.id.text );
    }

    @Override
    public void onCenterPosition(boolean b) {
        if( mText != null ) {
            mText.setTextColor( getResources().getColor( android.R.color.black ) );
        }
    }

    @Override
    public void onNonCenterPosition(boolean b) {
        if( mText != null ) {
            mText.setTextColor( getResources().getColor( android.R.color.darker_gray ) );
        }
    }
}
