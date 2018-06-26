package not.bored.clickerempire;

import android.content.DialogInterface;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity
        implements buildings.buildingBuilder, jobs.employmentOffice{
    GameSave gameSave = GameSave.getGameSave(this);
    int atomicHUT = 0;
    int workerCost = 20;
    double workerConsume = -1;
    double workerProduce = 1.4;
    double workerWoodProduction = .4;
    double workerStoneProduction = .2;
    private DrawerLayout mDrawerLayout;
    DecimalFormat df = new DecimalFormat("0.0");
    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            double farm = consume();
                            TextView food = findViewById(R.id.num_food);
                            TextView foodspeed = findViewById(R.id.FOOD);
                            workerCollect(food, "FOOD", farm, foodspeed);
                            double lumberjacks = Double.parseDouble(workerAmount("LUMBERJACKS"));
                            TextView wood = findViewById(R.id.num_wood);
                            TextView woodspeed = findViewById(R.id.WOOD);
                            workerCollect(wood, "WOOD", lumberjacks * workerWoodProduction, woodspeed);
                            double stonemasons = Double.parseDouble(workerAmount("STONEMASONS"));
                            TextView stone = findViewById(R.id.num_stone);
                            TextView stonespeed = findViewById(R.id.STONE);
                            workerCollect(stone, "STONE", stonemasons * workerStoneProduction, stonespeed);
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        String o = intent.getStringExtra("rename");
        if((o != null) && (o.equals("rename"))){
            String newcivname = intent.getStringExtra("newcivName");
            actionbar.setTitle(newcivname);
            //edit the db so that it can have the name of the civilization saved and then update the action bar
        }
        Button collect_food = findViewById(R.id.collect_food);
        Button collect_wood = findViewById(R.id.collect_wood);
        Button collect_stone = findViewById(R.id.collect_stone);
        Button reset = findViewById(R.id.resetdb);
        Button createWorkers = findViewById(R.id.create_worker);
        Button add_worker = findViewById(R.id.add_worker);
        Button substract_worker = findViewById(R.id.substract_worker);
        setScreen();
        final Button buildings = findViewById(R.id.buildings);
        final Button upgrades = findViewById(R.id.upgrades);
        final Button jobs = findViewById(R.id.jobs);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameSave.resetdb();
                setScreen();
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
                    Intent rename = new Intent(getApplicationContext(), Rename.class);
                    startActivity(rename);
                }
                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here


                return true;
            }
        });
        thread.start(); //starts automatic updates
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
    public void setScreen(){
        String pop = "Population: " + gameSave.resourceAmount("POPULATION") + "/" + gameSave.resourceAmount("POPULATION_MAX");
        String unemployed = "Unemployed: " +gameSave.resourceAmount("UNEMPLOYED");
        String food = gameSave.resourceAmount("FOOD") + "/" + gameSave.resourceAmount("FOOD_MAX");
        String wood = gameSave.resourceAmount("WOOD") + "/" + gameSave.resourceAmount("WOOD_MAX");
        String stone = gameSave.resourceAmount("STONE") + "/" + gameSave.resourceAmount("STONE_MAX");
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
            fragment = new jobs();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment, fragment);
            ft.commit();
        }
    }
    public void createWorker(TextView pop, int amt){
        String population = pop.getText().toString();
        String pop_num = population.substring(12);
        String pops[] = pop_num.split("/");
        int current = Integer.parseInt(pops[0]);
        int max = Integer.parseInt(pops[1]);
        double food = Double.parseDouble(gameSave.resourceAmount(GameSave.FOOD_col));
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
            gameSave.update("POPULATION", amt);
            gameSave.updateNoMax("UNEMPLOYED", amt);
            TextView foodtv = findViewById(R.id.num_food);
            collect(foodtv, "FOOD", cost);
        }
    }
    public void collect(TextView tv, String res, double amount) {
        String str_amt = tv.getText().toString();
        String array[] = str_amt.split("/");
        double max = Double.parseDouble(array[1]);
        double current = Double.parseDouble(array[0]);
        double currentdb = Double.parseDouble(gameSave.resourceAmount(res));
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
                String new_val = "" + df.format(current) + "/" + max;
                tv.setText(new_val);
            }
        }
    }
    public void workerCollect(TextView tv, String res, double amount, TextView sp) {
        String str_amt = tv.getText().toString();
        String array[] = str_amt.split("/");
        double max = Double.parseDouble(array[1]);
        double current = Double.parseDouble(array[0]);
        double currentdb = Double.parseDouble(gameSave.resourceAmount(res));
        String speed = "" + df.format(amount)+ "/s";
        sp.setText(speed);
        if((!((current+amount)<0)) || (!((currentdb+amount)<0))){
            double newcurrent = current + amount;
            if(newcurrent<=max && newcurrent>0){
                String new_val = "" + df.format(newcurrent) + "/" + max;
                tv.setText(new_val);
                gameSave.update(res, amount);
            }
            else if(newcurrent>max){
                String new_val = "" + max + "/" + max;
                tv.setText(new_val);
                amount = max - current;
                gameSave.update(res, amount);
            }
            else if(newcurrent<=0){
                String new_val = "0/" + max;
                tv.setText(new_val);
                gameSave.update(res, 0);
            }
        }
        else if((((current+amount)<0)) || (((currentdb+amount)<0))){
            String new_val = "0.0/" + max;
            tv.setText(new_val);
            gameSave.update(res, -currentdb);
        }
    }

    public void modifyunemployed(int amt){
        TextView unemployed = findViewById(R.id.unemployed);
        int total = Integer.parseInt(unemployed.getText().toString().substring(12));
        total += amt;
        String newu = "Unemployed: " + total;
        unemployed.setText(newu);
    }
    public double consume(){
        double population = Double.parseDouble(workerAmount("POPULATION"));
        double farmers = Double.parseDouble(workerAmount("FARMERS"));
        double consumption = population * workerConsume;
        double production = farmers * workerProduce;
        double fin =  Double.parseDouble(df.format(consumption + production));
        return fin;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            double maxfood = Double.parseDouble(array2[1]) + 200;
            double currentfood = Double.parseDouble(array2[0]);
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
