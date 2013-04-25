package cs314.tebbekaplan.quizapp;

import java.util.ArrayList;
import java.util.Random;

import android.app.Application;

public class QuizDriver extends Application {
	
	private ArrayList<QuizQuestion> questionBank; // all 50 possible questions
	private ArrayList<QuizQuestion> questionList;  // each question selected 1-10
	private boolean[] answers; // keeps track of which answers are right or wrong
	
	public QuizDriver() {
		
		super();
		
		questionBank = new ArrayList<QuizQuestion>(); 
		questionList = new ArrayList<QuizQuestion>();
		answers = new boolean[10];
		
		loadQuestionBank();
		//selectQuestions();
	}
	
	private void loadQuestionBank() {
		QuizQuestion q = new QuizQuestion("here is a new question it might be long blah blah blah",
        		"answer A text", "answer B text", "answer C text", "answer D text", 'c');
		questionList.add(q);
	}

	private void selectQuestions() {
		questionList.clear(); // just in case
		Random rng = new Random();
		ArrayList<Integer> generated = new ArrayList<Integer>(); // keep track of the selected question number..no duplicates
		for (int i = 0; i < 10; i++) { // need 10 questions
		    while(true) {
		        Integer next = rng.nextInt(50); // 0 - 49
		        if (!generated.contains(next)) {
		        	questionList.add(questionBank.get(next)); // add the selected question to questionList from questionBank
		            generated.add(next); // save the selected number to check for dups
		            break;
		        }
		    }
		}
	}
	
	// returns the question from the questionList where the 'first question' is really at index 0
	public QuizQuestion getQuestion(int questionNumber) {
		if(questionNumber > 0 && questionNumber < questionList.size()) { // check for valid question number
			return questionList.get(questionNumber-1);
		}
		return null;
	}
	
	public void recordAnswer(int questionNumber, boolean correct) {
		if(questionNumber > 0 && questionNumber < answers.length) {
			answers[questionNumber-1] = correct;
		}
		System.out.println("answer recorded");
	}
	
	public String getResultsString() {
		return "Your score is " + getNumberCorrectAnswers() + " out of 10.";
	}

	public int getNumberCorrectAnswers() {
		int correct = 0;
		for(int i=0; i < answers.length; i++) {
			if(answers[i] == true) {
				correct++;
			}
		}
		return correct;
	}
}
