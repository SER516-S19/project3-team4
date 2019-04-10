package studApp.DeskApp.dao;

import java.util.List;

/**
 * @author amankaushik
 */
public abstract class Question {
  /* Question text */
  private String title;
  /* List of available answer choices */
  private List<String> options;
  private String correctAnswer;

  Question(String title, List<String> options, String correctAnswerText) {
    this.title = title;
    this.options = options;
    this.correctAnswer = correctAnswerText;
  }

  public final String getTitle() {
    return title;
  }

  public final List<String> getOptions() {
    return options;
  }

  public final String getCorrectAnswer() {
    return correctAnswer;
  }
}
