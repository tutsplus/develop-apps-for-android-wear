package com.tutsplus.helloworld.activities;

import android.app.Activity;
import android.os.Bundle;

import com.tutsplus.helloworld.R;

/**
 * Created by Paul on 7/29/15.
 */
public class CustomNotificationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_custom_notification );
    }
}
