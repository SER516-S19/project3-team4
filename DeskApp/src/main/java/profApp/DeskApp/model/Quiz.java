package profApp.DeskApp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quiz implements Serializable {
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

	public void setQuestionList(List<Question> listQuestions) {
		questions = (ArrayList<Question>) listQuestions;

	}
}
