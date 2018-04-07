package ser210.quinnipiac.edu.yodaspeak;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private FragmentManager rFragmentManager;
    private FragmentTransaction rFragmentTransaction;

    // get intent from last activity and update the current text view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_receive);

        rFragmentManager = getFragmentManager();
        rFragmentTransaction = rFragmentManager.beginTransaction();
        rFragmentTransaction.add(R.id.resultActivity, new ResultFragmentActivity());
        rFragmentTransaction.commit();
/*
        // setting toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        */
    }
}
