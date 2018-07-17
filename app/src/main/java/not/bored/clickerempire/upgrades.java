package not.bored.clickerempire;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class upgrades extends Fragment {

    public upgrades() {
        // Required empty public constructor
    }
    private upgrade upgrades;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_upgrades, container, false);
        final Button upgradeSkinning = view.findViewById(R.id.skinning);
        upgradeSkinning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeSkinning()){
                    upgradeSkinning.setVisibility(View.GONE);
                    view.findViewById(R.id.textView).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("SKINNING")){
            upgradeSkinning.setVisibility(View.GONE);
            view.findViewById(R.id.textView).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost).setVisibility(View.GONE);
        }
        final Button upgradeHarvesting = view.findViewById(R.id.harvesting);
        upgradeHarvesting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeHarvesting()){
                    upgradeHarvesting.setVisibility(View.GONE);
                    view.findViewById(R.id.textView2).setVisibility(View.GONE);
                    view.findViewById(R.id.harvesting_cost).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("HARVESTING")){
            upgradeHarvesting.setVisibility(View.GONE);
            view.findViewById(R.id.textView2).setVisibility(View.GONE);
            view.findViewById(R.id.harvesting_cost).setVisibility(View.GONE);
        }
        final Button upgradeProspecting = view.findViewById(R.id.prospecting);
        upgradeProspecting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeProspecting()){
                    upgradeProspecting.setVisibility(View.GONE);
                    view.findViewById(R.id.textView3).setVisibility(View.GONE);
                    view.findViewById(R.id.prospecting_cost).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("PROSPECTING")){
            upgradeProspecting.setVisibility(View.GONE);
            view.findViewById(R.id.textView3).setVisibility(View.GONE);
            view.findViewById(R.id.prospecting_cost).setVisibility(View.GONE);
        }
        final Button upgradeDomestication = view.findViewById(R.id.domestication);
        upgradeDomestication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeDomestication()){
                    upgradeDomestication.setVisibility(View.GONE);
                    view.findViewById(R.id.textView6).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost2).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("DOMESTICATION")){
            upgradeDomestication.setVisibility(View.GONE);
            view.findViewById(R.id.textView6).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost2).setVisibility(View.GONE);
        }
        final Button upgradePloughshares = view.findViewById(R.id.ploughshares);
        upgradePloughshares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradePloughshares()){
                    upgradePloughshares.setVisibility(View.GONE);
                    view.findViewById(R.id.textView7).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost3).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("PLOUGHSHARES")){
            upgradePloughshares.setVisibility(View.GONE);
            view.findViewById(R.id.textView7).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost3).setVisibility(View.GONE);
        }
        final Button upgradeIrrigation = view.findViewById(R.id.irrigation);
        upgradeIrrigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeIrrigation()){
                    upgradeIrrigation.setVisibility(View.GONE);
                    view.findViewById(R.id.textView8).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost4).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("IRRIGATION")){
            upgradeIrrigation.setVisibility(View.GONE);
            view.findViewById(R.id.textView8).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost4).setVisibility(View.GONE);
        }
        final Button upgradeConstruction = view.findViewById(R.id.construction);
        upgradeConstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeConstruction()){
                    upgradeConstruction.setVisibility(View.GONE);
                    view.findViewById(R.id.textView9).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost5).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("CONSTRUCTION")){
            upgradeConstruction.setVisibility(View.GONE);
            view.findViewById(R.id.textView9).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost5).setVisibility(View.GONE);
        }
        final Button upgradeGranaries = view.findViewById(R.id.granaries);
        upgradeGranaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.granaries()) {
                    upgradeGranaries.setVisibility(View.GONE);
                    view.findViewById(R.id.textView10).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost6).setVisibility(View.GONE);
                }
            }
        });
        if(upgrades.checkUpgrade("GRANARIES")){
            upgradeGranaries.setVisibility(View.GONE);
            view.findViewById(R.id.textView10).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost6).setVisibility(View.GONE);
        }

        final Button upgradeMasonry = view.findViewById(R.id.masonry);
        upgradeMasonry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeMasonry()){
                    upgradeMasonry.setVisibility(View.GONE);
                    view.findViewById(R.id.textView4).setVisibility(View.GONE);
                    view.findViewById(R.id.masonry_cost).setVisibility(View.GONE);
                    upgradeDomestication.setVisibility(View.VISIBLE);
                    upgradePloughshares.setVisibility(View.VISIBLE);
                    upgradeIrrigation.setVisibility(View.VISIBLE);
                    upgradeConstruction.setVisibility(View.VISIBLE);
                    upgradeGranaries.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView6).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView7).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView8).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView9).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView10).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost2).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost3).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost4).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost5).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost6).setVisibility(View.VISIBLE);
                }
            }
        });
        if(upgrades.checkUpgrade("MASONRY")){
            upgradeMasonry.setVisibility(View.GONE);
            view.findViewById(R.id.textView4).setVisibility(View.GONE);
            view.findViewById(R.id.masonry_cost).setVisibility(View.GONE);
        }
        if (!upgrades.checkUpgrade("MASONRY")) {
            upgradeDomestication.setVisibility(View.GONE);
            upgradePloughshares.setVisibility(View.GONE);
            upgradeIrrigation.setVisibility(View.GONE);
            upgradeConstruction.setVisibility(View.GONE);
            upgradeGranaries.setVisibility(View.GONE);
            view.findViewById(R.id.textView6).setVisibility(View.GONE);
            view.findViewById(R.id.textView7).setVisibility(View.GONE);
            view.findViewById(R.id.textView8).setVisibility(View.GONE);
            view.findViewById(R.id.textView9).setVisibility(View.GONE);
            view.findViewById(R.id.textView10).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost2).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost3).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost4).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost5).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost6).setVisibility(View.GONE);
        }
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof upgrade) {
            upgrades = (upgrade) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface upgrade {
        boolean upgradeSkinning();
        boolean upgradeHarvesting();
        boolean upgradeProspecting();
        boolean upgradeMasonry();
        boolean upgradeDomestication();
        boolean upgradePloughshares();
        boolean upgradeIrrigation();
        boolean upgradeConstruction();
        boolean granaries();
        boolean checkUpgrade(String upgrade);
    }
}
