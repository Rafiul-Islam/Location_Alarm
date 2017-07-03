package com.aktar.sakifa.locationalarm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class EndTask extends Activity {

    ImageView end_task_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_task);

        end_task_button = (ImageView) findViewById(R.id.EndTaskButton);

    }
}
