package com.codecoresolutions.androparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityHome extends AppCompatActivity {

    private Button mButtonA1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mButtonA1=findViewById(R.id.btnslot1);

    }

    public void onClickA1(View view) {
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
        finish();
    }
}
