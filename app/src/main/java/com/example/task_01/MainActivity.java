package com.example.task_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    //taking variable of widgets

    TextView dateText;
    TextView timeText;
    Button dateButton;
    Button timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting find view by Id

        dateButton = (Button) findViewById(R.id.dateButton);
        timeButton = (Button) findViewById(R.id.timeButton);
        dateText = (TextView) findViewById(R.id.dateText);
        timeText = (TextView) findViewById(R.id.timeText);

        //setting on click listener for date

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateSet();
            }
        });

        //setting on click listener for time

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeSet();
            }
        });
    }
    // setting function for date

    private void dateSet()
    {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
              String calender =  year + " " + month + " " + date;
              dateText.setText(calender);
            }
        },YEAR,MONTH,DATE);
        datePickerDialog.show();
        Toast.makeText(getApplicationContext(), "Please Select Ur Date", Toast.LENGTH_SHORT).show();

    }


    //setting function for time
    private void timeSet()
    {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.DATE);
        int MINUTE = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour , int minute) {
              String time = "Hour :"+" "+hour+" "+"Minute :"+" "+minute;
              timeText.setText(time);
            }
        },HOUR , MINUTE , true);
        timePickerDialog.show();
        Toast.makeText(getApplicationContext(), "Please Select ur Time", Toast.LENGTH_SHORT).show();
    }
}