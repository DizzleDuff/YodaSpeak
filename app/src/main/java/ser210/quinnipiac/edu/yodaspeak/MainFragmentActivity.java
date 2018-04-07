package ser210.quinnipiac.edu.yodaspeak;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainFragmentActivity extends Fragment {

    private ImageButton yodaButton;
    private String result;

    public MainFragmentActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View iview = inflater.inflate(R.layout.activity_main_fragment, container, false);

        // add all things you're getting here
        yodaButton = (ImageButton) iview.findViewById(R.id.yodaButton1);

        // set on click listener
        yodaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //view = view;
                EditText editText = (EditText) iview.findViewById(R.id.enterText);
                result = editText.getText().toString();
                view.setEnabled(false);
                worker();
            }
        });

        return iview;
    }

    // send the intent with the written message
    public void showMessage(String result) {
        Intent intent = new Intent(getActivity(), ResultActivity.class);
        intent.putExtra("result", result);
        ((ImageButton) getView().findViewById(R.id.yodaButton1)).setEnabled(true);
        startActivity(intent);
    }

    /*
    // get the message and convert with YodaSpeak when button is clicked
    protected void onMessageSend(View view) {


    } */

    public void worker() {
        new YodaSpeak(this).execute(result);
    }
}
