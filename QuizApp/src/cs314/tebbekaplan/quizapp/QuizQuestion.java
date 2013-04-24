package cs314.tebbekaplan.quizapp;

public class QuizQuestion {
	
	private String question;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private char correctAnswer;
	
	public QuizQuestion(String question, String a, String b, String c, String d, char answer) {
		this.setQuestion(question);
		this.setAnswerA(a);
		this.setAnswerB(b);
		this.setAnswerC(c);
		this.setAnswerD(d);
		this.setCorrectAnswer(answer);
	}
	
	//check if a question is correct
	public boolean isCorrect(char choice) {
		// convert each character to string and compare them ignoring case
		if(Character.toString(correctAnswer).equalsIgnoreCase(Character.toString(choice))) {
			return true;
		}
		return false;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public char getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(char correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
