package com.myapplicationdev.android.problemstatementl09_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    Button btnFilter;
    ListView lv;
    Song data;
    CustomAdapter caSong;
    ArrayList al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);

        lv = findViewById(R.id.lv);

        ArrayList<Song> al = new ArrayList<Song>();
        DBHelper dbh = new DBHelper(ShowActivity.this);
        al.addAll(dbh.getAllSongs());

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("id");
        caSong = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(caSong);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DBHelper dbh = new DBHelper(ShowActivity.this);
            }
        });

    }
}
