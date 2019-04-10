

import java.util.List;

abstract class Question {
  private String title;
  private List<String> options;
  private String correctAnswer;

  Question(String title, List<String> options, String correctAnswerText) {
    this.title = title;
    this.options = options;
    this.correctAnswer = correctAnswerText;
  }
  
  public String getTitle() {
	  return title;
  }
}
