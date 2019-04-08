import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.*;

public class QuizListPanel extends JPanel {
	private List<QuizDAO> quizzes = null;
	private BoxLayout boxlayout = null;
	private String quizPanelName = null;
	private Dimension d = null;
	public QuizListPanel(List<QuizDAO> quizzes, String quizPanelName)  {
		initialize(quizzes, quizPanelName);	
		stylize();
		assemble();
	}
	
	private void initialize(List<QuizDAO> quizzes, String quizPanelName) {		
		this.quizzes = quizzes;
		this.quizPanelName = quizPanelName;
		boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.d = new Dimension(250, 50);
	}
	
	private void stylize() {
		setBackground(Color.CYAN);
		setLayout(boxlayout);
	}
	
	private void assemble() {
        for(QuizDAO q: quizzes) {
        	JButton jb = new JButton(q.getQuizName().substring(q.getQuizName().lastIndexOf('\\')+1));
        	jb.setAlignmentX(CENTER_ALIGNMENT);
        	jb.setAlignmentY(CENTER_ALIGNMENT);
        	jb.setMaximumSize(d);
        	add(jb);        	
        	jb.addActionListener(e->{
        		JFrame frame = new JFrame();
        		frame.setBounds(100, 100, 450, 300);
        		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);        		
        		buildQuizPanel(frame, q);				
        		frame.setVisible(true);
        	});
        }
	}
	
	private void buildQuizPanel(JFrame frame, QuizDAO q) {
		try {
			Class<?> clazz = Class.forName(quizPanelName);
			JPanel quizPanel = (JPanel) clazz.getDeclaredConstructor().newInstance();
    		frame.getContentPane().add(quizPanel);
		} catch (ClassNotFoundException | InstantiationException 
				| IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException | NoSuchMethodException 
				| SecurityException e1) {
			e1.printStackTrace();
		}
	}

}
