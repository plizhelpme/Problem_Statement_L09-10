package com.myapplicationdev.android.problemstatementl09_10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "song.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_SONG = "song";
    private static final String COLUMN_SONG_ID = "_id";
    private static final String COLUMN_SONG_TITLE = "song_title";
    private static final String COLUMN_SONG_SINGER = "song_singers";
    private static final String COLUMN_SONG_YEAR = "song_year";
    private static final String COLUMN_SONG_STARS = "song_stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_SONG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SONG_TITLE + " TEXT ,"+ COLUMN_SONG_SINGER + " TEXT ,"
                + COLUMN_SONG_YEAR + " INT ,"+ COLUMN_SONG_STARS + " INT) ";
        db.execSQL(createNoteTableSql);

        Log.i("info", "created tables");

        //Dummy records, to be inserted when the database is created
        for (int i = 0; i< 4; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_SONG_TITLE, "Song Title: " + i);
            db.insert(TABLE_SONG, null, values);
        }
        Log.i("info", "dummy records inserted");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN  module_name TEXT ");
        //onCreate(db);
    }

    public long insertSong(String songTitle, String songSinger
            , int songYear, int songStars) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SONG_TITLE, songTitle);
        values.put(COLUMN_SONG_SINGER, songSinger);
        values.put(COLUMN_SONG_YEAR, songYear);
        values.put(COLUMN_SONG_STARS, songStars);
        long result = db.insert(TABLE_SONG, null, values);
        db.close();
        Log.d("SQL Insert","Result"+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Song> getAllSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_SONG_ID, COLUMN_SONG_TITLE, COLUMN_SONG_SINGER, (COLUMN_SONG_YEAR), (COLUMN_SONG_STARS)};
        Cursor cursor = db.query(TABLE_SONG, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String songTitle = cursor.getString(1);
                String songSinger = cursor.getString(2);
                int songYear = cursor.getInt(3);
                int songStars = cursor.getInt(4);
                Song x = new Song(id, songTitle, songSinger, songYear, songStars);
                songs.add(x);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }


//    public int insert(ContactsContract.CommonDataKinds.Note data){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NOTE_CONTENT, data.getNoteContent());
//        String condition = COLUMN_ID + "= ?";
//        String[] args = {String.valueOf(data.getId())};
//        int result = db.update(TABLE_NOTE, values, condition, args);
//        db.close();
//        return result;
//    }

//    public int deleteNote(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String condition = COLUMN_ID + "= ?";
//        String[] args = {String.valueOf(id)};
//        int result = db.delete(TABLE_NOTE, condition, args);
//        db.close();
//        return result;
//    }

//    public ArrayList<Song> getAllSongs(String keyword) {
//        ArrayList<Song> songs = new ArrayList<Song>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns= {COLUMN_SONG_ID, COLUMN_SONG_TITLE, COLUMN_SONG_SINGER, String.valueOf(COLUMN_SONG_YEAR), String.valueOf(COLUMN_SONG_STARS)};
//        String condition = COLUMN_SONG_STARS + " Like ?";
//        String[] args = { "%" +  keyword + "%"};
//        Cursor cursor = db.query(TABLE_SONG, columns, condition, args,
//                null, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(0);
//                String songTitle = cursor.getString(1);
//                String
//                int songStars = cursor.getInt(4);
//                Song song = new Song(id, songTitle,songStars);
//                songs.add(song);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return songs;
//    }
}
