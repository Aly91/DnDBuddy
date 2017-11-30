package dndbuddy.app.dndbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.jar.Attributes;

//Based on database code example given in class

public class AppDB  {

    // database column NAMES e.g. rowID
    private static final String KEY_ROWID  = "_id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_CHARACTERCLASS = "Class";
    private static final String KEY_RACE = "Race";
    private static final String KEY_HITPOINTS = "HitPoints";
    private static final String KEY_STRENGTHSKILL = "Strengh";
    private static final String KEY_DEXTERITYSKILL = "Dexterity";
    private static final String KEY_CONSTITUTIONSKILL = "Constitution";
    private static final String KEY_INTELLIGENCESKILL = "Intelligence";
    private static final String KEY_WISDOMSKILL = "Wisdom";
    private static final String KEY_CHARISMASKILL = "Charisma";


    private static final String DATABASE_TABLE 	= "Characters";


    private static final String DATABASE_NAME 	= "AppDB";
    private static final int DATABASE_VERSION 	= 1; // since it is the first version of the dB


    // SQL statement to create the database
    private static final String DATABASE_CREATE =
            "create table“ + DATABASE_TABLE + “ (_id integer primary key autoincrement, " + "Name text not null,“ + “ Class text not null, " + "Race text not null" + "HitPoints int not null" +
                    "Strength int not null"+ "Dexterity int not null" + "Constitution int not null" + "Intelligence int not null" + "Wisdom int not null" + "Charisma int not null);";

    private final Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    // Constructor
    public AppDB (Context ctx)
    {

        this.context 	= ctx;
       databaseHelper	= new DatabaseHelper(context);
    }



    public AppDB open() throws SQLException
    {
        db  = databaseHelper.getWritableDatabase();
        return this;

    }
    public void close()

    {
        databaseHelper.close();
    }



    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        //
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        //
        public void onCreate(SQLiteDatabase db)
        {

            db.execSQL(DATABASE_CREATE); //execute the create table SQL statment
        }

        @Override
        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            // For future modification to the database.
        }
    }


   // Insert method that inserts the values fro the below columns
    public long insertCharacter (String Name, String Class, String Race, int HitPoints, int Strength, int Dexterity,int Constitution, int Intellegence,int Wisdom, int Charisma)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, Name);
        initialValues.put(KEY_CHARACTERCLASS , Class);
        initialValues.put(KEY_RACE, Race);
        initialValues.put(KEY_HITPOINTS, HitPoints);
        initialValues.put(KEY_STRENGTHSKILL, Strength);
        initialValues.put(KEY_DEXTERITYSKILL,Dexterity);
        initialValues.put(KEY_CONSTITUTIONSKILL, Constitution);
        initialValues.put(KEY_INTELLIGENCESKILL, Intellegence);
        initialValues.put(KEY_WISDOMSKILL, Wisdom);
        initialValues.put(KEY_CHARISMASKILL, Charisma);


        return db.insert(DATABASE_TABLE, null, initialValues);
    }



    public Cursor getAllCharacters(long rowId) throws SQLException {
        return db.query(DATABASE_TABLE, new String[]{
                        KEY_ROWID,
                        KEY_NAME,
                        KEY_CHARACTERCLASS,
                        KEY_RACE,
                        KEY_HITPOINTS,
                        KEY_STRENGTHSKILL,
                        KEY_DEXTERITYSKILL,
                        KEY_CONSTITUTIONSKILL,
                        KEY_INTELLIGENCESKILL,
                        KEY_WISDOMSKILL},
                null,
                null,
                null,
                null,
                null);
    }

    public Cursor getCharacter(long rowId) throws SQLException {


                        Cursor mCursor =
                        db.query(true, DATABASE_TABLE, new String[]{
                                        KEY_ROWID,
                                        KEY_NAME,
                                        KEY_CHARACTERCLASS,
                                        KEY_RACE,
                                        KEY_HITPOINTS,
                                        KEY_STRENGTHSKILL,
                                        KEY_DEXTERITYSKILL,
                                        KEY_CONSTITUTIONSKILL,
                                        KEY_INTELLIGENCESKILL,
                                        KEY_WISDOMSKILL

                                },
                                KEY_ROWID + "=" + rowId,
                                null,
                                null,
                                null,
                                null,
                                null);


        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
        }


    }





    

