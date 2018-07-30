package not.bored.clickerempire;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements buildings.buildingBuilder, jobs.employmentOffice, upgrades.upgrade,
        specialResources.specialResourcesListener, upgradedJobs.upgradedemploymentOffice,
        ECIjobs.ECIemploymentOffice, ECIupgradedjobs.ECIemploymentOffice, ECIbuildings.buildingBuilder,
        conquest.army, ECIconquest.army{
    GameSave gameSave = GameSave.getGameSave(this);
    int workerCost = 20;
    double workerConsume = -1;
    double workerProduce = 1.4;
    double workerWoodProduction = .4;
    double workerStoneProduction = .2;
    double barnMax = 200;
    double SoldierAttackSpeed = .05;
    double CavalryAttackSpeed = .11;
    int counter = 0;
    private DrawerLayout mDrawerLayout;
    DecimalFormat df = new DecimalFormat("0.0");
    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (thread != null) {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            counter = (counter + 1)%5;
                            WorkSpecialResource(counter);
                            double farm = consume();
                            TextView food = findViewById(R.id.num_food);
                            TextView foodspeed = findViewById(R.id.FOOD);
                            workerCollect(food, gameSave.FOOD, farm, foodspeed);
                            killWorkers(farm);
                            populationControl();
                            setUnemployed();
                            double lumberjacks = Double.parseDouble(workerAmount(gameSave.LUMBERJACKS));
                            TextView wood = findViewById(R.id.num_wood);
                            TextView woodspeed = findViewById(R.id.WOOD);
                            workerCollect(wood, gameSave.WOOD, lumberjacks * workerWoodProduction, woodspeed);
                            double stonemasons = Double.parseDouble(workerAmount(gameSave.STONEMASONS));
                            TextView stone = findViewById(R.id.num_stone);
                            TextView stonespeed = findViewById(R.id.STONE);
                            workerCollect(stone, gameSave.STONE, stonemasons * workerStoneProduction, stonespeed);
                            ActionBar actionBar = getSupportActionBar();
                            String name = civType() + " of " + gameSave.resourceAmount(gameSave.CIVILIZATION_NAME);
                            actionBar.setTitle(name);
                            TextView land = findViewById(R.id.land);
                            String l = "Land: " + gameSave.resourceAmount(gameSave.OCCUPIEDLAND) + "/" + gameSave.resourceAmount(gameSave.LAND);
                            land.setText(l);
                        }
                    });
                }
            } catch (InterruptedException e) {
                Toast.makeText(MainActivity.this,"Paused", Toast.LENGTH_LONG).show();
            }
        }
    };
    Thread conquestthread = new Thread() {
        @Override
        public void run() {
            try {
                while (conquestthread != null) {
                    Thread.sleep(100);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView land = findViewById(R.id.land);
                            String l = "Land: " + gameSave.resourceAmount(gameSave.OCCUPIEDLAND) + "/" + gameSave.resourceAmount(gameSave.LAND);
                            land.setText(l);
                        }
                    });
                }
            } catch (InterruptedException e) {
                Toast.makeText(MainActivity.this,"Paused", Toast.LENGTH_LONG).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        gameSave.resetdb();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        String o = intent.getStringExtra("rename");
        if((o != null) && (o.equals("rename"))){
            String newcivname = intent.getStringExtra("newcivName");
            gameSave.updateName(newcivname);
            String name = civType() + " of " + newcivname;
            actionbar.setTitle(name);
        }
        Button collect_food = findViewById(R.id.collect_food);
        Button collect_wood = findViewById(R.id.collect_wood);
        Button collect_stone = findViewById(R.id.collect_stone);
        Button reset = findViewById(R.id.resetdb);
        Button createWorkers = findViewById(R.id.create_worker);
        Button add_worker = findViewById(R.id.add_worker);
        Button substract_worker = findViewById(R.id.substract_worker);
        setScreen(actionbar);
        final Button buildings = findViewById(R.id.buildings);
        final Button upgrades = findViewById(R.id.upgrades);
        final Button jobs = findViewById(R.id.jobs);
        final Button specialRes = findViewById(R.id.specialresources);
        final Button conquest = findViewById(R.id.conquest);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSave.resetdb();
                ActionBar actionbar = getSupportActionBar();
                setScreen(actionbar);
            }
        });
        collect_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_food = findViewById(R.id.num_food);
                collect(num_food, "FOOD", 1);
                boolean val = new Random().nextInt(9)==0;
                if(val){
                    gameSave.updateNoMax(gameSave.SKINS,1);
                }
            }
        });
        collect_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_wood = findViewById(R.id.num_wood);
                collect(num_wood,gameSave.WOOD, 1);
                boolean val = new Random().nextInt(9)==0;
                if(val){
                    gameSave.updateNoMax(gameSave.HERBS,1);
                }
            }
        });
        collect_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_stone = findViewById(R.id.num_stone);
                collect(num_stone, gameSave.STONE, 1);
                boolean val = new Random().nextInt(9)==0;
                if(val){
                    gameSave.updateNoMax(gameSave.ORE,1);
                }
            }
        });
        buildings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(buildings);
            }
        });
        specialRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(specialRes);
            }
        });
        upgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(upgrades);
            }
        });
        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(jobs);
            }
        });
        conquest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(conquest);
            }
        });
        createWorkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView population = findViewById(R.id.population);
                EditText num_workers = findViewById(R.id.num_workers);
                int amt;
                if(num_workers.getText().toString().equals("")){
                    amt = 0;
                }
                else{
                    amt = Integer.parseInt(num_workers.getText().toString());
                }
                if(amt != 0){
                    createWorker(population, amt);
                }
            }
        });
        add_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num_workers = findViewById(R.id.num_workers);
                int amt = Integer.parseInt(num_workers.getText().toString());
                amt++;
                String a = "" + amt;
                num_workers.setText(a);
            }
        });
        substract_worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num_workers = findViewById(R.id.num_workers);
                int amt = Integer.parseInt(num_workers.getText().toString());
                amt--;
                if(amt>=1){
                    String a = "" + amt;
                    num_workers.setText(a);
                }
            }
        });
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // set item as selected to persist highlight
                item.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                int id = item.getItemId();

                if (id == R.id.rename) {
                    pause();
                    Intent rename = new Intent(getApplicationContext(), Rename.class);
                    String name = gameSave.resourceAmount(gameSave.CIVILIZATION_NAME);
                    rename.putExtra("name", name);
                    startActivity(rename);
                }
                else if (id == R.id.save_game){
                    pause();
                    AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
                    aBuilder.setMessage("Saving game will overwrite previous save game data. Are you sure you want to save?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this,"Game saved", Toast.LENGTH_SHORT).show();
                                    saveGame();
                                    resume();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    resume();
                                }
                            });
                    AlertDialog alert = aBuilder.create();
                    alert.setTitle("Save Game");
                    alert.show();
                }
                else if (id == R.id.load_game){
                    pause();
                    AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
                    aBuilder.setMessage("Loading game will overwrite game progress. Are you sure you want to load?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(MainActivity.this,"Game loaded", Toast.LENGTH_SHORT).show();
                                    loadGame();
//                                    gameSave.updateNoMax(gameSave.LAND,1000000000);
                                    resume();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    resume();
                                }
                            });
                    AlertDialog alert = aBuilder.create();
                    alert.setTitle("Save Game");
                    alert.show();
                }
                else if (id == R.id.pause) {
                    Toast.makeText(MainActivity.this,"Paused", Toast.LENGTH_LONG).show();
                    pause();
                }
                else if (id == R.id.resume) {
                    resume();
                }
                else if (id == R.id.enablecustomincrememtns) {
                    NavigationView navigationView = findViewById(R.id.nav_view);
                    Menu menu = navigationView.getMenu();
                    MenuItem enablecustomincrements = menu.findItem(R.id.enablecustomincrememtns);
                    if(ECI()){
                        gameSave.setECIunchecked();
                        enablecustomincrements.setTitle("Enable Custom Increments: Disabled");
                        Fragment buildings = getSupportFragmentManager().findFragmentByTag("ECIbuildings");
                        Fragment conquest = getSupportFragmentManager().findFragmentByTag("ECIconquest");
                        if(buildings != null && buildings.isVisible()){
                            buildings = new buildings();
                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fragment, buildings, "buildings");
                            ft.commit();

                        }
                        else if(conquest != null && conquest.isVisible()){
                            conquest = new conquest();
                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fragment, conquest, "conquest");
                            ft.commit();
                        }
                        else if(checkMUpgrade()){
                            Fragment fragment = getSupportFragmentManager().findFragmentByTag("ECIupgradedJobs");
                            if (fragment!=null  && fragment.isVisible()){
                                fragment = new upgradedJobs();
                                FragmentManager fm = getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.fragment, fragment, "upgradedJobs");
                                ft.commit();
                            }
                        }
                        else{
                            Fragment fragment = getSupportFragmentManager().findFragmentByTag("ECIjobs");
                            if (fragment!=null  && fragment.isVisible()){
                                fragment = new jobs();
                                FragmentManager fm = getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.fragment, fragment, "jobs");
                                ft.commit();
                            }
                        }

                    }
                    else{
                        gameSave.setECIchecked();
                        enablecustomincrements.setTitle("Enable Custom Increments: Enabled");
                        Fragment buildings = getSupportFragmentManager().findFragmentByTag("buildings");
                        Fragment conquest = getSupportFragmentManager().findFragmentByTag("conquest");
                        if(buildings != null && buildings.isVisible()){
                            buildings = new ECIbuildings();
                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fragment, buildings, "ECIbuildings");
                            ft.commit();
                        }
                        else if(conquest != null && conquest.isVisible()){
                            conquest = new ECIconquest();
                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.fragment, conquest, "ECIconquest");
                            ft.commit();
                        }
                        else if(checkMUpgrade()){
                            Fragment fragment = getSupportFragmentManager().findFragmentByTag("upgradedJobs");
                            if (fragment!=null  && fragment.isVisible()){
                                fragment = new ECIupgradedjobs();
                                FragmentManager fm = getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.fragment, fragment, "ECIupgradedJobs");
                                ft.commit();
                            }
                        }
                        else{
                            Fragment fragment = getSupportFragmentManager().findFragmentByTag("jobs");
                            if (fragment!=null  && fragment.isVisible()){
                                fragment = new ECIjobs();
                                FragmentManager fm = getSupportFragmentManager();
                                FragmentTransaction ft = fm.beginTransaction();
                                ft.replace(R.id.fragment, fragment, "ECIjobs");
                                ft.commit();
                            }
                        }
                    }
                }
                else if (id == R.id.purchasedUpgrades){
                    Intent intent = new Intent(MainActivity.this,purchasedUpgrades.class);
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.SKINNING)) == 1 ){
                        intent.putExtra(gameSave.SKINNING,gameSave.SKINNING);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.HARVESTING)) == 1 ){
                        intent.putExtra(gameSave.HARVESTING,gameSave.HARVESTING);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.PROSPECTING)) == 1 ){
                        intent.putExtra(gameSave.PROSPECTING,gameSave.PROSPECTING);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.MASONRY)) == 1 ){
                        intent.putExtra(gameSave.SKINNING,gameSave.MASONRY);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.DOMESTICATION)) == 1 ){
                        intent.putExtra(gameSave.DOMESTICATION,gameSave.DOMESTICATION);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.PLOUGHSHARES)) == 1 ){
                        intent.putExtra(gameSave.PLOUGHSHARES,gameSave.PLOUGHSHARES);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.IRRIGATION)) == 1 ){
                        intent.putExtra(gameSave.IRRIGATION,gameSave.IRRIGATION);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.CONSTRUCTION)) == 1 ){
                        intent.putExtra(gameSave.CONSTRUCTION,gameSave.CONSTRUCTION);
                    }
                    if(Integer.parseInt(gameSave.resourceAmount(gameSave.GRANARIES)) == 1 ){
                        intent.putExtra(gameSave.GRANARIES,gameSave.GRANARIES);
                    }
                    startActivity(intent);
                }
                return true;
            }
        });
        changeFragment(jobs);
        thread.start();
        conquestthread.start();
    }

    public void pause(){
        thread = null;
        conquestthread= null;
    }

    @Override
    public void onStop() {
        super.onStop();
        thread = null;
        conquestthread= null;
    }
    @Override
    public void onStart(){
        super.onStart();
        resume();
    }

    public void resume(){
        if(thread == null){
            thread = new Thread() {
                @Override
                public void run() {
                    try {
                        while (thread != null) {
                            Thread.sleep(1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    counter = (counter + 1)%5;
                                    WorkSpecialResource(counter);
                                    double farm = consume();
                                    TextView food = findViewById(R.id.num_food);
                                    TextView foodspeed = findViewById(R.id.FOOD);
                                    workerCollect(food, gameSave.FOOD, farm, foodspeed);
                                    killWorkers(farm);
                                    populationControl();
                                    setUnemployed();
                                    double lumberjacks = Double.parseDouble(workerAmount(gameSave.LUMBERJACKS));
                                    TextView wood = findViewById(R.id.num_wood);
                                    TextView woodspeed = findViewById(R.id.WOOD);
                                    workerCollect(wood, gameSave.WOOD, lumberjacks * workerWoodProduction, woodspeed);
                                    double stonemasons = Double.parseDouble(workerAmount(gameSave.STONEMASONS));
                                    TextView stone = findViewById(R.id.num_stone);
                                    TextView stonespeed = findViewById(R.id.STONE);
                                    workerCollect(stone, gameSave.STONE, stonemasons * workerStoneProduction, stonespeed);
                                    ActionBar actionBar = getSupportActionBar();
                                    String name = civType() + " of " + gameSave.resourceAmount(gameSave.CIVILIZATION_NAME);
                                    actionBar.setTitle(name);
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        Toast.makeText(MainActivity.this,"Paused", Toast.LENGTH_LONG).show();
                    }
                }
            };
            thread.start();
        }
        if(conquestthread==null){
            conquestthread = new Thread() {
                @Override
                public void run() {
                    try {
                        while (conquestthread != null) {
                            Thread.sleep(100);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    TextView land = findViewById(R.id.land);
                                    String l = "Land: " + gameSave.resourceAmount(gameSave.OCCUPIEDLAND) + "/" + gameSave.resourceAmount(gameSave.LAND);
                                    land.setText(l);
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        Toast.makeText(MainActivity.this,"Paused", Toast.LENGTH_LONG).show();
                    }
                }
            };
            conquestthread.start();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void saveGame(){
        SharedPreferences saveGame = getSharedPreferences("saveGame",MODE_PRIVATE);
        SharedPreferences.Editor editor = saveGame.edit();
        editor.clear();
        editor.apply();
        Map<String, String> map = gameSave.save();
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
            editor.putString(key, val);
        }
        editor.apply();
    }
    public void loadGame(){
        SharedPreferences loadGame = getSharedPreferences("saveGame", MODE_PRIVATE);
        Map<String, String> map = (Map<String, String>) loadGame.getAll();
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
            if(key.equals(gameSave.CIVILIZATION_NAME)){
                gameSave.updateName(val);
            }
            else if((key.equals(gameSave.FOOD)) || (key.equals(gameSave.FOOD_MAX)) || (key.equals(gameSave.WOOD)) || (key.equals(gameSave.WOOD_MAX)) || (key.equals(gameSave.STONE)) || (key.equals(gameSave.STONE_MAX))){
                gameSave.set(key, Double.parseDouble(val));
            }
            else{
                gameSave.set(key, Integer.parseInt(val));
            }
        }
        setScreen(getSupportActionBar());
    }
    public void setScreen(ActionBar actionBar) {
        String pop = "Population: " + gameSave.resourceAmount(gameSave.POPULATION) + "/" + gameSave.resourceAmount(gameSave.POPULATION_MAX);
        String unemployed = "Unemployed: " + gameSave.resourceAmount(gameSave.UNEMPLOYED);
        String food = gameSave.resourceAmount(gameSave.FOOD) + "/" + gameSave.resourceAmount(gameSave.FOOD_MAX);
        String wood = gameSave.resourceAmount(gameSave.WOOD) + "/" + gameSave.resourceAmount(gameSave.WOOD_MAX);
        String stone = gameSave.resourceAmount(gameSave.STONE) + "/" + gameSave.resourceAmount(gameSave.STONE_MAX);
        TextView poptv = findViewById(R.id.population);
        TextView unemployedtv = findViewById(R.id.unemployed);
        TextView foodtv = findViewById(R.id.num_food);
        TextView woodtv = findViewById(R.id.num_wood);
        TextView stonetv = findViewById(R.id.num_stone);
        poptv.setText(pop);
        unemployedtv.setText(unemployed);
        foodtv.setText(food);
        woodtv.setText(wood);
        stonetv.setText(stone);
        String civName = civType() + " of " + gameSave.resourceAmount(gameSave.CIVILIZATION_NAME);
        actionBar.setTitle(civName);
        if (checkUpgrade(gameSave.GRANARIES)) {
            barnMax = 400;
        }
        int i = Integer.parseInt(gameSave.resourceAmount(gameSave.IRRIGATION)) + Integer.parseInt(gameSave.resourceAmount(gameSave.DOMESTICATION)) + Integer.parseInt(gameSave.resourceAmount(gameSave.PLOUGHSHARES));
        switch (Integer.parseInt(gameSave.resourceAmount(gameSave.FARMERPRODUCTIONLEVEL))) {
            case 1:
                workerProduce = 1.5;
                break;
            case 2:
                workerProduce = 1.6;
                break;
            case 3:
                workerProduce = 1.7;
                break;
            default:
                workerProduce = 1.4;
                break;
        }
    }
    public void changeFragment(View view){
        Fragment fragment;
        if(view == findViewById(R.id.buildings)){
            if(ECI()){
                fragment = new ECIbuildings();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment, fragment,"ECIbuildings");
                ft.commit();
            }
            else{
                fragment = new buildings();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment, fragment,"buildings");
                ft.commit();
            }
        }
        else if(view == findViewById(R.id.upgrades)){
            fragment = new upgrades();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
        }
        else if(view == findViewById(R.id.jobs)){
            if(checkMUpgrade()){
                if(ECI()){
                    fragment = new ECIupgradedjobs();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment, fragment, "ECIugradedJobs");
                    ft.commit();
                }
                else{
                    fragment = new upgradedJobs();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment, fragment, "upgradedJobs");
                    ft.commit();
                }
            }
            else {
                if(ECI()){
                    fragment = new ECIjobs();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment, fragment, "ECIjobs");
                    ft.commit();
                }
                else{
                    fragment = new jobs();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment, fragment, "jobs");
                    ft.commit();
                }
            }
        }
        else if(view == findViewById(R.id.specialresources)){
            fragment = new specialResources();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
        }
        else if(view == findViewById(R.id.conquest)){
            if(ECI()){
                fragment = new ECIconquest();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment, fragment, "ECIconquest");
                ft.commit();
            }
            else{
                fragment = new conquest();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment, fragment, "conquest");
                ft.commit();
            }
        }
    }
    public void createWorker(TextView pop, int amt){
        int current = Integer.parseInt(gameSave.resourceAmount(gameSave.POPULATION));
        int max = Integer.parseInt(gameSave.resourceAmount(gameSave.POPULATION_MAX));
        double food = Double.parseDouble(gameSave.resourceAmount(GameSave.FOOD));
        double cost = amt * workerCost * (-1);
        food = food + cost;
        current = current + amt;
        if(current>max){
            Toast.makeText(MainActivity.this,"Not enough space", Toast.LENGTH_SHORT).show();
        }
        else if(food<0.0){
            Toast.makeText(MainActivity.this,"Not enough food", Toast.LENGTH_SHORT).show();
        }
        else{
            String p = "Population: " + current + "/" + max;
            pop.setText(p);
            TextView unemployed = findViewById(R.id.unemployed);
            String unemployedtxt = unemployed.getText().toString();
            int index = unemployedtxt.indexOf(' ') + 1;
            int unemployedworkers = Integer.parseInt(unemployedtxt.substring(index));
            unemployedworkers += amt;
            unemployedtxt = "Unemployed: " + unemployedworkers;
            unemployed.setText(unemployedtxt);
            gameSave.update(gameSave.POPULATION, amt);
            gameSave.updateNoMax(gameSave.UNEMPLOYED, amt);
            TextView foodtv = findViewById(R.id.num_food);
            collect(foodtv, gameSave.FOOD, cost);
        }
    }
    public void killWorkers(double amt){
        int amount = (int) Math.floor(amt * .1);
        if(amount<0 && Double.parseDouble(gameSave.resourceAmount(gameSave.FOOD))<=0 && Integer.parseInt(gameSave.resourceAmount(gameSave.POPULATION)) > 0){
            int currentpop = Integer.parseInt(gameSave.resourceAmount(gameSave.POPULATION));
            int newpop = currentpop + amount;
            if(newpop<=0){
                gameSave.set(gameSave.POPULATION,0);
                gameSave.set(gameSave.UNEMPLOYED,0);
                gameSave.set(gameSave.FARMERS,0);
                gameSave.set(gameSave.LUMBERJACKS,0);
                gameSave.set(gameSave.STONEMASONS,0);
                gameSave.set(gameSave.HEALERS,0);
                gameSave.set(gameSave.BLACKSMITHS,0);
                gameSave.set(gameSave.TANNERS,0);
            }
            else{
                if(Integer.parseInt(gameSave.resourceAmount(gameSave.POPULATION))>0){
                    kill(-amount);
                }

            }
        }
    }
    public void kill(int amount){
        int unemployed = Integer.parseInt(gameSave.resourceAmount(gameSave.UNEMPLOYED));
        if(unemployed>0){
            if(amount>unemployed){
                modifyunemployed(-unemployed);
                gameSave.update(gameSave.POPULATION,-unemployed);
                kill(amount-unemployed);
            }
            else{
                modifyunemployed(-amount);
                gameSave.update(gameSave.POPULATION,-amount);
            }
        }
        else {
            int farmers = Integer.parseInt(gameSave.resourceAmount(gameSave.FARMERS));
            int lumberjacks = Integer.parseInt(gameSave.resourceAmount(gameSave.LUMBERJACKS));
            int stonemasons = Integer.parseInt(gameSave.resourceAmount(gameSave.STONEMASONS));
            int healers = Integer.parseInt(gameSave.resourceAmount(gameSave.HEALERS));
            int blacksmiths = Integer.parseInt(gameSave.resourceAmount(gameSave.BLACKSMITHS));
            int tanners = Integer.parseInt(gameSave.resourceAmount(gameSave.TANNERS));
            int soldiers = Integer.parseInt(gameSave.resourceAmount(gameSave.SOLDIERS));
            int cavalry = Integer.parseInt(gameSave.resourceAmount(gameSave.CAVALRY));
            if(healers>0){
                if(amount>healers){
                    gameSave.update(gameSave.POPULATION,-healers);
                    gameSave.updateNoMax(gameSave.HEALERS,-healers);
                    kill(amount-healers);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.HEALERS,-amount);
                }
            }
            else if(tanners>0){
                if(amount>tanners){
                    gameSave.update(gameSave.POPULATION,-tanners);
                    gameSave.updateNoMax(gameSave.TANNERS,-tanners);
                    kill(amount-tanners);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.TANNERS,-amount);
                }
            }
            else if(blacksmiths>0){
                if(amount>blacksmiths){
                    gameSave.update(gameSave.POPULATION,-blacksmiths);
                    gameSave.updateNoMax(gameSave.BLACKSMITHS,-blacksmiths);
                    kill(amount-blacksmiths);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.BLACKSMITHS,-amount);
                }
            }
            else if(stonemasons>0){
                if(amount>stonemasons){
                    gameSave.update(gameSave.POPULATION,-stonemasons);
                    gameSave.updateNoMax(gameSave.STONEMASONS,-stonemasons);
                    kill(amount-stonemasons);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.STONEMASONS,-amount);
                }
            }
            else if(lumberjacks>0){
                if(amount>lumberjacks){
                    gameSave.update(gameSave.POPULATION,-lumberjacks);
                    gameSave.updateNoMax(gameSave.LUMBERJACKS,-lumberjacks);
                    kill(amount-lumberjacks);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.LUMBERJACKS,-amount);
                }
            }
            else if(farmers>0){
                if(amount>farmers){
                    gameSave.update(gameSave.POPULATION,-farmers);
                    gameSave.updateNoMax(gameSave.FARMERS,-farmers);
                    kill(amount-farmers);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.FARMERS,-amount);
                }
            }
            else if(cavalry>0){
                if(amount>cavalry){
                    gameSave.update(gameSave.POPULATION,-cavalry);
                    gameSave.updateNoMax(gameSave.CAVALRY,-cavalry);
                    kill(amount-cavalry);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.CAVALRY,-amount);
                }
            }
            else if(soldiers>0){
                if(amount>soldiers){
                    gameSave.update(gameSave.POPULATION,-soldiers);
                    gameSave.updateNoMax(gameSave.SOLDIERS,-soldiers);
                    kill(amount-soldiers);
                }
                else{
                    gameSave.update(gameSave.POPULATION,-amount);
                    gameSave.updateNoMax(gameSave.SOLDIERS,-amount);
                }
            }
        }
    }
    public void populationControl(){
        String pop = "Population: " + gameSave.resourceAmount(gameSave.POPULATION) + "/" + gameSave.resourceAmount(gameSave.POPULATION_MAX);
        TextView population = findViewById(R.id.population);
        population.setText(pop);
    }
    public void collect(TextView tv, String res, double amount) {
        String str_amt = tv.getText().toString();
        String array[] = str_amt.split("/");
        double max = Double.parseDouble(array[1]);
        double current = Double.parseDouble(array[0]);
        double currentdb = Double.parseDouble(gameSave.resourceAmount(res));
        if((!((current+amount)<0)) || (!((currentdb+amount)<0))){
            gameSave.update(res, amount);
            current = current + amount;
            if(current<=max){
                String new_val = "" + df.format(current) + "/" + max;
                tv.setText(new_val);
            }
        }
    }
    public void workerCollect(TextView tv, String res, double amount, TextView sp) {
        double max = Double.parseDouble(gameSave.resourceAmount(res+"_MAX"));
        double currentdb = Double.parseDouble(gameSave.resourceAmount(res));
        String speed = "" + df.format(amount)+ "/s";
        sp.setText(speed);
        if(((currentdb+amount)>0)){
            double newcurrent = currentdb + amount;
            if(newcurrent<=max && newcurrent>0){
                String new_val = "" + df.format(newcurrent) + "/" + df.format(max);
                tv.setText(new_val);
                gameSave.update(res, amount);
                boolean val = new Random().nextInt(9)==4;
                int newamt = (int)amount;
                if(val){
                    switch (res) {
                        case "FOOD":
                            if(checkUpgrade(gameSave.SKINNING)){
                                gameSave.updateNoMax(gameSave.SKINS,newamt);
                            }
                            break;
                        case "WOOD":
                            if(checkUpgrade(gameSave.HARVESTING)){
                                gameSave.updateNoMax(gameSave.HERBS,newamt);
                            }
                            break;
                        case "STONE":
                            if(checkUpgrade(gameSave.PROSPECTING)){
                                gameSave.updateNoMax(gameSave.ORE,newamt);
                            }
                            break;
                    }
                }
            }
            else if(newcurrent>max){
                String new_val = "" + df.format(max) + "/" + df.format(max);
                tv.setText(new_val);
                int newamt = (int)amount;
                amount = max - currentdb;
                gameSave.update(res, amount);
                boolean val = new Random().nextInt(9)==4;
                if(val){
                    switch (res) {
                        case "FOOD":
                            if(checkUpgrade(gameSave.SKINNING)){
                                gameSave.updateNoMax(gameSave.SKINS,newamt);
                            }
                            break;
                        case "WOOD":
                            if(checkUpgrade(gameSave.HARVESTING)){
                                gameSave.updateNoMax(gameSave.HERBS,newamt);
                            }
                            break;
                        case "STONE":
                            if(checkUpgrade(gameSave.PROSPECTING)){
                                gameSave.updateNoMax(gameSave.ORE,newamt);
                            }
                            break;
                    }
                }
            }
            else if(newcurrent<=0){
                String new_val = "0/" + df.format(max);
                tv.setText(new_val);
                gameSave.update(res, 0);
                boolean val = new Random().nextInt(9)==4;
                int newamt = (int)amount;
                if(val){
                    switch (res) {
                        case "FOOD":
                            if(checkUpgrade(gameSave.SKINNING)){
                                gameSave.updateNoMax(gameSave.SKINS,newamt);
                            }
                            break;
                        case "WOOD":
                            if(checkUpgrade(gameSave.HARVESTING)){
                                gameSave.updateNoMax(gameSave.HERBS,newamt);
                            }
                            break;
                        case "STONE":
                            if(checkUpgrade(gameSave.PROSPECTING)){
                                gameSave.updateNoMax(gameSave.ORE,newamt);
                            }
                            break;
                    }
                }
            }

        }
        else if((((currentdb+amount)<=0))){
            String new_val = "0.0/" + df.format(max);
            tv.setText(new_val);
            gameSave.set(res, 0);
        }
    }

    public void modifyunemployed(int amt){
        int total = Integer.parseInt(gameSave.resourceAmount(gameSave.UNEMPLOYED));
        total += amt;
        if (total >= 0) {
            gameSave.updateNoMax(gameSave.UNEMPLOYED,amt);
        }
        else{
            gameSave.setInt(gameSave.UNEMPLOYED,0);
        }
        setUnemployed();
    }
    public void setUnemployed(){
        TextView unemployed = findViewById(R.id.unemployed);
        String u = "Unemployed: " + gameSave.resourceAmount(gameSave.UNEMPLOYED);
        unemployed.setText(u);
    }
    public double consume(){
        double population = Double.parseDouble(workerAmount(gameSave.POPULATION));
        double farmers = Double.parseDouble(workerAmount(gameSave.FARMERS));
        double consumption = population * workerConsume;
        double production = farmers * workerProduce;
        double fin =  Double.parseDouble(df.format(consumption + production));
        return fin;
    }
    public String civType(){
        int pop = Integer.parseInt(gameSave.resourceAmount(gameSave.POPULATION));
        if(pop<20){
            return "Thorp";
        }
        else if(pop>=20 && pop<60){
            return "Hamlet";
        }
        else if(pop>=60 && pop<200){
            return "Village";
        }
        else if(pop>=200 && pop<2000){
            return "Small Town";
        }
        else if(pop>=2000 && pop<5000){
            return "Large Town";
        }
        else if(pop>=5000 && pop<10000){
            return "Small City";
        }
        else if(pop>=10000 && pop<20000){
            return "Large City";
        }
        else if(pop>=20000 && pop<50000){
            return "Metropolis";
        }
        else if(pop>=50000 && pop<100000){
            return "Small Nation";
        }
        else if(pop>=100000 && pop<200000){
            return "Nation";
        }
        else if(pop>=200000 && pop<500000){
            return "Large Nation";
        }
        else if (pop>=500000 && pop<1000000) {
            return "Empire";
        }
        else if (pop>=1000000 && pop<2000000) {
            return "Continental Empire";
        }
        else if (pop>=2000000 && pop<5000000) {
            return "World Confederation";
        }
        else {
            return "United World";
            //
        }
    }
    public void WorkSpecialResource(int counter){
        int tanners = Integer.parseInt(gameSave.resourceAmount(gameSave.TANNERS));
        int healers = Integer.parseInt(gameSave.resourceAmount(gameSave.HEALERS));
        int blacksmiths = Integer.parseInt(gameSave.resourceAmount(gameSave.BLACKSMITHS));
        if(counter == 1){
            if(Integer.parseInt(gameSave.resourceAmount(gameSave.SKINS))>=tanners){
                gameSave.updateNoMax(gameSave.SKINS, -tanners);
                gameSave.updateNoMax(gameSave.LEATHER, tanners);
            }
            if(Integer.parseInt(gameSave.resourceAmount(gameSave.HERBS))>=healers){
                gameSave.updateNoMax(gameSave.HERBS, -healers);
                gameSave.updateNoMax(gameSave.PIETY, healers);
            }
            if(Integer.parseInt(gameSave.resourceAmount(gameSave.ORE))>=blacksmiths){
                gameSave.updateNoMax(gameSave.ORE, -blacksmiths);
                gameSave.updateNoMax(gameSave.METAL, blacksmiths);
            }
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
            aBuilder.setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = aBuilder.create();
            alert.setTitle("Exit?");
            alert.show();
        }
    }

    @Override
    public boolean buildTent(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        TextView population = findViewById(R.id.population);
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));
        if((currentwood<(2*amt)) || (currentstone<(2*amt)) || ((amt*1 + occupiedland)>land)){
            if(((currentwood<(2*amt)) || (currentstone<(2*amt))) && ((amt*1 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*1 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }
            return false;
        }
        else{
            currentstone-=(2*amt);
            currentwood-=(2*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(resourceAmount(gameSave.POPULATION_MAX));
            new_pop_max = new_pop_max + amt;
            String new_population_text = "Population: " + Integer.parseInt(resourceAmount(gameSave.POPULATION)) + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-2*amt));
            gameSave.update(GameSave.STONE, (-2*amt));
            gameSave.updatemax(gameSave.POPULATION, amt);
            gameSave.createbuilding(gameSave.TENTS,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt);
            return true;
        }
    }

    @Override
    public boolean buildHut(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        TextView population = findViewById(R.id.population);
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));
        if((currentwood<(20*amt)) || (currentstone<(10*amt)) || ((amt*2 + occupiedland)>land)){
            if(((currentwood<(20*amt)) || (currentstone<(20*amt))) && ((amt*2 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*20 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }

            return false;
        }
        else{
            currentstone-=(10*amt);
            currentwood-=(20*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(resourceAmount(gameSave.POPULATION_MAX));
            new_pop_max = new_pop_max + amt;
            String new_population_text = "Population: " + Integer.parseInt(resourceAmount(gameSave.POPULATION)) + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-20*amt));
            gameSave.update(GameSave.STONE, (-10*amt));
            gameSave.updatemax(gameSave.POPULATION, (4*amt));
            gameSave.createbuilding(gameSave.HUTS,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*2);
            return true;
        }
    }
    @Override
    public boolean buildCottage(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        TextView population = findViewById(R.id.population);
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(10*amt)) || (currentstone<(30*amt)) || ((amt*5 + occupiedland)>land)){
            if(((currentwood<(10*amt)) || (currentstone<(10*amt))) && ((amt*5 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*10 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }

            return false;
        }
        else{
            currentstone-=(30*amt);
            currentwood-=(10*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(resourceAmount(gameSave.POPULATION_MAX));
            new_pop_max = new_pop_max + amt;
            String new_population_text = "Population: " + Integer.parseInt(resourceAmount(gameSave.POPULATION)) + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-20*amt));
            gameSave.update(GameSave.STONE, (-10*amt));
            gameSave.updatemax(gameSave.POPULATION, (4*amt));
            gameSave.createbuilding(gameSave.COTTAGES,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*5);
            return true;
        }
    }
    @Override
    public boolean buildHouse(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        TextView population = findViewById(R.id.population);
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));
        if((currentwood<(100*amt)) || (currentstone<(100*amt)) || ((amt*25 + occupiedland)>land)){
            if(((currentwood<(100*amt)) || (currentstone<(100*amt))) && ((amt*25 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*25 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }
            return false;
        }
        else{
            currentstone-=(100*amt);
            currentwood-=(100*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(resourceAmount(gameSave.POPULATION_MAX));
            new_pop_max = new_pop_max + amt;
            String new_population_text = "Population: " + Integer.parseInt(resourceAmount(gameSave.POPULATION)) + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-100*amt));
            gameSave.update(GameSave.STONE, (-100*amt));
            gameSave.updatemax(gameSave.POPULATION, (50*amt));
            gameSave.createbuilding(gameSave.HOUSES,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*25);
            return true;
        }
    }

    @Override
    public boolean buildMansion(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        TextView population = findViewById(R.id.population);
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(200*amt)) || (currentstone<(200*amt)) || ((amt*50 + occupiedland)>land)){
            if(((currentwood<(200*amt)) || (currentstone<(200*amt))) && ((amt*50 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*50 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }
            return false;
        }
        else{
            currentstone-=(200*amt);
            currentwood-=(200*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(resourceAmount(gameSave.POPULATION_MAX));
            new_pop_max = new_pop_max + amt*100;
            String new_population_text = "Population: " + Integer.parseInt(resourceAmount(gameSave.POPULATION)) + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-200*amt));
            gameSave.update(GameSave.STONE, (-200*amt));
            gameSave.updatemax(gameSave.POPULATION, (100*amt));
            gameSave.createbuilding(gameSave.MANSIONS,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*50);
            return true;
        }
    }

    @Override
    public boolean buildBarn(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(100*amt)) || (currentstone<(50*amt)) || ((amt*20 + occupiedland)>land)){
            if(((currentwood<(100*amt)) || (currentstone<(100*amt))) && ((amt*20 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*20 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }
            return false;
        }
        else{
            currentstone-=(50*amt);
            currentwood-=(100*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            TextView num_food = findViewById(R.id.num_food);
            String maxfood = "" + (Integer.parseInt(gameSave.resourceAmount(gameSave.FOOD_MAX)) + (barnMax*amt));
            String currentfood = gameSave.resourceAmount(gameSave.FOOD);
            String new_food = "" + currentfood + "/" + maxfood;
            num_food.setText(new_food);
            gameSave.update(GameSave.WOOD, (-100*amt));
            gameSave.update(GameSave.STONE, (-50*amt));
            gameSave.updatemax(gameSave.FOOD, (barnMax*amt));
            gameSave.createbuilding(gameSave.BARNS,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*20);
            return true;
        }
    }

    @Override
    public boolean buildWoodStockpile(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(100*amt)) || (currentstone<(50*amt)) || ((amt*20 + occupiedland)>land)){
            if(((currentwood<(100*amt)) || (currentstone<(50*amt))) && ((amt*20 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*20 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }
            return false;
        }
        else{
            currentstone-=(50*amt);
            currentwood-=(100*amt);
            max +=(200*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-100*amt));
            gameSave.update(GameSave.STONE, (-50*amt));
            gameSave.updatemax(gameSave.WOOD, (200*amt));
            gameSave.createbuilding(gameSave.WOODSTOCKPILES,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*20);
            return true;
        }
    }

    @Override
    public boolean buildStoneStockpile(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(100*amt)) || (currentstone<(50*amt)) || ((amt*20 + occupiedland)>land)){
            if(((currentwood<(100*amt)) || (currentstone<(50*amt))) && ((amt*20 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*1 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }

            return false;
        }
        else{
            currentstone-=(50*amt);
            currentwood-=(100*amt);
            maxstone += (200*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-100*amt));
            gameSave.update(GameSave.STONE, (-50*amt));
            gameSave.updatemax(GameSave.STONE, (200*amt));
            gameSave.createbuilding(GameSave.STONESTOCKPILES,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*20);
            return true;
        }
    }

    @Override
    public boolean buildTannery(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        double currentskins = Double.parseDouble(gameSave.resourceAmount(gameSave.SKINS));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(30*amt)) || (currentstone<(70*amt)) || (currentskins<(2*amt)) || ((amt*1 + occupiedland)>land)){

            if(((currentwood<(30*amt)) || (currentstone<(70*amt)) || (currentskins<(2*amt))) && ((amt*1 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*1 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }
            return false;
        }
        else{
            currentstone-=(70*amt);
            currentwood-=(30*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-30*amt));
            gameSave.update(GameSave.STONE, (-70*amt));
            gameSave.updateNoMax(GameSave.SKINS, (-2*amt));
            gameSave.createbuilding(GameSave.TANNERIES,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt);
            return true;
        }
    }

    @Override
    public boolean buildSmithy(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        double currentore = Double.parseDouble(gameSave.resourceAmount(gameSave.ORE));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(30*amt)) || (currentstone<(70*amt)) || (currentore<(2*amt)) || ((amt*1 + occupiedland)>land)){

            if(((currentwood<(30*amt)) || (currentstone<(70*amt)) || (currentore<(2*amt))) && ((amt*1 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*1 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }

            return false;
        }
        else{
            currentstone-=(70*amt);
            currentwood-=(30*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-30*amt));
            gameSave.update(GameSave.STONE, (-70*amt));
            gameSave.updateNoMax(GameSave.ORE, (-2*amt));
            gameSave.createbuilding(GameSave.SMITHIES,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND,amt);
            return true;
        }
    }

    @Override
    public boolean buildApothecary(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        double currentherbs = Double.parseDouble(gameSave.resourceAmount(gameSave.HERBS));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(30*amt)) || (currentstone<(70*amt)) || (currentherbs<(2*amt)) || ((amt*1 + occupiedland)>land)){

            if(((currentwood<(30*amt)) || (currentstone<(70*amt)) || (currentherbs<(2*amt))) && ((amt*1 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*1 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }

            return false;
        }
        else{
            currentstone-=(70*amt);
            currentwood-=(30*amt);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-30*amt));
            gameSave.update(GameSave.STONE, (-70*amt));
            gameSave.updateNoMax(GameSave.HERBS, (-2*amt));
            gameSave.createbuilding(GameSave.APOTHECARIES,amt);
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt);
            return true;
        }
    }

    @Override
    public boolean buildBarracks(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        double currentmetal = Double.parseDouble(gameSave.resourceAmount(gameSave.METAL));
        double currentfood = Double.parseDouble(gameSave.resourceAmount(gameSave.FOOD));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));
        if((currentwood<(60*amt)) || (currentstone<(120*amt)) || (currentmetal<(10*amt)) || (currentfood<(20*amt)) || ((amt*5 + occupiedland)>land)){

            if(((currentwood<(60*amt)) || (currentstone<(120*amt)) ||(currentmetal<(10*amt)) || (currentfood<(20*amt))) && ((amt*5 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*1 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }

            return false;
        }
        else{
            currentstone-=(120*amt);
            currentwood-=(60*amt);
            currentfood-=(20*amt);
            TextView num_food = findViewById(R.id.num_food);
            String new_val_food = df.format(currentfood) + "/" + gameSave.resourceAmount(gameSave.FOOD_MAX);
            num_food.setText(new_val_food);
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-60*amt));
            gameSave.update(GameSave.STONE, (-120*amt));
            gameSave.update(GameSave.FOOD, (-20*amt));
            gameSave.createbuilding(GameSave.BARRACKS,amt);
            gameSave.updateNoMax(GameSave.METAL, (-10*amt));
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*5);
            return true;
        }
    }

    @Override
    public boolean buildStables(int amt) {
        TextView num_wood = findViewById(R.id.num_wood);
        double max = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD_MAX));
        double currentwood = Double.parseDouble(gameSave.resourceAmount(gameSave.WOOD));
        TextView num_stone = findViewById(R.id.num_stone);
        double maxstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE_MAX));
        double currentstone = Double.parseDouble(gameSave.resourceAmount(gameSave.STONE));
        double currentleather = Double.parseDouble(gameSave.resourceAmount(gameSave.LEATHER));
        double currentfood = Double.parseDouble(gameSave.resourceAmount(gameSave.FOOD));
        int land = Integer.parseInt(gameSave.resourceAmount(GameSave.LAND));
        int occupiedland = Integer.parseInt(gameSave.resourceAmount(GameSave.OCCUPIEDLAND));

        if((currentwood<(60*amt)) || (currentstone<(120*amt)) || (currentleather<(10*amt)) || (currentfood<(60*amt)) || ((amt*5 + occupiedland)>land)){

            if(((currentwood<(60*amt)) || (currentstone<(120*amt)) || (currentleather<(10*amt)) || (currentfood<(60*amt))) && ((amt*5 + occupiedland)>land)){
                toast("Not enough land and resources to build!");
            }
            else if ((amt*5 + occupiedland)>land) {
                toast("Not enough land to build!");
            }
            else {
                toast("Not enough resources to build!");
            }

            return false;
        }
        else{
            currentstone-=(120*amt);
            currentwood-=(60*amt);
            currentfood-=(60*amt);
            TextView num_food = findViewById(R.id.num_food);
            String new_val_food = df.format(currentfood) + "/" + gameSave.resourceAmount(gameSave.FOOD_MAX);
            num_food.setText(new_val_food);
            String new_val = "" + df.format(currentwood) + "/" + max;
            String new_val_stone = "" + df.format(currentstone) + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, (-60*amt));
            gameSave.update(GameSave.STONE, (-120*amt));
            gameSave.update(GameSave.FOOD, (-60*amt));
            gameSave.createbuilding(GameSave.STABLES,amt);
            gameSave.updateNoMax(GameSave.METAL, (-10*amt));
            gameSave.updateNoMax(gameSave.OCCUPIEDLAND, amt*5);
            return true;
        }
    }

    @Override
    public boolean checkMUpgrade() {
        return Integer.parseInt(gameSave.resourceAmount(GameSave.MASONRY)) == 1;
    }

    @Override
    public boolean ECI() {
        return gameSave.ECI();
    }

    @Override
    public void switchfragj(boolean bool) {
        if(bool == true){
            Fragment fragment = new jobs();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
        }
        else{
            Fragment fragment = new ECIjobs();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
        }
    }

    @Override
    public String resourceAmount(String resource){
        return gameSave.resourceAmount(resource);
    }

    @Override
    public void addFarmer(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        if(amount<=unemployed){
            gameSave.updateNoMax(GameSave.FARMERS, amount);
            modifyunemployed(-amount);
        }
    }

    @Override
    public void substractFarmer(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.FARMERS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.FARMERS, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public void addLumberjack(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        if(amount<=unemployed){
            gameSave.updateNoMax(GameSave.LUMBERJACKS, amount);
            modifyunemployed(-amount);
        }
    }

    @Override
    public void substractLumberjack(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.LUMBERJACKS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.LUMBERJACKS, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public void addStonemason(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        if(amount<=unemployed){
            gameSave.updateNoMax(GameSave.STONEMASONS, amount);
            modifyunemployed(-amount);
        }
    }

    @Override
    public void substractStonemason(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.STONEMASONS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.STONEMASONS, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public String tanners() {
        return gameSave.resourceAmount(GameSave.TANNERS);
    }

    @Override
    public void addTanner(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        int tanneries = Integer.parseInt(gameSave.resourceAmount(gameSave.TANNERIES));
        int currenttanners = Integer.parseInt(gameSave.resourceAmount(gameSave.TANNERS));
        if(amount<=unemployed && (currenttanners+amount)<=tanneries){
            gameSave.updateNoMax(GameSave.TANNERS, amount);
            modifyunemployed(-amount);
        }
        else{
            toast("Not enough tanneries or workers");
        }
    }

    @Override
    public void substractTanner(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.TANNERS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.TANNERS, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public String healers() {
        return gameSave.resourceAmount(GameSave.HEALERS);
    }

    @Override
    public void addHealer(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        int apothecaries = Integer.parseInt(gameSave.resourceAmount(gameSave.APOTHECARIES));
        int currenthealers = Integer.parseInt(gameSave.resourceAmount(gameSave.HEALERS));
        if(amount<=unemployed && (currenthealers+amount)<=apothecaries){
            gameSave.updateNoMax(GameSave.HEALERS, amount);
            modifyunemployed(-amount);
        }
        else{
            toast("Not enough apothecaries or workers");
        }
    }

    @Override
    public void substractHealer(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.HEALERS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.HEALERS, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public String blacksmith() {
        return gameSave.resourceAmount(GameSave.BLACKSMITHS);
    }

    @Override
    public void addBlacksmith(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        int smithies = Integer.parseInt(gameSave.resourceAmount(gameSave.SMITHIES));
        int currentblacksmiths = Integer.parseInt(gameSave.resourceAmount(gameSave.BLACKSMITHS));
        if(amount<=unemployed && (currentblacksmiths+amount)<=smithies){
            gameSave.updateNoMax(GameSave.BLACKSMITHS, amount);
            modifyunemployed(-amount);
        }
        else{
            toast("Not enough smithies or workers");
        }
    }

    @Override
    public void substractBlacksmith(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.BLACKSMITHS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.BLACKSMITHS, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public String workerAmount(String worker) {
        return gameSave.resourceAmount(worker);
    }
    @Override
    public boolean upgradeSkinning() {
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.SKINS)) >= 10){
            gameSave.updateNoMax(GameSave.SKINS,-10);
            return gameSave.setInt(GameSave.SKINNING,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean upgradeHarvesting() {
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.HERBS)) >= 10){
            gameSave.updateNoMax(GameSave.HERBS,-10);
            return gameSave.setInt(GameSave.HARVESTING,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean upgradeProspecting() {
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.ORE)) >= 10){
            gameSave.updateNoMax(GameSave.ORE,-10);
            return gameSave.setInt(GameSave.PROSPECTING,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean upgradeMasonry() {
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.STONE)) >= 100 && Double.parseDouble(gameSave.resourceAmount("WOOD")) >= 100){
            TextView stone = findViewById(R.id.num_stone);
            collect(stone,GameSave.STONE, -100);
            TextView wood = findViewById(R.id.num_wood);
            collect(wood,GameSave.WOOD, -100);
            return gameSave.setInt(GameSave.MASONRY,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean upgradeDomestication() {
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.LEATHER)) >= 20){
            gameSave.updateNoMax(GameSave.LEATHER,-20);
            workerProduce += .1;
            gameSave.updateNoMax(GameSave.FARMERPRODUCTIONLEVEL,1);
            return gameSave.setInt(GameSave.DOMESTICATION,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean upgradePloughshares() {
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.METAL)) >= 20){
            gameSave.updateNoMax(GameSave.METAL,-20);
            workerProduce += .1;
            gameSave.updateNoMax(GameSave.FARMERPRODUCTIONLEVEL,1);
            return gameSave.setInt(GameSave.PLOUGHSHARES,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean upgradeIrrigation() {
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.STONE)) >= 200 && Double.parseDouble(gameSave.resourceAmount(GameSave.WOOD)) >= 500){
            gameSave.update(GameSave.WOOD,-500);
            gameSave.update(GameSave.STONE,-200);
            workerProduce += .1;
            gameSave.updateNoMax(GameSave.FARMERPRODUCTIONLEVEL,1);
            return gameSave.setInt(GameSave.IRRIGATION,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public boolean upgradeConstruction() {
        return false;
    }

    @Override
    public boolean granaries(){
        if(Double.parseDouble(gameSave.resourceAmount(GameSave.STONE)) >= 1000 && Double.parseDouble(gameSave.resourceAmount(GameSave.WOOD)) >= 1000){
            double max = Double.parseDouble(gameSave.resourceAmount(GameSave.FOOD_MAX));
            max-=200;
            max*=2;
            max+=200;
            gameSave.set(GameSave.FOOD_MAX,max);
            TextView stone = findViewById(R.id.num_stone);
            collect(stone,GameSave.STONE, -1000);
            TextView wood = findViewById(R.id.num_wood);
            collect(wood,GameSave.WOOD, -1000);
            setScreen(getSupportActionBar());
            barnMax = 400;
            return gameSave.setInt(GameSave.GRANARIES,1);
        }
        else {
            Toast.makeText(MainActivity.this,"Not enough resources to purchase this upgrade", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    @Override
    public boolean checkUpgrade(String upgrade) {
        return Integer.parseInt(gameSave.resourceAmount(upgrade)) == 1;
    }

    @Override
    public String Skins() {
        return gameSave.resourceAmount(GameSave.SKINS);
    }

    @Override
    public String Leather() {
        return gameSave.resourceAmount(GameSave.LEATHER);
    }

    @Override
    public String Herbs() {
        return gameSave.resourceAmount(GameSave.HERBS);
    }

    @Override
    public String Piety() {
        return gameSave.resourceAmount(GameSave.PIETY);
    }

    @Override
    public String Ore() {
        return gameSave.resourceAmount(GameSave.ORE);
    }

    @Override
    public String Metal() {
        return gameSave.resourceAmount(GameSave.METAL);
    }

    @Override
    public String farmers() {
        return gameSave.resourceAmount(GameSave.FARMERS);
    }

    @Override
    public String lumberjacks() {
        return gameSave.resourceAmount(GameSave.LUMBERJACKS);
    }

    @Override
    public String stonemasons() {
        return gameSave.resourceAmount(GameSave.STONEMASONS);
    }

    @Override
    public String soldiers() {
        return gameSave.resourceAmount(GameSave.SOLDIERS);
    }

    @Override
    public void addSoldier(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        int leather = Integer.parseInt(gameSave.resourceAmount(GameSave.LEATHER));
        int metal = Integer.parseInt(gameSave.resourceAmount(GameSave.METAL));
        int current = Integer.parseInt(gameSave.resourceAmount(GameSave.SOLDIERS));
        int barracks = Integer.parseInt(gameSave.resourceAmount(GameSave.BARRACKS));
        if(amount<=unemployed && (10*amount)<=metal && (10*amount)<=leather && (current+amount)<=(10*barracks)){
            gameSave.updateNoMax(GameSave.SOLDIERS, amount);
            gameSave.updateNoMax(GameSave.LEATHER, -(amount*10));
            gameSave.updateNoMax(GameSave.METAL, -(amount*10));
            modifyunemployed(-amount);
        }
    }

    @Override
    public void substractSoldier(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.SOLDIERS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.SOLDIERS, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public String cavalry() {
        return gameSave.resourceAmount(GameSave.CAVALRY);
    }

    @Override
    public void addCavalry(int amount) {
        int unemployed = Integer.parseInt(gameSave.resourceAmount(GameSave.UNEMPLOYED));
        int leather = Integer.parseInt(gameSave.resourceAmount(GameSave.LEATHER));
        int metal = Integer.parseInt(gameSave.resourceAmount(GameSave.METAL));
        int current = Integer.parseInt(gameSave.resourceAmount(GameSave.CAVALRY));
        int stables = Integer.parseInt(gameSave.resourceAmount(GameSave.STABLES));
        if(amount<=unemployed && (10*amount)<=metal && (10*amount)<=leather && (current+amount)<=(10*stables)){
            gameSave.updateNoMax(GameSave.CAVALRY, amount);
            gameSave.updateNoMax(GameSave.LEATHER, -(amount*10));
            gameSave.updateNoMax(GameSave.METAL, -(amount*10));
            modifyunemployed(-amount);
        }
    }

    @Override
    public void substractCavalry(int amount) {
        int amt = Integer.parseInt(gameSave.resourceAmount(GameSave.FARMERS));
        if(amt>=amount){
            gameSave.updateNoMax(GameSave.CAVALRY, -amount);
            modifyunemployed(amount);
        }
    }

    @Override
    public void toast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int amount(String res){
        return Integer.parseInt(gameSave.resourceAmount(res));
    }
    @Override
    public double SoldierEfficiency(){
        return SoldierAttackSpeed;
    }
    @Override
    public double CavalryEfficiency() {
        return CavalryAttackSpeed;
    }
    @Override
    public void killSoldier(int amount) {
        int soldiers = Integer.parseInt(gameSave.resourceAmount(gameSave.SOLDIERS));
        if(amount<=soldiers){
            gameSave.update(gameSave.POPULATION,-amount);
            gameSave.updateNoMax(gameSave.SOLDIERS,-amount);
        }
        else{
            gameSave.update(gameSave.POPULATION,-soldiers);
            gameSave.updateNoMax(gameSave.SOLDIERS,-soldiers);
        }
    }
    @Override
    public void killCavalry(int amount) {
        int cavalry = Integer.parseInt(gameSave.resourceAmount(gameSave.CAVALRY));
        if(amount<=cavalry){
            gameSave.update(gameSave.POPULATION,-amount);
            gameSave.updateNoMax(gameSave.CAVALRY,-amount);
        }
        else{
            gameSave.update(gameSave.POPULATION,-cavalry);
            gameSave.updateNoMax(gameSave.CAVALRY,-cavalry);
        }
    }

    @Override
    public void plunderLand(int amount){
        gameSave.updateNoMax(gameSave.LAND,amount);
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
        aBuilder.setMessage("" + amount + " acres of land plundered")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = aBuilder.create();
        alert.setTitle("VICTORY!!!");
        alert.show();
    }
    @Override
    public void defeat(){
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
        aBuilder.setMessage("Army has been defeated")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = aBuilder.create();
        alert.setTitle("Defeat!");
        alert.show();
    }
}
