package com.example.a16022916.p05_ndpsongs;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "NDPSongs.db";
    private static final String TABLE_NAME = "SONGS";
    private static final int DATABASE_VERSION = 1;
    private static final String COL0ID ="ID";
    private static final String COL1SONG_TITLE = "songTitle";
    private static final String COL2SINGERS = "singers";
    private static final String COL3YEAR = "year";
    private static final String COL4Rating = "rating";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "("+COL0ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + COL1SONG_TITLE + " TEXT,"
                + COL2SINGERS + " TEXT," + COL3YEAR  + " INTEGER," + COL4Rating + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public long insertSong(Song song){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1SONG_TITLE, song.getTitle());
        contentValues.put(COL2SINGERS, song.getSinger());
        contentValues.put(COL3YEAR,song.getYear());
        contentValues.put(COL4Rating,song.getRating());

        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();
        return result;
    }



    public ArrayList<Song> getAllSongs() {

        ArrayList<Song> songList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String songTitle = cursor.getString(1);
                String singers = cursor.getString(2);
                int yr = Integer.parseInt(cursor.getString(3));
                int rating = Integer.parseInt(cursor.getString(4));
                Song getSong = new Song(id,songTitle,singers,yr,rating);
                songList.add(getSong);

            } while (cursor.moveToNext());
        }
        db.close();
        return songList;

    }

    public Song getSongById(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

//        String query  = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.query(TABLE_NAME, new String[] { COL0ID,
                        COL1SONG_TITLE, COL2SINGERS , COL3YEAR, COL4Rating }, COL0ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);


        if(cursor.moveToFirst()) {
            Song retSong = new Song(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
            return retSong;
        }else{
            return null;
        }


    }

    public void updateSong(Song song){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL1SONG_TITLE, song.getTitle());
        values.put(COL2SINGERS, song.getSinger());
        values.put(COL3YEAR,song.getYear());
        values.put(COL4Rating,song.getRating());
        String condition = COL0ID + " =?";
        String[] args = {String.valueOf(song.getId())};
        db.update(TABLE_NAME,values,condition,args);
        db.close();

    }

    public void deleteSong(Song song){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, COL0ID + "=?", new String[]{String.valueOf(song.getId())});
        db.close();
    }

}
