package not.bored.clickerempire;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.achievement.Achievement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static java.security.AccessController.getContext;

@TargetApi(21)
public class Achievements extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    public void pause(){
        toast("Cannot pause from Achievements screen");
    }
    public void resume(){
        toast("Cannot resume from Achievements screen");
    }
    public void toast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
    GameSave gameSave = GameSave.getGameSave(this);
    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionbar.setTitle("Achievements");
        final Map<String, String> achievements = getAchievements();
        final Map<String, String> achievementsDesc = getAchievementButtons();
        ArrayList<String> achievement_entries= new ArrayList<>(achievements.keySet());
        Collections.sort(achievement_entries);
        LinearLayout ll = findViewById(R.id.achievements_layout);
        int coloralternator = 0;
        for (String entry : achievement_entries){
            Button tv = new Button(this);
            tv.setText(achievements.get(entry));
            tv.setTextSize(16);
            tv.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.WRAP_CONTENT);
            params.height = 100;
            params.setMargins(200,0,200,0);
            tv.setLayoutParams(params);
            tv.setGravity(Gravity.CENTER);
            if (coloralternator == 0){
                tv.setBackground(getDrawable(R.drawable.borderbuttonlightblue));
                coloralternator =1;
            }else{
//                tv.setBackground(getDrawable(R.drawable.borderbuttonlightred));
                coloralternator = 0;
            }
            tv.setClickable(true);
            ll.addView(tv);
            final String entry2 = entry;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String desc = achievementsDesc.get(entry2);
                    AlertDialog.Builder aBuilder = new AlertDialog.Builder(Achievements.this);
                    aBuilder.setMessage(desc)
                            .setCancelable(true)
                            .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                    AlertDialog alert = aBuilder.create();
                    alert.setTitle(achievements.get(entry2));
                    alert.show();
                    Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
                    nbutton.setTextColor(Color.BLACK);
                }
            });
        }
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // set item as selected to persist highlight
                item.setChecked(true);
                // close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                int id = item.getItemId();

                if (id == R.id.rename) {
                    pause();
                    Intent rename = new Intent(getApplicationContext(), Rename.class);
                    String name = gameSave.civName();
                    rename.putExtra("name", name);
                    startActivity(rename);
                }
                else if (id == R.id.save_game){
                    toast("Cannot save game from Achievements screen");
                }
                else if (id == R.id.load_game){
                    toast("Cannot load game from Achievements screen");
                }
                else if (id == R.id.pause) {
                    pause();
                }
                else if (id == R.id.resume) {
                    resume();
                }
                else if (id == R.id.reset){
                    toast("Cannot reset from Achievements screen");
                }
                else if (id == R.id.instructions){
                    Intent intent = new Intent(Achievements.this,Instructions.class);
                    startActivity(intent);
                }
//                else if (id == R.id.achievements) {
//
//                }
                else if (id == R.id.enablecustomincrememtns) {

                }
                else if (id == R.id.purchasedUpgrades){
                    Intent intent = new Intent(Achievements.this,purchasedUpgrades.class);
                    if(gameSave.resourceAmountI(gameSave.SKINNING) == 1 ){
                        intent.putExtra(gameSave.SKINNING,gameSave.SKINNING);
                    }
                    if(gameSave.resourceAmountI(gameSave.HARVESTING) == 1 ){
                        intent.putExtra(gameSave.HARVESTING,gameSave.HARVESTING);
                    }
                    if(gameSave.resourceAmountI(gameSave.PROSPECTING) == 1 ){
                        intent.putExtra(gameSave.PROSPECTING,gameSave.PROSPECTING);
                    }
                    if(gameSave.resourceAmountI(gameSave.MASONRY) == 1 ){
                        intent.putExtra(gameSave.MASONRY,gameSave.MASONRY);
                    }
                    if(gameSave.resourceAmountI(gameSave.DOMESTICATION) == 1 ){
                        intent.putExtra(gameSave.DOMESTICATION,gameSave.DOMESTICATION);
                    }
                    if(gameSave.resourceAmountI(gameSave.PLOUGHSHARES) == 1 ){
                        intent.putExtra(gameSave.PLOUGHSHARES,gameSave.PLOUGHSHARES);
                    }
                    if(gameSave.resourceAmountI(gameSave.IRRIGATION) == 1 ){
                        intent.putExtra(gameSave.IRRIGATION,gameSave.IRRIGATION);
                    }
                    if(gameSave.resourceAmountI(gameSave.CONSTRUCTION) == 1 ){
                        intent.putExtra(gameSave.CONSTRUCTION,gameSave.CONSTRUCTION);
                    }
                    if(gameSave.resourceAmountI(gameSave.GRANARIES) == 1 ){
                        intent.putExtra(gameSave.GRANARIES,gameSave.GRANARIES);
                    }
                    if(gameSave.resourceAmountI(gameSave.TENEMENTS) == 1 ){
                        intent.putExtra(gameSave.TENEMENTS,gameSave.TENEMENTS);
                    }
                    if(gameSave.resourceAmountI(gameSave.BASICSHIELDS) == 1 ){
                        intent.putExtra(gameSave.BASICSHIELDS,gameSave.BASICSHIELDS);
                    }
                    if(gameSave.resourceAmountI(gameSave.BASICWEAPONRY) == 1 ){
                        intent.putExtra(gameSave.BASICWEAPONRY,gameSave.BASICWEAPONRY);
                    }
                    if(gameSave.resourceAmountI(gameSave.PALISADE) == 1 ){
                        intent.putExtra(gameSave.PALISADE,gameSave.PALISADE);
                    }
                    if(gameSave.resourceAmountI(gameSave.GRANARIES) == 1 ){
                        intent.putExtra(gameSave.GRANARIES,gameSave.GRANARIES);
                    }
                    if(gameSave.resourceAmountI(gameSave.BUTCHERING) == 1 ){
                        intent.putExtra(gameSave.BUTCHERING,gameSave.BUTCHERING);
                    }
                    if(gameSave.resourceAmountI(gameSave.GARDENING) == 1 ){
                        intent.putExtra(gameSave.GARDENING,gameSave.GARDENING);
                    }
                    if(gameSave.resourceAmountI(gameSave.EXTRACTION) == 1 ){
                        intent.putExtra(gameSave.EXTRACTION,gameSave.EXTRACTION);
                    }
                    if(gameSave.resourceAmountI(gameSave.ARCHITECTURE) == 1 ){
                        intent.putExtra(gameSave.ARCHITECTURE,gameSave.ARCHITECTURE);
                    }
                    if(gameSave.resourceAmountI(gameSave.FLENSING) == 1 ){
                        intent.putExtra(gameSave.FLENSING,gameSave.FLENSING);
                    }
                    if(gameSave.resourceAmountI(gameSave.MACERATING) == 1 ){
                        intent.putExtra(gameSave.MACERATING,gameSave.MACERATING);
                    }
                    if(gameSave.resourceAmountI(gameSave.CROPROTATION) == 1 ){
                        intent.putExtra(gameSave.CROPROTATION,gameSave.CROPROTATION);
                    }
                    if(gameSave.resourceAmountI(gameSave.SELECTIVEBREEDING) == 1 ){
                        intent.putExtra(gameSave.SELECTIVEBREEDING,gameSave.SELECTIVEBREEDING);
                    }
                    if(gameSave.resourceAmountI(gameSave.FERTILIZERS) == 1 ){
                        intent.putExtra(gameSave.FERTILIZERS,gameSave.FERTILIZERS);
                    }
                    if(gameSave.resourceAmountI(gameSave.SLUMS) == 1 ){
                        intent.putExtra(gameSave.SLUMS,gameSave.SLUMS);
                    }
                    startActivity(intent);
                }
                return true;
            }
        });
//        MobileAds.initialize(this,"ca-app-pub-2519476145136157~3502779246");
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
    }

    public Map<String, String> getAchievements() {
        Map<String, String> achievements = new HashMap<String,String>();
        if(gameSave.AchievementShown(GameSave.THORP)){
            achievements.put(GameSave.THORP,"Thorp");
        }
        if(gameSave.AchievementShown(GameSave.HAMLET)){
            achievements.put(GameSave.HAMLET,"Hamlet");
        }
        if(gameSave.AchievementShown(GameSave.VILLAGE)){
            achievements.put(GameSave.VILLAGE,"Village");
        }
        if(gameSave.AchievementShown(GameSave.SMALL_TOWN)){
            achievements.put(GameSave.SMALL_TOWN,"Small Town");
        }
        if(gameSave.AchievementShown(GameSave.LARGE_TOWN)){
            achievements.put(GameSave.LARGE_TOWN,"Large Town");
        }
        if(gameSave.AchievementShown(GameSave.SMALL_CITY)){
            achievements.put(GameSave.SMALL_CITY,"Small City");
        }
        if(gameSave.AchievementShown(GameSave.LARGE_CITY)){
            achievements.put(GameSave.LARGE_CITY,"Large City");
        }
        if(gameSave.AchievementShown(GameSave.METROPOLIS)){
            achievements.put(GameSave.METROPOLIS,"Metropolis");
        }
        if(gameSave.AchievementShown(GameSave.SMALL_NATION)){
            achievements.put(GameSave.SMALL_NATION,"Small Nation");
        }
        if(gameSave.AchievementShown(GameSave.NATION)){
            achievements.put(GameSave.NATION,"Nation");
        }
        if(gameSave.AchievementShown(GameSave.LARGE_NATION)){
            achievements.put(GameSave.LARGE_NATION,"Large Nation");
        }
        if(gameSave.AchievementShown(GameSave.EMPIRE)){
            achievements.put(GameSave.EMPIRE,"Empire");
        }
        if(gameSave.AchievementShown(GameSave.CONTINENTAL_EMPIRE)){
            achievements.put(GameSave.CONTINENTAL_EMPIRE,"Continental Empire");
        }
        if(gameSave.AchievementShown(GameSave.WORLD_CONFEDERATION)){
            achievements.put(GameSave.WORLD_CONFEDERATION,"World Confederation");
        }
        if(gameSave.AchievementShown(GameSave.UNITED_WORLD)){
            achievements.put(GameSave.UNITED_WORLD,"United World");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_ONE)){
            achievements.put(GameSave.RAIDER_ONE,"Raider 1");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_TWO)){
            achievements.put(GameSave.RAIDER_TWO,"Raider 2");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_THREE)){
            achievements.put(GameSave.RAIDER_THREE,"Raider 3");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_FOUR)){
            achievements.put(GameSave.RAIDER_FOUR,"Raider 4");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_FIVE)){
            achievements.put(GameSave.RAIDER_FIVE,"Raider 5");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_SIX)){
            achievements.put(GameSave.RAIDER_SIX,"Raider 6");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_SEVEN)){
            achievements.put(GameSave.RAIDER_SEVEN,"Raider 7");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_EIGHT)){
            achievements.put(GameSave.RAIDER_EIGHT,"Raider 8");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_NINE)){
            achievements.put(GameSave.RAIDER_NINE,"Raider 9");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_TEN)){
            achievements.put(GameSave.RAIDER_TEN,"Raider 10");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_ONE)){
            achievements.put(GameSave.DEFEAT_ONE,"Defeat 1");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_TWO)){
            achievements.put(GameSave.DEFEAT_TWO,"Defeat 2");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_THREE)){
            achievements.put(GameSave.DEFEAT_THREE,"Defeat 3");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_FOUR)){
            achievements.put(GameSave.DEFEAT_FOUR,"Defeat 4");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_FIVE)){
            achievements.put(GameSave.DEFEAT_FIVE,"Defeat 5");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_SIX)){
            achievements.put(GameSave.DEFEAT_SIX,"Defeat 6");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_SEVEN)){
            achievements.put(GameSave.DEFEAT_SEVEN,"Defeat 7");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_EIGHT)){
            achievements.put(GameSave.DEFEAT_EIGHT,"Defeat 8");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_NINE)){
            achievements.put(GameSave.DEFEAT_NINE,"Defeat 9");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_TEN)){
            achievements.put(GameSave.DEFEAT_TEN,"Defeat 10");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_THORP)){
            achievements.put(GameSave.CONQUEROR_THORP,"Thorp Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_HAMLET)){
            achievements.put(GameSave.CONQUEROR_HAMLET,"Hamlet Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_VILLAGE)){
            achievements.put(GameSave.CONQUEROR_VILLAGE,"Village Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_SMALL_TOWN)){
            achievements.put(GameSave.CONQUEROR_SMALL_TOWN,"Small Town Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_LARGE_TOWN)){
            achievements.put(GameSave.CONQUEROR_LARGE_TOWN,"Large Town Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_SMALL_CITY)){
            achievements.put(GameSave.CONQUEROR_SMALL_CITY,"Small Citie Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_LARGE_CITY)){
            achievements.put(GameSave.CONQUEROR_LARGE_CITY,"Large Citie Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_METROPOLIS)){
            achievements.put(GameSave.CONQUEROR_METROPOLIS,"Metropolis Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_SMALL_NATION)){
            achievements.put(GameSave.CONQUEROR_SMALL_NATION,"Small Nation Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_NATION)){
            achievements.put(GameSave.CONQUEROR_NATION,"Nation Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_LARGE_NATION)){
            achievements.put(GameSave.CONQUEROR_LARGE_NATION,"Large Nation Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_EMPIRE)){
            achievements.put(GameSave.CONQUEROR_EMPIRE,"Empire Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_CONTINENTAL_EMPIRE)){
            achievements.put(GameSave.CONQUEROR_CONTINENTAL_EMPIRE,"Continental Empire Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_WORLD_CONFEDERATION)){
            achievements.put(GameSave.CONQUEROR_WORLD_CONFEDERATION,"World Confederation Conqueror");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_UNITED_WORLD)){
            achievements.put(GameSave.CONQUEROR_UNITED_WORLD,"United World Conqueror");
        }
        return achievements;
    }
    public Map<String, String> getAchievementButtons() {
        Map<String, String> achievements = new HashMap<String,String>();
        if(gameSave.AchievementShown(GameSave.THORP)){
            achievements.put(GameSave.THORP,"Conquer 1 Thorp");
        }
        if(gameSave.AchievementShown(GameSave.HAMLET)){
            achievements.put(GameSave.HAMLET,"Conquer 1 Hamlet");
        }
        if(gameSave.AchievementShown(GameSave.VILLAGE)){
            achievements.put(GameSave.VILLAGE,"Conquer 1 Village");
        }
        if(gameSave.AchievementShown(GameSave.SMALL_TOWN)){
            achievements.put(GameSave.SMALL_TOWN,"Conquer 1 Small Town");
        }
        if(gameSave.AchievementShown(GameSave.LARGE_TOWN)){
            achievements.put(GameSave.LARGE_TOWN,"Conquer 1 Large Town");
        }
        if(gameSave.AchievementShown(GameSave.SMALL_CITY)){
            achievements.put(GameSave.SMALL_CITY,"Conquer 1 Small City");
        }
        if(gameSave.AchievementShown(GameSave.LARGE_CITY)){
            achievements.put(GameSave.LARGE_CITY,"Conquer 1 Large City");
        }
        if(gameSave.AchievementShown(GameSave.METROPOLIS)){
            achievements.put(GameSave.METROPOLIS,"Conquer 1 Metropolis");
        }
        if(gameSave.AchievementShown(GameSave.SMALL_NATION)){
            achievements.put(GameSave.SMALL_NATION,"Conquer 1 Small Nation");
        }
        if(gameSave.AchievementShown(GameSave.NATION)){
            achievements.put(GameSave.NATION,"Conquer 1 Nation");
        }
        if(gameSave.AchievementShown(GameSave.LARGE_NATION)){
            achievements.put(GameSave.LARGE_NATION,"Conquer 1 Large Nation");
        }
        if(gameSave.AchievementShown(GameSave.EMPIRE)){
            achievements.put(GameSave.EMPIRE,"Conquer 1 Empire");
        }
        if(gameSave.AchievementShown(GameSave.CONTINENTAL_EMPIRE)){
            achievements.put(GameSave.CONTINENTAL_EMPIRE,"Conquer 1 Continental Empire");
        }
        if(gameSave.AchievementShown(GameSave.WORLD_CONFEDERATION)){
            achievements.put(GameSave.WORLD_CONFEDERATION,"Conquer 1 World Confederation");
        }
        if(gameSave.AchievementShown(GameSave.UNITED_WORLD)){
            achievements.put(GameSave.UNITED_WORLD,"Conquer 1 United World");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_ONE)){
            achievements.put(GameSave.RAIDER_ONE,"Conquer at least 10 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_TWO)){
            achievements.put(GameSave.RAIDER_TWO,"Conquer at least 20 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_THREE)){
            achievements.put(GameSave.RAIDER_THREE,"Conquer at least 30 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_FOUR)){
            achievements.put(GameSave.RAIDER_FOUR,"Conquer at least 40 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_FIVE)){
            achievements.put(GameSave.RAIDER_FIVE,"Conquer at least 50 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_SIX)){
            achievements.put(GameSave.RAIDER_SIX,"Conquer at least 60 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_SEVEN)){
            achievements.put(GameSave.RAIDER_SEVEN,"Conquer at least 70 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_EIGHT)){
            achievements.put(GameSave.RAIDER_EIGHT,"Conquer at least 80 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_NINE)){
            achievements.put(GameSave.RAIDER_NINE,"Conquer at least 90 settlements");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_TEN)){
            achievements.put(GameSave.RAIDER_TEN,"Conquer at least 100 settlements");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_ONE)){
            achievements.put(GameSave.DEFEAT_ONE,"Lose at least 10 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_TWO)){
            achievements.put(GameSave.DEFEAT_TWO,"Lose at least 20 battles");
        }
        if(gameSave.AchievementShown(GameSave.RAIDER_THREE)){
            achievements.put(GameSave.DEFEAT_THREE,"Lose at least 30 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_FOUR)){
            achievements.put(GameSave.DEFEAT_FOUR,"Lose at least 40 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_FIVE)){
            achievements.put(GameSave.DEFEAT_FIVE,"Lose at least 50 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_SIX)){
            achievements.put(GameSave.DEFEAT_SIX,"Lose at least 60 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_SEVEN)){
            achievements.put(GameSave.DEFEAT_SEVEN,"Lose at least 70 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_EIGHT)){
            achievements.put(GameSave.DEFEAT_EIGHT,"Lose at least 80 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_NINE)){
            achievements.put(GameSave.DEFEAT_NINE,"Lose at least 90 battles");
        }
        if(gameSave.AchievementShown(GameSave.DEFEAT_TEN)){
            achievements.put(GameSave.DEFEAT_TEN,"Lose at least 100 battles");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_THORP)){
            achievements.put(GameSave.CONQUEROR_THORP,"Conquer at least 10 Thorps");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_HAMLET)){
            achievements.put(GameSave.CONQUEROR_HAMLET,"Conquer at least 10 Hamlets");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_VILLAGE)){
            achievements.put(GameSave.CONQUEROR_VILLAGE,"Conquer at least 10 Villages");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_SMALL_TOWN)){
            achievements.put(GameSave.CONQUEROR_SMALL_TOWN,"Conquer at least 10 Small Towns");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_LARGE_TOWN)){
            achievements.put(GameSave.CONQUEROR_LARGE_TOWN,"Conquer at least 10 Large Towns");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_SMALL_CITY)){
            achievements.put(GameSave.CONQUEROR_SMALL_CITY,"Conquer at least 10 Small Cities");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_LARGE_CITY)){
            achievements.put(GameSave.CONQUEROR_LARGE_CITY,"Conquer at least 10 Large Cities");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_METROPOLIS)){
            achievements.put(GameSave.CONQUEROR_METROPOLIS,"Conquer at least 10 Metropolises");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_SMALL_NATION)){
            achievements.put(GameSave.CONQUEROR_SMALL_NATION,"Conquer at least 10 Small Nations");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_NATION)){
            achievements.put(GameSave.CONQUEROR_NATION,"Conquer at least 10 Nations");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_LARGE_NATION)){
            achievements.put(GameSave.CONQUEROR_LARGE_NATION,"Conquer at least 10 Large Nations");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_EMPIRE)){
            achievements.put(GameSave.CONQUEROR_EMPIRE,"Conquer at least 10 Empires");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_CONTINENTAL_EMPIRE)){
            achievements.put(GameSave.CONQUEROR_CONTINENTAL_EMPIRE,"Conquer at least 10 Continental Empires");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_WORLD_CONFEDERATION)){
            achievements.put(GameSave.CONQUEROR_WORLD_CONFEDERATION,"Conquer at least 10 World Confederations");
        }
        if(gameSave.AchievementShown(GameSave.CONQUEROR_UNITED_WORLD)){
            achievements.put(GameSave.CONQUEROR_UNITED_WORLD,"Conquer at least 10 United Worlds");
        }
        return achievements;
    }
}
