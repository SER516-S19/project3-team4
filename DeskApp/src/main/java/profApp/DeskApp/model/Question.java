package profApp.DeskApp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
	private String title;

	private List<String> options;

	private String correctAnswer;

	public Question(String title, List<String> options, String correctAnswer) {
		super();
		this.title = title;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	public Question() {

	}

	/**
	 * @param String
	 *            get title of Question
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            set title of Question
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param List
	 *            get options of Question
	 */
	public List<String> getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            set options of Question
	 */
	public void setOptions(String option) {
		if (this.options == null) {
			this.options = new ArrayList<String>();
		}
		this.options.add(option);
	}

	/**
	 * This method sets up the option list if it hasnt been initialized.
	 */
	public void setOptionsList() {
		this.options = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			options.add(null);
		}
	}

	/**
	 * @param String
	 *            get correct answer of Question
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correct
	 *            answer set correct answer of Question
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
