package com.example.rentmyspot;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "RentMySpot1.db";
    public static final String TABLENAME1 = "users";
    public static final String T1COL1 = "username";
    public static final String T1COL2 = "password";
    public static final String T1COL3 = "ReantedSeatingName";
    public static final String TABLENAME2 = "seating";
    public static final String T2COL1 = "SeatingID";
    public static final String T2COL2 = "username";
    public static final String T2COL3 = "SeatingName";
    public static final String T2COL4 = "SeatingCategory";
    public static final String T2COL5 = "SeatingPrice";
    public static final String T2COL6 = "SeatingDescription";
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLENAME1 + "(" + T1COL1 + " TEXT PRIMARY KEY," + T1COL2 + " TEXT," + T1COL3 + " TEXT" + ")");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLENAME2 + "(" + T2COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + T2COL2 + " TEXT," + T2COL3 + " TEXT," + T2COL4 + " TEXT," + T2COL5 + " INTEGER," + T2COL6 + " TEXT," +
                " FOREIGN KEY (" + T2COL6 + ") REFERENCES " + TABLENAME1 +
                "(" + T1COL1 + ")" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("drop Table if exists " + TABLENAME1);
      sqLiteDatabase.execSQL("drop Table if exists " + TABLENAME2);
      onCreate(sqLiteDatabase);
    }

    public boolean addSeating(Seating newSeating){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(T2COL2,newSeating.getUserneme());
        cv.put(T2COL3, newSeating.getSname());
        cv.put(T2COL4, newSeating.getScategory());
        cv.put(T2COL5, newSeating.getSprice());
        cv.put(T2COL6, newSeating.getSdescription());
        long insert = db.insert(TABLENAME2, null, cv);

        if(insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean DeleteOne(Seating deleteSeating ){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString= "Delete From " + TABLENAME2 + " WHERE " + T2COL2 + " = " + deleteSeating.getSname() ;
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        } else{
            // nothing happens. no one is added.
            return false;
        }
        //close
        }


    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(T1COL1, username);
        contentValues.put(T1COL2, password);
        long result = MyDB.insert(TABLENAME1, null, contentValues);

        if(result == -1 )
            return false;
        return true;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + TABLENAME1 + " where " + T1COL1 + " = ?", new String[]{username});
        if (cursor.getCount() > 0) return true;
        return false;
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from " + TABLENAME1 + " where " + T1COL1 + " = ? and " + T1COL2 + " = ?", new String[] {username,password});
        if(cursor.getCount()>0) return true;
        return false;
    }

}

