/* FOR TESTING PURPOSE ONLY - DELETE FROM FINAL RELEASE */

package studApp.DeskApp;

import java.awt.EventQueue;
import java.util.List;

import studApp.DeskApp.dao.QuizDAO;
import studApp.DeskApp.operations.JSONParser;

/**
 * @author amankaushik 
 * @author paulhorton
 */
public class mainTester {

    public static void main(String[] args) {
        QuizDAO quizDAO = JSONParser.parseFile("src/main/java/studApp/DeskApp/check.json", null);
        System.out.println(quizDAO.getQuizName());
        System.out.println(quizDAO.getQuestionList());
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionController qc = new QuestionController(quizDAO);
					QuestionWindow window = new QuestionWindow(qc);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    
}
