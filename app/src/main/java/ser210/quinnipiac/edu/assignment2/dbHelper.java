package ser210.quinnipiac.edu.assignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kyle on 4/6/2018.
 */

public class dbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "list.db";
    public static final String TB_NAME = "list_data";
    public static final String COL_ONE = "ID";
    public static final String COL_TWO = "ITEM1";
    public static final int DB_VERISON = 1;

    public dbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERISON);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE "
                + TB_NAME
                + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "ITEM1 TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
    }

    public boolean addEntry(String value){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TWO, value);

        long res = sqLiteDatabase.insert(TB_NAME, null, contentValues);

        if(res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getList(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TB_NAME, null);
        return cursor;
    }

}
