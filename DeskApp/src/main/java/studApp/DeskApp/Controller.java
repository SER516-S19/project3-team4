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
public class Controller {	
	private QuizDirChooser qdChooser = null;
	private static List<QuizDAO> quizzes = null;
	private QuizListFrame quizzesFrame = null;
	private List<DummyQuestionWindow> questionWindows = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller controller = new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	public Controller() {
		qdChooser = new QuizDirChooser();
		quizzes = getQuizzes(qdChooser.getPath());
		questionWindows = getQuestionWindows(quizzes);
		quizzesFrame = new QuizListFrame(quizzes, questionWindows);		
	}
	
	private List<QuizDAO> getQuizzes(String path){
        List<QuizDAO> quizDAOList = JSONParser.parseDirectory(path, null);
        return quizDAOList;
	}
	
	private List<DummyQuestionWindow> getQuestionWindows(List<QuizDAO> quizzes){
		List<DummyQuestionWindow> list = new LinkedList<>();
		for(QuizDAO q: quizzes) {
			list.add(new DummyQuestionWindow(q.getQuizName()));
			System.out.println("get quiz " + q.getQuizName());
		}
		return list;
	}

}
