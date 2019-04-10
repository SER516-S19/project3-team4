package profApp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Quiz class
 *
 * @author akashkadam
 * @version 1.0
 */
public class Question {

	private String title;
	
	private List<String> options;
	
	private String correctAnswer;

	 /**
     * @param String : get title of Question
     */
	public String getTitle() {
		return title;
	}

	 /**
     * @param title : set title of Question
     */
	public void setTitle(String title) {
		this.title = title;
	}

	 /**
     * @param List : get options of Question
     */
	public List<String> getOptions() {
		return options;
	}

	 /**
     * @param options : set options of Question
     */
	public void setOptions(String option) {
		if(this.options == null) {
			this.options = new ArrayList<String>();
		}
		this.options.add(option);
	}

	 /**
     * @param String : get correct answer of Question
     */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	 /**
     * @param correct answer : set correct answer of Question
     */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
}
