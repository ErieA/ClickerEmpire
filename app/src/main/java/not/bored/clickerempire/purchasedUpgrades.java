package not.bored.clickerempire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.TextView;

public class purchasedUpgrades extends AppCompatActivity {
    GameSave gameSave = GameSave.getGameSave(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased_upgrades);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout(((int) (width*.8)), ((int) (height*.8)));
        LinearLayout linearLayout = findViewById(R.id.purchased);
        Intent intent = getIntent();
        if(intent.getStringExtra(gameSave.SKINNING) != null){
            TextView tv = new TextView(this);
            tv.setText("Skinning");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.HARVESTING) != null){
            TextView tv = new TextView(this);
            tv.setText("Harvesting");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.PROSPECTING) != null){
            TextView tv = new TextView(this);
            tv.setText("Prospecting");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.MASONRY) != null){
            TextView tv = new TextView(this);
            tv.setText("Masonry");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.DOMESTICATION) != null){
            TextView tv = new TextView(this);
            tv.setText("Domestication");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.PLOUGHSHARES) != null){
            TextView tv = new TextView(this);
            tv.setText("Ploughshares");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.IRRIGATION) != null){
            TextView tv = new TextView(this);
            tv.setText("Irrigation");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.CONSTRUCTION) != null){
            TextView tv = new TextView(this);
            tv.setText("Construction");
            linearLayout.addView(tv);
        }
        if(intent.getStringExtra(gameSave.GRANARIES) != null){
            TextView tv = new TextView(this);
            tv.setText("Granaries");
            linearLayout.addView(tv);
        }
    }
}
