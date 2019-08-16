package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ECIbuildings extends Fragment {


    public ECIbuildings() {
    }

    private buildingBuilder builder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ecibuildings, container, false);
        Button buildtent = view.findViewById(R.id.buildtent);
        TextView num_tent = view.findViewById(R.id.num_tent);
        String amt = builder.resourceAmount("TENTS");
        num_tent.setText(amt);
        buildtent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_tent = getActivity().findViewById(R.id.num_tent);
                String str = num_tent.getText().toString();
                if (str == "") {
                    str = "0";
                }
                int num = Integer.parseInt(str);
                EditText customtent = getActivity().findViewById(R.id.customtent);
                int amt;
                try {
                    amt = Integer.parseInt(customtent.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                num += amt;
                boolean build = builder.buildTent(amt);
                if (build) {
                    num_tent.setText("" + num);
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
                if (str == "") {
                    str = "0";
                }
                int num = Integer.parseInt(str);
                EditText customhut = getActivity().findViewById(R.id.customhut);
                int amt;
                try {
                    amt = Integer.parseInt(customhut.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                num += amt;
                boolean build = builder.buildHut(amt);
                if (build) {
                    num_hut.setText("" + num);
                    num_hut.invalidate();
                    num_hut.requestLayout();
                }
            }
        });
        if (builder.checkMUpgrade()) {
            Button buildhouse = view.findViewById(R.id.buildhouse);
            TextView num_house = view.findViewById(R.id.num_house);
            amt = builder.resourceAmount("HOUSES");
            num_house.setText(amt);
            buildhouse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView num_house = getActivity().findViewById(R.id.num_house);
                    String str = num_house.getText().toString();
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText customhouse = getActivity().findViewById(R.id.customhouse);
                    int amt;
                    try {
                        amt = Integer.parseInt(customhouse.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildHouse(amt);
                    if (build) {
                        num_house.setText("" + num);
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
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText custommansion = getActivity().findViewById(R.id.custommansion);
                    int amt;
                    try {
                        amt = Integer.parseInt(custommansion.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildMansion(amt);
                    if (build) {
                        num_mansion.setText("" + num);
                        num_mansion.invalidate();
                        num_mansion.requestLayout();
                    }
                }
            });
            Button buildcottage = view.findViewById(R.id.buildcottage);
            TextView num_cottage = view.findViewById(R.id.num_cottage);
            amt = builder.resourceAmount("COTTAGES");
            num_cottage.setText(amt);
            buildcottage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView num_cottage = getActivity().findViewById(R.id.num_cottage);
                    String str = num_cottage.getText().toString();
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText customcottage = getActivity().findViewById(R.id.customcottage);
                    int amt;
                    try {
                        amt = Integer.parseInt(customcottage.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildCottage(amt);
                    if (build) {
                        num_cottage.setText("" + num);
                        num_cottage.invalidate();
                        num_cottage.requestLayout();
                    }
                }
            });
            Button buildtannery = view.findViewById(R.id.buildtannery);
            TextView num_tannery = view.findViewById(R.id.num_tannery);
            amt = builder.resourceAmount("TANNERIES");
            num_tannery.setText(amt);
            buildtannery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView num_tannery = getActivity().findViewById(R.id.num_tannery);
                    String str = num_tannery.getText().toString();
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText customtannery = getActivity().findViewById(R.id.customtannery);
                    int amt;
                    try {
                        amt = Integer.parseInt(customtannery.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildTannery(amt);
                    if (build) {
                        num_tannery.setText("" + num);
                        num_tannery.invalidate();
                        num_tannery.requestLayout();
                    }
                }
            });
            Button buildsmithy = view.findViewById(R.id.buildsmithy);
            TextView num_smithy = view.findViewById(R.id.num_smithy);
            amt = builder.resourceAmount("SMITHIES");
            num_smithy.setText(amt);
            buildsmithy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView num_smithy = getActivity().findViewById(R.id.num_smithy);
                    String str = num_smithy.getText().toString();
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText customsmithy = getActivity().findViewById(R.id.customsmithy);
                    int amt;
                    try {
                        amt = Integer.parseInt(customsmithy.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildSmithy(amt);
                    if (build) {
                        num_smithy.setText("" + num);
                        num_smithy.invalidate();
                        num_smithy.requestLayout();
                    }
                }
            });
            Button buildapothecary = view.findViewById(R.id.buildapothecary);
            TextView num_apothecary = view.findViewById(R.id.num_apothecary);
            amt = builder.resourceAmount("APOTHECARIES");
            num_apothecary.setText(amt);
            buildapothecary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView num_apothecary = getActivity().findViewById(R.id.num_apothecary);
                    String str = num_apothecary.getText().toString();
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText customapothecaries = getActivity().findViewById(R.id.customapothecary);
                    int amt;
                    try {
                        amt = Integer.parseInt(customapothecaries.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildApothecary(amt);
                    if (build) {
                        num_apothecary.setText("" + num);
                        num_apothecary.invalidate();
                        num_apothecary.requestLayout();
                    }
                }
            });
            Button buildbarracks = view.findViewById(R.id.buildbarracks);
            TextView num_barracks = view.findViewById(R.id.num_barracks);
            amt = builder.resourceAmount("BARRACKS");
            num_barracks.setText(amt);
            buildbarracks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView num_barracks = getActivity().findViewById(R.id.num_barracks);
                    String str = num_barracks.getText().toString();
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText custombarracks = getActivity().findViewById(R.id.custombarracks);
                    int amt;
                    try {
                        amt = Integer.parseInt(custombarracks.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildBarracks(amt);
                    if (build) {
                        num_barracks.setText("" + num);
                        num_barracks.invalidate();
                        num_barracks.requestLayout();
                    }
                }
            });

        } else {
            view.findViewById(R.id.buildcottage).setVisibility(View.GONE);
            view.findViewById(R.id.num_cottage).setVisibility(View.GONE);
            view.findViewById(R.id.customcottage).setVisibility(View.GONE);
            view.findViewById(R.id.buildhouse).setVisibility(View.GONE);
            view.findViewById(R.id.num_house).setVisibility(View.GONE);
            view.findViewById(R.id.customhouse).setVisibility(View.GONE);
            view.findViewById(R.id.buildmansion).setVisibility(View.GONE);
            view.findViewById(R.id.num_mansion).setVisibility(View.GONE);
            view.findViewById(R.id.custommansion).setVisibility(View.GONE);
            view.findViewById(R.id.buildtannery).setVisibility(View.GONE);
            view.findViewById(R.id.num_tannery).setVisibility(View.GONE);
            view.findViewById(R.id.customtannery).setVisibility(View.GONE);
            view.findViewById(R.id.buildsmithy).setVisibility(View.GONE);
            view.findViewById(R.id.num_smithy).setVisibility(View.GONE);
            view.findViewById(R.id.customsmithy).setVisibility(View.GONE);
            view.findViewById(R.id.buildapothecary).setVisibility(View.GONE);
            view.findViewById(R.id.num_apothecary).setVisibility(View.GONE);
            view.findViewById(R.id.customapothecary).setVisibility(View.GONE);
            view.findViewById(R.id.buildbarracks).setVisibility(View.GONE);
            view.findViewById(R.id.num_barracks).setVisibility(View.GONE);
            view.findViewById(R.id.custombarracks).setVisibility(View.GONE);
        }
        if (builder.checkUpgrade("HORSEBACKRIDING")) {
            Button buildstables = view.findViewById(R.id.buildstables);
            TextView num_stables = view.findViewById(R.id.num_stables);
            amt = builder.resourceAmount("STABLES");
            num_stables.setText(amt);
            buildstables.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView num_stables = getActivity().findViewById(R.id.num_stables);
                    String str = num_stables.getText().toString();
                    if (str == "") {
                        str = "0";
                    }
                    int num = Integer.parseInt(str);
                    EditText customstables = getActivity().findViewById(R.id.customstables);
                    int amt;
                    try {
                        amt = Integer.parseInt(customstables.getText().toString());
                    } catch (NumberFormatException e) {
                        amt = 0;
                    }
                    num += amt;
                    boolean build = builder.buildStables(amt);
                    if (build) {
                        num_stables.setText("" + num);
                        num_stables.invalidate();
                        num_stables.requestLayout();
                    }
                }
            });
        } else {
            view.findViewById(R.id.buildstables).setVisibility(View.GONE);
            view.findViewById(R.id.num_stables).setVisibility(View.GONE);
            view.findViewById(R.id.customstables).setVisibility(View.GONE);
        }
        Button buildbarn = view.findViewById(R.id.buildbarn);
        TextView num_barn = view.findViewById(R.id.num_barn);
        amt = builder.resourceAmount("BARNS");
        num_barn.setText(amt);
        buildbarn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView num_barn = getActivity().findViewById(R.id.num_barn);
                String str = num_barn.getText().toString();
                if (str == "") {
                    str = "0";
                }
                int num = Integer.parseInt(str);
                EditText custombarn = getActivity().findViewById(R.id.custombarn);
                int amt;
                try {
                    amt = Integer.parseInt(custombarn.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                num += amt;
                boolean build = builder.buildBarn(amt);
                if (build) {
                    num_barn.setText("" + num);
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
                if (str == "") {
                    str = "0";
                }
                int num = Integer.parseInt(str);
                EditText customwoodstockpiles = getActivity().findViewById(R.id.customwoodstockpile);
                int amt;
                try {
                    amt = Integer.parseInt(customwoodstockpiles.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                num += amt;
                boolean build = builder.buildWoodStockpile(amt);
                if (build) {
                    num_woodstockpile.setText("" + num);
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
                if (str == "") {
                    str = "0";
                }
                int num = Integer.parseInt(str);
                EditText customstoenstockpiles = getActivity().findViewById(R.id.customstonestockpile);
                int amt;
                try {
                    amt = Integer.parseInt(customstoenstockpiles.getText().toString());
                } catch (NumberFormatException e) {
                    amt = 0;
                }
                num += amt;
                boolean build = builder.buildStoneStockpile(amt);
                if (build) {
                    num_stonestockpile.setText("" + num);
                    num_stonestockpile.invalidate();
                    num_stonestockpile.requestLayout();
                }
            }
        });
        return view;
    }

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

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface buildingBuilder {
        // TODO: Update argument type and name
        //add in amount and make default 1
        boolean buildTent(int amt);

        boolean buildHut(int amt);

        boolean buildCottage(int amt);

        boolean buildHouse(int amt);

        boolean buildMansion(int amt);

        boolean buildBarn(int amt);

        boolean buildWoodStockpile(int amt);

        boolean buildStoneStockpile(int amt);

        boolean buildTannery(int amt);

        boolean buildSmithy(int amt);

        boolean buildApothecary(int amt);

        boolean buildBarracks(int amt);

        boolean buildStables(int amt);

        boolean checkMUpgrade();

        boolean ECI();

        void toast(String string);

        String resourceAmount(String resource);

        boolean checkUpgrade(String upgrade);
    }
}
