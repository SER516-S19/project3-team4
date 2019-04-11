package studApp.DeskApp;

import javax.swing.*;

public class DummyQuestionWindow {
	private JFrame frame = null;
	private String qn = null;
	
	public DummyQuestionWindow(String quizName) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		frame.setBounds(100, 100, 450, 300);
		qn = quizName;
	}
	
	public void show() {
		frame.setVisible(true);
		System.out.println(qn);
	}
}
