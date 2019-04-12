package profApp.DeskApp.Controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import profApp.DeskApp.Views.EditQuestionWindow;
import profApp.DeskApp.Views.EditQuizWindow;
import profApp.DeskApp.Views.SaveDialog;
import profApp.DeskApp.model.Question;
import profApp.DeskApp.model.Quiz;
import profApp.Utils.QuizConstants;
import profApp.Utils.QuizUtils;

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

	public void startEdit() {

		if(listQuestions==null && listQuestions.isEmpty()) {
			SaveDialog save = new SaveDialog(this,QuizConstants.noQuestionMesage);
		}
		if (listQuestions.size() > 0 && this.index < listQuestions.size() ) {
			Question question = listQuestions.get(index);
			if (currentWindow != null) {
				currentWindow.dispose();
				currentWindow = new EditQuestionWindow(index, question, this);

			} else {
				currentWindow = new EditQuestionWindow(index, question, this);
			}

		}
		if (index >= listQuestions.size()) {

			SaveDialog save = new SaveDialog(this,QuizConstants.saveDialogMessage);
		}
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setQuestion(int index, Question question) {
		listQuestions.add( question);
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
		if(currentWindow!=null)
		currentWindow.dispose();
	       currentWindow =  new EditQuestionWindow(index, new Question(), this);
	       
		
	}

	public boolean remove(Question question) {
	if(listQuestions.contains(question))
		{listQuestions.remove(question);
		  return true;
		}
		return false;
	}

}
