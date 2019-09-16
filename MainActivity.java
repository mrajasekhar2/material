package mobiroad.com.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mobiroad.com.myapplication.codejava.ExplodeTransition;
import mobiroad.com.myapplication.codejava.FadeTransition;
import mobiroad.com.myapplication.codejava.SharedTransition;
import mobiroad.com.myapplication.codejava.SlideTransition;

public class MainActivity extends AppCompatActivity {
    TextView tv_text, tv_text1, tv_text2, tv_text3, tv_shared;
    Toolbar toolbar;
    private ImageView imgStar;
    private TextView txvShared;
    ImageView im_image;
LinearLayout ll_shared;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("WelCome to Material design");

        tv_text = findViewById(R.id.tv_text);
        tv_text1 = findViewById(R.id.tv_text1);
        tv_text2 = findViewById(R.id.tv_text2);
        tv_text3 = findViewById(R.id.tv_text3);
        ll_shared = findViewById(R.id.ll_shared);

        tv_shared = findViewById(R.id.tv_shared);
        im_image = findViewById(R.id.im_image);


        setupWindowAnimations();

        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                Intent i = new Intent(MainActivity.this, ExplodeTransition.class);
                startActivity(i, options.toBundle());

            }
        });
        tv_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                Intent i = new Intent(MainActivity.this, FadeTransition.class);
                startActivity(i, options.toBundle());
                Log.d("Main", "onClick: " + options.toBundle());

            }
        });
        tv_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
                Intent i = new Intent(MainActivity.this, SlideTransition.class);
                startActivity(i, options.toBundle());

            }
        });
        ll_shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Pair[] pair = new Pair[2];

                pair[0] = new Pair<View, String>(im_image, "im_image");
                pair[1] = new Pair<View, String>(tv_shared, "tv_shared");

                //noinspection unchecked
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pair);
                Intent i = new Intent(MainActivity.this, SharedTransition.class);
                startActivity(i, options.toBundle());
            }
        });


    }


    private void setupWindowAnimations() {
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);

        getWindow().setAllowReturnTransitionOverlap(false);
    }

}

