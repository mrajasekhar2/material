package mobiroad.com.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import mobiroad.com.myapplication.codexml.ExplodeTransitionXml;
import mobiroad.com.myapplication.codexml.FadeTransitionXml;
import mobiroad.com.myapplication.codexml.SharedTransitionXml;
import mobiroad.com.myapplication.codexml.SlidetransitionXml;

public class SecondMainActivity extends AppCompatActivity {
    private TextView tv_explode, tv_fade, tv_slide, tv_shared;
    private ImageView im_image;
    private LinearLayout ll_shared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.BOTTOM);
        slide.setDuration(1000);

        getWindow().setReenterTransition(slide);
        getWindow().setExitTransition(slide);
        getWindow().setAllowReturnTransitionOverlap(false);


        tv_explode = findViewById(R.id.tv_explode);
        tv_fade = findViewById(R.id.tv_fade);
        tv_slide = findViewById(R.id.tv_slide);
        tv_shared = findViewById(R.id.tv_shared);
        im_image = findViewById(R.id.im_image);


        ll_shared = findViewById(R.id.ll_shared);

        tv_explode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SecondMainActivity.this);

                Intent in = new Intent(SecondMainActivity.this, ExplodeTransitionXml.class);
                startActivity(in, options.toBundle());

            }
        });

        tv_fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondMainActivity.this, FadeTransitionXml.class);


                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(SecondMainActivity.this).toBundle());
            }
        });

        tv_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(SecondMainActivity.this, SlidetransitionXml.class);
                startActivity(in, ActivityOptions.makeSceneTransitionAnimation(SecondMainActivity.this).toBundle());
            }
        });

        ll_shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent in = new Intent(SecondMainActivity.this, SharedTransitionXml.class);
                Pair[] pair = new Pair[2];
//                pairs[0]= new Pair()

                startActivity(in, ActivityOptions.makeSceneTransitionAnimation(SecondMainActivity.this, Pair.<View, String>create(im_image, "im_image"), Pair.<View, String>create(tv_shared,"tv_shared")).toBundle());
            }
        });


    }
}
