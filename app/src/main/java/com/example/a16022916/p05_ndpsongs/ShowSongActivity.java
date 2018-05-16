package com.example.a16022916.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowSongActivity extends AppCompatActivity {

    public DatabaseHelper db = new DatabaseHelper(this);

    ListView lvSongs;
    Button btnShow5Stars;
    ArrayList<Song> songList;
    CustomAdapter caSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lvSongs = findViewById(R.id.listViewSongs);
        btnShow5Stars = findViewById(R.id.buttonShow);

        songList = db.getAllSongs();
//        songList = new ArrayList<>();
//        songList.add(new Song("Justin","Justin",2311,5));
        caSong = new CustomAdapter(this, R.layout.song_list_row, songList);
        lvSongs.setAdapter(caSong);

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), ModifySongActivity.class);
                intent.putExtra("songId",songList.get(i).getId());
                startActivity(intent);
            }
        });
        btnShow5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
