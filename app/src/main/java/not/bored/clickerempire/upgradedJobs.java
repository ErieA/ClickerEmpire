package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class upgradedJobs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private upgradedemploymentOffice office;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof upgradedemploymentOffice) {
            office = (upgradedemploymentOffice) context;
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
                    Thread.sleep(500);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                TextView healers = getActivity().findViewById(R.id.healersu);
                                String h = "Healers: " + office.healers();
                                healers.setText(h);
                                TextView tanners = getActivity().findViewById(R.id.tannersu);
                                String t = "Tanners: " + office.tanners();
                                tanners.setText(t);
                                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                                String b = "Blacksmiths: " + office.blacksmith();
                                blacksmiths.setText(b);
                                TextView farmers = getActivity().findViewById(R.id.farmersu);
                                String f = "Farmers: " + office.farmers();
                                farmers.setText(f);
                                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                                String l = "Lumberjacks: " + office.lumberjacks();
                                lumberjacks.setText(l);
                                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                                String s = "Stonemasons: " + office.stonemasons();
                                stonemasons.setText(s);
                            }
                            catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };
    public upgradedJobs() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upgraded_jobs, container, false);


        Button addFarmer = view.findViewById(R.id.add_farmeru);
        Button substractFarmer = view.findViewById(R.id.substract_farmeru);
        Button addLumberjack = view.findViewById(R.id.add_lumberjacku);
        Button substractLumberjack = view.findViewById(R.id.substract_lumberjacku);
        Button addstonemason = view.findViewById(R.id.add_stonemasonu);
        Button substractstonemason = view.findViewById(R.id.substract_stonemasonu);
        Button addTanner = view.findViewById(R.id.add_tannersu);
        Button substractTanner = view.findViewById(R.id.substract_tannersu);
        Button addHealer = view.findViewById(R.id.add_healersu);
        Button substractHealer = view.findViewById(R.id.substract_healersu);
        Button addBlacksmith= view.findViewById(R.id.add_blacksmithsu);
        Button substractBlacksmith = view.findViewById(R.id.substract_blacksmithsu);

        //10
        Button addFarmer10 = view.findViewById(R.id.add_farmeru10);
        Button substractFarmer10 = view.findViewById(R.id.substract_farmeru10);
        Button addLumberjack10 = view.findViewById(R.id.add_lumberjacku10);
        Button substractLumberjack10 = view.findViewById(R.id.substract_lumberjacku10);
        Button addstonemason10 = view.findViewById(R.id.add_stonemasonu10);
        Button substractstonemason10 = view.findViewById(R.id.substract_stonemasonu10);
        Button addTanner10 = view.findViewById(R.id.add_tannersu10);
        Button substractTanner10 = view.findViewById(R.id.substract_tannersu10);
        Button addHealer10 = view.findViewById(R.id.add_healersu10);
        Button substractHealer10 = view.findViewById(R.id.substract_healersu10);
        Button addBlacksmith10 = view.findViewById(R.id.add_blacksmithsu10);
        Button substractBlacksmith10 = view.findViewById(R.id.substract_blacksmithsu10);

        //100
        Button addFarmer100 = view.findViewById(R.id.add_farmeru100);
        Button substractFarmer100 = view.findViewById(R.id.substract_farmeru100);
        Button addLumberjack100 = view.findViewById(R.id.add_lumberjacku100);
        Button substractLumberjack100 = view.findViewById(R.id.substract_lumberjacku100);
        Button addstonemason100 = view.findViewById(R.id.add_stonemasonu100);
        Button substractstonemason100 = view.findViewById(R.id.substract_stonemasonu100);
        Button addTanner100 = view.findViewById(R.id.add_tannersu100);
        Button substractTanner100 = view.findViewById(R.id.substract_tannersu100);
        Button addHealer100 = view.findViewById(R.id.add_healersu100);
        Button substractHealer100 = view.findViewById(R.id.substract_healersu100);
        Button addBlacksmith100 = view.findViewById(R.id.add_blacksmithsu100);
        Button substractBlacksmith100 = view.findViewById(R.id.substract_blacksmithsu100);

        //1000
        Button addFarmer1000 = view.findViewById(R.id.add_farmeru1000);
        Button substractFarmer1000 = view.findViewById(R.id.substract_farmeru1000);
        Button addLumberjack1000 = view.findViewById(R.id.add_lumberjacku1000);
        Button substractLumberjack1000 = view.findViewById(R.id.substract_lumberjacku1000);
        Button addstonemason1000 = view.findViewById(R.id.add_stonemasonu1000);
        Button substractstonemason1000 = view.findViewById(R.id.substract_stonemasonu1000);
        Button addTanner1000 = view.findViewById(R.id.add_tannersu1000);
        Button substractTanner1000 = view.findViewById(R.id.substract_tannersu1000);
        Button addHealer1000 = view.findViewById(R.id.add_healersu1000);
        Button substractHealer1000 = view.findViewById(R.id.substract_healersu1000);
        Button addBlacksmith1000 = view.findViewById(R.id.add_blacksmithsu1000);
        Button substractBlacksmith1000 = view.findViewById(R.id.substract_blacksmithsu1000);


        addHealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addHealer(1);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        substractHealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractHealer(1);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        addHealer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addHealer(10);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        substractHealer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractHealer(10);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        addHealer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addHealer(100);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        substractHealer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractHealer(100);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        addHealer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addHealer(1000);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        substractHealer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractHealer(1000);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String f = "Healers: " + office.healers();
                healers.setText(f);
            }
        });
        addBlacksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addBlacksmith(1);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        substractBlacksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractBlacksmith(1);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        addBlacksmith10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addBlacksmith(10);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        substractBlacksmith10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractBlacksmith(10);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        addBlacksmith100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addBlacksmith(100);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        substractBlacksmith100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractBlacksmith(100);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        addBlacksmith1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addBlacksmith(1000);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        substractBlacksmith1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractBlacksmith(1000);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String f = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(f);
            }
        });
        addFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(1);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(1);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(1);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(1);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(1);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(1);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addFarmer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(10);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(10);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(10);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(10);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(10);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(10);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addFarmer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(100);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(100);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(100);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(100);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(100);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(100);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addFarmer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(1000);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(1000);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(1000);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(1000);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(1000);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(1000);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addTanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addTanner(1);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        substractTanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractTanner(1);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        addTanner10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addTanner(10);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        substractTanner10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractTanner(10);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        addTanner100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addTanner(100);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        substractTanner100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractTanner(100);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        addTanner1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addTanner(1000);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        substractTanner1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractTanner(1000);
                TextView tanner = getActivity().findViewById(R.id.tannersu);
                String f = "Tanners: " + office.tanners();
                tanner.setText(f);
            }
        });
        TextView healers = view.findViewById(R.id.healersu);
        String h = "Healers: " + office.healers();
        healers.setText(h);
        TextView tanners = view.findViewById(R.id.tannersu);
        String t = "Tanners: " + office.tanners();
        tanners.setText(t);
        TextView blacksmiths = view.findViewById(R.id.blacksmithsu);
        String b = "Blacksmiths: " + office.blacksmith();
        blacksmiths.setText(b);
        TextView farmers = view.findViewById(R.id.farmersu);
        String f = "Farmers: " + office.farmers();
        farmers.setText(f);
        TextView lumberjacks = view.findViewById(R.id.lumberjacksu);
        String l = "Lumberjacks: " + office.lumberjacks();
        lumberjacks.setText(l);
        TextView stonemasons = view.findViewById(R.id.stonemasonsu);
        String s = "Stonemasons: " + office.stonemasons();
        stonemasons.setText(s);
        thread.start();
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        thread.interrupt();
    }

    public interface upgradedemploymentOffice {
        // TODO: Update argument type and name
        String farmers();
        void addFarmer(int amount);
        void substractFarmer(int amount);
        String lumberjacks();
        void addLumberjack(int amount);
        void substractLumberjack(int amount);
        String stonemasons();
        void addStonemason(int amount);
        void substractStonemason(int amount);
        String tanners();
        void addTanner(int amount);
        void substractTanner(int amount);
        String healers();
        void addHealer(int amount);
        void substractHealer(int amount);
        String blacksmith();
        void addBlacksmith(int amount);
        void substractBlacksmith(int amount);
        boolean checkMUpgrade();
        void toast(String string);
        boolean ECI();

    }
}
