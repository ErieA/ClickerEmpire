package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class conquest extends Fragment {


    private army army;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof army) {
            army = (army) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(100);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                TextView Soldiers = getActivity().findViewById(R.id.Soldiers);
                                String s = "Soldiers: " + army.soldiers();
                                Soldiers.setText(s);
                                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                                String c = "Cavalry: " + army.cavalry();
                                cavalry.setText(c);
                            }
                            catch (NullPointerException e) {
                                army.toast("Something fishy is going on");
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };
    public conquest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_conquest, container, false);
        Button addSoldier = view.findViewById(R.id.add_soldier);
        Button substractSoldier = view.findViewById(R.id.substract_soldier);
        Button addCavalry = view.findViewById(R.id.add_cavalry);
        Button substractCavalry = view.findViewById(R.id.substract_cavalry);

        //10
        Button addSoldier10 = view.findViewById(R.id.add_soldier10);
        Button substractSoldier10 = view.findViewById(R.id.substract_soldier10);
        Button addCavalry10 = view.findViewById(R.id.add_cavalry10);
        Button substractCavalry10 = view.findViewById(R.id.substract_cavalry10);

        //100
        Button addSoldier100 = view.findViewById(R.id.add_soldier100);
        Button substractSoldier100 = view.findViewById(R.id.substract_soldier100);
        Button addCavalry100 = view.findViewById(R.id.add_cavalry100);
        Button substractCavalry100 = view.findViewById(R.id.substract_cavalry100);

        //1000
        Button addSoldier1000 = view.findViewById(R.id.add_soldier1000);
        Button substractSoldier1000 = view.findViewById(R.id.substract_soldier1000);
        Button addCavalry1000 = view.findViewById(R.id.add_cavalry1000);
        Button substractCavalry1000 = view.findViewById(R.id.substract_cavalry1000);

        addSoldier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addSoldier(1);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        substractSoldier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractSoldier(1);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        addSoldier10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addSoldier(10);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        substractSoldier10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractSoldier(10);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        addSoldier100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addSoldier(100);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        substractSoldier100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractSoldier(100);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        addSoldier1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addSoldier(1000);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        substractSoldier1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractSoldier(1000);
                TextView soldier = getActivity().findViewById(R.id.Soldiers);
                String s = "Soldiers: " + army.soldiers();
                soldier.setText(s);
            }
        });
        addCavalry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addCavalry(1);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });
        substractCavalry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractCavalry(1);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });
        addCavalry10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addCavalry(10);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });
        substractCavalry10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractCavalry(10);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });
        addCavalry100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addCavalry(100);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });
        substractCavalry100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractCavalry(100);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });
        addCavalry1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.addCavalry(1000);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });
        substractCavalry1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                army.substractCavalry(1000);
                TextView cavalry = getActivity().findViewById(R.id.Cavalry);
                String c = "Cavalry: " + army.cavalry();
                cavalry.setText(c);
            }
        });



        Button invadeThorp = view.findViewById(R.id.iThorp);
        Button invadeHamlet = view.findViewById(R.id.iHamlet);
        Button invadeVillage = view.findViewById(R.id.iVillage);
        Button invadeSmallTown = view.findViewById(R.id.iSmalltown);
        Button invadeLargeTown = view.findViewById(R.id.iLargetown);
        Button invadeSmallCity = view.findViewById(R.id.iSmallcity);
        Button invadeLargeCity = view.findViewById(R.id.iLargecity);
        Button invadeMetropolis = view.findViewById(R.id.iMetropolis);
        Button invadeSmallNation = view.findViewById(R.id.iSmallnation);
        Button invadeNation = view.findViewById(R.id.iNation);
        Button invadeLargeNation = view.findViewById(R.id.iLargenation);
        Button invadeEmpire = view.findViewById(R.id.iEmpire);
        Button invadeContinentalEmpire = view.findViewById(R.id.iContinentalEmpire);
        Button invadeWorlConfederation = view.findViewById(R.id.iWorldConfederation);
        Button invadeUnitedWorld = view.findViewById(R.id.iUnitedWorld);
        invadeThorp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invadeThorp(new Random().nextInt(5),army.amount("SOLDIERS") + army.amount("CAVALRY"));
            }
        });
        invadeHamlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invadeHamlet(Math.floor(Math.random() * ((15-3)+1) + 3),army.amount("SOLDIERS") + army.amount("CAVALRY"));
            }
        });
        invadeVillage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((50-10)+1) + 10), "Village", new Random().nextInt(100)+100);
            }
        });
        invadeSmallTown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((500-100)+1) + 100), "Small Town", (int) Math.floor(Math.random() * ((2000-1000)+1) + 100));
            }
        });
        invadeLargeTown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((400-100)+1) + 100), "large Town", (int) Math.floor(Math.random() * ((200-100)+1) + 100));
            }
        });
        invadeSmallCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((2500-250)+1) + 250), "Small City", (int) Math.floor(Math.random() * ((10000-5000)+1) + 5000));
            }
        });
        invadeLargeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((5000-1000)+1) + 1000), "Large City", (int) Math.floor(Math.random() * ((20000-10000)+1) + 10000));
            }
        });
        invadeMetropolis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((12500-2500)+1) + 2500), "Metropolis", (int) Math.floor(Math.random() * ((25000-5000)+1) + 5000));
            }
        });
        invadeSmallNation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((25000-5000)+1) + 5000), "Small Nation", (int) Math.floor(Math.random() * ((100000-50000)+1) + 50000));
            }
        });
        invadeNation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((50000-10000)+1) + 10000), "Nation", (int) Math.floor(Math.random() * ((200000-100000)+1) + 100000));
            }
        });
        invadeLargeNation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((125000-25000)+1) + 25000), "Large Nation", (int) Math.floor(Math.random() * ((500000-250000)+1) + 250000));
            }
        });
        invadeEmpire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((250000-50000)+1) + 50000), "Empire", (int) Math.floor(Math.random() * ((1000000-500000)+1) + 500000));
            }
        });
        invadeContinentalEmpire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((1000000-500000)+1) + 500000), "Continental Empire", (int) Math.floor(Math.random() * ((2000000-1000000)+1) + 1000000));
            }
        });
        invadeWorlConfederation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((1500000-1000000)+1) + 1000000), "World Confederation", (int) Math.floor(Math.random() * ((4000000-2000000)+1) + 2000000));
            }
        });
        invadeUnitedWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invade(Math.floor(Math.random() * ((2000000-1500000)+1) + 1500000), "Village", (int) Math.floor(Math.random() * ((4000000-2000000)+1) + 2000000));
            }
        });
        thread.start();

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        thread.interrupt();
    }
    public void invadeThorp(double enemy, double total) {
        Handler h = new android.os.Handler();
        final HomeArmy ha = new HomeArmy();
        final Enemy e = new Enemy();
        try{
            TextView enemytv = getActivity().findViewById(R.id.enemyArmy);
            enemytv.setText("Enemy Soldiers: " + enemy);
            TextView invading = getActivity().findViewById(R.id.invading);
            invading.setText("Invading Thorp");
        }catch (NullPointerException x) {
            x.printStackTrace();
        }
        enemy-=1;
        total-=1;
        if(total%2==0){
            army.killSoldier(1);
        }else{
            army.killCavalry(1);
        }
        e.add(enemy);
        ha.soldiers = total;
        if(enemy<=0){
            try {
                TextView enemytv = getActivity().findViewById(R.id.enemyArmy);
                TextView invading = getActivity().findViewById(R.id.invading);
                enemytv.setText("Enemy Soldiers: " + enemy);
                invading.setText("Invasion Successful!");
            }catch (NullPointerException x) {
                x.printStackTrace();
            }
            army.plunderLand((new Random().nextInt(10)) + 10);
            return;
        }
        else if(total<=0){
            army.defeat();
            TextView invading = getActivity().findViewById(R.id.invading);
            invading.setText("Invasion Unsuccessful! Army has been defeated.");
            return;
        }
        else{
            h.postDelayed(
                    new Runnable() {
                        public void run() {
                            invadeThorp(e.enemySoldiers,ha.soldiers);
                        }
                    },1000);
        }

    }
    public void invadeHamlet(double enemy, double total) {
        Handler h = new android.os.Handler();
        final HomeArmy ha = new HomeArmy();
        final Enemy e = new Enemy();
        try{
            TextView enemytv = getActivity().findViewById(R.id.enemyArmy);
            enemytv.setText("Enemy Soldiers: " + enemy);
            TextView invading = getActivity().findViewById(R.id.invading);
            invading.setText("Invading Hamlet");
        }catch (NullPointerException x) {
            x.printStackTrace();
        }
        enemy-=1;
        total-=1;
        if(total%2==0){
            army.killSoldier(1);
        }else{
            army.killCavalry(1);
        }
        e.add(enemy);
        ha.soldiers = total;
        if(enemy<=0){
            try {
                TextView enemytv = getActivity().findViewById(R.id.enemyArmy);
                TextView invading = getActivity().findViewById(R.id.invading);
                enemytv.setText("Enemy Soldiers: " + enemy);
                invading.setText("Invasion Successful!");
            }catch (NullPointerException x) {
                x.printStackTrace();
            }
            army.plunderLand((new Random().nextInt(30)) + 30);
            return;
        }
        else if(total<=0){
            army.defeat();
            TextView invading = getActivity().findViewById(R.id.invading);
            invading.setText("Invasion Unsuccessful! Army has been defeated.");
            return;
        }
        else{
            h.postDelayed(
                    new Runnable() {
                        public void run() {
                            invadeHamlet(e.enemySoldiers,ha.soldiers);
                        }
                    },1000);
        }

    }
    public void invade(double enemy, final String civType, final int plunder) {
        Handler h = new android.os.Handler();
        final HomeArmy ha = new HomeArmy();
        final Enemy e = new Enemy();
        try{
            TextView enemytv = getActivity().findViewById(R.id.enemyArmy);
            enemytv.setText("Enemy Soldiers: " + enemy);
            TextView invading = getActivity().findViewById(R.id.invading);
            invading.setText("Invading "+ civType);
        }catch (NullPointerException x) {
            x.printStackTrace();
        }
        int kill = (int) Math.ceil(enemy*.03);
        enemy-= Double.parseDouble(army.soldiers())*army.SoldierEfficiency() + Double.parseDouble(army.cavalry())*army.CavalryEfficiency();
        enemy = (int) Math.ceil(enemy);
        army.killSoldier(kill);
        army.killCavalry(kill);
        e.add(enemy);
        ha.soldiers = Integer.parseInt(army.soldiers());
        ha.cavalry = Integer.parseInt(army.cavalry());
        if(enemy<=0){
            try {
                TextView enemytv = getActivity().findViewById(R.id.enemyArmy);
                TextView invading = getActivity().findViewById(R.id.invading);
                enemytv.setText("Enemy Soldiers: " + enemy);
                invading.setText("Invasion Successful!");
            }catch (NullPointerException x) {
                x.printStackTrace();
            }
            army.plunderLand(plunder);
            return;
        }
        else if((Integer.parseInt(army.soldiers()) + Integer.parseInt(army.cavalry()))<=0){
            army.defeat();
            TextView invading = getActivity().findViewById(R.id.invading);
            invading.setText("Invasion Unsuccessful! Army has been defeated.");
            return;
        }
        else{
            h.postDelayed(
                    new Runnable() {
                        public void run() {
                            invade(e.enemySoldiers,civType, plunder);
                        }
                    },1000);
        }
    }

    private class Enemy {
        public double enemySoldiers;
        public void substract(double d){
            enemySoldiers -= d;
        }
        public void add(double d){
            enemySoldiers += d;
        }
    }
    private class HomeArmy {
        public double soldiers;
        public double cavalry;
        public void substract(double d){
            soldiers -= d/2;
            cavalry -= d/2;
        }
        public void add(double d){
            soldiers += d/2;
            cavalry += d/2;
        }
        public void setArmy(double c, double s){
            cavalry = c;
            soldiers = s;
        }
    }

    public interface army {
        // TODO: Update argument type and name
        String soldiers();
        void addSoldier(int amount);
        void substractSoldier(int amount);
        String cavalry();
        void addCavalry(int amount);
        void substractCavalry(int amount);
        void toast(String string);
        int amount(String res);
        double SoldierEfficiency();
        double CavalryEfficiency();
        void killSoldier(int amount);
        void killCavalry(int amount);
        void plunderLand(int amount);
        void defeat();
//        void invadeThorp();
//        void invadeHamlet();
//        void invadeVillage();
//        void invadeSmallTown();
//        void invadeLargeTown();
//        void invadeSmallCity();
//        void invadeLargeCity();
//        void invadeMetropolis();
//        void invadeSmallNation();
//        void invadeNation();
//        void invadeLargeNation();
//        void invadeEmpire();
//        void invadeContinentalEmpire();
//        void invadeWorldConfederatio();
//        void invadeUnitedWorld();

    }
}
