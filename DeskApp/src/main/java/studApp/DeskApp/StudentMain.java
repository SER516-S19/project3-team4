/* FOR TESTING PURPOSE ONLY - DELETE FROM FINAL RELEASE */

package studApp.DeskApp;

import java.awt.EventQueue;
import java.util.List;

import studApp.DeskApp.controllers.QuestionController;
import studApp.DeskApp.controllers.QuizListController;
import studApp.DeskApp.models.QuizDAO;
import studApp.DeskApp.utils.JSONParser;
import studApp.DeskApp.views.EndFrame;
import studApp.DeskApp.views.QuestionFrame;
import studApp.DeskApp.views.QuizListFrame;

/**
 * @author amankaushik
 * @author paulhorton
 */
public class StudentMain {

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizListController quizListController = new QuizListController();
					QuestionController  questionController = new QuestionController();
					QuestionFrame questionFrame = new QuestionFrame(questionController, new EndFrame());
					new QuizListFrame(quizListController, questionFrame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
    }    
}
