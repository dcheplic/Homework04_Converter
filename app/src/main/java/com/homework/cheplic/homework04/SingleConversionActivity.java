package com.homework.cheplic.homework04;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class SingleConversionActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SingleConversionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
