package com.aktar.sakifa.locationalarm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class StartTask extends Activity {

    ImageView start_task_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_task);

        start_task_button = (ImageView) findViewById(R.id.StartTaskButton);

    }
}
