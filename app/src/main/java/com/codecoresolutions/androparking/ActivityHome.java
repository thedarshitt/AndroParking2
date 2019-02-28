package com.codecoresolutions.androparking;

import android.content.Intent;
import android.service.autofill.Dataset;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class ActivityHome extends AppCompatActivity {

    private Button mButtonS1,mButtonS2,mButtonS3,mButtonS4;
    static String slot;
    private TextView mTextView;
    private DatabaseReference mdatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mButtonS1=findViewById(R.id.btnslot1);
        mButtonS2=findViewById(R.id.btnslot2);
        mButtonS3=findViewById(R.id.btnslot3);
        mButtonS4=findViewById(R.id.btnslot4);

//        mdatabaseReference=FirebaseDatabase.getInstance().getReference("CheckAvailability");
//        mdatabaseReference.child("CheckAvailability").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String s1, s2, s3, s4;
//                s1 = dataSnapshot.child("Slot1").getValue(String.class);
//                s2 = dataSnapshot.child("Slot2").getValue(String.class);
//                s3 = dataSnapshot.child("Slot3").getValue(String.class);
//                s4 = dataSnapshot.child("Slot4").getValue(String.class);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                mTextView.setText(databaseError.getMessage());
//            }
//        });

        mButtonS1.setEnabled(false);

        }

    public void onClickA1(View view) {
        slot="Slot1";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
        finish();
    }

    public void onClickA2(View view) {
        slot="Slot2";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
        finish();
    }

    public void onClickA3(View view) {
        slot="Slot3";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
        finish();
    }

    public void onClickA4(View view) {
        slot="Slot4";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
        finish();
    }

}
