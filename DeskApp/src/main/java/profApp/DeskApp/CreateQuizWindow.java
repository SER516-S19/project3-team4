package profApp.DeskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CreateQuizWindow extends JFrame {

	
	private JFrame frame;
	private JTextField textField;

	public CreateQuizWindow() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Quiz Title");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(629, 161, 205, 48);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK));
		textField.setBounds(524, 221, 335, 55);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBorder(new LineBorder(Color.BLACK));
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setBackground(SystemColor.scrollbar);
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 14));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQuestionsWindow addQuestions = new AddQuestionsWindow(textField.getText(),null);
				addQuestions.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(587, 332, 230, 40);
		panel.add(btnSubmit);

		JLabel lblCreateQuiz = new JLabel("Create Quiz");
		lblCreateQuiz.setForeground(new Color(139, 0, 0));
		lblCreateQuiz.setFont(new Font("Arial", Font.BOLD, 28));
		lblCreateQuiz.setBounds(604, 60, 243, 61);
		panel.add(lblCreateQuiz);
	}
}
