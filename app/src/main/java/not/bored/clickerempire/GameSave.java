package not.bored.clickerempire;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

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
                "CIVILIZATION_NAME TEXT NOT NULL," +
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
        sql = "INSERT INTO RESOURCES (CIVILIZATION_NAME, FOOD, FOOD_MAX, WOOD, WOOD_MAX, STONE, STONE_MAX, POPULATION, POPULATION_MAX, " +
                "TENTS, HUTS, HOUSES, MANSIONS, BARNS, WOODSTOCKPILES, STONESTOCKPILES, FARMERS, LUMBERJACKS, STONEMASONS, UNEMPLOYED) " +
                "VALUES ('Clicker','0','200','0','200','0','200','0','0','0','0','0','0','0','0','0','0','0','0','0')";
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
    public boolean set(String res, double amt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(res, amt);
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
    public boolean updateName(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CIVILIZATION_NAME", name);
        long result = db.update(RESOURCES, contentValues, null, null);
        return result != -1;
    }
    public Map<String, String> save(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(1));buffer.append(",");buffer.append(data.getString(2));buffer.append(",");
            buffer.append(data.getString(3));buffer.append(",");buffer.append(data.getString(4));buffer.append(",");
            buffer.append(data.getString(5));buffer.append(",");buffer.append(data.getString(6));buffer.append(",");
            buffer.append(data.getString(7));buffer.append(",");buffer.append(data.getString(8));buffer.append(",");
            buffer.append(data.getString(9));buffer.append(",");buffer.append(data.getString(10));buffer.append(",");
            buffer.append(data.getString(11));buffer.append(",");buffer.append(data.getString(12));buffer.append(",");
            buffer.append(data.getString(13));buffer.append(",");buffer.append(data.getString(14));buffer.append(",");
            buffer.append(data.getString(15));buffer.append(",");buffer.append(data.getString(16));buffer.append(",");
            buffer.append(data.getString(17));buffer.append(",");buffer.append(data.getString(18));buffer.append(",");
            buffer.append(data.getString(19));buffer.append(",");buffer.append(data.getString(20));
        }
        data.close();
        Map<String, String> map = new HashMap<String, String>();
        String save[] = buffer.toString().split(",");
        map.put("CIVILIZATION_NAME", save[0]);map.put("FOOD", save[1]);map.put("FOOD_MAX", save[2]);
        map.put("WOOD", save[3]);map.put("WOOD_MAX", save[4]);map.put("STONE", save[5]);
        map.put("STONE_MAX", save[6]);map.put("POPULATION", save[7]);map.put("POPULATION_MAX", save[8]);
        map.put("TENTS", save[9]);map.put("HUTS", save[10]);map.put("HOUSES", save[11]);map.put("MANSIONS", save[12]);
        map.put("BARNS", save[13]);map.put("WOODSTOCKPILES", save[14]);map.put("STONESTOCKPILES", save[15]);
        map.put("FARMERS", save[16]);map.put("LUMBERJACKS", save[17]);map.put("STONEMASONS", save[18]);
        map.put("UNEMPLOYED", save[19]);
        return map;
    }
}
