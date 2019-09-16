package mobiroad.com.myapplication.codexml;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import mobiroad.com.myapplication.R;

public class FadeTransitionXml extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);

//        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);

        getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.fade));
        getWindow().setAllowEnterTransitionOverlap(false);

    }
}
