package com.example.flooddetectionsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView blob;
    public TextView txt_threat_code;
    public TextView txt_threat_level;
    public TextView txt_description;
    public TextView txt_remedy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Recordings.getSensorData();

        blob = (LottieAnimationView) findViewById(R.id.blob);
        txt_threat_code = (TextView) findViewById(R.id.threat_code);
        txt_threat_level = (TextView) findViewById(R.id.threat_level);
        txt_description = (TextView) findViewById(R.id.description);
        txt_remedy = (TextView) findViewById(R.id.remedy);

        String blob_color;
        char threat_code;
        String threat_level;
        String description;
        String remedy;

        if(Recordings.sensor3){
            // color : red
            blob_color = "red";

            // threat code : C
            threat_code = 'C';

            // threat threat_level : Critical
            threat_level = "Critical";

            // description : water level above third mark
            description = "water level above third mark";

            // remedy : immediately evacuate
            remedy = "immediately evacuate";
        }
        else if(Recordings.sensor2){
            // color : orange
            blob_color = "orange";

            // threat code : H
            threat_code = 'H';

            // threat level : High
            threat_level = "High";

            // description : water level between second and third mark
            description = "water level between second and third mark";

            // remedy : stay alert for updates
            remedy = "stay alert for updates";
        }
        else if(Recordings.sensor1){
            // color : yellow
            blob_color = "yellow";

            // threat code : M
            threat_code = 'M';

            // threat level : medium
            threat_level = "Medium";

            // description : water level between first and second mark
            description = "water level between first and second mark";

            // remedy : stay alert for updates
            remedy = "stay alert for updates";
        }
        else{
            // color : green
            blob_color = "green";

            // threat code : L
            threat_code = 'L';

            // threat level : low
            threat_level = "Low";

            // description : water level below first mark
            description = "water level below first mark";

            // remedy : chill
            remedy = "relax and move on with your life";
        }

        Log.d("details",threat_level);
        Log.d("details",description);
        Log.d("details",remedy);

        txt_threat_code.setText(String.valueOf(threat_code));
        txt_threat_level.setText(threat_level);
        txt_description.setText(description);
        txt_remedy.setText(remedy);

        int resID = getResources().getIdentifier("blue_blob", "raw", getPackageName());
        blob.setAnimation(resID);
        blob.playAnimation();
    }

    public void refresh(View view){
        Intent refresh = new Intent(this,MainActivity.class);
        startActivity(refresh);
        this.finish();
    }
}