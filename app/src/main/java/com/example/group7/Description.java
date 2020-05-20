package com.example.group7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Description extends AppCompatActivity {

    private TextView dateview,textdeleteview;
    private EditText addactivity;
    private Button addbutton;

    ListView listView;
    ArrayList<NameList> list = new ArrayList<>();
    NameAdapter ArAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        addactivity = findViewById(R.id.editactivity);
        addbutton = findViewById(R.id.addbtn);
        dateview = findViewById(R.id.dateview);
        textdeleteview = findViewById(R.id.deletetext);
        listView = findViewById(R.id.actiitylist);

        ArAd=new NameAdapter(list);
        listView.setAdapter(ArAd);

        String str = getIntent().getExtras().getString("Key");

        dateview.setText(str);




        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (addactivity.getText().toString().length() == 0)
                {
                    Toast.makeText(Description.this, "Add Activity", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    list.add(new NameList(addactivity.getText().toString()));
                    ArAd.notifyDataSetChanged();
                    addactivity.setText("");
                }

                if (list.isEmpty())
                {
                    textdeleteview.setText("");
                }
                else
                {
                    textdeleteview.setText("Click on Activity to delete");
                }

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder adb=new AlertDialog.Builder(Description.this);

                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete?");

                final int positionToRemove = position;

                adb.setNegativeButton("Cancel", null);

                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        list.remove(positionToRemove);
                        ArAd.notifyDataSetChanged();
                        if (list.isEmpty())
                        {
                            textdeleteview.setText("");
                        }
                        else
                        {
                            textdeleteview.setText("Click on Activity to delete");
                        }

                    }});

                adb.show();


            }

        });

    }

}
