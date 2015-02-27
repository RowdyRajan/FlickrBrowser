package com.example.rajanjassal.flickrbrowser;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;


/**
 * Created by rajanjassal on 2015-02-14.
 */
public class BaseActivity extends ActionBarActivity {
    private Toolbar mToolbar;

    protected Toolbar activateToolBar(){
        if (mToolbar == null ){
            mToolbar = (Toolbar) findViewById(R.id.app_bar);
            if (mToolbar != null) {
                setSupportActionBar(mToolbar);
            }
        }
        return  mToolbar;
    }

    protected Toolbar activeToolBarWithHomeEnabled(){
        activateToolBar();
        if(mToolbar != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return mToolbar;
    }
}
