package com.tutsplus.helloworld.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DotsPageIndicator;
import android.support.wearable.view.GridViewPager;

import com.tutsplus.helloworld.R;
import com.tutsplus.helloworld.adapters.GridViewPagerAdapter;

/**
 * Created by Paul on 7/14/15.
 */
public class GridViewPagerActivity extends Activity {

    private GridViewPager mGridViewPager;
    private DotsPageIndicator mPageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_pager);

        mGridViewPager = (GridViewPager) findViewById( R.id.pager );
        mPageIndicator = (DotsPageIndicator) findViewById( R.id.page_indiciator );
        mPageIndicator.setPager( mGridViewPager );
        GridViewPagerAdapter adapter = new GridViewPagerAdapter( this, getFragmentManager() );
        mGridViewPager.setAdapter( adapter );
    }
}
