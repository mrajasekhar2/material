package mobiroad.com.myapplication.codejava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.Window;

import mobiroad.com.myapplication.R;

public class ExplodeTransition extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);


        Explode explode = new Explode();
        explode.setDuration(1000);
        getWindow().setEnterTransition(explode);
        getWindow().setAllowEnterTransitionOverlap(false);

    }
}
