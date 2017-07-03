package com.aktar.sakifa.locationalarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button add_task_button, start_task_button, end_task_button, task_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objCasting();
        onButtonClick();

    }

    public void objCasting(){

        add_task_button = (Button) findViewById(R.id.addTaskButton);
        start_task_button = (Button) findViewById(R.id.StartTaskButton);
        end_task_button = (Button) findViewById(R.id.EndTaskButton);
        task_button = (Button) findViewById(R.id.taskButton);

    }

    public void onButtonClick(){

        add_task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add_Task.class);
                startActivity(intent);
            }
        });

        task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Tasks.class);
                startActivity(intent);

            }
        });

        start_task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, StartTask.class);
                startActivity(intent);

            }
        });

        end_task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, EndTask.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
