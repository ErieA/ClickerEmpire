package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ECIupgradedjobs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private ECIemploymentOffice office;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ECIemploymentOffice) {
            office = (ECIemploymentOffice) context;
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
                            try {
                                TextView farmers = getActivity().findViewById(R.id.farmersu);
                                String f = "Farmers: " + office.farmers();
                                farmers.setText(f);
                                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                                String l = "Lumberjacks: " + office.lumberjacks();
                                lumberjacks.setText(l);
                                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                                String s = "Stonemasons: " + office.stonemasons();
                                stonemasons.setText(s);
                                TextView tanners = getActivity().findViewById(R.id.tannersu);
                                String t = "Tanners: " + office.tanners();
                                tanners.setText(t);
                                TextView healers = getActivity().findViewById(R.id.healersu);
                                String h = "Healers: " + office.healers();
                                healers.setText(h);
                                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                                String b = "Blacksmiths: " + office.blacksmith();
                                blacksmiths.setText(b);
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };

    public ECIupgradedjobs() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eciupgradedjobs, container, false);

        //1
        Button addFarmer = view.findViewById(R.id.customadd_farmer);
        Button substractFarmer = view.findViewById(R.id.customsubstract_farmer);
        Button addLumberjack = view.findViewById(R.id.customadd_lumberjack);
        Button substractLumberjack = view.findViewById(R.id.customsubstract_lumberjack);
        Button addstonemason = view.findViewById(R.id.customadd_stonemason);
        Button substractstonemason = view.findViewById(R.id.customsubstract_stonemason);
        Button addtanner = view.findViewById(R.id.customadd_tanner);
        Button substracttanner = view.findViewById(R.id.customsubstract_tanner);
        Button addhealer = view.findViewById(R.id.customadd_healer);
        Button substracthealer = view.findViewById(R.id.customsubstract_healer);
        Button addblacksmith = view.findViewById(R.id.customadd_blacksmith);
        Button substractblacksmith = view.findViewById(R.id.customsubstract_blacksmith);


        addFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText farmer = getActivity().findViewById(R.id.customfarmer);
                int amt;
                try {
                    amt = Integer.parseInt(farmer.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.addFarmer(amt);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        substractFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText farmer = getActivity().findViewById(R.id.customfarmer);
                int amt;
                try {
                    amt = Integer.parseInt(farmer.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.substractFarmer(amt);
                TextView farmers = getActivity().findViewById(R.id.farmersu);
                String f = "Farmers: " + office.farmers();
                farmers.setText(f);
            }
        });
        addLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText lumberjack = getActivity().findViewById(R.id.customlumberjack);
                int amt;
                try {
                    amt = Integer.parseInt(lumberjack.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.addLumberjack(amt);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        substractLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText lumberjack = getActivity().findViewById(R.id.customlumberjack);
                int amt;
                try {
                    amt = Integer.parseInt(lumberjack.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.substractLumberjack(amt);
                TextView lumberjacks = getActivity().findViewById(R.id.lumberjacksu);
                String l = "Lumberjacks: " + office.lumberjacks();
                lumberjacks.setText(l);
            }
        });
        addstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stonemason = getActivity().findViewById(R.id.customstonemason);
                int amt;
                try {
                    amt = Integer.parseInt(stonemason.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.addStonemason(amt);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        substractstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stonemason = getActivity().findViewById(R.id.customstonemason);
                int amt;
                try {
                    amt = Integer.parseInt(stonemason.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.substractStonemason(amt);
                TextView stonemasons = getActivity().findViewById(R.id.stonemasonsu);
                String s = "Stonemasons: " + office.stonemasons();
                stonemasons.setText(s);
            }
        });
        addtanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tanner = getActivity().findViewById(R.id.customtanner);
                int amt;
                try {
                    amt = Integer.parseInt(tanner.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.addTanner(amt);
                TextView tanners = getActivity().findViewById(R.id.tannersu);
                String t = "Tanners: " + office.tanners();
                tanners.setText(t);
            }
        });
        substracttanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tanner = getActivity().findViewById(R.id.customtanner);
                int amt;
                try {
                    amt = Integer.parseInt(tanner.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.substractTanner(amt);
                TextView tanners = getActivity().findViewById(R.id.tannersu);
                String t = "Tanners: " + office.tanners();
                tanners.setText(t);
            }
        });
        addhealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText healer = getActivity().findViewById(R.id.customhealer);
                int amt;
                try {
                    amt = Integer.parseInt(healer.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.addHealer(amt);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String h = "Healers: " + office.healers();
                healers.setText(h);
            }
        });
        substracthealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText healer = getActivity().findViewById(R.id.customhealer);
                int amt;
                try {
                    amt = Integer.parseInt(healer.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.substractHealer(amt);
                TextView healers = getActivity().findViewById(R.id.healersu);
                String h = "Healers: " + office.healers();
                healers.setText(h);
            }
        });
        addblacksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText blacksmith = getActivity().findViewById(R.id.customblacksmith);
                int amt;
                try {
                    amt = Integer.parseInt(blacksmith.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.addBlacksmith(amt);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String b = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(b);
            }
        });
        substractblacksmith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText blacksmith = getActivity().findViewById(R.id.customblacksmith);
                int amt;
                try {
                    amt = Integer.parseInt(blacksmith.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                office.substractBlacksmith(amt);
                TextView blacksmiths = getActivity().findViewById(R.id.blacksmithsu);
                String b = "Blacksmiths: " + office.blacksmith();
                blacksmiths.setText(b);
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

    public interface ECIemploymentOffice {
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
