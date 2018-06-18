package not.bored.clickerempire;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Erie M. Adames on 6/12/2018.
 */

public class GameSave extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GameSave.db";
    public static final String RESOURCES = "Resources";
    public static final String FOOD_col = "FOOD";
    public static final String WOOD_col = "WOOD";
    public static final String STONE_col = "STONE";
    public static final String POPULATION = "POPULATION";
    public GameSave(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + RESOURCES +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FOOD INTEGER NOT NULL," +
                "FOOD_MAX INTEGER NOT NULL," +
                "WOOD INTEGER NOT NULL," +
                "WOOD_MAX INTEGER NOT NULL," +
                "STONE INTEGER NOT NULL," +
                "STONE_MAX INTEGER NOT NULL," +
                "POPULATION INTEGER NOT NULL," +
                "POPULATION_MAX INTEGER NOT NULL," +
                "TENTS INTEGER NOT NULL," +
                "HUTS INTEGER NOT NULL," +
                "HOUSES INTEGER NOT NULL," +
                "MANSIONS INTEGER NOT NULL," +
                "FARMERS INTEGER NOT NULL," +
                "LUMBERJACKS INTEGER NOT NULL," +
                "STONEMASONS INTEGER NOT NULL," +
                "UNEMPLOYED INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO RESOURCES (FOOD, FOOD_MAX, WOOD, WOOD_MAX, STONE, STONE_MAX, POPULATION, POPULATION_MAX, " +
                "TENTS, HUTS, HOUSES, MANSIONS, FARMERS, LUMBERJACKS, STONEMASONS, UNEMPLOYED) " +
                "VALUES ('0','200','0','200','0','200','0','0','0','0','0','0','0','0','0','0')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + RESOURCES);
        onCreate(db);
    }
    public boolean update(String res, int amt){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + res + ", " + res + "_MAX FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
            buffer.append(",");
            buffer.append(data.getString(1));
        }
        String str = buffer.toString();
        String[] array = str.split(",");
        int current = Integer.parseInt(array[0]);
        int max = Integer.parseInt(array[1]);
        current = current + amt;
        ContentValues contentValues = new ContentValues();
        contentValues.put(res, current);
        if(current<=max){
            long result = db.update(RESOURCES, contentValues, null, null);

            return result != -1;
        }
        else {
            return false;
        }
    }
    public boolean updatemax(String res, int amt){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + res + "_MAX FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        String str = buffer.toString();
        int max = Integer.parseInt(str);
        max = max + amt;
        ContentValues contentValues = new ContentValues();
        String res_max = res + "_MAX";
        contentValues.put(res_max, max);
        long result = db.update(RESOURCES, contentValues, null, null);

        return result != -1;
    }
    public boolean createbuilding(String building, int amt, int populattion){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + building + ", POPULATION_MAX FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
            buffer.append(",");
            buffer.append(data.getString(1));
        }
        String str[] = buffer.toString().split(",");
        int current = Integer.parseInt(str[0]);
        int population = Integer.parseInt(str[1]);
        current = current + amt;
        ContentValues contentValues = new ContentValues();
        contentValues.put(building, current);
        contentValues.put("POPULATION_MAX", population);
        long result = db.update(RESOURCES, contentValues, null, null);
        return result != -1;
    }
    public String resourceAmount(String res){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ res + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        String c = buffer.toString();
        return  c;
    }
    public String showamt(String res){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ res + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        String c = buffer.toString();
        return  c;
    }
    public boolean assignJob(String job, int amount){
        int unemployed = Integer.parseInt(this.resourceAmount("UNEMPLOYED"));
        if((unemployed == 0) || ((unemployed - amount) < 0)){
            return false;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        unemployed -= amount;
        int workers = Integer.parseInt(this.resourceAmount(job));
        workers += amount;
        ContentValues contentValues = new ContentValues();
        contentValues.put("UNEMPLOYED", unemployed);
        contentValues.put(job, workers);
        long result = db.update(RESOURCES, contentValues, null, null);
        return result != -1;
    }
    public boolean resetdb(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + RESOURCES);
        onCreate(db);
        return true;
    }
}
