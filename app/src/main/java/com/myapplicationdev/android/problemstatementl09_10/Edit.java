package com.myapplicationdev.android.problemstatementl09_10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {

    TextView tvID;
    TextView tvFixID;
    TextView tvTitle;
    EditText etTitle;
    TextView tvSingers;
    EditText etSingers;
    TextView tvYear;
    EditText etYear;
    TextView tvStars;
    RadioGroup rgStars;
    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;
    Song data;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvTitle = findViewById(R.id.tvSongTitle);
        etTitle = findViewById(R.id.etFixTitle);
        tvSingers = findViewById(R.id.tvFixSingers);
        etSingers = findViewById(R.id.etFixSingers);
        tvYear = findViewById(R.id.tvFixYear);
        etYear = findViewById(R.id.etFixYear);
        tvStars = findViewById(R.id.tvFixStars);
        rgStars = findViewById(R.id.rgFixStars);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent x = getIntent();
        data = (Song) x.getSerializableExtra("id");

        tvFixID.setText(data.getId());
        etTitle.setText(data.getSongTitle());
        etSingers.setText(data.getSongSinger());
        etYear.setText(data.getSongYear());

    }
}
