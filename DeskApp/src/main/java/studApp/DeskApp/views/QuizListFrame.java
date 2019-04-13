package studApp.DeskApp.views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.*;

import studApp.DeskApp.controllers.QuizListController;
import studApp.DeskApp.models.QuizDAO;

/**
 * This frame will list a button for each quiz. When the button is click, the corresponding quiz frame
 * will be shown;
 * @author Hongfei Ju
 * @version 1.0
 */
public class QuizListFrame extends JFrame {
	private List<QuizDAO> qs = null;
	private JPanel panel = null;
	private QuizListController quizController;
	private QuestionFrame nextWindow;
	
	public QuizListFrame(QuizListController quizController, QuestionFrame nextWindow)  {
		this.quizController = quizController;
		this.nextWindow = nextWindow;
		initialize(quizController.getQuizList());	
		stylize();
		assemble();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
	}
	
	private void initialize(List<QuizDAO> quizzes) {
		panel = new JPanel();
		qs = quizzes;
	}
	
	private void stylize() {
		setBounds(100, 100, 350, 50*qs.size()+50);
		panel.setBackground(Color.GREEN);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	
	/**
	 * assemble the quiz buttons into the panel
	 */
	private void assemble() {
		add(panel);
        for(int i=0;i<qs.size();i++) {
        	JButton jb = new JButton(qs.get(i).getQuizName().substring(qs.get(i).getQuizName().lastIndexOf('\\')+1));
        	jb.setAlignmentX(CENTER_ALIGNMENT);
        	jb.setAlignmentY(CENTER_ALIGNMENT);
        	jb.setMaximumSize(new Dimension(250, 50));
        	panel.add(jb);        	
        	int index= i;
        	jb.addActionListener(e->{
        		QuizDAO quiz = quizController.getQuizList().get(index);
        		nextWindow.getController().setQuiz(quiz);
        		setVisible(false);
        		nextWindow.render();
        	});
        }
	}

}
