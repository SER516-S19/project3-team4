package studApp.DeskApp.controllers;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import studApp.DeskApp.models.QuizDAO;
import studApp.DeskApp.utils.JSONParser;
import studApp.DeskApp.views.QuizDirFrame;

/**
 * A basic controller that will initialize and return the quiz data
 * @author Hongfei Ju
 * @version 1.0
 */
public class QuizListController {	
	private QuizDirFrame qdChooser = null;
	private static List<QuizDAO> quizzes = null;
	
	public QuizListController() {
		qdChooser = new QuizDirFrame();
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
