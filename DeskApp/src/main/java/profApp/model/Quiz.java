package profApp.model;

import java.util.ArrayList;

/**
 * Quiz class
 *
 * @author akashkadam
 * @version 1.0
 */
public class Quiz {

	private ArrayList<Question> questions;

	/**
	 * Parameterized constructor with questionList attribute.
	 *
	 */
	public Quiz(ArrayList<Question> questionList) {
		super();
		this.questions = questionList;
	}

	public ArrayList<Question> getQuestionList() {
		return questions;
	}
}
