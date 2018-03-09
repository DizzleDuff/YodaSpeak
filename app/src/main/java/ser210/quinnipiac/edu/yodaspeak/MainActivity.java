package ser210.quinnipiac.edu.yodaspeak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// send the intent with the written message
	public void showMessage(String result) {
		Intent intent = new Intent(this, ResultActivity.class);
		intent.putExtra("result", result);
		((ImageButton)findViewById(R.id.yodaButton1)).setEnabled(true);
		startActivity(intent);
	}

	// get the message and convert with YodaSpeak when button is clicked
	protected void onMessageSend(View view) {
		EditText editTextt = (EditText) findViewById(R.id.enterText);
		String text = editTextt.getText().toString().trim();
		view.setEnabled(false);
		new YodaSpeak(this).execute(text);
	}



}
