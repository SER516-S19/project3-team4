import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;
import java.awt.Dimension;


public class StudentMenu {

	JFrame quiz = new JFrame("Student Quiz Application");
	JPanel quizPanel = new JPanel();
	JLabel message = new JLabel("Select a quiz you want to start : ");
	String[] quizzes = { "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Quiz 5", "Quiz 6" };
	final JComboBox<String> quizMenu = new JComboBox<String>(quizzes);
	JButton startQuiz = new JButton("Start Quiz");
	BoxLayout boxlayout = new BoxLayout(quizPanel, BoxLayout.Y_AXIS);

	public StudentMenu() {

		startQuiz.setAlignmentX(Component.CENTER_ALIGNMENT);

		quizMenu.setMaximumSize(quizMenu.getPreferredSize());
		quizMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

		message.setAlignmentX(Component.CENTER_ALIGNMENT);

		quizPanel.add(message);
		quizPanel.add(Box.createRigidArea(new Dimension(0, 80)));
		quizPanel.add(quizMenu);
		quizPanel.add(Box.createRigidArea(new Dimension(0, 80)));
		quizPanel.add(startQuiz);
		quizPanel.setLayout(boxlayout); 
		quizPanel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

    	quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	quiz.setSize(650, 650);
    	quiz.setLocation(300, 50);
    	quiz.add(quizPanel);
		quiz.setVisible(true);

	}
	
}