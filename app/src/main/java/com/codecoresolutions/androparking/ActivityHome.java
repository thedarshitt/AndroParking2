package com.codecoresolutions.androparking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.service.autofill.Dataset;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
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
    private TextView mTextView,mTextViewS1,mTextViewS2,mTextViewS3,mTextViewS4;
    private DatabaseReference mdatabaseReference;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mButtonS1=findViewById(R.id.btnslot1);
        mButtonS2=findViewById(R.id.btnslot2);
        mButtonS3=findViewById(R.id.btnslot3);
        mButtonS4=findViewById(R.id.btnslot4);

        mTextViewS1=findViewById(R.id.textViewS1);
        mTextViewS2=findViewById(R.id.textViewS2);
        mTextViewS3=findViewById(R.id.textViewS3);
        mTextViewS4=findViewById(R.id.textViewS4);

        mSwipeRefreshLayout=findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startActivity(getIntent());
                finish();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

       mdatabaseReference=FirebaseDatabase.getInstance().getReference();

       mdatabaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               String s1=dataSnapshot.child("CheckAvailability").child("Slot1").getValue(String.class);
               String s2=dataSnapshot.child("CheckAvailability").child("Slot2").getValue(String.class);
               String s3=dataSnapshot.child("CheckAvailability").child("Slot3").getValue(String.class);
               String s4=dataSnapshot.child("CheckAvailability").child("Slot4").getValue(String.class);

               //slot 1
               if(s1.equals("booked")){
                   mButtonS1.setBackgroundResource(R.drawable.reserved_slot_shape);
                   mButtonS1.setEnabled(false);
                   mTextViewS1.setText("A1 : Not Available");
               }
               if(s1.equals("onHold")){
                   mButtonS1.setBackgroundResource(R.drawable.onhold_slot_shape);
                   mButtonS1.setEnabled(false);
                   mTextViewS1.setText("A1 : On Hold");
               }
               if(s1.equals("empty")){
                   mButtonS1.setBackgroundResource(R.drawable.slotshape);
                   mButtonS1.setEnabled(true);
                   mTextViewS1.setText("A1 : Available");
               }

               //slot 2
               if(s2.equals("booked")){
                   mButtonS2.setBackgroundResource(R.drawable.reserved_slot_shape);
                   mButtonS2.setEnabled(false);
                   mTextViewS2.setText("A2 : Not Available");
               }
               if(s2.equals("onHold")){
                   mButtonS2.setBackgroundResource(R.drawable.onhold_slot_shape);
                   mButtonS2.setEnabled(false);
                   mTextViewS2.setText("A2 : On Hold");
               }
               if(s2.equals("empty")){
                   mButtonS2.setBackgroundResource(R.drawable.slotshape);
                   mButtonS2.setEnabled(true);
                   mTextViewS2.setText("A1 : Available");
               }

               //slot 3
               if(s3.equals("booked")){
                   mButtonS3.setBackgroundResource(R.drawable.reserved_slot_shape);
                   mButtonS3.setEnabled(false);
                   mTextViewS3.setText("A3 : Not Available");
               }
               if(s3.equals("onHold")){
                   mButtonS3.setBackgroundResource(R.drawable.onhold_slot_shape);
                   mButtonS3.setEnabled(false);
                   mTextViewS3.setText("A3 : On Hold");
               }
               if(s3.equals("empty")){
                   mButtonS3.setBackgroundResource(R.drawable.slotshape);
                   mButtonS3.setEnabled(true);
                   mTextViewS3.setText("A1 : Available");
               }

               //slot 4
               if(s4.equals("booked")){
                   mButtonS4.setBackgroundResource(R.drawable.reserved_slot_shape);
                   mButtonS4.setEnabled(false);
                   mTextViewS4.setText("A4 : Not Available");
               }
               if(s4.equals("onHold")){
                   mButtonS4.setBackgroundResource(R.drawable.onhold_slot_shape);
                   mButtonS4.setEnabled(false);
                   mTextViewS4.setText("A4 : On Hold");
               }
               if(s4.equals("empty")){
                   mButtonS4.setBackgroundResource(R.drawable.slotshape);
                   mButtonS4.setEnabled(true);
                   mTextViewS4.setText("A1 : Available");
               }

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

}

    public void onClickA1(View view) {
        slot="Slot1";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
    }

    public void onClickA2(View view) {
        slot="Slot2";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
    }

    public void onClickA3(View view) {
        slot="Slot3";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
    }

    public void onClickA4(View view) {
        slot="Slot4";
        startActivity(new Intent(ActivityHome.this,ActivityReserveDetails.class));
    }

}
