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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_upgrades, container, false);
        final Button upgradeFlensing = view.findViewById(R.id.flensing);
        upgradeFlensing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeFlensing()) {
                    upgradeFlensing.setVisibility(View.GONE);
                    view.findViewById(R.id.flensing_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.flensingtv).setVisibility(View.GONE);
                    upgrades.toast("" + upgrades.checkUpgrade("FLENSING"));
                }
            }
        });
        final Button upgradeMacerating = view.findViewById(R.id.macerating);
        upgradeMacerating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeMacerating()) {
                    upgradeMacerating.setVisibility(View.GONE);
                    view.findViewById(R.id.macerating_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.maceratingtv).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeCropRotation = view.findViewById(R.id.croprotation);
        upgradeCropRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeCropRotation()) {
                    upgradeCropRotation.setVisibility(View.GONE);
                    view.findViewById(R.id.croprotation_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.croprotationtv).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeSelectiveBreeding = view.findViewById(R.id.selectivebreeding);
        upgradeSelectiveBreeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeSelectiveBreeding()) {
                    upgradeSelectiveBreeding.setVisibility(View.GONE);
                    view.findViewById(R.id.selectivebreeding_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.selectivebreedingtv).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeFertilizers = view.findViewById(R.id.fertilizers);
        upgradeFertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeFertilizers()) {
                    upgradeFertilizers.setVisibility(View.GONE);
                    view.findViewById(R.id.fertilizers_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.fertilizerstv).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeSlums = view.findViewById(R.id.slums);
        upgradeSlums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeSlums()) {
                    upgradeSlums.setVisibility(View.GONE);
                    view.findViewById(R.id.slums_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.slumstv).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeArchitecture = view.findViewById(R.id.architecture);
        upgradeArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeArchitecture()){
                    upgradeArchitecture.setVisibility(View.GONE);
                    view.findViewById(R.id.architecture_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.architecturetv).setVisibility(View.GONE);
                    upgradeFlensing.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.flensing_cost).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.flensingtv).setVisibility(View.VISIBLE);
                    upgradeMacerating.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.macerating_cost).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.maceratingtv).setVisibility(View.VISIBLE);
                    upgradeCropRotation.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.croprotationtv).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.croprotation_cost).setVisibility(View.VISIBLE);
                    upgradeSelectiveBreeding.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.selectivebreedingtv).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.selectivebreeding_cost).setVisibility(View.VISIBLE);
                    upgradeFertilizers.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.fertilizerstv).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.fertilizers_cost).setVisibility(View.VISIBLE);
                    upgradeSlums.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.slumstv).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.slums_cost).setVisibility(View.VISIBLE);

                }
            }
        });
        if(upgrades.checkUpgrade("ARCHITECTURE")){
            upgradeArchitecture.setVisibility(View.GONE);
            view.findViewById(R.id.architecture_cost).setVisibility(View.GONE);
            view.findViewById(R.id.architecturetv).setVisibility(View.GONE);
            upgradeFlensing.setVisibility(View.VISIBLE);
            view.findViewById(R.id.flensing_cost).setVisibility(View.VISIBLE);
            view.findViewById(R.id.flensingtv).setVisibility(View.VISIBLE);
            upgradeMacerating.setVisibility(View.VISIBLE);
            view.findViewById(R.id.macerating_cost).setVisibility(View.VISIBLE);
            view.findViewById(R.id.maceratingtv).setVisibility(View.VISIBLE);
            upgradeCropRotation.setVisibility(View.VISIBLE);
            view.findViewById(R.id.croprotationtv).setVisibility(View.VISIBLE);
            view.findViewById(R.id.croprotation_cost).setVisibility(View.VISIBLE);
            upgradeSelectiveBreeding.setVisibility(View.VISIBLE);
            view.findViewById(R.id.selectivebreedingtv).setVisibility(View.VISIBLE);
            view.findViewById(R.id.selectivebreeding_cost).setVisibility(View.VISIBLE);
            upgradeFertilizers.setVisibility(View.VISIBLE);
            view.findViewById(R.id.fertilizerstv).setVisibility(View.VISIBLE);
            view.findViewById(R.id.fertilizers_cost).setVisibility(View.VISIBLE);
            upgradeSlums.setVisibility(View.VISIBLE);
            view.findViewById(R.id.slumstv).setVisibility(View.VISIBLE);
            view.findViewById(R.id.slums_cost).setVisibility(View.VISIBLE);
        }else {
            upgradeFlensing.setVisibility(View.GONE);
            view.findViewById(R.id.flensing_cost).setVisibility(View.GONE);
            view.findViewById(R.id.flensingtv).setVisibility(View.GONE);
            upgradeMacerating.setVisibility(View.GONE);
            view.findViewById(R.id.macerating_cost).setVisibility(View.GONE);
            view.findViewById(R.id.maceratingtv).setVisibility(View.GONE);
            upgradeCropRotation.setVisibility(View.GONE);
            view.findViewById(R.id.croprotationtv).setVisibility(View.GONE);
            view.findViewById(R.id.croprotation_cost).setVisibility(View.GONE);
            upgradeSelectiveBreeding.setVisibility(View.GONE);
            view.findViewById(R.id.selectivebreedingtv).setVisibility(View.GONE);
            view.findViewById(R.id.selectivebreeding_cost).setVisibility(View.GONE);
            upgradeFertilizers.setVisibility(View.GONE);
            view.findViewById(R.id.fertilizerstv).setVisibility(View.GONE);
            view.findViewById(R.id.fertilizers_cost).setVisibility(View.GONE);
            upgradeSlums.setVisibility(View.GONE);
            view.findViewById(R.id.slumstv).setVisibility(View.GONE);
            view.findViewById(R.id.slums_cost).setVisibility(View.GONE);
        }
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
        final Button upgradeTenements = view.findViewById(R.id.tenements);
        upgradeTenements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeTenements()) {
                    upgradeTenements.setVisibility(View.GONE);
                    view.findViewById(R.id.textView11).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost7).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeBasicWeaponry = view.findViewById(R.id.basicweaponry);
        upgradeBasicWeaponry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeBasicWeaponry()) {
                    upgradeBasicWeaponry.setVisibility(View.GONE);
                    view.findViewById(R.id.textView12).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost8).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeBasicShields = view.findViewById(R.id.basicshields);
        upgradeBasicShields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeBasicShields()) {
                    upgradeBasicShields.setVisibility(View.GONE);
                    view.findViewById(R.id.textView13).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost9).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradePalisade = view.findViewById(R.id.palisade);
        upgradePalisade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradePalisade()) {
                    upgradePalisade.setVisibility(View.GONE);
                    view.findViewById(R.id.textView14).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost10).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeButchering = view.findViewById(R.id.butchering);
        upgradeButchering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeButchering()) {
                    upgradeButchering.setVisibility(View.GONE);
                    view.findViewById(R.id.textView15).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost11).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeGardening = view.findViewById(R.id.gardening);
        upgradeGardening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeGardening()) {
                    upgradeGardening.setVisibility(View.GONE);
                    view.findViewById(R.id.textView16).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost12).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeExtraction = view.findViewById(R.id.extraction);
        upgradeExtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeExtraction()) {
                    upgradeExtraction.setVisibility(View.GONE);
                    view.findViewById(R.id.textView17).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost13).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeHorsebackRiding = view.findViewById(R.id.horsebackriding);
        upgradeHorsebackRiding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeHorsebackRiding()) {
                    upgradeHorsebackRiding.setVisibility(View.GONE);
                    view.findViewById(R.id.horsebackriding_cost).setVisibility(View.GONE);
                    view.findViewById(R.id.horsebackridingtv).setVisibility(View.GONE);
                }
            }
        });
        final Button upgradeConstruction = view.findViewById(R.id.construction);
        upgradeConstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upgrades.upgradeConstruction()){
                    upgradeConstruction.setVisibility(View.GONE);
                    view.findViewById(R.id.textView9).setVisibility(View.GONE);
                    view.findViewById(R.id.skinning_cost5).setVisibility(View.GONE);
                    upgradeButchering.setVisibility(View.VISIBLE);
                    upgradeGardening.setVisibility(View.VISIBLE);
                    upgradeExtraction.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView15).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView16).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView17).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost11).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost12).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost13).setVisibility(View.VISIBLE);
                    upgradeArchitecture.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.architecturetv).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.architecture_cost).setVisibility(View.VISIBLE);
                }
            }
        });
        if(upgrades.checkUpgrade("CONSTRUCTION")){
            upgradeConstruction.setVisibility(View.GONE);
            view.findViewById(R.id.textView9).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost5).setVisibility(View.GONE);
        }
        else {
            upgradeButchering.setVisibility(View.GONE);
            upgradeGardening.setVisibility(View.GONE);
            upgradeExtraction.setVisibility(View.GONE);
            view.findViewById(R.id.textView15).setVisibility(View.GONE);
            view.findViewById(R.id.textView16).setVisibility(View.GONE);
            view.findViewById(R.id.textView17).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost11).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost12).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost13).setVisibility(View.GONE);
            upgradeArchitecture.setVisibility(View.GONE);
            view.findViewById(R.id.architecturetv).setVisibility(View.GONE);
            view.findViewById(R.id.architecture_cost).setVisibility(View.GONE);
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
                    upgradeTenements.setVisibility(View.VISIBLE);
                    upgradeBasicShields.setVisibility(View.VISIBLE);
                    upgradeBasicWeaponry.setVisibility(View.VISIBLE);
                    upgradePalisade.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView6).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView7).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView8).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView9).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView10).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView11).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView12).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView13).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.textView14).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost2).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost3).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost4).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost5).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost6).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost7).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost8).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost9).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.skinning_cost10).setVisibility(View.VISIBLE);
                    upgradeHorsebackRiding.setVisibility(View.VISIBLE);
                    view.findViewById(R.id.horsebackriding_cost).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.horsebackridingtv).setVisibility(View.VISIBLE);
                }
            }
        });
        if(upgrades.checkUpgrade("MASONRY")){
            upgradeMasonry.setVisibility(View.GONE);
            view.findViewById(R.id.textView4).setVisibility(View.GONE);
            view.findViewById(R.id.masonry_cost).setVisibility(View.GONE);
        }else {
            upgradeDomestication.setVisibility(View.GONE);
            upgradePloughshares.setVisibility(View.GONE);
            upgradeIrrigation.setVisibility(View.GONE);
            upgradeConstruction.setVisibility(View.GONE);
            upgradeGranaries.setVisibility(View.GONE);
            upgradeTenements.setVisibility(View.GONE);
            upgradeBasicShields.setVisibility(View.GONE);
            upgradeBasicWeaponry.setVisibility(View.GONE);
            upgradePalisade.setVisibility(View.GONE);
            view.findViewById(R.id.textView6).setVisibility(View.GONE);
            view.findViewById(R.id.textView7).setVisibility(View.GONE);
            view.findViewById(R.id.textView8).setVisibility(View.GONE);
            view.findViewById(R.id.textView9).setVisibility(View.GONE);
            view.findViewById(R.id.textView10).setVisibility(View.GONE);
            view.findViewById(R.id.textView11).setVisibility(View.GONE);
            view.findViewById(R.id.textView12).setVisibility(View.GONE);
            view.findViewById(R.id.textView13).setVisibility(View.GONE);
            view.findViewById(R.id.textView14).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost2).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost3).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost4).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost5).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost6).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost7).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost8).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost9).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost10).setVisibility(View.GONE);
            upgradeHorsebackRiding.setVisibility(View.GONE);
            view.findViewById(R.id.horsebackriding_cost).setVisibility(View.GONE);
            view.findViewById(R.id.horsebackridingtv).setVisibility(View.GONE);

        }
        if(upgrades.checkUpgrade("FLENSING")){
            upgradeFlensing.setVisibility(View.GONE);
            view.findViewById(R.id.flensingtv).setVisibility(View.GONE);
            view.findViewById(R.id.flensing_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("MACERATING")){
            upgradeMacerating.setVisibility(View.GONE);
            view.findViewById(R.id.maceratingtv).setVisibility(View.GONE);
            view.findViewById(R.id.macerating_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("CROPROTATION")){
            upgradeCropRotation.setVisibility(View.GONE);
            view.findViewById(R.id.croprotationtv).setVisibility(View.GONE);
            view.findViewById(R.id.croprotation_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("SELECTIVEBREEDING")){
            upgradeSelectiveBreeding.setVisibility(View.GONE);
            view.findViewById(R.id.selectivebreedingtv).setVisibility(View.GONE);
            view.findViewById(R.id.selectivebreeding_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("FERTILIZERS")){
            upgradeFertilizers.setVisibility(View.GONE);
            view.findViewById(R.id.fertilizerstv).setVisibility(View.GONE);
            view.findViewById(R.id.fertilizers_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("SLUMS")){
            upgradeSlums.setVisibility(View.GONE);
            view.findViewById(R.id.slumstv).setVisibility(View.GONE);
            view.findViewById(R.id.slums_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("SKINNING")){
            upgradeSkinning.setVisibility(View.GONE);
            view.findViewById(R.id.textView).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("HARVESTING")){
            upgradeHarvesting.setVisibility(View.GONE);
            view.findViewById(R.id.textView2).setVisibility(View.GONE);
            view.findViewById(R.id.harvesting_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("PROSPECTING")){
            upgradeProspecting.setVisibility(View.GONE);
            view.findViewById(R.id.textView3).setVisibility(View.GONE);
            view.findViewById(R.id.prospecting_cost).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("DOMESTICATION")){
            upgradeDomestication.setVisibility(View.GONE);
            view.findViewById(R.id.textView6).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost2).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("PLOUGHSHARES")){
            upgradePloughshares.setVisibility(View.GONE);
            view.findViewById(R.id.textView7).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost3).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("IRRIGATION")){
            upgradeIrrigation.setVisibility(View.GONE);
            view.findViewById(R.id.textView8).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost4).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("GRANARIES")){
            upgradeGranaries.setVisibility(View.GONE);
            view.findViewById(R.id.textView10).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost6).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("TENEMENTS")){
            upgradeTenements.setVisibility(View.GONE);
            view.findViewById(R.id.textView11).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost7).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("BASICWEAPONRY")){
            upgradeBasicWeaponry.setVisibility(View.GONE);
            view.findViewById(R.id.textView12).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost8).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("BASICSHIELDS")){
            upgradeBasicShields.setVisibility(View.GONE);
            view.findViewById(R.id.textView13).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost9).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("PALISADE")){
            upgradePalisade.setVisibility(View.GONE);
            view.findViewById(R.id.textView14).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost10).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("BUTCHERING")){
            upgradeButchering.setVisibility(View.GONE);
            view.findViewById(R.id.textView15).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost11).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("GARDENING")){
            upgradeGardening.setVisibility(View.GONE);
            view.findViewById(R.id.textView16).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost12).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("EXTRACTION")){
            upgradeExtraction.setVisibility(View.GONE);
            view.findViewById(R.id.textView17).setVisibility(View.GONE);
            view.findViewById(R.id.skinning_cost13).setVisibility(View.GONE);
        }
        if(upgrades.checkUpgrade("HORSEBACKRIDING")){
            upgradeHorsebackRiding.setVisibility(View.GONE);
            view.findViewById(R.id.horsebackriding_cost).setVisibility(View.GONE);
            view.findViewById(R.id.horsebackridingtv).setVisibility(View.GONE);
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
        boolean upgradeTenements();
        boolean upgradeBasicWeaponry();
        boolean upgradeBasicShields();
        boolean upgradePalisade();
        boolean upgradeButchering();
        boolean upgradeGardening();
        boolean upgradeExtraction();
        boolean upgradeHorsebackRiding();
        boolean upgradeArchitecture();
        boolean upgradeFlensing();
        boolean upgradeMacerating();
        boolean upgradeCropRotation();
        boolean upgradeSelectiveBreeding();
        boolean upgradeFertilizers();
        boolean upgradeSlums();
        boolean checkUpgrade(String upgrade);
        void toast(String string);
    }
}
