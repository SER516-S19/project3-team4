package studApp.DeskApp.controllers;

import studApp.DeskApp.models.Question;
import studApp.DeskApp.models.QuizDAO;

/**
 * Controller for a quiz. Takes in a QuizDAO
 * and provides functionality to get questions
 * in order, grade questions, and loop until all
 * questions are completed
 * @author paulhorton
 * @version 1.0
 */
public class QuestionController {
	QuizDAO quiz;
	boolean[] correctAnswers;
	int currentQuestion;
	int quizLength;
	
	public QuestionController() {
		currentQuestion = 0;
	}
	
	/**
	 * Sets the quiz model for the controller to pass to the view
	 * @param quizDAO
	 */
	public void setQuiz(QuizDAO quizDAO) {
		this.quiz = quizDAO;
		quizLength = quiz.getQuestionList().size();
		correctAnswers = new boolean[quizLength];
	}
	
	/**
	 * Returns the current question
	 * @return the current question
	 */
	public Question getCurrentQuestion() {
		return quiz.getQuestionList().get(currentQuestion);
	}
	
	/**
	 * Returns the next one
	 * @return the next question or null if there is no next question
	 */
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
	
	/**
	 * Grades the current question and returns the next one
	 * @param answer The string answer of the current question
	 * @return the next question or null if there is no next question
	 */
	public Question submitAnswer(String answer) {
		correctAnswers[currentQuestion] = answer.equals(
				quiz.getQuestionList().get(currentQuestion).getCorrectAnswer());
		return getNextQuestion();
	}

	/**
	 * Checks if all questions are correctly answered
	 * @return if the quiz is all correct or not
	 */
	private boolean isAllCorrect() {
		for(boolean b: correctAnswers) if(!b) return false;
		return true;
	}
}
