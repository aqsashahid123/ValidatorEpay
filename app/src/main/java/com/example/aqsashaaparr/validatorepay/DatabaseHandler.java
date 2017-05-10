package com.example.aqsashaaparr.validatorepay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AQSA SHaaPARR on 5/9/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

        public static  final String DATABASE_NAME = "fareData";
        public static  final int DATABASE_VERSION =1;
        public static final String TABLENAME = "Fare";




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase db) {
String CREATE_FARE_TABLE= "CREATE TABLE if not exists " + TABLENAME
        +"(Fare_id int,Fare_Route text,Fare_Price text,Fare_type text,added_by text,update_by text,date_added_by text,date_updated text)";
db.execSQL(CREATE_FARE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        // Create tables again
        onCreate(db);

    }

    void addFareData(FareData fareData) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Fare_id", fareData.getFare_ID()); // Contact Name
        values.put("Fare_Route",fareData.getFare_route() ); // Contact Phone
        values.put("Fare_Price", fareData.getFare_price()); // Contact Phone
        values.put("Fare_type", fareData.getFare_type()); // Contact Phone
        values.put("added_by", fareData.getAdded_by()); // Contact Phon
        values.put("date_added_by", fareData.getDate_added()); // Contact Phone
        values.put("date_updated", fareData.getDate_updated());
        // Inserting Row
        db.insert(TABLENAME, null, values);
        db.close(); // Closing database connection
    }

//    FareData getData(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLENAME, new String[] { "Fare_id",
//                        "Fare_Route", "Fare_Price" }, "Fare_id" + "=?",
//                new String[] { String.valueOf(id) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToLast();
//        // cursor.moveToFirst();
//
//        FareData contact = new FareData(cursor.getString(0),
//                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
//        // return contact
//        return contact;
//    }
//
//


    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLENAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int m = cursor.getCount();
        cursor.close();
        // return count
        return m;
//

    }


}
