package cs314.tebbekaplan.quizapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question1 extends Activity {
	
	Button btnA, btnB, btnC, btnD;
	EditText ansA, ansB, ansC, ansD, questionText;
	private QuizQuestion question;
	private QuizDriver quizDriver;
	private int questionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        
        questionNumber = 1;
        quizDriver = (QuizDriver) getApplication();
        this.question = quizDriver.getQuestion(1);
        
        // assign buttons/text fields
        btnA = (Button) findViewById(R.id.buttonA);
        btnB = (Button) findViewById(R.id.buttonB);
        btnC = (Button) findViewById(R.id.buttonC);
        btnD = (Button) findViewById(R.id.buttonD);
        ansA = (EditText) findViewById(R.id.answerA);
        ansB = (EditText) findViewById(R.id.answerB);
        ansC = (EditText) findViewById(R.id.answerC);
        ansD = (EditText) findViewById(R.id.answerD);
        questionText = (EditText) findViewById(R.id.questionText);
        
        questionText.setText(question.getQuestion());
        ansA.setText(question.getAnswerA());
        ansB.setText(question.getAnswerB());
        ansC.setText(question.getAnswerC());
        ansD.setText(question.getAnswerD());
        
        // set the un-editable boxes
        questionText.setKeyListener(null);
        ansA.setKeyListener(null);
        ansB.setKeyListener(null);
        ansC.setKeyListener(null);
        ansD.setKeyListener(null);
        
        // set up listeners for buttons
        initListeners();
        
        /*
		// move to next question
		Intent intent = new Intent(v.getContext(), SecondPage.class);
		String value = text.getText().toString();
		intent.putExtra("value", value);
		startActivityForResult(intent, 0);
		*/
        		

    }
    
    private void initListeners() {
    	btnA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				recordAnswer('a');
			}
		});
        
        btnB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				recordAnswer('b');
			}
		});
        
        btnC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				recordAnswer('c');
			}
		});
        
        btnD.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				recordAnswer('d');
			}
		});
	}

	// eventually make this record answer
    private void recordAnswer(char answer) {
    	Toast msg;
		if(question.isCorrect(answer)) {
			quizDriver.recordAnswer(1, true);
			msg = Toast.makeText(getBaseContext(), "Correct Answer! :)", Toast.LENGTH_LONG);
		} else {
			quizDriver.recordAnswer(1, false);
			msg = Toast.makeText(getBaseContext(), "Incorrect Answer! :(", Toast.LENGTH_LONG);
		}
		msg.show();
		//launchNextQuestion();
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.question1, menu);
        return true;
    }
    
}
