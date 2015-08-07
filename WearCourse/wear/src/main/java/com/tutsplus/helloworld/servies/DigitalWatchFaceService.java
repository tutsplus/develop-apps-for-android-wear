package com.tutsplus.helloworld.servies;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.wearable.watchface.CanvasWatchFaceService;
import android.support.wearable.watchface.WatchFaceStyle;
import android.text.format.Time;
import android.view.SurfaceHolder;
import android.widget.TextClock;

import com.tutsplus.helloworld.R;

/**
 * Created by Paul on 8/6/15.
 */
public class DigitalWatchFaceService extends CanvasWatchFaceService {

    @Override
    public Engine onCreateEngine() {
        return new Engine();
    }

    private class Engine extends CanvasWatchFaceService.Engine {
        private Typeface WATCH_TEXT_TYPEFACE = Typeface.create( Typeface.SERIF, Typeface.NORMAL );

        private Paint mBackgroundColorPaint;
        private Paint mTextColorPaint;

        private int mBackgroundColor = Color.parseColor( "white" );
        private int mTextColor = Color.parseColor("red");

        private Time mTime;

        @Override
        public void onCreate(SurfaceHolder holder) {
            super.onCreate(holder);

            setWatchFaceStyle(new WatchFaceStyle.Builder(DigitalWatchFaceService.this)
                    .setBackgroundVisibility(WatchFaceStyle.BACKGROUND_VISIBILITY_INTERRUPTIVE)
                    .setCardPeekMode(WatchFaceStyle.PEEK_MODE_VARIABLE)
                    .setShowSystemUiTime(false)
                    .build());

            mBackgroundColorPaint = new Paint();
            mBackgroundColorPaint.setColor( mBackgroundColor );

            mTextColorPaint = new Paint();
            mTextColorPaint.setColor( mTextColor );
            mTextColorPaint.setTypeface(WATCH_TEXT_TYPEFACE);
            mTextColorPaint.setTextSize( getResources().getDimension( R.dimen.watch_face_text_size ));
            mTextColorPaint.setAntiAlias( true );

            mTime = new Time();
        }

        @Override
        public void onTimeTick() {
            super.onTimeTick();
            invalidate();
        }

        @Override
        public void onDraw(Canvas canvas, Rect bounds) {
            super.onDraw(canvas, bounds);
            mTime.setToNow();
            canvas.drawRect( 0, 0, bounds.width(), bounds.height(), mBackgroundColorPaint );

            String timeText = getHourString() + ":" + String.format( "%02d", mTime.minute );
            timeText += ( mTime.hour < 12 ) ? "AM" : "PM";
            canvas.drawText( timeText, 40, 150, mTextColorPaint );
        }

        private String getHourString() {
            if( mTime.hour % 12 == 0 )
                return "12";
            else if( mTime.hour <= 12 )
                return String.valueOf( mTime.hour );
            else
                return String.valueOf( mTime.hour - 12 );
        }
    }
}
