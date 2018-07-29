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
    public static final String CIVILIZATION_NAME = "CIVILIZATION_NAME";
    public static final String RESOURCES = "Resources";
    public static final String FOOD = "FOOD";
    public static final String FOOD_MAX = "FOOD_MAX";
    public static final String WOOD = "WOOD";
    public static final String WOOD_MAX = "WOOD_MAX";
    public static final String STONE = "STONE";
    public static final String STONE_MAX = "STONE_MAX";
    public static final String SKINS = "SKINS";
    public static final String LEATHER = "LEATHER";
    public static final String HERBS = "HERBS";
    public static final String PIETY = "PIETY";
    public static final String ORE = "ORE";
    public static final String METAL = "METAL";
    public static final String POPULATION = "POPULATION";
    public static final String POPULATION_MAX = "POPULATION_MAX";
    public static final String TENTS = "TENTS";
    public static final String HUTS = "HUTS";
    public static final String COTTAGES = "COTTAGES";
    public static final String HOUSES = "HOUSES";
    public static final String MANSIONS = "MANSIONS";
    public static final String BARNS = "BARNS";
    public static final String WOODSTOCKPILES = "WOODSTOCKPILES";
    public static final String STONESTOCKPILES = "STONESTOCKPILES";
    public static final String FARMERS = "FARMERS";
    public static final String LUMBERJACKS = "LUMBERJACKS";
    public static final String STONEMASONS = "STONEMASONS";
    public static final String UNEMPLOYED = "UNEMPLOYED";
    public static final String SKINNING = "SKINNING";
    public static final String HARVESTING = "HARVESTING";
    public static final String PROSPECTING = "PROSPECTING";
    public static final String MASONRY = "MASONRY";
    public static final String DOMESTICATION = "DOMESTICATION";
    public static final String PLOUGHSHARES = "PLOUGHSHARES";
    public static final String IRRIGATION = "IRRIGATION";
    public static final String CONSTRUCTION = "CONSTRUCTION";
    public static final String GRANARIES = "GRANARIES";
    public static final String TANNERIES = "TANNERIES";
    public static final String SMITHIES = "SMITHIES";
    public static final String APOTHECARIES = "APOTHECARIES";
    public static final String BARRACKS = "BARRACKS";
    public static final String FARMERPRODUCTIONLEVEL = "FARMERPRODUCTIONLEVEL";
    public static final String TANNERS = "TANNERS";
    public static final String BLACKSMITHS = "BLACKSMITHS";
    public static final String HEALERS = "HEALERS";
    public static final String LAND = "LAND";
    public static final String STABLES = "STABLES";
    public static final String ECI = "ECI";
    public static final String SOLDIERS = "SOLDIERS";
    public static final String CAVALRY = "CAVALRY";
    public static final String OCCUPIEDLAND = "OCCUPIEDLAND";


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
                "( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CIVILIZATION_NAME TEXT NOT NULL," +
                "FOOD REAL NOT NULL," +
                "FOOD_MAX REAL NOT NULL," +
                "WOOD REAL NOT NULL," +
                "WOOD_MAX REAL NOT NULL," +
                "STONE REAL NOT NULL," +
                "STONE_MAX REAL NOT NULL," +
                "SKINS INTEGER NOT NULL," +
                "LEATHER INTEGER NOT NULL," +
                "HERBS INTEGER NOT NULL," +
                "PIETY INTEGER NOT NULL," +
                "ORE INTEGER NOT NULL," +
                "METAL INTEGER NOT NULL," +
                "POPULATION INTEGER NOT NULL," +
                "POPULATION_MAX INTEGER NOT NULL," +
                "TENTS INTEGER NOT NULL," +
                "HUTS INTEGER NOT NULL," +
                "COTTAGES INTEGER NOT NULL," +
                "HOUSES INTEGER NOT NULL," +
                "MANSIONS INTEGER NOT NULL," +
                "BARNS INTEGER NOT NULL," +
                "WOODSTOCKPILES INTEGER NOT NULL," +
                "STONESTOCKPILES INTEGER NOT NULL," +
                "FARMERS INTEGER NOT NULL," +
                "LUMBERJACKS INTEGER NOT NULL," +
                "STONEMASONS INTEGER NOT NULL," +
                "UNEMPLOYED INTEGER NOT NULL," +
                "SKINNING INTEGER NOT NULL," +
                "HARVESTING INTEGER NOT NULL," +
                "PROSPECTING INTEGER NOT NULL," +
                "MASONRY INTEGER NOT NULL," +
                "DOMESTICATION INTEGER NOT NULL," +
                "PLOUGHSHARES INTEGER NOT NULL," +
                "IRRIGATION INTEGER NOT NULL," +
                "CONSTRUCTION INTEGER NOT NULL," +
                "GRANARIES INTEGER NOT NULL," +
                "TANNERIES INTEGER NOT NULL," +
                "SMITHIES INTEGER NOT NULL," +
                "APOTHECARIES INTEGER NOT NULL," +
                "BARRACKS INTEGER NOT NULL," +
                "FARMERPRODUCTIONLEVEL INTEGER NOT NULL," +
                "TANNERS INTEGER NOT NULL," +
                "BLACKSMITHS INTEGER NOT NULL," +
                "HEALERS INTEGER NOT NULL," +
                "LAND INTEGER NOT NULL," +
                "STABLES INTEGER NOT NULL," +
                "SOLDIERS INTEGER NOT NULL," +
                "CAVALRY INTEGER NOT NULL," +
                "OCCUPIEDLAND INTEGER NOT NULL)";
        db.execSQL(sql);
        sql = "INSERT INTO " + RESOURCES + " ( CIVILIZATION_NAME," +
                " FOOD," +
                " FOOD_MAX," +
                " WOOD," +
                " WOOD_MAX," +
                " STONE," +
                " STONE_MAX," +
                " SKINS," +
                " LEATHER," +
                " HERBS," +
                " PIETY," +
                " ORE," +
                " METAL," +
                " POPULATION," +
                " POPULATION_MAX," +
                " TENTS," +
                " HUTS," +
                " COTTAGES," +
                " HOUSES," +
                " MANSIONS," +
                " BARNS," +
                " WOODSTOCKPILES," +
                " STONESTOCKPILES," +
                " FARMERS," +
                " LUMBERJACKS," +
                " STONEMASONS," +
                " UNEMPLOYED," +
                " SKINNING," +
                " HARVESTING," +
                " PROSPECTING," +
                " MASONRY," +
                " DOMESTICATION," +
                " PLOUGHSHARES," +
                " IRRIGATION," +
                " CONSTRUCTION," +
                " GRANARIES," +
                " TANNERIES," +
                " SMITHIES," +
                " APOTHECARIES," +
                " BARRACKS," +
                " FARMERPRODUCTIONLEVEL," +
                " TANNERS," +
                " BLACKSMITHS," +
                " HEALERS," +
                " LAND," +
                " STABLES," +
                " SOLDIERS," +
                " CAVALRY," +
                " OCCUPIEDLAND) " +
                "VALUES ('Clicker'," +
                "'0'," +
                "'200'," +
                "'0'," +
                "'200'," +
                "'0'," +
                "'200'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'100'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0')";
        db.execSQL(sql);

        String esql = "CREATE TABLE " + ECI +
                "( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ECI INTEGER NOT NULL)";
        db.execSQL(esql);
        esql = "INSERT INTO " + ECI + " ( ECI ) VALUES ( '0' )";
        db.execSQL(esql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + RESOURCES);
        onCreate(db);
    }
    public boolean updateNoMax(String res, double amt){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + res + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        data.close();
        String str = buffer.toString();
        double current = Double.parseDouble(str);
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
    public boolean setInt(String res, int amt){
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
    public void setECIchecked(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ECI, 1);
        db.update(ECI, contentValues, null, null);
    }
    public void setECIunchecked(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ECI, 0);
        db.update(ECI, contentValues, null, null);
    }
    public boolean ECI(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT ECI FROM ECI";
        Cursor data = db.rawQuery(sql,null);
        StringBuffer buffer = new StringBuffer();
        while(data.moveToNext()){
            buffer.append(data.getString(0));
        }
        data.close();
        int str = Integer.parseInt(buffer.toString());
        return str == 1;
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
    public void resetdb(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + RESOURCES);
        db.execSQL("DROP TABLE IF EXISTS " + ECI);
        onCreate(db);
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
            buffer.append(data.getString(1));buffer.append(",");
            buffer.append(data.getString(2));buffer.append(",");
            buffer.append(data.getString(3));buffer.append(",");
            buffer.append(data.getString(4));buffer.append(",");
            buffer.append(data.getString(5));buffer.append(",");
            buffer.append(data.getString(6));buffer.append(",");
            buffer.append(data.getString(7));buffer.append(",");
            buffer.append(data.getString(8));buffer.append(",");
            buffer.append(data.getString(9));buffer.append(",");
            buffer.append(data.getString(10));buffer.append(",");
            buffer.append(data.getString(11));buffer.append(",");
            buffer.append(data.getString(12));buffer.append(",");
            buffer.append(data.getString(13));buffer.append(",");
            buffer.append(data.getString(14));buffer.append(",");
            buffer.append(data.getString(15));buffer.append(",");
            buffer.append(data.getString(16));buffer.append(",");
            buffer.append(data.getString(17));buffer.append(",");
            buffer.append(data.getString(18));buffer.append(",");
            buffer.append(data.getString(19));buffer.append(",");
            buffer.append(data.getString(20));buffer.append(",");
            buffer.append(data.getString(21));buffer.append(",");
            buffer.append(data.getString(22));buffer.append(",");
            buffer.append(data.getString(23));buffer.append(",");
            buffer.append(data.getString(24));buffer.append(",");
            buffer.append(data.getString(25));buffer.append(",");
            buffer.append(data.getString(26));buffer.append(",");
            buffer.append(data.getString(27));buffer.append(",");
            buffer.append(data.getString(28));buffer.append(",");
            buffer.append(data.getString(29));buffer.append(",");
            buffer.append(data.getString(30));buffer.append(",");
            buffer.append(data.getString(31));buffer.append(",");
            buffer.append(data.getString(32));buffer.append(",");
            buffer.append(data.getString(33));buffer.append(",");
            buffer.append(data.getString(34));buffer.append(",");
            buffer.append(data.getString(35));buffer.append(",");
            buffer.append(data.getString(36));buffer.append(",");
            buffer.append(data.getString(37));buffer.append(",");
            buffer.append(data.getString(38));buffer.append(",");
            buffer.append(data.getString(39));buffer.append(",");
            buffer.append(data.getString(40));buffer.append(",");
            buffer.append(data.getString(41));buffer.append(",");
            buffer.append(data.getString(42));buffer.append(",");
            buffer.append(data.getString(43));buffer.append(",");
            buffer.append(data.getString(44));buffer.append(",");
            buffer.append(data.getString(45));buffer.append(",");
            buffer.append(data.getString(46));buffer.append(",");
            buffer.append(data.getString(47));buffer.append(",");
            buffer.append(data.getString(48));buffer.append(",");
            buffer.append(data.getString(48));
        }
        data.close();
        Map<String, String> map = new HashMap<String, String>();
        String save[] = buffer.toString().split(",");
        map.put(CIVILIZATION_NAME, save[0]);
        map.put(FOOD, save[1]);
        map.put(FOOD_MAX, save[2]);
        map.put(WOOD, save[3]);
        map.put(WOOD_MAX, save[4]);
        map.put(STONE, save[5]);
        map.put(STONE_MAX, save[6]);
        map.put(SKINS, save[7]);
        map.put(LEATHER, save[8]);
        map.put(HERBS, save[9]);
        map.put(PIETY, save[10]);
        map.put(ORE, save[11]);
        map.put(METAL, save[12]);
        map.put(POPULATION, save[13]);
        map.put(POPULATION_MAX, save[14]);
        map.put(TENTS, save[15]);
        map.put(HUTS, save[16]);
        map.put(COTTAGES, save[17]);
        map.put(HOUSES, save[18]);
        map.put(MANSIONS, save[19]);
        map.put(BARNS, save[20]);
        map.put(WOODSTOCKPILES, save[21]);
        map.put(STONESTOCKPILES, save[22]);
        map.put(FARMERS, save[23]);
        map.put(LUMBERJACKS, save[24]);
        map.put(STONEMASONS, save[25]);
        map.put(UNEMPLOYED, save[26]);
        map.put(SKINNING, save[27]);
        map.put(HARVESTING, save[28]);
        map.put(PROSPECTING, save[29]);
        map.put(MASONRY, save[30]);
        map.put(DOMESTICATION, save[31]);
        map.put(PLOUGHSHARES, save[32]);
        map.put(IRRIGATION, save[33]);
        map.put(CONSTRUCTION, save[34]);
        map.put(GRANARIES, save[35]);
        map.put(TANNERIES, save[36]);
        map.put(SMITHIES, save[37]);
        map.put(APOTHECARIES, save[38]);
        map.put(BARRACKS, save[39]);
        map.put(FARMERPRODUCTIONLEVEL, save[40]);
        map.put(TANNERS, save[41]);
        map.put(BLACKSMITHS, save[42]);
        map.put(HEALERS, save[43]);
        map.put(LAND, save[44]);
        map.put(STABLES, save[45]);
        map.put(SOLDIERS, save[46]);
        map.put(CAVALRY, save[47]);
        map.put(OCCUPIEDLAND, save[48]);
        return map;
    }
}
