package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class jobs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private employmentOffice office;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof employmentOffice) {
            office = (employmentOffice) context;
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
                                TextView farmers = getActivity().findViewById(R.id.farmers);
                                String f = "Farmers: " + office.farmers();
                                farmers.setText(f);
                                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                                String l = "Lumberjacks: " + office.lumberjacks();
                                lumberjacks.setText(l);
                                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                                String s = "Stonemasons: " + office.stonemasons();
                                stonemasons.setText(s);
                            }
                            catch (NullPointerException e) {
                                office.toast("Something fishy is going on");
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };
    public jobs() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);
//        LinearLayout all = view.findViewById(R.id.all);
//        all.setVisibility(View.VISIBLE);
        //1
        Button addFarmer = view.findViewById(R.id.add_farmer);
        Button substractFarmer = view.findViewById(R.id.substract_farmer);
        Button addLumberjack = view.findViewById(R.id.add_lumberjack);
        Button substractLumberjack = view.findViewById(R.id.substract_lumberjack);
        Button addstonemason = view.findViewById(R.id.add_stonemason);
        Button substractstonemason = view.findViewById(R.id.substract_stonemason);

        //10
        Button addFarmer10 = view.findViewById(R.id.add_farmer10);
        Button substractFarmer10 = view.findViewById(R.id.substract_farmer10);
        Button addLumberjack10 = view.findViewById(R.id.add_lumberjack10);
        Button substractLumberjack10 = view.findViewById(R.id.substract_lumberjack10);
        Button addstonemason10 = view.findViewById(R.id.add_stonemason10);
        Button substractstonemason10 = view.findViewById(R.id.substract_stonemason10);

        //100
        Button addFarmer100 = view.findViewById(R.id.add_farmer100);
        Button substractFarmer100 = view.findViewById(R.id.substract_farmer100);
        Button addLumberjack100 = view.findViewById(R.id.add_lumberjack100);
        Button substractLumberjack100 = view.findViewById(R.id.substract_lumberjack100);
        Button addstonemason100 = view.findViewById(R.id.add_stonemason100);
        Button substractstonemason100 = view.findViewById(R.id.substract_stonemason100);

        //1000
        Button addFarmer1000 = view.findViewById(R.id.add_farmer1000);
        Button substractFarmer1000 = view.findViewById(R.id.substract_farmer1000);
        Button addLumberjack1000 = view.findViewById(R.id.add_lumberjack1000);
        Button substractLumberjack1000 = view.findViewById(R.id.substract_lumberjack1000);
        Button addstonemason1000 = view.findViewById(R.id.add_stonemason1000);
        Button substractstonemason1000 = view.findViewById(R.id.substract_stonemason1000);


        addFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(1);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(1);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(1);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(1);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(1);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(1);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addFarmer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(10);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(10);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(10);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(10);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(10);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(10);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addFarmer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(100);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(100);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(100);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(100);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(100);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(100);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addFarmer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addFarmer(1000);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractFarmer(1000);
                TextView farmers = getActivity().findViewById(R.id.farmers);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addLumberjack(1000);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractLumberjack(1000);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacks);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.addStonemason(1000);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                office.substractStonemason(1000);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasons);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
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

    public interface employmentOffice {
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
        boolean checkMUpgrade();
        String workerAmount(String worker);
        void toast(String string);

    }
}
