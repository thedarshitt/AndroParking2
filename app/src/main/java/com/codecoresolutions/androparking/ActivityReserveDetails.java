package com.codecoresolutions.androparking;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Random;
import java.util.Calendar;

public class ActivityReserveDetails extends AppCompatActivity {
    private TextView mTextViewTime;
    private Button mButtonReserve;
    private EditText mEditTextName,mEditTextVehicle;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;
    int mHour,mMin;
    String ArrivalTime;
    Random r=new Random();
    int id=r.nextInt(4000)+3000;
    String uid="AP"+id+"2019";   //uid
    static String x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_details);

        mButtonReserve=findViewById(R.id.btnReserve);
        mEditTextName=findViewById(R.id.edName);
        mEditTextVehicle=findViewById(R.id.edVehicle);
        mTextViewTime=findViewById(R.id.tvTime);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        progressDialog=new ProgressDialog(this);

    }

    public void onClickSelectTime(View view) {

        final Calendar c= Calendar.getInstance();
        mHour=c.get(Calendar.HOUR_OF_DAY);
        mMin=c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mTextViewTime.setText(hourOfDay+" : "+minute);
                ArrivalTime=hourOfDay+":"+minute;
            }
        },mHour,mMin,false);
        timePickerDialog.show();

    }

    //sends data to firebase(UID{name,uid,arriving time,vehicle number})
    public void onClickReserve(View view) {
        SendToFB();
    }

    public void SendToFB(){
        String name=mEditTextName.getText().toString();
        String vehicle=mEditTextVehicle.getText().toString();

        if (name.isEmpty()){
            mEditTextName.setError("please enter your name");
            mEditTextName.requestFocus();
            return;
        }
        if(vehicle.isEmpty()){
            mEditTextVehicle.setError("please enter vehicle number");
            mEditTextVehicle.requestFocus();
            return;
        }

        progressDialog.setMessage("Reserving a slot, Please wait");
        progressDialog.show();

        x=uid;
        Fdata fdata=new Fdata(name,vehicle,uid,ArrivalTime);
        databaseReference.child(fdata.uid).setValue(fdata);



        progressDialog.dismiss();

        Toast.makeText(this,"Slot Reserved Successfully",Toast.LENGTH_LONG).show();

        startActivity(new Intent(ActivityReserveDetails.this,activityReservationSuccess.class));
        finish();

    }

}
