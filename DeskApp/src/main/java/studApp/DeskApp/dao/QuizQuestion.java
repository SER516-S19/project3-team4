package studApp.DeskApp.dao;

import java.util.List;

/**
 * @author amankaushik
 */
public class QuizQuestion extends Question{
  QuizQuestion(String title, List<String> options, String correctAnswer) {
    super(title, options, correctAnswer);
  }
}
