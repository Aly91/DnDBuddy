package dndbuddy.app.dndbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class AppDB {

    // database column NAMES e.g. rowID
    private static final String KEY_ROWID 	    = "_id";
    private static final String KEY_WHATEVER_YOUR_COLUMN_NAME_IS = "";

    private static final String DATABASE_TABLE 	= "Characters";
    private static final String DATABASE_TABLE2 = "Notes";

    private static final String DATABASE_NAME 	= "AppDB";
    private static final int DATABASE_VERSION 	= 1; // since it is the first version of the dB


    // SQL statement to create the database
    private static final String DATABASE_CREATE =
            "SQL to create table(s)";

    private final Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    // Constructor
    public AppDB (Context ctx)
    {
        //
        this.context 	= ctx;
       databaseHelper	= new DatabaseHelper(context);
    }

    public AppDB open() throws SQLException
    {
        db     = databaseHelper.getWritableDatabase();
        return this;

    }

    // nested dB helper class
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

            // Execute SQL to create your tables (call the execSQL method of the SQLLiteDatabase class, passing in your create table(s) SQL)
        }

        @Override
        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            // dB structure change..

        }
    }   // end nested class



    // remainder of the Database Example methods to "use" the database
    public void close()

    {
        databaseHelper.close();
    }

    // an example of a database insert.  This is for a particular database that has three columns
    public long insertPerson(String firstName, String surname, String city)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_WHATEVER_YOUR_COLUMN_NAME_IS, firstName);
        // put your own column/ values onto the Context Values object

        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    // an example of a custom method to query a database.

    public Cursor exampleCustomQuery(long rowId) throws SQLException
    {
        // The query method from SQLLiteDatabase class has various parameters that define the query: the database table, the string of columns names to be returned and
        // the last set of parameters allow you to specify "where" conditions for the query.  In this case, there is just one "where" clause. The others are unused.

        Cursor mCursor =   db.query(true, DATABASE_TABLE, new String[]
                        {
                                // this String array is the 2nd paramter to the query method - and is the list of columns you want to return
                                KEY_WHATEVER_YOUR_COLUMN_NAME_IS

                        },
                KEY_ROWID + "=" + rowId,  null, null, null, null, null);

        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

}// end class

    

