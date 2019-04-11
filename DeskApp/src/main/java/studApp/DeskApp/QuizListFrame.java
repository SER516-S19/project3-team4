package studApp.DeskApp;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.*;

import studApp.DeskApp.dao.QuizDAO;

/**
 * This frame will list a button for each quiz. When the button is click, the corresponding quiz frame
 * will be shown;
 * @author Hongfei Ju
 * @version 1.0
 */
public class QuizListFrame extends JFrame {
	private List<QuizDAO> qs = null;
	private JPanel panel = null;
	private List<DummyQuestionWindow> qws = null;
	
	public QuizListFrame(List<QuizDAO> quizzes, List<DummyQuestionWindow> questionWindows)  {
		initialize(quizzes, questionWindows);	
		stylize();
		assemble();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
	}
	
	/**
	 * initialize the quiz list panel, get the quiz list data and question window list
	 */
	private void initialize(List<QuizDAO> quizzes, List<DummyQuestionWindow> questionWindows) {
		panel = new JPanel();
		qs = quizzes;
		qws = questionWindows;	
	}
	
	/**
	 * set the size of the frame and style of the panel
	 */
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
        	System.out.println("add button" + qs.get(i).getQuizName());
        	JButton jb = new JButton(qs.get(i).getQuizName().substring(qs.get(i).getQuizName().lastIndexOf('\\')+1));
        	jb.setAlignmentX(CENTER_ALIGNMENT);
        	jb.setAlignmentY(CENTER_ALIGNMENT);
        	jb.setMaximumSize(new Dimension(250, 50));
        	panel.add(jb);        	
        	int index= i;
        	jb.addActionListener(e->{
        		qws.get(index).show();
        	});
        	
        }
	}

}
