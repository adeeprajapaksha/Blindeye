package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WorkersLogin extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_workers_login);

        textView = (TextView)findViewById (R.id.textView);
        editText = (EditText)findViewById (R.id.editText);
        button   = (Button) findViewById (R.id.button3);

        vibrator = (Vibrator) getSystemService (VIBRATOR_SERVICE);

        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String code = editText.getText ().toString ();
                if (!code.equals ("")){
                    for (int i = 0; i < Database.codes.length; i++){
                        if (code.equals (Database.codes[i])){

                            vibrator.vibrate (60);
                            //Enter to WorkerMap

                            Intent intent = new Intent(getApplicationContext (),DetectorActivity.class);
                            startActivity (intent);
                            finish ();
                        }else{

                            textView.setText ("Wrong Password");

                            vibrator.vibrate (300);
                        }

                    }
                }
            }
        });
    }
}
