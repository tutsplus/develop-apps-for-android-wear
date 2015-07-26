package com.tutsplus.helloworld.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;
import android.widget.Toast;

import com.tutsplus.helloworld.R;

/**
 * Created by Paul on 7/6/15.
 */
public class DelayedConfirmationViewActivity extends Activity implements DelayedConfirmationView.DelayedConfirmationListener {

    private DelayedConfirmationView mDelayedConfirmationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_confirmation_view);

        mDelayedConfirmationView = (DelayedConfirmationView) findViewById( R.id.delayed_confirmation );
        mDelayedConfirmationView.setTotalTimeMs( 3000 );
        mDelayedConfirmationView.setListener(this);
        mDelayedConfirmationView.start();
    }

    @Override
    public void onTimerFinished(View view) {
        Toast.makeText( this, "Timer Finished", Toast.LENGTH_SHORT ).show();
        mDelayedConfirmationView.setListener(null);
        finish();
    }

    @Override
    public void onTimerSelected(View view) {
        Toast.makeText( this, "Timer Selected", Toast.LENGTH_SHORT ).show();
        mDelayedConfirmationView.setListener( null );
        finish();
    }
}
