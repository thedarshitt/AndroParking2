package com.codecoresolutions.androparking;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private static int mSplash_Time_Out=5000;
    LottieAnimationView car;
    Animation mfromleft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfromleft=AnimationUtils.loadAnimation(this,R.anim.fromleft);
        car=findViewById(R.id.car);
        car.setAnimation(mfromleft);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,ActivityHome.class));
                finish();
            }
        },mSplash_Time_Out);

    }
}
