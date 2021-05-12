package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_start_up);


        Button buttonA;
        Button buttonB;

        final Vibrator vibrator;

            buttonA = (Button) findViewById(R.id.button1);
            buttonB = (Button) findViewById(R.id.button2);

            vibrator = (Vibrator) getSystemService (VIBRATOR_SERVICE);


            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    vibrator.vibrate(60);

                    Intent intent = new Intent(StartUpActivity.this, WorkersLogin.class);
                    startActivity(intent);
                }
            });
            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vibrator.vibrate(60);

                    Intent intent = new Intent(StartUpActivity.this, UsersMap.class);
                    startActivity(intent);
                }
            });
    }
}
