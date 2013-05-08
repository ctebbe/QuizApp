package cs314.tebbekaplan.quizapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import android.app.Application;

public class QuizDriver extends Application {
	
	private ArrayList<QuizQuestion> questionBank; // all 50 possible questions
	private ArrayList<QuizQuestion> questionList;  // each question selected 1-10
	private boolean[] answers; // keeps track of which answers are right or wrong
	private boolean[] questionsAttempted;
	
	public QuizDriver() {
		
		super();
		
		questionBank = new ArrayList<QuizQuestion>(); 
		questionList = new ArrayList<QuizQuestion>();
		answers = new boolean[10];
		questionsAttempted = new boolean[10];
		for(int i=0; i<answers.length-1; i++) {
			answers[i] = false;
		}
		
		//selectQuestions();
	}
	
	public void selectQuestions() {
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
		if(questionNumber > 0 && questionNumber <= questionList.size()) { // check for valid question number
			return questionList.get(questionNumber-1);
		}
		return null;
	}
	
	// records the answer for corresponding question
	public void recordAnswer(int questionNumber, boolean correct) {
		if(questionNumber > 0 && questionNumber <= answers.length) {
			questionsAttempted[questionNumber-1] = true; //Record that we have attempted this question
			answers[questionNumber-1] = correct;
		}
	}
	
	public int getQuestionsAttempted(){
		
		int attempted = 0;
		
		for(int i = 0; i < questionsAttempted.length; i++){
			if(questionsAttempted[i] == true){
				attempted++;
			}
		}
		
		return attempted;
	}
	
	public String getResultsString() {
		String totalQuestions = " Total questions on quiz: " + questionList.size();
		String questionsAttempted = "\n \n Number of questions attempted: " + getQuestionsAttempted();
		String correctAnswers = "\n \n Number of correct answers: " + getNumberCorrectAnswers();
		
		return totalQuestions + questionsAttempted + correctAnswers;

	}

	// return number of answers currently correct
	public int getNumberCorrectAnswers() {
		int correct = 0;
		for(int i=0; i < answers.length; i++) {
			if(answers[i] == true) {
				correct++;
			}
		}
		return correct;
	}

	// parses data from a file already opened in the bufferedreader
	public void parseQuestionData(BufferedReader br) throws IOException {
		String record, element, question = null, a = null, b = null, c = null, d = null;
		char correct;
		while((record = br.readLine()) != null) {
            element = getElement(record);
            if (element == null) throw new IOException();
            if (element.equals("Question")) {
            	question = getStringValue(record);
            } else if (element.equals("Answer A")) {
            	a = getStringValue(record);
            } else if (element.equals("Answer B")) {
            	b = getStringValue(record);
            } else if (element.equals("Answer C")) {
            	c = getStringValue(record);
            } else if (element.equals("Answer D")) {
            	d = getStringValue(record);
            } else if (element.equals("Correct Answer")) {
            	correct = getCharValue(record);
            	questionBank.add(new QuizQuestion(question, a, b, c, d, correct)); // change to questionBank eventually
            }
		}
	}

	// get the tag
	private String getElement(String record) {
		try {
            return (record.substring(record.indexOf("<") + 1, record.indexOf(">")));
        } catch(Exception e) {
            return null;
        }
	}
	
	// get the string value inside the tag
	private String getStringValue(String record) {
        return (record.substring(record.indexOf(">") + 1, record.indexOf("</"))).trim();
    }
	
	// get the character value inside the tag
	private Character getCharValue(String record) {
        return record.charAt(record.indexOf(">") + 1);
    }
}
