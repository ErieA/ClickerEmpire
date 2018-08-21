package not.bored.clickerempire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

public class purchasedUpgrades extends AppCompatActivity {
//    GameSave gameSave = GameSave.getGameSave(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased_upgrades);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout(((int) (width*.8)), ((int) (height*.8)));
        Intent intent = getIntent();
        LinearLayout layout = findViewById(R.id.purchased);
        Bundle bundle = intent.getExtras();
        try {
            Set<String> keys = bundle.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                TextView tv = new TextView(this);
                String txt = key.substring(0,1) + key.toLowerCase().substring(1);
                tv.setText("  " +txt);
                tv.setTextSize(16);
                layout.addView(tv);
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
