package com.homework.cheplic.homework04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Devin on 3/5/2018.
 */

public class MultiConversionActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new MultiConversionFragment();
    }

    public static Intent newIntent(Context context){
        Intent i = new Intent(context, MultiConversionActivity.class);
        return i;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
