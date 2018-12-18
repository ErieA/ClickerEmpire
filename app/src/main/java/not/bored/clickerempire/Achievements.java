package not.bored.clickerempire;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

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
                else if (id == R.id.achievements) {

                }
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
}
