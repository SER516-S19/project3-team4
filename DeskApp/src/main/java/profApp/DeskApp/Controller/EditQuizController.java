package profApp.DeskApp.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.apache.commons.lang3.StringUtils;

import profApp.DeskApp.Error.ErrorScreen;
import profApp.DeskApp.Views.EditQuestionWindow;
import profApp.DeskApp.Views.EditQuizWindow;
import profApp.DeskApp.Views.SaveDialog;
import profApp.DeskApp.model.Question;
import profApp.DeskApp.model.Quiz;
import profApp.Utils.QuizConstants;
import profApp.Utils.QuizUtils;

/**
 * This is controller class which handles request for 1. SetQuestion 2. Replace
 * Question.
 * 
 * @author kirti Jha and Kumar Prabhu Kalyan
 * 
 */
public class EditQuizController {

	String filePath;
	Quiz quiz;

	int index;
	ArrayList<Question> listQuestions;

	EditQuestionWindow currentWindow;

	public EditQuizController(String filePath) {

		this.filePath = filePath;
		if (filePath != null && !StringUtils.isBlank(filePath))
			try {
				quiz = QuizUtils.getJsonStringQuiz(filePath);
			} catch (IOException e) {
				QuizUtils.setErrorDialog(e.getMessage());
			}
		index = 0;
		listQuestions = quiz.getQuestionList();

		currentWindow = null;
		this.startEdit();
	}

	/**
	 * This method allows to edit question window.
	 * 
	 * @param
	 * @return
	 */
	public void startEdit() {

		System.out.println(listQuestions.size());
		if (listQuestions == null || listQuestions.isEmpty()) {

			System.out.println("No questions");
			SaveDialog save = new SaveDialog(this, QuizConstants.noQuestionMesage);

		} else {
			if (listQuestions.size() > 0 && this.index < listQuestions.size()) {
				Question question = listQuestions.get(index);
				if (currentWindow != null) {
					currentWindow.dispose();
					currentWindow = new EditQuestionWindow(index, question, this);

				} else {
					currentWindow = new EditQuestionWindow(index, question, this);
				}

			} else {
				if (index >= listQuestions.size()) {

					SaveDialog save = new SaveDialog(this, QuizConstants.saveDialogMessage);
				}
			}
		}
	}

	/**
	 * This method sets the index for the question list.
	 * 
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * This method replaces the object at a specific position with the object passed
	 * as parameter.
	 * 
	 * @param index
	 * @param question
	 */
	public void replaceQuestion(int index, Question question) {
		listQuestions.set(index, question);
	}

	/**
	 * This helper method checks the list and based on the current pointer adds or
	 * replaces the object.
	 * 
	 * @param index
	 * @param question
	 */
	public void setQuestion(int index, Question question) {

		if (listQuestions == null || listQuestions.isEmpty()) {
			listQuestions = new ArrayList<Question>();
			listQuestions.add(question);
			quiz.setQuestionList(listQuestions);
		} else {
			if (index >= listQuestions.size()) {
				listQuestions.add(question);
			} else {
				listQuestions.set(index, question);
			}
		}
	}

	/**
	 * This helper method writes the json to file with given filePath.
	 */
	public void writeToFile() {
		QuizUtils.writeToFile(filePath, quiz);

	}

	/**
	 * This helper method disposes the current window for edit quiz.
	 */
	public void disposeWindow() {
		if (currentWindow != null)
			currentWindow.dispose();
	}

	/**
	 * This helper method disposes the current window for edit quiz and opens a new
	 * one with a new question
	 */
	public void addQuestion() {
		if (currentWindow != null)
			currentWindow.dispose();
		currentWindow = new EditQuestionWindow(index, new Question(), this);

	}

	/**
	 * This helper method to remove question from a quiz.
	 * 
	 * @param question
	 * @return
	 */
	public boolean remove(Question question) {
		if (listQuestions.contains(question)) {
			listQuestions.remove(question);
			return true;
		}
		return false;
	}

	/**
	 * This method is a getter for quiz.
	 * 
	 * @return
	 */
	public Quiz getQuiz() {
		return quiz;
	}

}
