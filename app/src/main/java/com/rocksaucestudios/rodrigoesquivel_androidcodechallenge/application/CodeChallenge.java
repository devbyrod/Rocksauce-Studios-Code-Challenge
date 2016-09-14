package com.rocksaucestudios.rodrigoesquivel_androidcodechallenge.application;

import android.app.Application;

import com.rocksaucestudios.rodrigoesquivel_androidcodechallenge.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Mandrake on 9/12/16.
 */
public class CodeChallenge extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig calligraphyConfig = new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/bebasneue.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();

    }
}
