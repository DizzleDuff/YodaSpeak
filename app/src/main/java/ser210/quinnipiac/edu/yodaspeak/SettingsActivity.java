package ser210.quinnipiac.edu.yodaspeak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class SettingsActivity extends Activity {
    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //ll = (LinearLayout) findViewById(R.id.settings);
        //ll.setBackgroundResource(MainActivity.backgroundCheck());
    }

    public void OnButtonClick(View v){
        switch (v.getId()) {
            case R.id.buttonimage1:
                break;
            case R.id.buttonimage2:
                break;
            case R.id.buttonimage3:
                break;

        }
    }
}