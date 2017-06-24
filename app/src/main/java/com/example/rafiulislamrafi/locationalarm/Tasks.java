package com.example.rafiulislamrafi.locationalarm;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class Tasks extends Activity {

    Button showdata, deleteDat;
    DataBase_Helper myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        showdata = (Button) findViewById(R.id.viewData);

        viewAllData();
    }

    public void viewAllData() {

        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor data = myDatabase.getAllData();

                if (data.getCount() == 0) {

                    //Show Message
                    showMessage("Error", "Nothing Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (data.moveToNext()) {

                    buffer.append("ID : " + data.getString(0) + " \n ");
                    buffer.append("\tLOCATION : " + data.getString(1) + " \n ");
                    buffer.append("\tTASK : " + data.getString(2) + " \n ");
                    buffer.append("\tTIME : " + data.getString(3) + " \n\n");
                    buffer.append("\tDATE : " + data.getString(4) + " \n\n");
                }

                //Show all data
                showMessage("Data", buffer.toString());
            }
        });

    }

    public void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
