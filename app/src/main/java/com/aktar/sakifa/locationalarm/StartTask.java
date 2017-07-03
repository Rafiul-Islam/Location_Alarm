package com.aktar.sakifa.locationalarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class StartTask extends Add_Task {

    ImageView start_task_button;
    DataBase_Helper myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_task);

        myDatabase = new DataBase_Helper(this);

        start_task_button = (ImageView) findViewById(R.id.StartTaskButton);

        setAlert();

    }

    public void setAlert(){

        start_task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor data = myDatabase.getAllData();

                Calendar calendar = Calendar.getInstance();

                calendar.setTimeInMillis(System.currentTimeMillis());

                calendar.set(Calendar.YEAR, mYear);
                calendar.set(Calendar.MONTH, mMonth);
                calendar.set(Calendar.DAY_OF_MONTH, mDay);

                calendar.set(Calendar.HOUR_OF_DAY, mHour);
                calendar.set(Calendar.MINUTE, mMinute);

                Toast.makeText(getApplicationContext(), "DATE : " + mDay + "-" + mMonth + "-" + mYear + "\nTIME - " + mHour + " : " + mMinute , Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), myAlarmService.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                        0, intent , PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getApplicationContext()
                        .getSystemService(Context.ALARM_SERVICE);

                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 3000, pendingIntent);

            }

        });
    }

}
