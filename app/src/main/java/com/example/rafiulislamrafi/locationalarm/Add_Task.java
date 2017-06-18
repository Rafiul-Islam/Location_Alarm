package com.example.rafiulislamrafi.locationalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.Calendar;

public class Add_Task extends Activity {

    DataBase_Helper myDatabase;

    int PLACE_PICKER_REQUEST = 1;

    private int mYear, mMonth, mDay, mHour, mMinute;

    String name, id, task;

    String Date, Time;

    EditText get_location, get_task;
    TimePicker get_time;
    DatePicker get_date;
    Button submit_button;

    ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__task);

        myDatabase = new DataBase_Helper(this);

        get_location = (EditText) findViewById(R.id.getLocation);
        get_task = (EditText) findViewById(R.id.getTask);
        get_date = (DatePicker) findViewById(R.id.getDate);
        get_time = (TimePicker) findViewById(R.id.getTime);

        map = (ImageView) findViewById(R.id.mapViewButton);

        submit_button = (Button) findViewById(R.id.submit);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                Intent intent;
                try {
                    intent = builder.build(getApplicationContext());
                    startActivityForResult(intent, PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        submitData();
    }

    protected void onActivityResult(int request_code, int result_code, Intent data) {

        if (request_code == PLACE_PICKER_REQUEST) {

            if (result_code == RESULT_OK) {

                Place place = PlacePicker.getPlace(data, this);

                name = String.format("%s", place.getName());
                id = String.format("%s", place.getLatLng());

                get_location.setText(""+name);
            }
        }
    }

   public void submitData(){

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                task = get_task.getText().toString();

                // Get date
                final Calendar date = Calendar.getInstance();
                mYear = date.get(Calendar.YEAR);
                mMonth = date.get(Calendar.MONTH);
                mDay = date.get(Calendar.DAY_OF_MONTH);

                Date = ("Date : "+ mDay + "-" + mMonth + "-" + mYear);

                // Get Time
                final Calendar time = Calendar.getInstance();
                mHour = time.get(Calendar.HOUR_OF_DAY);
                mMinute = time.get(Calendar.MINUTE);

                Time = ("Time - "+ mMinute + ":" + mHour);

                boolean isInserted = myDatabase.insertData(id.toString(), task.toString(), Time.toString(), Date.toString());

                if (isInserted == true) {

                    Toast.makeText(Add_Task.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(Add_Task.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

                clearText();
            }
        });
    }

    public void clearText() {

        get_location.setText("");
        get_task.setText("");
    }
}
