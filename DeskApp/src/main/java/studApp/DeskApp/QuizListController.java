package studApp.DeskApp;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import studApp.DeskApp.dao.QuizDAO;
import studApp.DeskApp.operations.JSONParser;

/**
 * A basic controller that will initialize the quiz data and all UI components
 * @author Hongfei Ju
 * @version 1.0
 */
public class QuizListController {	
	private QuizDirChooser qdChooser = null;
	private static List<QuizDAO> quizzes = null;
	
	public QuizListController() {
		qdChooser = new QuizDirChooser();
		quizzes = getQuizzes(qdChooser.getPath());
	}
	
	private List<QuizDAO> getQuizzes(String path){
        List<QuizDAO> quizDAOList = JSONParser.parseDirectory(path, null);
        return quizDAOList;
	}
	
	public List<QuizDAO> getQuizList() {
		return quizzes;
	}
}
