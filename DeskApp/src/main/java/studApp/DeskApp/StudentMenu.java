

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentMenu  {
	JFrame frame = new JFrame("Student Quiz Application");
	JPanel panel = new JPanel();
	String quizzes[] = { "Quiz1", "Quiz2", "Quiz3", "Quiz4", "Quiz5" };
	JComboBox comboBox= new JComboBox(quizzes);
	JButton button = new JButton("Take Quiz");
	JLabel pageName = new JLabel("Welcome to Student Menu !!", SwingConstants.CENTER);
	//pageName.setFont(new Font("Serif", Font.PLAIN, 14));

	JLabel selectQuizName = new JLabel("Select Quiz"); 


	public StudentMenu() {
		panel.setLayout(new GridLayout(4,1,2,30));
		panel.add(pageName);
		panel.add(selectQuizName);
		panel.add(comboBox);
		panel.add(button);
		
		frame.add(panel);
		
		frame.pack();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new  StudentMenu();
	}
}
