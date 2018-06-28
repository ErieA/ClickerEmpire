package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class jobs extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private employmentOffice office;
    public jobs() {
        // Required empty public constructor
    }

//    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);
        TextView farmerstv = view.findViewById(R.id.farmers);
        String f = "Farmers: " +office.workerAmount("FARMERS");
        farmerstv.setText(f);
        TextView lumberjackstv = view.findViewById(R.id.lumberjacks);
        String l = "Lumberjacks: " + office.workerAmount("LUMBERJACKS");
        lumberjackstv.setText(l);
        TextView stonemasonstv = view.findViewById(R.id.stonemasons);
        String s ="Stonemasons: " + office.workerAmount("STONEMASONS");
        stonemasonstv.setText(s);

        //1
        final Button addFarmer = view.findViewById(R.id.add_farmer);
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
                addFarmers(1);
            }
        });
        substractFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subFarmers(1);
            }
        });
        addLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLumberjacks(1);
            }
        });
        substractLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subLumberjacks(1);
            }
        });
        addstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStonemasons(1);
            }
        });
        substractstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subStonemasons(1);
            }
        });
        addFarmer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFarmers(10);
            }
        });
        substractFarmer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subFarmers(10);
            }
        });
        addLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLumberjacks(10);
            }
        });
        substractLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subLumberjacks(10);
            }
        });
        addLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLumberjacks(10);
            }
        });
        substractLumberjack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subLumberjacks(10);
            }
        });
        addstonemason10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStonemasons(10);
            }
        });
        substractstonemason10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subStonemasons(10);
            }
        });
        addFarmer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFarmers(100);
            }
        });
        substractFarmer100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subFarmers(100);
            }
        });
        addLumberjack100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLumberjacks(100);
            }
        });
        substractLumberjack100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subLumberjacks(100);
            }
        });
        addstonemason100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStonemasons(100);
            }
        });
        substractstonemason100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subStonemasons(100);
            }
        });
        addFarmer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFarmers(1000);
            }
        });
        substractFarmer1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subFarmers(1000);
            }
        });
        addLumberjack1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLumberjacks(1000);
            }
        });
        substractLumberjack1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subLumberjacks(1000);
            }
        });
        addstonemason1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStonemasons(1000);
            }
        });
        substractstonemason1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subStonemasons(1000);
            }
        });
        return view;
    }
    public void addFarmers(int amount){
        if(office.totalUnemployed()>=amount){
            office.addFarmer(amount);
            TextView farmerstv =(TextView) getActivity().findViewById(R.id.farmers);
            int farmers = Integer.parseInt(farmerstv.getText().toString().substring(9));
            farmers+=amount;
            String ff = "Farmers: " + farmers;
            farmerstv.setText(ff);
            farmerstv.invalidate();
            farmerstv.requestLayout();
            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.detach(currentFragment);
            fragmentTransaction.attach(currentFragment);
            fragmentTransaction.commit();
        }
    }
    public void subFarmers(int amount){
        if(Integer.parseInt(office.workerAmount("FARMERS"))>=amount){
            office.substractFarmer(amount);
            TextView farmerstv =(TextView) getActivity().findViewById(R.id.farmers);
            int farmers = Integer.parseInt(farmerstv.getText().toString().substring(9));
            farmers-=amount;
            String ff = "Farmers: " + farmers;
            farmerstv.setText(ff);
            farmerstv.invalidate();
            farmerstv.requestLayout();
            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.detach(currentFragment);
            fragmentTransaction.attach(currentFragment);
            fragmentTransaction.commit();
        }
    }
    public void addLumberjacks(int amount){
        if(office.totalUnemployed()>=amount){
            office.addLumberjack(amount);
            TextView lumberjackstv = getActivity().findViewById(R.id.lumberjacks);
            int lumberjacks = Integer.parseInt(lumberjackstv.getText().toString().substring(13));
            lumberjacks+=amount;
            String ll ="Lumberjacks: " + lumberjacks;
            lumberjackstv.setText(ll);
            lumberjackstv.invalidate();
            lumberjackstv.requestLayout();
            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.detach(currentFragment);
            fragmentTransaction.attach(currentFragment);
            fragmentTransaction.commit();
        }
    }
    public void subLumberjacks(int amount){
        if(Integer.parseInt(office.workerAmount("LUMBERJACKS"))>=amount){
            office.substractLumberjack(amount);
            TextView lumberjackstv = getActivity().findViewById(R.id.lumberjacks);
            int lumberjacks = Integer.parseInt(lumberjackstv.getText().toString().substring(13));
            lumberjacks-=amount;
            String ll ="Lumberjacks: " + lumberjacks;
            lumberjackstv.setText(ll);
            lumberjackstv.invalidate();
            lumberjackstv.requestLayout();
            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.detach(currentFragment);
            fragmentTransaction.attach(currentFragment);
            fragmentTransaction.commit();
        }
    }
    public void addStonemasons(int amount){
        if(office.totalUnemployed()>=amount){
            office.addStonemason(amount);
            TextView stonemasonstv = getActivity().findViewById(R.id.stonemasons);
            int stonemasons= Integer.parseInt(stonemasonstv.getText().toString().substring(13));
            stonemasons+=amount;
            String ss = "Stonemasons: " + stonemasons;
            stonemasonstv.setText(ss);
            stonemasonstv.invalidate();
            stonemasonstv.requestLayout();
            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.detach(currentFragment);
            fragmentTransaction.attach(currentFragment);
            fragmentTransaction.commit();
        }
    }
    public void subStonemasons(int amount){
        if(Integer.parseInt(office.workerAmount("STONEMASONS"))>=amount){
            office.substractStonemason(amount);
            TextView stonemasonstv = getActivity().findViewById(R.id.stonemasons);
            int stonemasons= Integer.parseInt(stonemasonstv.getText().toString().substring(13));
            stonemasons-=amount;
            String ss = "Stonemasons: " + stonemasons;
            stonemasonstv.setText(ss);
            stonemasonstv.invalidate();
            stonemasonstv.requestLayout();
            Fragment currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.detach(currentFragment);
            fragmentTransaction.attach(currentFragment);
            fragmentTransaction.commit();
        }
    }
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

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface employmentOffice {
        // TODO: Update argument type and name
        int totalUnemployed();
        void addFarmer(int amount);
        void substractFarmer(int amount);
        void addLumberjack(int amount);
        void substractLumberjack(int amount);
        void addStonemason(int amount);
        void substractStonemason(int amount);
        void toast(int i);
        String workerAmount(String worker);

    }
}
