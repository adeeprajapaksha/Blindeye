package org.tensorflow.lite.examples.detection;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WorkersDetailsActivity extends AppCompatActivity {

    private TextView prcnt2;

    Button on;
    Button off;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_workers_details);

        prcnt2 = findViewById (R.id.prcnt2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("PERCENTAGE_STATUS");


        on = (Button) findViewById (R.id.onbtn);
        off = (Button) findViewById (R.id.offbtn);

        vibrator = (Vibrator)getSystemService (VIBRATOR_SERVICE);

        on.setOnClickListener (new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                vibrator.vibrate(60);
                FirebaseDatabase database = FirebaseDatabase.getInstance ();
                DatabaseReference myRef = database.getReference ("SERVO_STATUS");
                myRef.setValue (1);
            }
        });
        off.setOnClickListener (new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                vibrator.vibrate(60);
                FirebaseDatabase database = FirebaseDatabase.getInstance ();
                DatabaseReference myRef = database.getReference ("SERVO_STATUS");
                myRef.setValue (0);
            }
        });

        myRef.addValueEventListener(new ValueEventListener () {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);
                prcnt2.setText (value.toString()+"%");

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


    }
}
