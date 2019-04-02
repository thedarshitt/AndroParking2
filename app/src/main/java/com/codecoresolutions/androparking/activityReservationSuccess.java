package com.codecoresolutions.androparking;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;
import com.google.zxing.WriterException;

public class activityReservationSuccess extends AppCompatActivity {

    private TextView value,slotid;
    private String inputValue;
    private Bitmap bitmap;
    private QRGEncoder qrgEncoder;
    private ImageView qrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_success);

        ActivityReserveDetails ad =new ActivityReserveDetails();
        inputValue=ad.x;
        slotid=findViewById(R.id.tvSlotid);
        slotid.setText(new ActivityHome().slot+" reserved successfully !!");
        value=findViewById(R.id.tv_value);
        value.setText(inputValue);
        qrImage=findViewById(R.id.qrCode);
        //QRcode();
    }


    //Generates QR code based on UNIQUE ID
    /*public void QRcode(){
        ActivityReserveDetails ad =new ActivityReserveDetails();
        inputValue=ad.x;
        slotid=findViewById(R.id.tvSlotid);
        slotid.setText(new ActivityHome().slot+" reserved successfully !!");
        value=findViewById(R.id.tv_value);
        value.setText(inputValue);
        qrImage=findViewById(R.id.qrCode);

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;

        qrgEncoder = new QRGEncoder(
                inputValue, null,
                QRGContents.Type.TEXT,
                smallerDimension);
        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            qrImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("TAG", e.toString());
        }
    }*/

    public void onClickHome(View view) {
        startActivity(new Intent(activityReservationSuccess.this,ActivityHome.class));
        finish();
    }


}
