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

    private static GameSave gameSave;

    public static synchronized GameSave getGameSave(Context context){
        if(gameSave == null) {
            gameSave = new GameSave(context);
        }
        return gameSave;
    }

    private GameSave(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + RESOURCES +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "FOOD REAL NOT NULL," +
                "FOOD_MAX REAL NOT NULL," +
                "WOOD REAL NOT NULL," +
                "WOOD_MAX REAL NOT NULL," +
                "STONE REAL NOT NULL," +
                "STONE_MAX REAL NOT NULL," +
                "POPULATION INTEGER NOT NULL," +
                "POPULATION_MAX INTEGER NOT NULL," +
                "TENTS INTEGER NOT NULL," +
                "HUTS INTEGER NOT NULL," +
                "HOUSES INTEGER NOT NULL," +
                "MANSIONS INTEGER NOT NULL," +
                "BARNS INTEGER NOT NULL," +
                "WOODSTOCKPILES INTEGER NOT NULL," +
                "STONESTOCKPILES INTEGER NOT NULL," +
                "FARMERS INTEGER NOT NULL," +
                "LUMBERJACKS INTEGER NOT NULL," +
                "STONEMASONS INTEGER NOT NULL," +
                "UNEMPLOYED INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO RESOURCES (FOOD, FOOD_MAX, WOOD, WOOD_MAX, STONE, STONE_MAX, POPULATION, POPULATION_MAX, " +
                "TENTS, HUTS, HOUSES, MANSIONS, BARNS, WOODSTOCKPILES, STONESTOCKPILES, FARMERS, LUMBERJACKS, STONEMASONS, UNEMPLOYED) " +
                "VALUES ('0','200','0','200','0','200','0','0','0','0','0','0','0','0','0','0','0','0','0')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + RESOURCES);
        onCreate(db);
    }
    public boolean updateNoMax(String res, int amt){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + res + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        data.close();
        String str = buffer.toString();
        int current = Integer.parseInt(str);
        current = current + amt;
        ContentValues contentValues = new ContentValues();
        contentValues.put(res, current);
        long result = db.update(RESOURCES, contentValues, null, null);
        return result != -1;
    }
    public boolean update(String res, double amt){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + res + ", " + res + "_MAX FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
            buffer.append(",");
            buffer.append(data.getString(1));
        }
        data.close();
        String str = buffer.toString();
        String[] array = str.split(",");
        double current = Double.parseDouble(array[0]);
        Double max = Double.parseDouble(array[1]);
        current = current + amt;
        if(current<=max){
            ContentValues contentValues = new ContentValues();
            contentValues.put(res, current);
            long result = db.update(RESOURCES, contentValues, null, null);
            return result != -1;
        }
        else{
            ContentValues contentValues = new ContentValues();
            contentValues.put(res, max);
            long result = db.update(RESOURCES, contentValues, null, null);
            return result != -1;
        }
    }
    public boolean updatemax(String res, double amt){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + res + "_MAX FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        data.close();
        String str = buffer.toString();
        double max = Double.parseDouble(str);
        max = max + amt;
        ContentValues contentValues = new ContentValues();
        String res_max = res + "_MAX";
        contentValues.put(res_max, max);
        long result = db.update(RESOURCES, contentValues, null, null);
        return result != -1;
    }
    public boolean createbuilding(String building, int amt){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + building + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        data.close();
        String str = buffer.toString();
        int current = Integer.parseInt(str);
        current = current + amt;
        ContentValues contentValues = new ContentValues();
        contentValues.put(building, current);
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
        data.close();
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
        data.close();
        String c = buffer.toString();
        return  c;
    }
    public boolean resetdb(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + RESOURCES);
        onCreate(db);
        return true;
    }
}
