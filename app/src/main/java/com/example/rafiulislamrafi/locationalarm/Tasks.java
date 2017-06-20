package com.example.rafiulislamrafi.locationalarm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Tasks extends Activity {

    TextView tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        tasks = (TextView) findViewById(R.id.tasks);

        Add_Task add_task = new Add_Task();

    }
}
