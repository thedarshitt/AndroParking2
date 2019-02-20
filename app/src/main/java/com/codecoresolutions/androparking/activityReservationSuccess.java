package com.codecoresolutions.androparking;

import android.graphics.Point;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import androidmads.library.qrgenearator.QRGSaver;
import com.google.zxing.WriterException;

public class activityReservationSuccess extends AppCompatActivity {

    TextView value;
    String inputValue;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    ImageView qrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_success);

        QRcode();

    }

    //Generates QR code based on UNIQUE ID
    public void QRcode(){

        ActivityReserveDetails ad =new ActivityReserveDetails();
        inputValue=ad.x;
        value=(TextView)findViewById(R.id.tv_value);
        qrImage=(ImageView)findViewById(R.id.qrCode);
        value.setText(inputValue);;

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
    }

}
