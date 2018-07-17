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
        implements buildings.buildingBuilder, jobs.employmentOffice, upgrades.upgrade, specialResources.specialResourcesListener, upgradedJobs.upgradedemploymentOffice{
    GameSave gameSave = GameSave.getGameSave(this);
    int workerCost = 20;
    double workerConsume = -1;
    double workerProduce = 1.4;
    double workerWoodProduction = .4;
    double workerStoneProduction = .2;
    double barnMax = 200;
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
    Thread saver = new Thread() {
        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    int i = 60000*60;
                    Thread.sleep(i);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            saveGame();
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
            //edit the db so that it can have the name of the civilization saved and then update the action bar
        }
//        gameSave.resetdb();
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
        final Button specialRes= findViewById(R.id.specialresources);
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
                collect(num_food, "FOOD", 100);
                boolean val = new Random().nextInt(10)==0;
                if(val){
                    gameSave.updateNoMax(gameSave.SKINS,1);
                }
            }
        });
        collect_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_wood = findViewById(R.id.num_wood);
                collect(num_wood,gameSave.WOOD, 100);
                boolean val = new Random().nextInt(10)==0;
                if(val){
                    gameSave.updateNoMax(gameSave.HERBS,1);
                }
            }
        });
        collect_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_stone = findViewById(R.id.num_stone);
                collect(num_stone, gameSave.STONE, 100);
                boolean val = new Random().nextInt(10)==0;
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

                return true;
            }
        });
        changeFragment(jobs);
        thread.start(); //starts automatic updates
        saver.start();
    }

    public void pause(){
        thread = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        thread = null;
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
                                    double farm = consume();
                                    TextView food = findViewById(R.id.num_food);
                                    TextView foodspeed = findViewById(R.id.FOOD);
                                    workerCollect(food, "FOOD", farm, foodspeed);
                                    killWorkers(farm);
                                    populationControl();
                                    setUnemployed();
                                    double lumberjacks = Double.parseDouble(workerAmount("LUMBERJACKS"));
                                    TextView wood = findViewById(R.id.num_wood);
                                    TextView woodspeed = findViewById(R.id.WOOD);
                                    workerCollect(wood, "WOOD", lumberjacks * workerWoodProduction, woodspeed);
                                    double stonemasons = Double.parseDouble(workerAmount("STONEMASONS"));
                                    TextView stone = findViewById(R.id.num_stone);
                                    TextView stonespeed = findViewById(R.id.STONE);
                                    workerCollect(stone, "STONE", stonemasons * workerStoneProduction, stonespeed);
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
            fragment = new buildings();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
            }
        else if(view == findViewById(R.id.upgrades)){
            fragment = new upgrades();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();}
        else if(view == findViewById(R.id.jobs)){
            if(checkMUpgrade()){
                fragment = new upgradedJobs();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment, fragment);
                ft.commit();
            }
            else {
                fragment = new jobs();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment, fragment);
                ft.commit();
            }
        }
        else if(view == findViewById(R.id.specialresources)){
            fragment = new specialResources();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
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
            if(tanners>0){
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
            if(blacksmiths>0){
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
            if(stonemasons>0){
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
            if(lumberjacks>0){
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
            if(farmers>0){
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
        double i =currentdb+amount;
        if(((currentdb+amount)>0)){
            double newcurrent = currentdb + amount;
            if(newcurrent<=max && newcurrent>0){
                String new_val = "" + df.format(newcurrent) + "/" + max;
                tv.setText(new_val);
                gameSave.update(res, amount);
            }
            else if(newcurrent>max){
                String new_val = "" + max + "/" + max;
                tv.setText(new_val);
                amount = max - currentdb;
                gameSave.update(res, amount);
            }
            else if(newcurrent<=0){
                String new_val = "0/" + max;
                tv.setText(new_val);
                gameSave.update(res, 0);
            }
            boolean val = new Random().nextInt(10)==0;
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
        else if((((currentdb+amount)<=0))){
            String new_val = "0.0/" + max;
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
//        toast("Consumption" + consumption + " Production: " + production);
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
            return "Planetary Confederation";
        }
        else {
            return "United World";
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
    public boolean buildTent() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        TextView population = findViewById(R.id.population);
        String pop = population.getText().toString();
        String pop1 = pop.substring(12);
        String pop2[] = pop1.split("/");
        if((currentwood<2) || (currentstone<2)){
            return false;
        }
        else{
            currentstone-=2;
            currentwood-=2;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(pop2[1]);
            new_pop_max = new_pop_max + 1;
            String new_population_text = "Population: " + pop2[0] + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, -2);
            gameSave.update(GameSave.STONE, -2);
            gameSave.updatemax(gameSave.POPULATION, 1);
            gameSave.createbuilding(gameSave.TENTS,1);
            return true;
        }
    }

    @Override
    public boolean buildHut() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        TextView population = findViewById(R.id.population);
        String pop = population.getText().toString();
        String pop1 = pop.substring(12);
        String pop2[] = pop1.split("/");
        if((currentwood<20) || (currentstone<10)){
            return false;
        }
        else{
            currentstone-=10;
            currentwood-=20;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(pop2[1]);
            new_pop_max = new_pop_max + 4;
            String new_population_text = "Population: " + pop2[0] + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, -20);
            gameSave.update(GameSave.STONE, -10);
            gameSave.updatemax(gameSave.POPULATION, 4);
            gameSave.createbuilding(gameSave.HUTS,1);
            return true;
        }
    }
    @Override
    public boolean buildCottage() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        TextView population = findViewById(R.id.population);
        String pop = population.getText().toString();
        String pop1 = pop.substring(12);
        String pop2[] = pop1.split("/");
        if((currentwood<10) || (currentstone<30)){
            return false;
        }
        else{
            currentstone-=30;
            currentwood-=10;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(pop2[1]);
            new_pop_max = new_pop_max + 6;
            String new_population_text = "Population: " + pop2[0] + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, -20);
            gameSave.update(GameSave.STONE, -10);
            gameSave.updatemax(gameSave.POPULATION, 4);
            gameSave.createbuilding(gameSave.COTTAGES,1);
            return true;
        }
    }
    @Override
    public boolean buildHouse() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        TextView population = findViewById(R.id.population);
        String pop = population.getText().toString();
        String pop1 = pop.substring(12);
        String pop2[] = pop1.split("/");
        if((currentwood<100) || (currentstone<100)){
            return false;
        }
        else{
            currentstone-=100;
            currentwood-=100;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(pop2[1]);
            new_pop_max = new_pop_max + 50;
            String new_population_text = "Population: " + pop2[0] + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, -100);
            gameSave.update(GameSave.STONE, -100);
            gameSave.updatemax(gameSave.POPULATION, 50);
            gameSave.createbuilding(gameSave.HOUSES,1);
            return true;
        }
    }

    @Override
    public boolean buildMansion() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        TextView population = findViewById(R.id.population);
        String pop = population.getText().toString();
        String pop1 = pop.substring(12);
        String pop2[] = pop1.split("/");
        if((currentwood<200) || (currentstone<200)){
            return false;
        }
        else{
            currentstone-=200;
            currentwood-=200;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            int new_pop_max = Integer.parseInt(pop2[1]);
            new_pop_max = new_pop_max + 100;
            String new_population_text = "Population: " + pop2[0] + "/" + new_pop_max;
            population.setText(new_population_text);
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, -200);
            gameSave.update(GameSave.STONE, -200);
            gameSave.updatemax(gameSave.POPULATION, 100);
            gameSave.createbuilding(gameSave.MANSIONS,1);
            return true;
        }
    }

    @Override
    public boolean buildBarn() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        if((currentwood<100) || (currentstone<50)){
            return false;
        }
        else{
            currentstone-=50;
            currentwood-=100;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            TextView num_food = findViewById(R.id.num_food);
            String food = num_food.getText().toString();
            String array2[] = food.split("/");
            double maxfood = Double.parseDouble(array2[1]) + barnMax;
            double currentfood = Double.parseDouble(array2[0]);
            String new_food = "" + currentfood + "/" + maxfood;
            num_food.setText(new_food);
            gameSave.update(GameSave.WOOD, -100);
            gameSave.update(GameSave.STONE, -50);
            gameSave.updatemax(gameSave.FOOD, barnMax);
            gameSave.createbuilding(gameSave.BARNS,1);
            return true;
        }
    }

    @Override
    public boolean buildWoodStockpile() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        if((currentwood<100) || (currentstone<50)){
            return false;
        }
        else{
            currentstone-=50;
            currentwood-=100;
            max +=200;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, -100);
            gameSave.update(GameSave.STONE, -50);
            gameSave.updatemax(gameSave.WOOD, 200);
            gameSave.createbuilding(gameSave.WOODSTOCKPILES,1);
            return true;
        }
    }

    @Override
    public boolean buildStoneStockpile() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        double max = Double.parseDouble(array[1]);
        double currentwood = Double.parseDouble(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        double maxstone = Double.parseDouble(array1[1]);
        double currentstone = Double.parseDouble(array1[0]);
        if((currentwood<100) || (currentstone<50)){
            return false;
        }
        else{
            currentstone-=50;
            currentwood-=100;
            maxstone += 200;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            gameSave.update(GameSave.WOOD, -100);
            gameSave.update(GameSave.STONE, -50);
            gameSave.updatemax(GameSave.STONE, 200);
            gameSave.createbuilding(GameSave.STONESTOCKPILES,1);
            return true;
        }
    }

    @Override
    public boolean buildTannery() {
        return false;
    }

    @Override
    public boolean buildSmithy() {
        return false;
    }

    @Override
    public boolean buildApothecary() {
        return false;
    }

    @Override
    public boolean buildBarracks() {
        return false;
    }

    @Override
    public boolean checkMUpgrade() {
        return Integer.parseInt(gameSave.resourceAmount(GameSave.MASONRY)) == 1;
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
        if(amount<=unemployed){
            gameSave.updateNoMax(GameSave.TANNERS, amount);
            modifyunemployed(-amount);
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
        if(amount<=unemployed){
            gameSave.updateNoMax(GameSave.HEALERS, amount);
            modifyunemployed(-amount);
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
        if(amount<=unemployed){
            gameSave.updateNoMax("BLACKSMITHS", amount);
            modifyunemployed(-amount);
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
    public String Herbs() {
        return gameSave.resourceAmount(GameSave.HERBS);
    }

    @Override
    public String Ore() {
        return gameSave.resourceAmount(GameSave.ORE);
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
    public void toast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }
}
