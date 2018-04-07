package ser210.quinnipiac.edu.yodaspeak;

import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultFragmentActivity extends Fragment {

    private ImageButton yodaButton2;

    public ResultFragmentActivity(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View iview = inflater.inflate(R.layout.activity_result_fragment, container, false);

        yodaButton2 = (ImageButton) iview.findViewById(R.id.yodaButton2);

        String text = (String) (getActivity().getIntent().getExtras().get("result"));
        TextView textView = (TextView) iview.findViewById(R.id.messageReceive);
        textView.setText(text);

        // set on click listener
        yodaButton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), MainActivity.class);
                //((ImageButton)iview.findViewById(R.id.yodaButton1)).setEnabled(true);
                startActivity(intent);
            }
        });

        return iview;
    }

    /*
    // when you press button you go back to main activity
    public void onGoBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    */
}
