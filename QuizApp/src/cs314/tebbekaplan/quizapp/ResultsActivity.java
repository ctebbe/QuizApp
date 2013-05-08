package cs314.tebbekaplan.quizapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class ResultsActivity extends Activity {
	
	EditText txtResult;
	private QuizDriver quizDriver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		quizDriver = (QuizDriver) getApplication();
		
		txtResult = (EditText) findViewById(R.id.results);
		txtResult.setKeyListener(null);
		txtResult.setText(quizDriver.getResultsString() + "\n \n \n \n Thanks for playing!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
