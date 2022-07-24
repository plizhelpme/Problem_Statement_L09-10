package com.myapplicationdev.android.problemstatementl09_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    EditText etTitle;
    TextView tvSingers;
    EditText etSingers;
    TextView tvYear;
    EditText etYear;
    TextView tvStars;
    RadioGroup rgStars;
    Button btnInsert;
    Button btnShow;
    ArrayList<Song> al;
    CustomAdapter caSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        etTitle = findViewById(R.id.etTitle);
        tvSingers = findViewById(R.id.tvSingers);
        etSingers = findViewById(R.id.etSingers);
        tvYear = findViewById(R.id.tvYear);
        etYear = findViewById(R.id.etYear);
        tvStars = findViewById(R.id.tvStars);
        rgStars = findViewById(R.id.rgStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);

        al = new ArrayList<Song>();

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                al.addAll(dbh.getAllSongs());
                Intent i = new Intent(MainActivity.this,
                        ShowActivity.class);
                startActivity(i);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int song = rgStars.getCheckedRadioButtonId();

                DBHelper dbh = new DBHelper(MainActivity.this);
                if (song == R.id.rb1) {
                    long inserted_id = dbh.insertSong(title, singers, year, song);
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
                        caSong.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (song == R.id.rb2) {
                    long inserted_id = dbh.insertSong(title, singers, year, song);
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
                        caSong.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (song == R.id.rb3) {
                    long inserted_id = dbh.insertSong(title, singers, year, song);
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
                        caSong.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (song == R.id.rb4) {
                    long inserted_id = dbh.insertSong(title, singers, year, song);
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
                        caSong.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (song == R.id.rb5) {
                    long inserted_id = dbh.insertSong(title, singers, year, song);
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
                        caSong.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}