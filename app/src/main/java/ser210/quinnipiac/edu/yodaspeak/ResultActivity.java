package ser210.quinnipiac.edu.yodaspeak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

	// get intent from last activity and update the current text view
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_receive);
		String text = (String)(getIntent().getExtras().get("result"));
		TextView textView = (TextView)findViewById(R.id.messageReceive);
		textView.setText(text);
	}

	// when you press button you go back to main activity
	public void onGoBack(View view){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
