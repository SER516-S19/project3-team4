package profApp.DeskApp.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.apache.commons.lang3.StringUtils;

import profApp.DeskApp.Views.EditQuestionWindow;
import profApp.DeskApp.Views.EditQuizWindow;
import profApp.DeskApp.Views.SaveDialog;
import profApp.DeskApp.model.Question;
import profApp.DeskApp.model.Quiz;
import profApp.Utils.QuizConstants;
import profApp.Utils.QuizUtils;

/**
 * This is controller class which handles request for 1. SetQuestion
 * 2. Replace Question.
 * 
 * @author kirti Jha and Kumar Prabhu Kalyan
 * 
 */
public class EditQuizController {

	String filePath;
	Quiz quiz;

	int index;
	List<Question> listQuestions;

	EditQuestionWindow currentWindow;

	public EditQuizController(String filePath) {
		System.out.println("In controller");
		this.filePath = filePath;
		if (filePath != null && !StringUtils.isBlank(filePath))
			quiz = QuizUtils.getJsonStringQuiz(filePath);
		index = 0;
		listQuestions = quiz.getQuestionList();

		currentWindow = null;
		this.startEdit();
	}

	/**
	 * This method allows to edit question window.
	 * @param
	 * @return
	 */
	public void startEdit() {

		System.out.println(listQuestions.size());
		if (listQuestions == null || listQuestions.isEmpty()) {

			System.out.println("No questions");
			SaveDialog save = new SaveDialog(this, QuizConstants.noQuestionMesage);
			
		}else {
			if (listQuestions.size() > 0 && this.index < listQuestions.size()) {
				System.out.println(index+":::::::"+listQuestions.size());
				Question question = listQuestions.get(index);
				if (currentWindow != null) {
					currentWindow.dispose();
					currentWindow = new EditQuestionWindow(index, question, this);
	
				} else {
					currentWindow = new EditQuestionWindow(index, question, this);
				}
	
			}else {
				if (index >= listQuestions.size()) {
		
					System.out.println("Save dialog");
					SaveDialog save = new SaveDialog(this, QuizConstants.saveDialogMessage);
				}
			}
		}
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void replaceQuestion(int index, Question question)
	{
		System.out.println("Replacing");
		listQuestions.set(index, question);
	}
	
	public void setQuestion(int index, Question question) {
		
	    if(listQuestions==null || listQuestions.isEmpty() ) {
	    	System.out.println("Here");
	    	listQuestions = new ArrayList<Question>();
	    	listQuestions.add(question);
	    }else {
	    	if(index>=listQuestions.size())
	    		listQuestions.add(question);
	    	else {
		System.out.println("Setting");
		listQuestions.set(index,question);
	    	}
	    }
	}

	public void writeToFile() {
		for (Question que : quiz.getQuestionList()) {
			System.out.println(que.getTitle());
		}
		System.out.println("Writing");
		QuizUtils.writeToFile(filePath, quiz);

	}

	public void disposeWindow() {
		if (currentWindow != null)
			currentWindow.dispose();
	}

	public void addQuestion() {
		if (currentWindow != null)
			currentWindow.dispose();
		currentWindow = new EditQuestionWindow(index, new Question(), this);

	}

	public boolean remove(Question question) {
		if (listQuestions.contains(question)) {
			listQuestions.remove(question);
			return true;
		}
		return false;
	}
	public Quiz getQuiz() {
		return quiz;
	}

}
