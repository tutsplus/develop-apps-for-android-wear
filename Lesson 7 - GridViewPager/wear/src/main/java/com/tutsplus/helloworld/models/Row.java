package com.tutsplus.helloworld.models;

import android.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 7/14/15.
 */
public class Row {
    private final List<Fragment> columns = new ArrayList<Fragment>();

    public Row( Fragment... fragments ) {
        for( Fragment fragment : fragments ) {
            columns.add( fragment );
        }
    }

    public Fragment getColumn( int i ) {
        return columns.get( i );
    }

    public int getColumnCount() {
        return columns.size();
    }
}
