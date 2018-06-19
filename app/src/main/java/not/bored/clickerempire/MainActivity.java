package not.bored.clickerempire;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
        implements buildings.buildingBuilder, jobs.employmentOffice{
    GameSave gameSave = GameSave.getGameSave(this);
    int atomicHUT = 0;
    int workerCost = 1;
    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int farmers = Integer.parseInt(workerAmount("FARMERS"));
                            TextView food = findViewById(R.id.num_food);
                            TextView foodspeed = findViewById(R.id.FOOD);
                            workerCollect(food, "FOOD", farmers, foodspeed);
                            int lumberjacks = Integer.parseInt(workerAmount("LUMBERJACKS"));
                            TextView wood = findViewById(R.id.num_wood);
                            TextView woodspeed = findViewById(R.id.WOOD);
                            workerCollect(wood, "WOOD", lumberjacks, woodspeed);
                            int stonemasons = Integer.parseInt(workerAmount("STONEMASONS"));
                            TextView stone = findViewById(R.id.num_stone);
                            TextView stonespeed = findViewById(R.id.STONE);
                            workerCollect(stone, "STONE", stonemasons, stonespeed);
                        }
                    });
                }
            } catch (InterruptedException e) {
                Toast.makeText(MainActivity.this,"Oops, something went wrong", Toast.LENGTH_LONG).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button collect_food = findViewById(R.id.collect_food);
        Button collect_wood = findViewById(R.id.collect_wood);
        Button collect_stone = findViewById(R.id.collect_stone);
        Button reset = findViewById(R.id.resetdb);
        Button createWorkers = findViewById(R.id.create_worker);
        TextView population = findViewById(R.id.population);
        Button add_worker = findViewById(R.id.add_worker);
        Button substract_worker = findViewById(R.id.substract_worker);
        String pop_max = gameSave.resourceAmount("POPULATION_MAX");
        String pop = gameSave.resourceAmount("POPULATION");
        String str = "Population: " + pop + "/" + pop_max;
        population.setText(str);
        final Button buildings = findViewById(R.id.buildings);
        final Button upgrades = findViewById(R.id.upgrades);
        final Button jobs = findViewById(R.id.jobs);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSave.resetdb();
                TextView num_food = findViewById(R.id.num_food);
                TextView num_wood = findViewById(R.id.num_wood);
                TextView num_stone = findViewById(R.id.num_stone);
                TextView population = findViewById(R.id.population);
                TextView unemployed = findViewById(R.id.unemployed);
                unemployed.setText("Unemployed: 0");
                String str_amt = num_food.getText().toString();
                String array[] = str_amt.split("/");
                int max = Integer.parseInt(array[1]);
                String new_val = "0/" + max;
                num_food.setText(new_val);
                num_wood.setText(new_val);
                num_stone.setText(new_val);
                population.setText("Population: 0/0");
                atomicHUT = 0;
            }
        });
        collect_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_food = findViewById(R.id.num_food);
                collect(num_food, "FOOD", 1);
            }
        });
        collect_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_wood = findViewById(R.id.num_wood);
                collect(num_wood,"WOOD", 1);
            }
        });
        collect_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_stone = findViewById(R.id.num_stone);
                collect(num_stone, "STONE", 1);
            }
        });
        buildings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(buildings);
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
        thread.start(); //starts automatic updates
    }
    public void changeFragment(View view){
        Fragment fragment;
        if(view == findViewById(R.id.buildings)){
            fragment = new buildings();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
//            Toast.makeText(MainActivity.this,"bulidings", Toast.LENGTH_SHORT).show();
        }
        else if(view == findViewById(R.id.upgrades)){
            fragment = new upgrades();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
//            Toast.makeText(MainActivity.this,"upgrades", Toast.LENGTH_SHORT).show();
        }
        else if(view == findViewById(R.id.jobs)){
            fragment = new jobs();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
//            Toast.makeText(MainActivity.this,"jobs", Toast.LENGTH_SHORT).show();
        }
    }
    public void createWorker(TextView pop, int amt){
        String population = pop.getText().toString();
        String pop_num = population.substring(12);
        String pops[] = pop_num.split("/");
        int current = Integer.parseInt(pops[0]);
        int max = Integer.parseInt(pops[1]);
        int food = Integer.parseInt(gameSave.resourceAmount(GameSave.FOOD_col));
        int cost = amt * workerCost * (-1);
        food = food + cost;
        current = current + amt;
        if(current>max){
            Toast.makeText(MainActivity.this,"Not enough space", Toast.LENGTH_SHORT).show();
        }
        else if(food<0){
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
            gameSave.update("POPULATION", amt);
            gameSave.updateNoMax("UNEMPLOYED", amt);
            TextView foodtv = findViewById(R.id.num_food);
            collect(foodtv, "FOOD", cost);
//            Toast.makeText(MainActivity.this,"Worker created", Toast.LENGTH_SHORT).show();
        }
    }
    public void collect(TextView tv, String res, int amount) {
        String str_amt = tv.getText().toString();
        String array[] = str_amt.split("/");
        int max = Integer.parseInt(array[1]);
        int current = Integer.parseInt(array[0]);
        int currentdb = Integer.parseInt(gameSave.resourceAmount(res));
        if((!((current+amount)<0)) || (!((currentdb+amount)<0))){
            boolean saved = gameSave.update(res, amount);
            if(saved){
                String amt = gameSave.showamt(res);
                Toast.makeText(MainActivity.this, res +" added to the DataBase: " + amt, Toast.LENGTH_SHORT).show();
            }
            else{
                String amt = gameSave.showamt(res);
                Toast.makeText(MainActivity.this, res +" not added to the DataBase: " + amt, Toast.LENGTH_SHORT).show();
            }
            current = current + amount;
            if(current<=max){
                String new_val = "" + current + "/" + max;
                tv.setText(new_val);
            }
        }
    }
    //place indicator to prevent file from being accessed too much
    public void workerCollect(TextView tv, String res, int amount, TextView sp) {
        String str_amt = tv.getText().toString();
        String array[] = str_amt.split("/");
        int max = Integer.parseInt(array[1]);
        int current = Integer.parseInt(array[0]);
        int currentdb = Integer.parseInt(gameSave.resourceAmount(res));
        if((!((current+amount)<0)) || (!((currentdb+amount)<0))){
            String speed = "" + amount + "/s";
            sp.setText(speed);
            int newcurrent = current + amount;
            if(newcurrent<=max){
                String new_val = "" + newcurrent + "/" + max;
                tv.setText(new_val);
                gameSave.update(res, amount);
            }
            else if(newcurrent>max){
                String new_val = "" + max + "/" + max;
                tv.setText(new_val);
                amount = max - current;
                gameSave.update(res, amount);
            }
        }
    }

    public void modifyunemployed(int amt){
        TextView unemployed = findViewById(R.id.unemployed);
        int total = Integer.parseInt(unemployed.getText().toString().substring(12));
        total += amt;
        String newu = "Unemployed: " + total;
        unemployed.setText(newu);
    }
    @Override
    public void onBackPressed() {
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

    @Override
    public boolean buildTent() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        int max = Integer.parseInt(array[1]);
        int currentwood = Integer.parseInt(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        int maxstone = Integer.parseInt(array1[1]);
        int currentstone = Integer.parseInt((array1[0]));
        TextView population = findViewById(R.id.population);
        String pop = population.getText().toString();
        String pop1 = pop.substring(12);
        String pop2[] = pop1.split("/");
        if((currentwood<2) || (currentstone<=2)){
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
            gameSave.update(GameSave.WOOD_col, -2);
            gameSave.update(GameSave.STONE_col, -2);
            gameSave.updatemax("POPULATION", 1);
            gameSave.createbuilding("TENTS",1);
            return true;
        }
    }

    @Override
    public boolean buildHut() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        int max = Integer.parseInt(array[1]);
        int currentwood = Integer.parseInt(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        int maxstone = Integer.parseInt(array1[1]);
        int currentstone = Integer.parseInt((array1[0]));
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
            gameSave.update(GameSave.WOOD_col, -20);
            gameSave.update(GameSave.STONE_col, -10);
            gameSave.updatemax("POPULATION", 4);
            gameSave.createbuilding("HUTS",1);
            return true;
        }
    }

    @Override
    public boolean buildHouse() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        int max = Integer.parseInt(array[1]);
        int currentwood = Integer.parseInt(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        int maxstone = Integer.parseInt(array1[1]);
        int currentstone = Integer.parseInt((array1[0]));
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
            gameSave.update(GameSave.WOOD_col, -100);
            gameSave.update(GameSave.STONE_col, -100);
            gameSave.updatemax("POPULATION", 50);
            gameSave.createbuilding("HOUSES",1);
            return true;
        }
    }

    @Override
    public boolean buildMansion() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        int max = Integer.parseInt(array[1]);
        int currentwood = Integer.parseInt(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        int maxstone = Integer.parseInt(array1[1]);
        int currentstone = Integer.parseInt((array1[0]));
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
            gameSave.update(GameSave.WOOD_col, -200);
            gameSave.update(GameSave.STONE_col, -200);
            gameSave.updatemax("POPULATION", 100);
            gameSave.createbuilding("MANSIONS",1);
            return true;
        }
    }

    @Override
    public boolean buildBarn() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        int max = Integer.parseInt(array[1]);
        int currentwood = Integer.parseInt(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        int maxstone = Integer.parseInt(array1[1]);
        int currentstone = Integer.parseInt((array1[0]));
        if((currentwood<100) || (currentstone<50)){
            return false;
        }
        else{
            Toast.makeText(MainActivity.this,"What the fuck", Toast.LENGTH_SHORT).show();
            currentstone-=50;
            currentwood-=100;
            String new_val = "" + currentwood + "/" + max;
            String new_val_stone = "" + currentstone + "/" + maxstone;
            num_wood.setText(new_val);
            num_stone.setText(new_val_stone);
            TextView num_food = findViewById(R.id.num_food);
            String food = num_food.getText().toString();
            String array2[] = food.split("/");
            int maxfood = Integer.parseInt(array2[1]) + 200;
            int currentfood = Integer.parseInt(array2[0]);
            String new_food = "" + currentfood + "/" + maxfood;
            num_food.setText(new_food);
            gameSave.update(GameSave.WOOD_col, -100);
            gameSave.update(GameSave.STONE_col, -50);
            gameSave.updatemax("FOOD", 200);
            gameSave.createbuilding("BARNS",1);
            return true;
        }
    }

    @Override
    public boolean buildWoodStockpile() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        int max = Integer.parseInt(array[1]);
        int currentwood = Integer.parseInt(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        int maxstone = Integer.parseInt(array1[1]);
        int currentstone = Integer.parseInt((array1[0]));
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
            gameSave.update(GameSave.WOOD_col, -100);
            gameSave.update(GameSave.STONE_col, -50);
            gameSave.updatemax("WOOD", 200);
            gameSave.createbuilding("WOODSTOCKPILES",1);
            return true;
        }
    }

    @Override
    public boolean buildStoneStockpile() {
        TextView num_wood = findViewById(R.id.num_wood);
        String wood = num_wood.getText().toString();
        String array[] = wood.split("/");
        int max = Integer.parseInt(array[1]);
        int currentwood = Integer.parseInt(array[0]);
        TextView num_stone = findViewById(R.id.num_stone);
        String stone = num_stone.getText().toString();
        String array1[] = stone.split("/");
        int maxstone = Integer.parseInt(array1[1]);
        int currentstone = Integer.parseInt((array1[0]));
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
            gameSave.update(GameSave.WOOD_col, -100);
            gameSave.update(GameSave.STONE_col, -50);
            gameSave.updatemax("STONE", 200);
            gameSave.createbuilding("STONESTOCKPILES",1);
            return true;
        }
    }

    @Override
    public String resourceAmount(String resource){
        return gameSave.resourceAmount(resource);
    }

    @Override
    public boolean atomicHUT() {
        if(atomicHUT == 0){
            atomicHUT++;
//            Toast.makeText(MainActivity.this,"atomicHUT" + atomicHUT, Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int totalUnemployed(){
        int c =Integer.parseInt(gameSave.resourceAmount("UNEMPLOYED"));
//        Toast.makeText(MainActivity.this,"whhatttt+ " + c, Toast.LENGTH_SHORT).show();
        return c;
    }

    @Override
    public void addFarmer(int amount) {
        int namount = -1 * amount;
        gameSave.updateNoMax("FARMERS", amount);
        gameSave.updateNoMax("UNEMPLOYED", namount);
        this.modifyunemployed(namount);
//        Toast.makeText(MainActivity.this,"farmer added", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void substractFarmer(int amount) {
        int namount = -1 * amount;
        gameSave.updateNoMax("FARMERS", namount);
        gameSave.updateNoMax("UNEMPLOYED", amount);
        this.modifyunemployed(amount);
    }

    @Override
    public void addLumberjack(int amount) {
        int namount = -1 * amount;
        gameSave.updateNoMax("LUMBERJACKS", amount);
        gameSave.updateNoMax("UNEMPLOYED", namount);
        this.modifyunemployed(namount);
    }

    @Override
    public void substractLumberjack(int amount) {
        int namount = -1 * amount;
        gameSave.updateNoMax("LUMBERJACKS", namount);
        gameSave.updateNoMax("UNEMPLOYED", amount);
        this.modifyunemployed(amount);
    }

    @Override
    public void addStonemason(int amount) {
        int namount = -1 * amount;
        gameSave.updateNoMax("STONEMASONS", amount);
        gameSave.updateNoMax("UNEMPLOYED", namount);
        this.modifyunemployed(namount);
    }

    @Override
    public void substractStonemason(int amount) {
        int namount = -1 * amount;
        gameSave.updateNoMax("STONEMASONS", namount);
        gameSave.updateNoMax("UNEMPLOYED", amount);
        this.modifyunemployed(amount);
    }

    @Override
    public void toast(int i) {
//        Toast.makeText(MainActivity.this,"there are " + i + " farmers", Toast.LENGTH_SHORT).show();

    }

    @Override
    public String workerAmount(String worker) {
        return gameSave.resourceAmount(worker);
    }
}
