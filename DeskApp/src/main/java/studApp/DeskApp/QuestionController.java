package studApp.DeskApp;

import studApp.DeskApp.dao.Question;
import studApp.DeskApp.dao.QuizDAO;

public class QuestionController {
	QuizDAO quiz;
	boolean[] correctAnswers;
	int currentQuestion;
	int quizLength;
	QuestionController(QuizDAO quiz) {
		this.quiz = quiz;
		quizLength = quiz.getQuestionList().size();
		correctAnswers = new boolean[quizLength];
		currentQuestion = 0;
	}
	
	public Question getNextQuestion() {
		if(isAllCorrect()){
			return null;
		}
		else {
			do {
				currentQuestion = (currentQuestion + 1) % quizLength ;
			} while (correctAnswers[currentQuestion]);
			return quiz.getQuestionList().get(currentQuestion);
		}
	}
	
	/*
	 * Returns whether all questions are answered correctly
	 */
	private boolean isAllCorrect() {
		for(boolean b: correctAnswers) if(!b) return false;
		return true;
	}
}
