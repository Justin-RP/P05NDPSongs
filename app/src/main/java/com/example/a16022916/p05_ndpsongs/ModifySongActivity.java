package com.example.a16022916.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ModifySongActivity extends AppCompatActivity {

    public DatabaseHelper db = new DatabaseHelper(this);

    EditText etId;
    EditText etTitle;
    EditText etSinger;
    EditText etYear;
    RadioGroup rgStars;
    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        etId = findViewById(R.id.modifyEditTextID);
        etTitle = findViewById(R.id.modifyEditTextSongTitle);
        etSinger = findViewById(R.id.modifyEditTextSinger);
        etYear = findViewById(R.id.modifyEditTextYear);

        btnUpdate = findViewById(R.id.modifyButtonUpdate);
        btnDelete = findViewById(R.id.modifyButtonDelete);
        btnCancel = findViewById(R.id.modifyButtonCancel);

        etTitle.setEnabled(false);

        Intent intent = getIntent();
        int intSongId = intent.getIntExtra("songId",0);

//        Toast.makeText(getApplicationContext(),String.valueOf(intSongId),Toast.LENGTH_LONG).show();
        Song modSong = db.getSongById(intSongId);
//
        etId.setText(String.valueOf(modSong.getId()));
//        etTitle.setText(modSong.getTitle());
//        etSinger.setText(modSong.getSinger());
//        etYear.setText(String.valueOf(modSong.getYear()));

    }
}
