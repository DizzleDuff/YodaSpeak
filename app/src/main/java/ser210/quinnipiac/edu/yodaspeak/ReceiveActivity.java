package ser210.quinnipiac.edu.yodaspeak;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //intent stuff
        Intent intent = getIntent();
        String nameText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView nameView = (TextView)findViewById(R.id.messageReceive);
        nameView.setText(nameText);
    }

    public void onGoBack(View view){

    }

}
