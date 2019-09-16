package mobiroad.com.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;

public class OtherActivity extends AppCompatActivity {
    String Key_type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);

        Intent intent = getIntent();
        Key_type = intent.getStringExtra("KEY_TYPE");


        animating(Key_type);

        getWindow().setAllowEnterTransitionOverlap(false);


    }

    private void animating(String key_type) {

        if (key_type.equals("Explode")) {

            Explode enterTransition = new Explode();
            enterTransition.setDuration(1000);
            getWindow().setEnterTransition(enterTransition);

        } else if (key_type.equals("Slide")) {

            Slide enterTransition = new Slide();
            enterTransition.setSlideEdge(Gravity.RIGHT);
            enterTransition.setDuration(1000);
            enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
            getWindow().setEnterTransition(enterTransition);

        } else if (Key_type.equals("fade")) {
            Fade enterTransition = new Fade();
            enterTransition.setDuration(1000);
            getWindow().setEnterTransition(enterTransition);
        } else {

        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

}
