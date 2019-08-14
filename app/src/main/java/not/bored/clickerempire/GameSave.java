package not.bored.clickerempire;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erie M. Adames on 6/12/2018.
 */

public class GameSave extends SQLiteOpenHelper implements Serializable {
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
    public static final String BASICWEAPONRY = "BASICWEAPONRY";
    public static final String BASICSHIELDS = "BASICSHIELDS";
    public static final String TENEMENTS = "TENEMENTS";
    public static final String PALISADE = "PALISADE";
    public static final String BUTCHERING = "BUTCHERING";
    public static final String GARDENING = "GARDENING";
    public static final String EXTRACTION = "EXTRACTION";
    public static final String HORSEBACKRIDING = "HORSEBACKRIDING";
    public static final String ARCHITECTURE = "ARCHITECTURE";
    public static final String FLENSING = "FLENSING";
    public static final String MACERATING = "MACERATING";
    public static final String CROPROTATION = "CROPROTATION";
    public static final String SELECTIVEBREEDING = "SELECTIVEBREEDING";
    public static final String FERTILIZERS = "FERTILIZERS";
    public static final String SLUMS = "SLUMS";
    public static final String SICK = "SICK";

    public static final String THORP = "THORP";
    public static final String HAMLET = "HAMLET";
    public static final String VILLAGE = "VILLAGE";
    public static final String SMALL_TOWN = "SMALL_TOWN";
    public static final String LARGE_TOWN = "LARGE_TOWN";
    public static final String SMALL_CITY = "SMALL_CITY";
    public static final String LARGE_CITY = "LARGE_CITY";
    public static final String METROPOLIS = "METROPOLIS";
    public static final String SMALL_NATION = "SMALL_NATION";
    public static final String NATION = "NATION";
    public static final String LARGE_NATION = "LARGE_NATION";
    public static final String EMPIRE = "EMPIRE";
    public static final String CONTINENTAL_EMPIRE = "CONTINENTAL_EMPIRE";
    public static final String WORLD_CONFEDERATION = "WORLD_CONFEDERATION";
    public static final String UNITED_WORLD = "UNITED_WORLD";
    public static final String INVASIONCOUNTER = "INVASIONCOUNTER";
    public static final String DEFEATCOUNTER = "DEFEATCOUNTER";
    public static final String RAIDER_ONE = "RAIDER_ONE";
    public static final String RAIDER_TWO = "RAIDER_TWO";
    public static final String RAIDER_THREE = "RAIDER_THREE";
    public static final String RAIDER_FOUR = "RAIDER_FOUR";
    public static final String RAIDER_FIVE = "RAIDER_FIVE";
    public static final String RAIDER_SIX = "RAIDER_SIX";
    public static final String RAIDER_SEVEN = "RAIDER_SEVEN";
    public static final String RAIDER_EIGHT = "RAIDER_EIGHT";
    public static final String RAIDER_NINE = "RAIDER_NINE";
    public static final String RAIDER_TEN = "RAIDER_TEN";
    public static final String DEFEAT_ONE = "DEFEAT_ONE";
    public static final String DEFEAT_TWO = "DEFEAT_TWO";
    public static final String DEFEAT_THREE = "DEFEAT_THREE";
    public static final String DEFEAT_FOUR = "DEFEAT_FOUR";
    public static final String DEFEAT_FIVE = "DEFEAT_FIVE";
    public static final String DEFEAT_SIX = "DEFEAT_SIX";
    public static final String DEFEAT_SEVEN = "DEFEAT_SEVEN";
    public static final String DEFEAT_EIGHT = "DEFEAT_EIGHT";
    public static final String DEFEAT_NINE = "DEFEAT_NINE";
    public static final String DEFEAT_TEN = "DEFEAT_TEN";
    public static final String CONQUEROR_THORP = "CONQUEROR_THORP";
    public static final String CONQUEROR_THORP_COUNTER = "CONQUEROR_THORP_COUNTER";
    public static final String CONQUEROR_HAMLET = "CONQUEROR_HAMLET";
    public static final String CONQUEROR_HAMLET_COUNTER = "CONQUEROR_HAMLET_COUNTER";
    public static final String CONQUEROR_VILLAGE = "CONQUEROR_VILLAGE";
    public static final String CONQUEROR_VILLAGE_COUNTER = "CONQUEROR_VILLAGE_COUNTER";
    public static final String CONQUEROR_SMALL_TOWN = "CONQUEROR_SMALL_TOWN";
    public static final String CONQUEROR_SMALL_TOWN_COUNTER = "CONQUEROR_SMALL_TOWN_COUNTER";
    public static final String CONQUEROR_LARGE_TOWN = "CONQUEROR_LARGE_TOWN";
    public static final String CONQUEROR_LARGE_TOWN_COUNTER = "CONQUEROR_LARGE_TOWN_COUNTER";
    public static final String CONQUEROR_SMALL_CITY = "CONQUEROR_SMALL_CITY";
    public static final String CONQUEROR_SMALL_CITY_COUNTER = "CONQUEROR_SMALL_CITY_COUNTER";
    public static final String CONQUEROR_LARGE_CITY = "CONQUEROR_LARGE_CITY";
    public static final String CONQUEROR_LARGE_CITY_COUNTER = "CONQUEROR_LARGE_CITY_COUNTER";
    public static final String CONQUEROR_METROPOLIS = "CONQUEROR_METROPOLIS";
    public static final String CONQUEROR_METROPOLIS_COUNTER = "CONQUEROR_METROPOLIS_COUNTER";
    public static final String CONQUEROR_SMALL_NATION = "CONQUEROR_SMALL_NATION";
    public static final String CONQUEROR_SMALL_NATION_COUNTER = "CONQUEROR_SMALL_NATION_COUNTER";
    public static final String CONQUEROR_NATION = "CONQUEROR_NATION";
    public static final String CONQUEROR_NATION_COUNTER = "CONQUEROR_NATION_COUNTER";
    public static final String CONQUEROR_LARGE_NATION = "CONQUEROR_LARGE_NATION";
    public static final String CONQUEROR_LARGE_NATION_COUNTER = "CONQUEROR_LARGE_NATION_COUNTER";
    public static final String CONQUEROR_EMPIRE = "CONQUEROR_EMPIRE";
    public static final String CONQUEROR_EMPIRE_COUNTER = "CONQUEROR_EMPIRE_COUNTER";
    public static final String CONQUEROR_CONTINENTAL_EMPIRE = "CONQUEROR_CONTINENTAL_EMPIRE";
    public static final String CONQUEROR_CONTINENTAL_EMPIRE_COUNTER = "CONQUEROR_CONTINENTAL_EMPIRE_COUNTER";
    public static final String CONQUEROR_WORLD_CONFEDERATION = "CONQUEROR_WORLD_CONFEDERATION";
    public static final String CONQUEROR_WORLD_CONFEDERATION_COUNTER = "CONQUEROR_WORLD_CONFEDERATION_COUNTER";
    public static final String CONQUEROR_UNITED_WORLD = "CONQUEROR_UNITED_WORLD";
    public static final String CONQUEROR_UNITED_WORLD_COUNTER = "CONQUEROR_UNITED_WORLD_COUNTER";
    public static final String BLACKSMITH_ONE = "BLACKSMITH_ONE";
    public static final String TANNER_ONE = "TANNER_ONE";
    public static final String HEALER_ONE = "HEALER_ONE";


    private static GameSave gameSave;
    DecimalFormat df = new DecimalFormat("0.0");
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
                "OCCUPIEDLAND INTEGER NOT NULL," +
                "BASICWEAPONRY INTEGER NOT NULL," +
                "BASICSHIELDS INTEGER NOT NULL," +
                "TENEMENTS INTEGER NOT NULL," +
                "PALISADE INTEGER NOT NULL," +
                "BUTCHERING INTEGER NOT NULL," +
                "GARDENING INTEGER NOT NULL," +
                "EXTRACTION INTEGER NOT NULL," +
                "HORSEBACKRIDING INTEGER NOT NULL," +
                "ARCHITECTURE INTEGER NOT NULL," +
                "FLENSING INTEGER NOT NULL," +
                "MACERATING INTEGER NOT NULL," +
                "CROPROTATION INTEGER NOT NULL," +
                "SELECTIVEBREEDING INTEGER NOT NULL," +
                "FERTILIZERS INTEGER NOT NULL," +
                "SLUMS INTEGER NOT NULL," +
                "SICK INTEGER NOT NULL)";
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
                " OCCUPIEDLAND," +
                " BASICWEAPONRY," +
                " BASICSHIELDS," +
                " TENEMENTS," +
                " PALISADE," +
                " BUTCHERING," +
                " GARDENING," +
                " EXTRACTION," +
                " HORSEBACKRIDING," +
                " ARCHITECTURE," +
                " FLENSING," +
                " MACERATING," +
                " CROPROTATION," +
                " SELECTIVEBREEDING," +
                " FERTILIZERS," +
                " SLUMS, " +
                " SICK)" +
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
                "'1000'," +
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
                "'0')";
        db.execSQL(sql);

        String esql = "CREATE TABLE " + ECI +
                "( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ECI INTEGER NOT NULL)";
        db.execSQL(esql);
        esql = "INSERT INTO " + ECI + " ( ECI ) VALUES ( '0' )";
        db.execSQL(esql);
        String asql = "CREATE TABLE ACHIEVEMENTS" +
                "( ID INTEGER PRIMARY KEY," +
                "THORP INTEGER NOT NULL," +
                "THORP_V INTEGER NOT NULL," +
                "HAMLET INTEGER NOT NULL," +
                "HAMLET_V INTEGER NOT NULL," +
                "VILLAGE INTEGER NOT NULL," +
                "VILLAGE_V INTEGER NOT NULL," +
                "SMALL_TOWN INTEGER NOT NULL," +
                "SMALL_TOWN_V INTEGER NOT NULL," +
                "lARGE_TOWN INTEGER NOT NULL," +
                "lARGE_TOWN_V INTEGER NOT NULL," +
                "SMALL_CITY INTEGER NOT NULL," +
                "SMALL_CITY_V INTEGER NOT NULL," +
                "LARGE_CITY INTEGER NOT NULL," +
                "LARGE_CITY_V INTEGER NOT NULL," +
                "METROPOLIS INTEGER NOT NULL," +
                "METROPOLIS_V INTEGER NOT NULL," +
                "SMALL_NATION INTEGER NOT NULL," +
                "SMALL_NATION_V INTEGER NOT NULL," +
                "NATION INTEGER NOT NULL," +
                "NATION_V INTEGER NOT NULL," +
                "LARGE_NATION INTEGER NOT NULL," +
                "LARGE_NATION_V INTEGER NOT NULL," +
                "EMPIRE INTEGER NOT NULL," +
                "EMPIRE_V INTEGER NOT NULL," +
                "CONTINENTAL_EMPIRE INTEGER NOT NULL," +
                "CONTINENTAL_EMPIRE_V INTEGER NOT NULL," +
                "WORLD_CONFEDERATION INTEGER NOT NULL," +
                "WORLD_CONFEDERATION_V INTEGER NOT NULL," +
                "UNITED_WORLD INTEGER NOT NULL," +
                "UNITED_WORLD_V INTEGER NOT NULL," +
                "RAIDER_ONE INTEGER NOT NULL," +
                "RAIDER_ONE_V INTEGER NOT NULL," +
                "RAIDER_TWO INTEGER NOT NULL," +
                "RAIDER_TWO_V INTEGER NOT NULL," +
                "RAIDER_THREE INTEGER NOT NULL," +
                "RAIDER_THREE_V INTEGER NOT NULL," +
                "RAIDER_FOUR INTEGER NOT NULL," +
                "RAIDER_FOUR_V INTEGER NOT NULL," +
                "RAIDER_FIVE INTEGER NOT NULL," +
                "RAIDER_FIVE_V INTEGER NOT NULL," +
                "RAIDER_SIX INTEGER NOT NULL," +
                "RAIDER_SIX_V INTEGER NOT NULL," +
                "RAIDER_SEVEN INTEGER NOT NULL," +
                "RAIDER_SEVEN_V INTEGER NOT NULL," +
                "RAIDER_EIGHT INTEGER NOT NULL," +
                "RAIDER_EIGHT_V INTEGER NOT NULL," +
                "RAIDER_NINE INTEGER NOT NULL," +
                "RAIDER_NINE_V INTEGER NOT NULL," +
                "RAIDER_TEN INTEGER NOT NULL," +
                "RAIDER_TEN_V INTEGER NOT NULL," +
                "DEFEAT_ONE INTEGER NOT NULL," +
                "DEFEAT_ONE_V INTEGER NOT NULL," +
                "DEFEAT_TWO INTEGER NOT NULL," +
                "DEFEAT_TWO_V INTEGER NOT NULL," +
                "DEFEAT_THREE INTEGER NOT NULL," +
                "DEFEAT_THREE_V INTEGER NOT NULL," +
                "DEFEAT_FOUR INTEGER NOT NULL," +
                "DEFEAT_FOUR_V INTEGER NOT NULL," +
                "DEFEAT_FIVE INTEGER NOT NULL," +
                "DEFEAT_FIVE_V INTEGER NOT NULL," +
                "DEFEAT_SIX INTEGER NOT NULL," +
                "DEFEAT_SIX_V INTEGER NOT NULL," +
                "DEFEAT_SEVEN INTEGER NOT NULL," +
                "DEFEAT_SEVEN_V INTEGER NOT NULL," +
                "DEFEAT_EIGHT INTEGER NOT NULL," +
                "DEFEAT_EIGHT_V INTEGER NOT NULL," +
                "DEFEAT_NINE INTEGER NOT NULL," +
                "DEFEAT_NINE_V INTEGER NOT NULL," +
                "DEFEAT_TEN INTEGER NOT NULL," +
                "DEFEAT_TEN_V INTEGER NOT NULL," +
                "INVASIONCOUNTER INTEGER NOT NULL,"+
                "DEFEATCOUNTER INTEGER NOT NULL," +
                "CONQUEROR_THORP INTEGER NOT NULL," +
                "CONQUEROR_THORP_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_THORP_V INTEGER NOT NULL," +
                "CONQUEROR_HAMLET INTEGER NOT NULL," +
                "CONQUEROR_HAMLET_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_HAMLET_V INTEGER NOT NULL," +
                "CONQUEROR_VILLAGE INTEGER NOT NULL," +
                "CONQUEROR_VILLAGE_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_VILLAGE_V INTEGER NOT NULL," +
                "CONQUEROR_SMALL_TOWN INTEGER NOT NULL," +
                "CONQUEROR_SMALL_TOWN_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_SMALL_TOWN_V INTEGER NOT NULL," +
                "CONQUEROR_LARGE_TOWN INTEGER NOT NULL," +
                "CONQUEROR_LARGE_TOWN_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_LARGE_TOWN_V INTEGER NOT NULL," +
                "CONQUEROR_SMALL_CITY INTEGER NOT NULL," +
                "CONQUEROR_SMALL_CITY_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_SMALL_CITY_V INTEGER NOT NULL," +
                "CONQUEROR_LARGE_CITY INTEGER NOT NULL," +
                "CONQUEROR_LARGE_CITY_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_LARGE_CITY_V INTEGER NOT NULL," +
                "CONQUEROR_METROPOLIS INTEGER NOT NULL," +
                "CONQUEROR_METROPOLIS_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_METROPOLIS_V INTEGER NOT NULL," +
                "CONQUEROR_SMALL_NATION INTEGER NOT NULL," +
                "CONQUEROR_SMALL_NATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_SMALL_NATION_V INTEGER NOT NULL," +
                "CONQUEROR_NATION INTEGER NOT NULL," +
                "CONQUEROR_NATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_NATION_V INTEGER NOT NULL," +
                "CONQUEROR_LARGE_NATION INTEGER NOT NULL," +
                "CONQUEROR_LARGE_NATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_LARGE_NATION_V INTEGER NOT NULL," +
                "CONQUEROR_EMPIRE INTEGER NOT NULL," +
                "CONQUEROR_EMPIRE_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_EMPIRE_V INTEGER NOT NULL," +
                "CONQUEROR_CONTINENTAL_EMPIRE INTEGER NOT NULL," +
                "CONQUEROR_CONTINENTAL_EMPIRE_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_CONTINENTAL_EMPIRE_V INTEGER NOT NULL," +
                "CONQUEROR_WORLD_CONFEDERATION INTEGER NOT NULL," +
                "CONQUEROR_WORLD_CONFEDERATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_WORLD_CONFEDERATION_V INTEGER NOT NULL," +
                "CONQUEROR_UNITED_WORLD INTEGER NOT NULL," +
                "CONQUEROR_UNITED_WORLD_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_UNITED_WORLD_V INTEGER NOT NULL)";
        db.execSQL(asql);
        asql = "INSERT INTO ACHIEVEMENTS" +
                " (" +
                "THORP ," +
                "THORP_V," +
                "HAMLET ," +
                "HAMLET_V," +
                "VILLAGE ," +
                "VILLAGE_V," +
                "SMALL_TOWN ," +
                "SMALL_TOWN_V," +
                "lARGE_TOWN ," +
                "lARGE_TOWN_V," +
                "SMALL_CITY ," +
                "SMALL_CITY_V," +
                "LARGE_CITY ," +
                "LARGE_CITY_V," +
                "METROPOLIS ," +
                "METROPOLIS_V," +
                "SMALL_NATION ," +
                "SMALL_NATION_V," +
                "NATION ," +
                "NATION_V," +
                "LARGE_NATION ," +
                "LARGE_NATION_V," +
                "EMPIRE ," +
                "EMPIRE_V," +
                "CONTINENTAL_EMPIRE ," +
                "CONTINENTAL_EMPIRE_V," +
                "WORLD_CONFEDERATION ," +
                "WORLD_CONFEDERATION_V," +
                "UNITED_WORLD ," +
                "UNITED_WORLD_V," +
                "RAIDER_ONE," +
                "RAIDER_ONE_V," +
                "RAIDER_TWO," +
                "RAIDER_TWO_V," +
                "RAIDER_THREE," +
                "RAIDER_THREE_V," +
                "RAIDER_FOUR," +
                "RAIDER_FOUR_V," +
                "RAIDER_FIVE," +
                "RAIDER_FIVE_V," +
                "RAIDER_SIX," +
                "RAIDER_SIX_V," +
                "RAIDER_SEVEN," +
                "RAIDER_SEVEN_V," +
                "RAIDER_EIGHT," +
                "RAIDER_EIGHT_V," +
                "RAIDER_NINE," +
                "RAIDER_NINE_V," +
                "RAIDER_TEN," +
                "RAIDER_TEN_V," +
                "DEFEAT_ONE," +
                "DEFEAT_ONE_V," +
                "DEFEAT_TWO," +
                "DEFEAT_TWO_V," +
                "DEFEAT_THREE," +
                "DEFEAT_THREE_V," +
                "DEFEAT_FOUR," +
                "DEFEAT_FOUR_V," +
                "DEFEAT_FIVE," +
                "DEFEAT_FIVE_V," +
                "DEFEAT_SIX," +
                "DEFEAT_SIX_V," +
                "DEFEAT_SEVEN," +
                "DEFEAT_SEVEN_V," +
                "DEFEAT_EIGHT," +
                "DEFEAT_EIGHT_V," +
                "DEFEAT_NINE," +
                "DEFEAT_NINE_V," +
                "DEFEAT_TEN," +
                "DEFEAT_TEN_V," +
                "INVASIONCOUNTER," +
                "DEFEATCOUNTER," +
                "CONQUEROR_THORP," +
                "CONQUEROR_THORP_COUNTER," +
                "CONQUEROR_THORP_V," +
                "CONQUEROR_HAMLET," +
                "CONQUEROR_HAMLET_COUNTER," +
                "CONQUEROR_HAMLET_V," +
                "CONQUEROR_VILLAGE," +
                "CONQUEROR_VILLAGE_COUNTER," +
                "CONQUEROR_VILLAGE_V," +
                "CONQUEROR_SMALL_TOWN," +
                "CONQUEROR_SMALL_TOWN_COUNTER," +
                "CONQUEROR_SMALL_TOWN_V," +
                "CONQUEROR_LARGE_TOWN," +
                "CONQUEROR_LARGE_TOWN_COUNTER," +
                "CONQUEROR_LARGE_TOWN_V," +
                "CONQUEROR_SMALL_CITY," +
                "CONQUEROR_SMALL_CITY_COUNTER," +
                "CONQUEROR_SMALL_CITY_V," +
                "CONQUEROR_LARGE_CITY," +
                "CONQUEROR_LARGE_CITY_COUNTER," +
                "CONQUEROR_LARGE_CITY_V," +
                "CONQUEROR_METROPOLIS," +
                "CONQUEROR_METROPOLIS_COUNTER," +
                "CONQUEROR_METROPOLIS_V," +
                "CONQUEROR_SMALL_NATION," +
                "CONQUEROR_SMALL_NATION_COUNTER," +
                "CONQUEROR_SMALL_NATION_V," +
                "CONQUEROR_NATION," +
                "CONQUEROR_NATION_COUNTER," +
                "CONQUEROR_NATION_V," +
                "CONQUEROR_LARGE_NATION," +
                "CONQUEROR_LARGE_NATION_COUNTER," +
                "CONQUEROR_LARGE_NATION_V," +
                "CONQUEROR_EMPIRE," +
                "CONQUEROR_EMPIRE_COUNTER," +
                "CONQUEROR_EMPIRE_V," +
                "CONQUEROR_CONTINENTAL_EMPIRE," +
                "CONQUEROR_CONTINENTAL_EMPIRE_COUNTER," +
                "CONQUEROR_CONTINENTAL_EMPIRE_V," +
                "CONQUEROR_WORLD_CONFEDERATION," +
                "CONQUEROR_WORLD_CONFEDERATION_COUNTER," +
                "CONQUEROR_WORLD_CONFEDERATION_V," +
                "CONQUEROR_UNITED_WORLD," +
                "CONQUEROR_UNITED_WORLD_COUNTER," +
                "CONQUEROR_UNITED_WORLD_V)" +
                "VALUES (" +
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
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0')";
        db.execSQL(asql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + RESOURCES);

        onCreate(db);
    }
    public void createAchievementDB(SQLiteDatabase db){
        String asql = "CREATE TABLE ACHIEVEMENTS" +
                "( ID INTEGER PRIMARY KEY," +
                "THORP INTEGER NOT NULL," +
                "THORP_V INTEGER NOT NULL," +
                "HAMLET INTEGER NOT NULL," +
                "HAMLET_V INTEGER NOT NULL," +
                "VILLAGE INTEGER NOT NULL," +
                "VILLAGE_V INTEGER NOT NULL," +
                "SMALL_TOWN INTEGER NOT NULL," +
                "SMALL_TOWN_V INTEGER NOT NULL," +
                "lARGE_TOWN INTEGER NOT NULL," +
                "lARGE_TOWN_V INTEGER NOT NULL," +
                "SMALL_CITY INTEGER NOT NULL," +
                "SMALL_CITY_V INTEGER NOT NULL," +
                "LARGE_CITY INTEGER NOT NULL," +
                "LARGE_CITY_V INTEGER NOT NULL," +
                "METROPOLIS INTEGER NOT NULL," +
                "METROPOLIS_V INTEGER NOT NULL," +
                "SMALL_NATION INTEGER NOT NULL," +
                "SMALL_NATION_V INTEGER NOT NULL," +
                "NATION INTEGER NOT NULL," +
                "NATION_V INTEGER NOT NULL," +
                "LARGE_NATION INTEGER NOT NULL," +
                "LARGE_NATION_V INTEGER NOT NULL," +
                "EMPIRE INTEGER NOT NULL," +
                "EMPIRE_V INTEGER NOT NULL," +
                "CONTINENTAL_EMPIRE INTEGER NOT NULL," +
                "CONTINENTAL_EMPIRE_V INTEGER NOT NULL," +
                "WORLD_CONFEDERATION INTEGER NOT NULL," +
                "WORLD_CONFEDERATION_V INTEGER NOT NULL," +
                "UNITED_WORLD INTEGER NOT NULL," +
                "UNITED_WORLD_V INTEGER NOT NULL," +
                "RAIDER_ONE INTEGER NOT NULL," +
                "RAIDER_ONE_V INTEGER NOT NULL," +
                "RAIDER_TWO INTEGER NOT NULL," +
                "RAIDER_TWO_V INTEGER NOT NULL," +
                "RAIDER_THREE INTEGER NOT NULL," +
                "RAIDER_THREE_V INTEGER NOT NULL," +
                "RAIDER_FOUR INTEGER NOT NULL," +
                "RAIDER_FOUR_V INTEGER NOT NULL," +
                "RAIDER_FIVE INTEGER NOT NULL," +
                "RAIDER_FIVE_V INTEGER NOT NULL," +
                "RAIDER_SIX INTEGER NOT NULL," +
                "RAIDER_SIX_V INTEGER NOT NULL," +
                "RAIDER_SEVEN INTEGER NOT NULL," +
                "RAIDER_SEVEN_V INTEGER NOT NULL," +
                "RAIDER_EIGHT INTEGER NOT NULL," +
                "RAIDER_EIGHT_V INTEGER NOT NULL," +
                "RAIDER_NINE INTEGER NOT NULL," +
                "RAIDER_NINE_V INTEGER NOT NULL," +
                "RAIDER_TEN INTEGER NOT NULL," +
                "RAIDER_TEN_V INTEGER NOT NULL," +
                "DEFEAT_ONE INTEGER NOT NULL," +
                "DEFEAT_ONE_V INTEGER NOT NULL," +
                "DEFEAT_TWO INTEGER NOT NULL," +
                "DEFEAT_TWO_V INTEGER NOT NULL," +
                "DEFEAT_THREE INTEGER NOT NULL," +
                "DEFEAT_THREE_V INTEGER NOT NULL," +
                "DEFEAT_FOUR INTEGER NOT NULL," +
                "DEFEAT_FOUR_V INTEGER NOT NULL," +
                "DEFEAT_FIVE INTEGER NOT NULL," +
                "DEFEAT_FIVE_V INTEGER NOT NULL," +
                "DEFEAT_SIX INTEGER NOT NULL," +
                "DEFEAT_SIX_V INTEGER NOT NULL," +
                "DEFEAT_SEVEN INTEGER NOT NULL," +
                "DEFEAT_SEVEN_V INTEGER NOT NULL," +
                "DEFEAT_EIGHT INTEGER NOT NULL," +
                "DEFEAT_EIGHT_V INTEGER NOT NULL," +
                "DEFEAT_NINE INTEGER NOT NULL," +
                "DEFEAT_NINE_V INTEGER NOT NULL," +
                "DEFEAT_TEN INTEGER NOT NULL," +
                "DEFEAT_TEN_V INTEGER NOT NULL," +
                "INVASIONCOUNTER INTEGER NOT NULL,"+
                "DEFEATCOUNTER INTEGER NOT NULL," +
                "CONQUEROR_THORP INTEGER NOT NULL," +
                "CONQUEROR_THORP_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_THORP_V INTEGER NOT NULL," +
                "CONQUEROR_HAMLET INTEGER NOT NULL," +
                "CONQUEROR_HAMLET_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_HAMLET_V INTEGER NOT NULL," +
                "CONQUEROR_VILLAGE INTEGER NOT NULL," +
                "CONQUEROR_VILLAGE_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_VILLAGE_V INTEGER NOT NULL," +
                "CONQUEROR_SMALL_TOWN INTEGER NOT NULL," +
                "CONQUEROR_SMALL_TOWN_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_SMALL_TOWN_V INTEGER NOT NULL," +
                "CONQUEROR_LARGE_TOWN INTEGER NOT NULL," +
                "CONQUEROR_LARGE_TOWN_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_LARGE_TOWN_V INTEGER NOT NULL," +
                "CONQUEROR_SMALL_CITY INTEGER NOT NULL," +
                "CONQUEROR_SMALL_CITY_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_SMALL_CITY_V INTEGER NOT NULL," +
                "CONQUEROR_LARGE_CITY INTEGER NOT NULL," +
                "CONQUEROR_LARGE_CITY_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_LARGE_CITY_V INTEGER NOT NULL," +
                "CONQUEROR_METROPOLIS INTEGER NOT NULL," +
                "CONQUEROR_METROPOLIS_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_METROPOLIS_V INTEGER NOT NULL," +
                "CONQUEROR_SMALL_NATION INTEGER NOT NULL," +
                "CONQUEROR_SMALL_NATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_SMALL_NATION_V INTEGER NOT NULL," +
                "CONQUEROR_NATION INTEGER NOT NULL," +
                "CONQUEROR_NATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_NATION_V INTEGER NOT NULL," +
                "CONQUEROR_LARGE_NATION INTEGER NOT NULL," +
                "CONQUEROR_LARGE_NATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_LARGE_NATION_V INTEGER NOT NULL," +
                "CONQUEROR_EMPIRE INTEGER NOT NULL," +
                "CONQUEROR_EMPIRE_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_EMPIRE_V INTEGER NOT NULL," +
                "CONQUEROR_CONTINENTAL_EMPIRE INTEGER NOT NULL," +
                "CONQUEROR_CONTINENTAL_EMPIRE_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_CONTINENTAL_EMPIRE_V INTEGER NOT NULL," +
                "CONQUEROR_WORLD_CONFEDERATION INTEGER NOT NULL," +
                "CONQUEROR_WORLD_CONFEDERATION_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_WORLD_CONFEDERATION_V INTEGER NOT NULL," +
                "CONQUEROR_UNITED_WORLD INTEGER NOT NULL," +
                "CONQUEROR_UNITED_WORLD_COUNTER INTEGER NOT NULL," +
                "CONQUEROR_UNITED_WORLD_V INTEGER NOT NULL)";
        db.execSQL(asql);
        asql = "INSERT INTO ACHIEVEMENTS" +
                " (" +
                "THORP ," +
                "THORP_V," +
                "HAMLET ," +
                "HAMLET_V," +
                "VILLAGE ," +
                "VILLAGE_V," +
                "SMALL_TOWN ," +
                "SMALL_TOWN_V," +
                "lARGE_TOWN ," +
                "lARGE_TOWN_V," +
                "SMALL_CITY ," +
                "SMALL_CITY_V," +
                "LARGE_CITY ," +
                "LARGE_CITY_V," +
                "METROPOLIS ," +
                "METROPOLIS_V," +
                "SMALL_NATION ," +
                "SMALL_NATION_V," +
                "NATION ," +
                "NATION_V," +
                "LARGE_NATION ," +
                "LARGE_NATION_V," +
                "EMPIRE ," +
                "EMPIRE_V," +
                "CONTINENTAL_EMPIRE ," +
                "CONTINENTAL_EMPIRE_V," +
                "WORLD_CONFEDERATION ," +
                "WORLD_CONFEDERATION_V," +
                "UNITED_WORLD ," +
                "UNITED_WORLD_V," +
                "RAIDER_ONE," +
                "RAIDER_ONE_V," +
                "RAIDER_TWO," +
                "RAIDER_TWO_V," +
                "RAIDER_THREE," +
                "RAIDER_THREE_V," +
                "RAIDER_FOUR," +
                "RAIDER_FOUR_V," +
                "RAIDER_FIVE," +
                "RAIDER_FIVE_V," +
                "RAIDER_SIX," +
                "RAIDER_SIX_V," +
                "RAIDER_SEVEN," +
                "RAIDER_SEVEN_V," +
                "RAIDER_EIGHT," +
                "RAIDER_EIGHT_V," +
                "RAIDER_NINE," +
                "RAIDER_NINE_V," +
                "RAIDER_TEN," +
                "RAIDER_TEN_V," +
                "DEFEAT_ONE," +
                "DEFEAT_ONE_V," +
                "DEFEAT_TWO," +
                "DEFEAT_TWO_V," +
                "DEFEAT_THREE," +
                "DEFEAT_THREE_V," +
                "DEFEAT_FOUR," +
                "DEFEAT_FOUR_V," +
                "DEFEAT_FIVE," +
                "DEFEAT_FIVE_V," +
                "DEFEAT_SIX," +
                "DEFEAT_SIX_V," +
                "DEFEAT_SEVEN," +
                "DEFEAT_SEVEN_V," +
                "DEFEAT_EIGHT," +
                "DEFEAT_EIGHT_V," +
                "DEFEAT_NINE," +
                "DEFEAT_NINE_V," +
                "DEFEAT_TEN," +
                "DEFEAT_TEN_V," +
                "INVASIONCOUNTER," +
                "DEFEATCOUNTER," +
                "CONQUEROR_THORP," +
                "CONQUEROR_THORP_COUNTER," +
                "CONQUEROR_THORP_V," +
                "CONQUEROR_HAMLET," +
                "CONQUEROR_HAMLET_COUNTER," +
                "CONQUEROR_HAMLET_V," +
                "CONQUEROR_VILLAGE," +
                "CONQUEROR_VILLAGE_COUNTER," +
                "CONQUEROR_VILLAGE_V," +
                "CONQUEROR_SMALL_TOWN," +
                "CONQUEROR_SMALL_TOWN_COUNTER," +
                "CONQUEROR_SMALL_TOWN_V," +
                "CONQUEROR_LARGE_TOWN," +
                "CONQUEROR_LARGE_TOWN_COUNTER," +
                "CONQUEROR_LARGE_TOWN_V," +
                "CONQUEROR_SMALL_CITY," +
                "CONQUEROR_SMALL_CITY_COUNTER," +
                "CONQUEROR_SMALL_CITY_V," +
                "CONQUEROR_LARGE_CITY," +
                "CONQUEROR_LARGE_CITY_COUNTER," +
                "CONQUEROR_LARGE_CITY_V," +
                "CONQUEROR_METROPOLIS," +
                "CONQUEROR_METROPOLIS_COUNTER," +
                "CONQUEROR_METROPOLIS_V," +
                "CONQUEROR_SMALL_NATION," +
                "CONQUEROR_SMALL_NATION_COUNTER," +
                "CONQUEROR_SMALL_NATION_V," +
                "CONQUEROR_NATION," +
                "CONQUEROR_NATION_COUNTER," +
                "CONQUEROR_NATION_V," +
                "CONQUEROR_LARGE_NATION," +
                "CONQUEROR_LARGE_NATION_COUNTER," +
                "CONQUEROR_LARGE_NATION_V," +
                "CONQUEROR_EMPIRE," +
                "CONQUEROR_EMPIRE_COUNTER," +
                "CONQUEROR_EMPIRE_V," +
                "CONQUEROR_CONTINENTAL_EMPIRE," +
                "CONQUEROR_CONTINENTAL_EMPIRE_COUNTER," +
                "CONQUEROR_CONTINENTAL_EMPIRE_V," +
                "CONQUEROR_WORLD_CONFEDERATION," +
                "CONQUEROR_WORLD_CONFEDERATION_COUNTER," +
                "CONQUEROR_WORLD_CONFEDERATION_V," +
                "CONQUEROR_UNITED_WORLD," +
                "CONQUEROR_UNITED_WORLD_COUNTER," +
                "CONQUEROR_UNITED_WORLD_V)" +
                "VALUES (" +
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
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0')";
        db.execSQL(asql);
    }
    public void updateDB(SQLiteDatabase db){
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
                "OCCUPIEDLAND INTEGER NOT NULL," +
                "BASICWEAPONRY INTEGER NOT NULL," +
                "BASICSHIELDS INTEGER NOT NULL," +
                "TENEMENTS INTEGER NOT NULL," +
                "PALISADE INTEGER NOT NULL," +
                "BUTCHERING INTEGER NOT NULL," +
                "GARDENING INTEGER NOT NULL," +
                "EXTRACTION INTEGER NOT NULL," +
                "HORSEBACKRIDING INTEGER NOT NULL," +
                "ARCHITECTURE INTEGER NOT NULL," +
                "FLENSING INTEGER NOT NULL," +
                "MACERATING INTEGER NOT NULL," +
                "CROPROTATION INTEGER NOT NULL," +
                "SELECTIVEBREEDING INTEGER NOT NULL," +
                "FERTILIZERS INTEGER NOT NULL," +
                "SLUMS INTEGER NOT NULL," +
                "SICK INTEGER NOT NULL)";
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
                " OCCUPIEDLAND," +
                " BASICWEAPONRY," +
                " BASICSHIELDS," +
                " TENEMENTS," +
                " PALISADE," +
                " BUTCHERING," +
                " GARDENING," +
                " EXTRACTION," +
                " HORSEBACKRIDING," +
                " ARCHITECTURE," +
                " FLENSING," +
                " MACERATING," +
                " CROPROTATION," +
                " SELECTIVEBREEDING," +
                " FERTILIZERS," +
                " SLUMS," +
                " SICK) " +
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
                "'1000'," +
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
                "'0')";
        db.execSQL(sql);
    }
    public void addAchievementDB(){
        try{
            AchievementShown(CONQUEROR_UNITED_WORLD);
        } catch (SQLException e){
            SQLiteDatabase db = this.getWritableDatabase();
            if (e.getMessage().contains("no such column")){
                Map<String, String> achievements = saveAchievementsDBhelper();
                db.execSQL("DROP TABLE IF EXISTS ACHIEVEMENTS");
                createAchievementDB(db);
                for (Map.Entry<String, String> entry : achievements.entrySet()){
                    String key = entry.getKey();
                    String val = entry.getValue();
                    gameSave.setAchievementDB(key, Integer.parseInt(val));
                }
            }
            else{
                createAchievementDB(db);
            }
        }
        try {
            gameSave.resourceAmountI(SICK);
        }catch (SQLException e){
            SQLiteDatabase db = this.getWritableDatabase();
            Map<String, String> data = gameSave.dbUpdateHelper();
            db.execSQL("DROP TABLE IF EXISTS RESOURCES");
            updateDB(db);
            for (Map.Entry<String, String> entry : data.entrySet()){
                String key = entry.getKey();
                String val = entry.getValue();
                if(key.equals(gameSave.CIVILIZATION_NAME)){
                    gameSave.updateName(val);
                }
                else if((key.equals(gameSave.FOOD))
                        || (key.equals(gameSave.FOOD_MAX))
                        || (key.equals(gameSave.WOOD))
                        || (key.equals(gameSave.WOOD_MAX))
                        || (key.equals(gameSave.STONE))
                        || (key.equals(gameSave.STONE_MAX))){
                    gameSave.set(key, Double.parseDouble(val));
                }
                else{
                    gameSave.set(key, Integer.parseInt(val));
                }
            }
        }
    }
    public boolean setAchievementDB(String res, int amt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(res, amt);
        long result = db.update("ACHIEVEMENTS", contentValues, null, null);
        return result != -1;
    }
    public boolean InvasionCounter(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + INVASIONCOUNTER + " FROM ACHIEVEMENTS WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        double current = 0;
        while(data.moveToNext()){
            current = data.getInt(0);
        }
        data.close();
        current = current + 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(INVASIONCOUNTER, current);
        long result = db.update("ACHIEVEMENTS", contentValues, null, null);
        return result != -1;
    }
    public boolean invadeCiv(String civ){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + civ + "_COUNTER FROM ACHIEVEMENTS WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        double current = 0;
        while(data.moveToNext()){
            current = data.getInt(0);
        }
        data.close();
        current = current + 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(civ + "_COUNTER", current);
        long result = db.update("ACHIEVEMENTS", contentValues, null, null);
        return result != -1;
    }
    public int NumCivInv(String civ){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ civ + "_COUNTER FROM ACHIEVEMENTS WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        int x = 0;
        while(data.moveToNext()){
            x = data.getInt(0);
        }
        data.close();
        return x;
    }
    public boolean DefeatCounter(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + DEFEATCOUNTER + " FROM ACHIEVEMENTS WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        double current = 0;
        while(data.moveToNext()){
            current = data.getInt(0);
        }
        data.close();
        current = current + 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DEFEATCOUNTER, current);
        long result = db.update("ACHIEVEMENTS", contentValues, null, null);
        return result != -1;
    }
    public boolean UnlockAchievement(String res){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(res, 1);
        long result = db.update("ACHIEVEMENTS", contentValues, null, null);
        return result != -1;
    }
    public boolean ShowAchievement(String res){
        String res2 = res + "_V";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(res2, 1);
        long result = db.update("ACHIEVEMENTS", contentValues, null, null);
        return result != -1;
    }
    public boolean AchievementShown(String res){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ res + "_V FROM ACHIEVEMENTS WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        int x = 0;
        while(data.moveToNext()){
            x = data.getInt(0);
        }
        data.close();
        return x == 1;
    }
    public int NumDefInv(int i){
        String res;
        if(i == 1){
            res = INVASIONCOUNTER;
        }
        else {
            res = DEFEATCOUNTER;
        }
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ res + " FROM ACHIEVEMENTS WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        int x = 0;
        while(data.moveToNext()){
            x = data.getInt(0);
        }
        data.close();
        return x;
    }
    public boolean updateNoMax(String res, double amt) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT " + res + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql, null);
        double current = 0;
        while (data.moveToNext()) {
            current = data.getDouble(0);
        }
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
        double current = 0;
        double max = 0;
        while(data.moveToNext()){
            current = data.getDouble(0);
            max = data.getDouble(1);
        }
        data.close();
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
        double max = 0;
        while(data.moveToNext()){
            max = data.getDouble(0);
        }
        data.close();
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
        int current = 0;
        while(data.moveToNext()){
            current = data.getInt(0);
        }
        data.close();
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
    public double resourceAmountD(String res){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ res + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        double x = 0;
        while(data.moveToNext()){
            x = data.getDouble(0);
        }
        data.close();
        return x;
    }
    public int resourceAmountI(String res){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ res + " FROM " + RESOURCES + " WHERE ID = 1";
        Cursor data = db.rawQuery(sql,null);
        int x = 0;
        while(data.moveToNext()){
            x = data.getInt(0);
        }
        data.close();
        return x;
    }
    public String civName(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT "+ CIVILIZATION_NAME + " FROM " + RESOURCES + " WHERE ID = 1";
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
        db.execSQL("DROP TABLE IF EXISTS ACHIEVEMENTS");
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
    public Map<String, String> dbUpdateHelper(){
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
            buffer.append(data.getString(49));buffer.append(",");
            buffer.append(data.getString(50));buffer.append(",");
            buffer.append(data.getString(51));buffer.append(",");
            buffer.append(data.getString(52));buffer.append(",");
            buffer.append(data.getString(53));buffer.append(",");
            buffer.append(data.getString(54));buffer.append(",");
            buffer.append(data.getString(55));buffer.append(",");
            buffer.append(data.getString(56));buffer.append(",");
            buffer.append(data.getString(57));buffer.append(",");
            buffer.append(data.getString(58));buffer.append(",");
            buffer.append(data.getString(59));buffer.append(",");
            buffer.append(data.getString(60));buffer.append(",");
            buffer.append(data.getString(61));buffer.append(",");
            buffer.append(data.getString(62));buffer.append(",");
            buffer.append(data.getString(63));buffer.append(",");
            buffer.append(data.getString(64));

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
        map.put(BASICWEAPONRY, save[49]);
        map.put(BASICSHIELDS, save[50]);
        map.put(TENEMENTS, save[51]);
        map.put(PALISADE, save[52]);
        map.put(BUTCHERING, save[53]);
        map.put(GARDENING, save[54]);
        map.put(EXTRACTION, save[55]);
        map.put(HORSEBACKRIDING, save[56]);
        map.put(ARCHITECTURE, save[57]);
        map.put(FLENSING, save[58]);
        map.put(MACERATING, save[59]);
        map.put(CROPROTATION, save[60]);
        map.put(SELECTIVEBREEDING, save[61]);
        map.put(FERTILIZERS, save[62]);
        map.put(SLUMS, save[63]);

        return map;
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
            buffer.append(data.getString(49));buffer.append(",");
            buffer.append(data.getString(50));buffer.append(",");
            buffer.append(data.getString(51));buffer.append(",");
            buffer.append(data.getString(52));buffer.append(",");
            buffer.append(data.getString(53));buffer.append(",");
            buffer.append(data.getString(54));buffer.append(",");
            buffer.append(data.getString(55));buffer.append(",");
            buffer.append(data.getString(56));buffer.append(",");
            buffer.append(data.getString(57));buffer.append(",");
            buffer.append(data.getString(58));buffer.append(",");
            buffer.append(data.getString(59));buffer.append(",");
            buffer.append(data.getString(60));buffer.append(",");
            buffer.append(data.getString(61));buffer.append(",");
            buffer.append(data.getString(62));buffer.append(",");
            buffer.append(data.getString(63));buffer.append(",");
            buffer.append(data.getString(64));buffer.append(",");
            buffer.append(data.getString(65));

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
        map.put(BASICWEAPONRY, save[49]);
        map.put(BASICSHIELDS, save[50]);
        map.put(TENEMENTS, save[51]);
        map.put(PALISADE, save[52]);
        map.put(BUTCHERING, save[53]);
        map.put(GARDENING, save[54]);
        map.put(EXTRACTION, save[55]);
        map.put(HORSEBACKRIDING, save[56]);
        map.put(ARCHITECTURE, save[57]);
        map.put(FLENSING, save[58]);
        map.put(MACERATING, save[59]);
        map.put(CROPROTATION, save[60]);
        map.put(SELECTIVEBREEDING, save[61]);
        map.put(FERTILIZERS, save[62]);
        map.put(SLUMS, save[63]);
        map.put(SICK, save[64]);

        return map;
    }
    public Map<String, String> saveAchievements(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM ACHIEVEMENTS WHERE ID = 1";
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
            buffer.append(data.getString(49));buffer.append(",");
            buffer.append(data.getString(50));buffer.append(",");
            buffer.append(data.getString(51));buffer.append(",");
            buffer.append(data.getString(52));buffer.append(",");
            buffer.append(data.getString(53));buffer.append(",");
            buffer.append(data.getString(54));buffer.append(",");
            buffer.append(data.getString(55));buffer.append(",");
            buffer.append(data.getString(56));buffer.append(",");
            buffer.append(data.getString(57));buffer.append(",");
            buffer.append(data.getString(58));buffer.append(",");
            buffer.append(data.getString(59));buffer.append(",");
            buffer.append(data.getString(60));buffer.append(",");
            buffer.append(data.getString(61));buffer.append(",");
            buffer.append(data.getString(62));buffer.append(",");
            buffer.append(data.getString(63));buffer.append(",");
            buffer.append(data.getString(64));buffer.append(",");
            buffer.append(data.getString(65));buffer.append(",");
            buffer.append(data.getString(66));buffer.append(",");
            buffer.append(data.getString(67));buffer.append(",");
            buffer.append(data.getString(68));buffer.append(",");
            buffer.append(data.getString(69));buffer.append(",");
            buffer.append(data.getString(70));buffer.append(",");
            buffer.append(data.getString(71));buffer.append(",");
            buffer.append(data.getString(72));buffer.append(",");
            buffer.append(data.getString(73));buffer.append(",");
            buffer.append(data.getString(74));buffer.append(",");
            buffer.append(data.getString(75));buffer.append(",");
            buffer.append(data.getString(76));buffer.append(",");
            buffer.append(data.getString(77));buffer.append(",");
            buffer.append(data.getString(78));buffer.append(",");
            buffer.append(data.getString(79));buffer.append(",");
            buffer.append(data.getString(80));buffer.append(",");
            buffer.append(data.getString(81));buffer.append(",");
            buffer.append(data.getString(82));buffer.append(",");
            buffer.append(data.getString(83));buffer.append(",");
            buffer.append(data.getString(84));buffer.append(",");
            buffer.append(data.getString(85));buffer.append(",");
            buffer.append(data.getString(86));buffer.append(",");
            buffer.append(data.getString(87));buffer.append(",");
            buffer.append(data.getString(88));buffer.append(",");
            buffer.append(data.getString(89));buffer.append(",");
            buffer.append(data.getString(90));buffer.append(",");
            buffer.append(data.getString(91));buffer.append(",");
            buffer.append(data.getString(92));buffer.append(",");
            buffer.append(data.getString(93));buffer.append(",");
            buffer.append(data.getString(94));buffer.append(",");
            buffer.append(data.getString(95));



        }
        data.close();
        Map<String, String> map = new HashMap<String, String>();
        String save[] = buffer.toString().split(",");
        map.put(THORP, save[0]);
        map.put(THORP + "_V", save[1]);
        map.put(HAMLET, save[2]);
        map.put(HAMLET + "_V", save[3]);
        map.put(VILLAGE, save[4]);
        map.put(VILLAGE + "_V", save[5]);
        map.put(SMALL_TOWN, save[6]);
        map.put(SMALL_TOWN + "_V", save[7]);
        map.put(LARGE_TOWN, save[8]);
        map.put(LARGE_TOWN + "_V", save[9]);
        map.put(SMALL_CITY, save[10]);
        map.put(SMALL_CITY + "_V", save[11]);
        map.put(LARGE_CITY, save[12]);
        map.put(LARGE_CITY + "_V", save[13]);
        map.put(METROPOLIS, save[14]);
        map.put(METROPOLIS + "_V", save[15]);
        map.put(SMALL_NATION, save[16]);
        map.put(SMALL_NATION + "_V", save[17]);
        map.put(NATION, save[18]);
        map.put(NATION + "_V", save[19]);
        map.put(LARGE_NATION, save[20]);
        map.put(LARGE_NATION + "_V", save[21]);
        map.put(EMPIRE, save[22]);
        map.put(EMPIRE + "_V", save[23]);
        map.put(CONTINENTAL_EMPIRE, save[24]);
        map.put(CONTINENTAL_EMPIRE + "_V", save[25]);
        map.put(WORLD_CONFEDERATION, save[26]);
        map.put(WORLD_CONFEDERATION + "_V", save[27]);
        map.put(UNITED_WORLD, save[28]);
        map.put(UNITED_WORLD + "_V", save[29]);
        map.put(RAIDER_ONE, save[30]);
        map.put(RAIDER_ONE + "_V", save[31]);
        map.put(RAIDER_TWO, save[32]);
        map.put(RAIDER_TWO + "_V", save[33]);
        map.put(RAIDER_THREE, save[34]);
        map.put(RAIDER_THREE + "_V", save[35]);
        map.put(RAIDER_FOUR, save[36]);
        map.put(RAIDER_FOUR + "_V", save[37]);
        map.put(RAIDER_FIVE, save[38]);
        map.put(RAIDER_FIVE + "_V", save[39]);
        map.put(RAIDER_SIX, save[40]);
        map.put(RAIDER_SIX + "_V", save[41]);
        map.put(RAIDER_SEVEN, save[42]);
        map.put(RAIDER_SEVEN + "_V", save[43]);
        map.put(RAIDER_EIGHT, save[44]);
        map.put(RAIDER_EIGHT + "_V", save[45]);
        map.put(RAIDER_NINE, save[46]);
        map.put(RAIDER_NINE + "_V", save[47]);
        map.put(RAIDER_TEN, save[48]);
        map.put(RAIDER_TEN + "_V", save[49]);
        map.put(INVASIONCOUNTER, save[50]);
        map.put(DEFEATCOUNTER, save[51]);
        map.put(CONQUEROR_THORP, save[52]);
        map.put(CONQUEROR_THORP_COUNTER, save[53]);
        map.put(CONQUEROR_THORP + "_V", save[54]);
        map.put(CONQUEROR_HAMLET, save[55]);
        map.put(CONQUEROR_HAMLET_COUNTER, save[56]);
        map.put(CONQUEROR_HAMLET + "_V", save[57]);
        map.put(CONQUEROR_VILLAGE, save[58]);
        map.put(CONQUEROR_VILLAGE_COUNTER, save[59]);
        map.put(CONQUEROR_VILLAGE + "_V", save[60]);
        map.put(CONQUEROR_SMALL_TOWN, save[61]);
        map.put(CONQUEROR_SMALL_TOWN_COUNTER, save[62]);
        map.put(CONQUEROR_SMALL_TOWN + "_V", save[63]);
        map.put(CONQUEROR_LARGE_TOWN, save[64]);
        map.put(CONQUEROR_LARGE_TOWN_COUNTER, save[65]);
        map.put(CONQUEROR_LARGE_TOWN + "_V", save[66]);
        map.put(CONQUEROR_SMALL_CITY, save[67]);
        map.put(CONQUEROR_SMALL_CITY_COUNTER, save[68]);
        map.put(CONQUEROR_SMALL_CITY + "_V", save[69]);
        map.put(CONQUEROR_LARGE_CITY, save[70]);
        map.put(CONQUEROR_LARGE_CITY_COUNTER, save[71]);
        map.put(CONQUEROR_LARGE_CITY + "_V", save[72]);
        map.put(CONQUEROR_METROPOLIS, save[73]);
        map.put(CONQUEROR_METROPOLIS_COUNTER, save[74]);
        map.put(CONQUEROR_METROPOLIS + "_V", save[75]);
        map.put(CONQUEROR_SMALL_NATION, save[76]);
        map.put(CONQUEROR_SMALL_NATION_COUNTER, save[77]);
        map.put(CONQUEROR_SMALL_NATION + "_V", save[78]);
        map.put(CONQUEROR_NATION, save[79]);
        map.put(CONQUEROR_NATION_COUNTER, save[80]);
        map.put(CONQUEROR_NATION + "_V", save[81]);
        map.put(CONQUEROR_LARGE_NATION, save[82]);
        map.put(CONQUEROR_LARGE_NATION_COUNTER, save[83]);
        map.put(CONQUEROR_LARGE_NATION + "_V", save[84]);
        map.put(CONQUEROR_EMPIRE, save[85]);
        map.put(CONQUEROR_EMPIRE_COUNTER, save[86]);
        map.put(CONQUEROR_EMPIRE + "_V", save[87]);
        map.put(CONQUEROR_CONTINENTAL_EMPIRE, save[88]);
        map.put(CONQUEROR_CONTINENTAL_EMPIRE_COUNTER, save[89]);
        map.put(CONQUEROR_CONTINENTAL_EMPIRE + "_V", save[90]);
        map.put(CONQUEROR_WORLD_CONFEDERATION, save[91]);
        map.put(CONQUEROR_WORLD_CONFEDERATION_COUNTER, save[92]);
        map.put(CONQUEROR_WORLD_CONFEDERATION + "_V", save[93]);
        map.put(CONQUEROR_UNITED_WORLD, save[94]);
        map.put(CONQUEROR_UNITED_WORLD_COUNTER, save[95]);
        map.put(CONQUEROR_UNITED_WORLD + "_V", save[96]);

        return map;
    }
    public Map<String, String> saveAchievementsDBhelper(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM ACHIEVEMENTS WHERE ID = 1";
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
            buffer.append(data.getString(49));buffer.append(",");
            buffer.append(data.getString(50));buffer.append(",");
            buffer.append(data.getString(51));buffer.append(",");
            buffer.append(data.getString(52));

        }
        data.close();
        Map<String, String> map = new HashMap<String, String>();
        String save[] = buffer.toString().split(",");
        map.put(THORP, save[0]);
        map.put(THORP + "_V", save[1]);
        map.put(HAMLET, save[2]);
        map.put(HAMLET + "_V", save[3]);
        map.put(VILLAGE, save[4]);
        map.put(VILLAGE + "_V", save[5]);
        map.put(SMALL_TOWN, save[6]);
        map.put(SMALL_TOWN + "_V", save[7]);
        map.put(LARGE_TOWN, save[8]);
        map.put(LARGE_TOWN + "_V", save[9]);
        map.put(SMALL_CITY, save[10]);
        map.put(SMALL_CITY + "_V", save[11]);
        map.put(LARGE_CITY, save[12]);
        map.put(LARGE_CITY + "_V", save[13]);
        map.put(METROPOLIS, save[14]);
        map.put(METROPOLIS + "_V", save[15]);
        map.put(SMALL_NATION, save[16]);
        map.put(SMALL_NATION + "_V", save[17]);
        map.put(NATION, save[18]);
        map.put(NATION + "_V", save[19]);
        map.put(LARGE_NATION, save[20]);
        map.put(LARGE_NATION + "_V", save[21]);
        map.put(EMPIRE, save[22]);
        map.put(EMPIRE + "_V", save[23]);
        map.put(CONTINENTAL_EMPIRE, save[24]);
        map.put(CONTINENTAL_EMPIRE + "_V", save[25]);
        map.put(WORLD_CONFEDERATION, save[26]);
        map.put(WORLD_CONFEDERATION + "_V", save[27]);
        map.put(UNITED_WORLD, save[28]);
        map.put(UNITED_WORLD + "_V", save[29]);
        map.put(RAIDER_ONE, save[30]);
        map.put(RAIDER_ONE + "_V", save[31]);
        map.put(RAIDER_TWO, save[32]);
        map.put(RAIDER_TWO + "_V", save[33]);
        map.put(RAIDER_THREE, save[34]);
        map.put(RAIDER_THREE + "_V", save[35]);
        map.put(RAIDER_FOUR, save[36]);
        map.put(RAIDER_FOUR + "_V", save[37]);
        map.put(RAIDER_FIVE, save[38]);
        map.put(RAIDER_FIVE + "_V", save[39]);
        map.put(RAIDER_SIX, save[40]);
        map.put(RAIDER_SIX + "_V", save[41]);
        map.put(RAIDER_SEVEN, save[42]);
        map.put(RAIDER_SEVEN + "_V", save[43]);
        map.put(RAIDER_EIGHT, save[44]);
        map.put(RAIDER_EIGHT + "_V", save[45]);
        map.put(RAIDER_NINE, save[46]);
        map.put(RAIDER_NINE + "_V", save[47]);
        map.put(RAIDER_TEN, save[48]);
        map.put(RAIDER_TEN + "_V", save[49]);
        map.put(INVASIONCOUNTER, save[50]);
        map.put(DEFEATCOUNTER, save[51]);

        return map;
    }
}
