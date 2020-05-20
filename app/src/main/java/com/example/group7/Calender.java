package com.example.group7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calender extends AppCompatActivity {

    private CalendarView calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        calender = findViewById(R.id.calenderview);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String s = dayOfMonth + " - " + (month + 1) + " - " + year;

                Intent intent = new Intent(Calender.this,Description.class);
                intent.putExtra("Key",s);
                startActivity(intent);
            }
        });
    }
}
