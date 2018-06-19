package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class buildings extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private buildingBuilder builder;

    public buildings() {
        // Required empty public constructor
    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment buildings.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static buildings newInstance(String param1, String param2) {
//        buildings fragment = new buildings();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buildings, container, false);
        Button buildtent = view.findViewById(R.id.buildtent);
        TextView num_tent = view.findViewById(R.id.num_tent);
        String amt = builder.resourceAmount("TENTS");
        num_tent.setText(amt);
        buildtent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_tent = getActivity().findViewById(R.id.num_tent);
                String str = num_tent.getText().toString();
                if(str == ""){
                    str = "0";
                }
                int num = Integer.parseInt(str);
                num++;
                boolean build = builder.buildTent();
                if(build){
                    num_tent.setText(""+num);
                    num_tent.invalidate();
                    num_tent.requestLayout();
                }
            }
        });
        Button buildhut = view.findViewById(R.id.buildhut);
        TextView num_hut = view.findViewById(R.id.num_hut);
        amt = builder.resourceAmount("HUTS");
        num_hut.setText(amt);
        buildhut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_hut = getActivity().findViewById(R.id.num_hut);
                String str = num_hut.getText().toString();
                if(str == ""){
                    str = "0";
                }
                int num = Integer.parseInt(str);
                num++;
                boolean build = builder.buildHut();
                if(build){
                    num_hut.setText(""+num);
                    num_hut.invalidate();
                    num_hut.requestLayout();
                }
            }
        });
        Button buildhouse = view.findViewById(R.id.buildhouse);
        TextView num_house = view.findViewById(R.id.num_house);
        amt = builder.resourceAmount("HOUSES");
        num_house.setText(amt);
        buildhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_house = getActivity().findViewById(R.id.num_house);
                String str = num_house.getText().toString();
                if(str == ""){
                    str = "0";
                }
                int num = Integer.parseInt(str);
                num++;
                boolean build = builder.buildHouse();
                if(build){
                    num_house.setText(""+num);
                    num_house.invalidate();
                    num_house.requestLayout();
                }
            }
        });
        Button buildmansion = view.findViewById(R.id.buildmansion);
        TextView num_mansion = view.findViewById(R.id.num_mansion);
        amt = builder.resourceAmount("MANSIONS");
        num_mansion.setText(amt);
        buildmansion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_mansion = getActivity().findViewById(R.id.num_mansion);
                String str = num_mansion.getText().toString();
                if(str == ""){
                    str = "0";
                }
                int num = Integer.parseInt(str);
                num++;
                boolean build = builder.buildMansion();
                if(build){
                    num_mansion.setText(""+num);
                    num_mansion.invalidate();
                    num_mansion.requestLayout();
                }
            }
        });
        Button buildbarn = view.findViewById(R.id.buildbarn);
        TextView num_barn = view.findViewById(R.id.num_barn);
        amt = builder.resourceAmount("BARNS");
        num_barn.setText(amt);
        buildbarn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_barn = getActivity().findViewById(R.id.num_barn);
                String str = num_barn.getText().toString();
                if(str == ""){
                    str = "0";
                }
                int num = Integer.parseInt(str);
                num++;
                boolean build = builder.buildBarn();
                if(build){
                    num_barn.setText(""+num);
                    num_barn.invalidate();
                    num_barn.requestLayout();
                }
            }
        });
        Button buildwoodstockpile = view.findViewById(R.id.buildwoodstockpile);
        TextView num_woodstockpile = view.findViewById(R.id.num_woodstockpile);
        amt = builder.resourceAmount("WOODSTOCKPILES");
        num_woodstockpile.setText(amt);
        buildwoodstockpile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_woodstockpile = getActivity().findViewById(R.id.num_woodstockpile);
                String str = num_woodstockpile.getText().toString();
                if(str == ""){
                    str = "0";
                }
                int num = Integer.parseInt(str);
                num++;
                boolean build = builder.buildWoodStockpile();
                if(build){
                    num_woodstockpile.setText(""+num);
                    num_woodstockpile.invalidate();
                    num_woodstockpile.requestLayout();
                }
            }
        });
        Button buildstonestockpile = view.findViewById(R.id.buildstonestockpile);
        TextView num_stonestockpile = view.findViewById(R.id.num_stonestockpile);
        amt = builder.resourceAmount("STONESTOCKPILES");
        num_stonestockpile.setText(amt);
        buildstonestockpile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_stonestockpile = getActivity().findViewById(R.id.num_stonestockpile);
                String str = num_stonestockpile.getText().toString();
                if(str == ""){
                    str = "0";
                }
                int num = Integer.parseInt(str);
                num++;
                boolean build = builder.buildStoneStockpile();
                if(build){
                    num_stonestockpile.setText(""+num);
                    num_stonestockpile.invalidate();
                    num_stonestockpile.requestLayout();
                }
            }
        });
        return view;
    }
    //
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof buildingBuilder) {
            builder = (buildingBuilder) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    //
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
    public interface buildingBuilder {
        // TODO: Update argument type and name
        boolean buildTent();
        boolean buildHut();
        boolean buildHouse();
        boolean buildMansion();
        boolean buildBarn();
        boolean buildWoodStockpile();
        boolean buildStoneStockpile();
        String resourceAmount(String resource);
        boolean atomicHUT();
    }
}
