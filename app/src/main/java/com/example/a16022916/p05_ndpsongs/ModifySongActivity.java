package com.example.a16022916.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ModifySongActivity extends AppCompatActivity {

    public DatabaseHelper db = new DatabaseHelper(this);

    EditText etId;
    EditText etTitle;
    EditText etSinger;
    EditText etYear;

    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    RadioButton rb5;
    RadioGroup rgRating;

    Button btnUpdate;
    Button btnDelete;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        rb1 = findViewById(R.id.modifyRadioButton1);
        rb2 = findViewById(R.id.modifyRadioButton2);
        rb3 = findViewById(R.id.modifyRadioButton3);
        rb4 = findViewById(R.id.modifyRadioButton4);
        rb5 = findViewById(R.id.modifyRadioButton5);
        rgRating = findViewById(R.id.modifyRadioGroupStars);

        etId = findViewById(R.id.modifyEditTextID);
        etTitle = findViewById(R.id.modifyEditTextSongTitle);
        etSinger = findViewById(R.id.modifyEditTextSinger);
        etYear = findViewById(R.id.modifyEditTextYear);

        btnUpdate = findViewById(R.id.modifyButtonUpdate);
        btnDelete = findViewById(R.id.modifyButtonDelete);
        btnCancel = findViewById(R.id.modifyButtonCancel);

        etId.setEnabled(false);

        Intent intent = getIntent();
        int intSongId = intent.getIntExtra("songId",0);

        final Song modSong = db.getSongById(intSongId);

        etId.setText(String.valueOf(modSong.getId()));
        etTitle.setText(modSong.getTitle());
        etSinger.setText(modSong.getSinger());
        etYear.setText(String.valueOf(modSong.getYear()));

        int rating = modSong.getRating();

        switch (rating){
            case 1: rb1.setChecked(true);
            break;
            case 2: rb2.setChecked(true);
            break;
            case 3: rb3.setChecked(true);
            break;
            case 4: rb4.setChecked(true);
            break;
            case 5: rb5.setChecked(true);
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTitle = etTitle.getText().toString();
                String strSinger = etSinger.getText().toString();
                int intYear = Integer.valueOf(etYear.getText().toString());

                modSong.setTitle(strTitle);
                modSong.setSinger(strSinger);
                modSong.setYear(intYear);

                int starsCheckedId = rgRating.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(starsCheckedId);
                String strRadio = selectedRadioButton.getText().toString();
                int intRadio;

                if(strRadio.equalsIgnoreCase("1")){
                    intRadio = 1;
                } else if (strRadio.equalsIgnoreCase("2")){
                    intRadio = 2;
                } else if (strRadio.equalsIgnoreCase("3")){
                    intRadio = 3;
                } else if (strRadio.equalsIgnoreCase("4")){
                    intRadio = 4;
                } else {
                    intRadio = 5;
                }

                modSong.setRating(intRadio);

                db.updateSong(modSong);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteSong(modSong);
                finish();
            }
        });
    }
}
