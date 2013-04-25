package cs314.tebbekaplan.quizapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button btnStartQuiz;
	TextView txtTitle, txtAuthor;
	@SuppressWarnings("unused")
	private QuizDriver quizDriver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		quizDriver = (QuizDriver) getApplication();
		
		btnStartQuiz = (Button) findViewById(R.id.startQuiz);
		txtTitle = (TextView) findViewById(R.id.title);
		txtAuthor = (TextView) findViewById(R.id.authors);
		
		btnStartQuiz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), Question1.class);
				startActivityForResult(intent, 0);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
