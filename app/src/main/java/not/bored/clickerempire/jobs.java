package not.bored.clickerempire;

import android.content.Context;
import android.net.Uri;
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
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
    private employmentOffice office;
    public jobs() {
        // Required empty public constructor
    }

//    // TODO: Rename and change types and number of parameters
//    public static jobs newInstance(String param1, String param2) {
//        jobs fragment = new jobs();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

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
        Button addFarmer = view.findViewById(R.id.add_farmer);
        Button substractFarmer = view.findViewById(R.id.substract_farmer);
        Button addLumberjack = view.findViewById(R.id.add_lumberjack);
        Button substractLumberjack = view.findViewById(R.id.substract_lumberjack);
        Button addstonemason = view.findViewById(R.id.add_stonemason);
        Button substractstonemason = view.findViewById(R.id.substract_stonemason);
        addFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(office.totalUnemployed()>0){
                    office.addFarmer();
                    TextView farmerstv =(TextView) getActivity().findViewById(R.id.farmers);
                    int farmers = Integer.parseInt(farmerstv.getText().toString().substring(9));
                    farmers++;
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
        });
        substractFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(office.workerAmount("FARMERS"))>0){
                    office.substractFarmer();
                    TextView farmerstv =(TextView) getActivity().findViewById(R.id.farmers);
                    int farmers = Integer.parseInt(farmerstv.getText().toString().substring(9));
                    farmers--;
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
        });
        addLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(office.totalUnemployed()>0){
                    office.addLumberjack();
                    TextView lumberjackstv = getActivity().findViewById(R.id.lumberjacks);
                    int lumberjacks = Integer.parseInt(lumberjackstv.getText().toString().substring(13));
                    lumberjacks++;
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
        });
        substractLumberjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(office.workerAmount("LUMBERJACKS"))>0){
                    office.substractLumberjack();
                    TextView lumberjackstv = getActivity().findViewById(R.id.lumberjacks);
                    int lumberjacks = Integer.parseInt(lumberjackstv.getText().toString().substring(13));
                    lumberjacks--;
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
        });
        addstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(office.totalUnemployed()>0){
                    office.addStonemason();
                    TextView stonemasonstv = getActivity().findViewById(R.id.stonemasons);
                    int stonemasons= Integer.parseInt(stonemasonstv.getText().toString().substring(13));
                    stonemasons++;
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
        });
        substractstonemason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(office.workerAmount("STONEMASONS"))>0){
                    office.substractStonemason();
                    TextView stonemasonstv = getActivity().findViewById(R.id.stonemasons);
                    int stonemasons= Integer.parseInt(stonemasonstv.getText().toString().substring(13));
                    stonemasons--;
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
        });
        return view;
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
        void addFarmer();
        void substractFarmer();
        void addLumberjack();
        void substractLumberjack();
        void addStonemason();
        void substractStonemason();
        void toast(int i);
        String workerAmount(String worker);

    }
}
