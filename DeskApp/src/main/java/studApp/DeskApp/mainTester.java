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
    List<QuizDAO> quizDAO = JSONParser.parseDirectory("/home/amankaushik/project3-team4/Quizzes/", null);
    System.out.println(quizDAO.get(0).getQuizName());
    System.out.println(quizDAO.get(0).getQuestionList());

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          QuestionController qc = new QuestionController(quizDAO.get(0));
          QuestionWindow window = new QuestionWindow(qc);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

}
