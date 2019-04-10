package studApp.DeskApp.dao;

import java.util.List;

/**
 * @author amankaushik
 */
public class QuizDAO {
  private String name;
  private List<Question> questions;

  public String getQuizName() {
    return name;
  }

  public void setQuizName(String quizName) {
    this.name = quizName;
  }

  public List<Question> getQuestionList() {
    return questions;
  }

  void setQuestionList(List<Question> questions) {
    this.questions = questions;
  }
}
