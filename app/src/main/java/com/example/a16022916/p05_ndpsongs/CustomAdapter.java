package com.example.a16022916.p05_ndpsongs;

import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

//    public DatabaseHelper db = new DatabaseHelper(this);

    ListActivity list = new ListActivity();

    TextView tvYear;
    TextView tvSong;
    TextView tvArtist;
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;
    ImageView iv5;
    ImageView ivImage;

    TextView tvDesc;

    Context parent_context;
    int layout_id;

    ArrayList<Song> songList;


    public CustomAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent,false);

        tvYear = rowView.findViewById(R.id.rowTextViewYear);
        tvSong = rowView.findViewById(R.id.rowTextViewSongTitle);
        tvArtist = rowView.findViewById(R.id.rowTextViewArtist);
        ivImage = rowView.findViewById(R.id.rowIvImageView);

        iv1 = rowView.findViewById(R.id.rowIV1);
        iv2 = rowView.findViewById(R.id.rowIV2);
        iv3 = rowView.findViewById(R.id.rowIV3);
        iv4 = rowView.findViewById(R.id.rowIV4);
        iv5 = rowView.findViewById(R.id.rowIV5);

        Song currentItem = songList.get(position);

        tvYear.setText(String.valueOf(currentItem.getYear()));
        tvSong.setText(currentItem.getTitle());
        tvArtist.setText(currentItem.getSinger());

        String strRating = String.valueOf(currentItem.getRating());

        if(strRating.equalsIgnoreCase("1")){
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
        } else if(strRating.equalsIgnoreCase("2")) {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
        } else if(strRating.equalsIgnoreCase("3")) {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
        } else if(strRating.equalsIgnoreCase("4")) {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
        } else {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }



    //extract of storage for checked
//    CompoundButton.OnCheckedChangeListener myListener = new CompoundButton.OnCheckedChangeListener() {
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
//            m
//        }
//    }
}
