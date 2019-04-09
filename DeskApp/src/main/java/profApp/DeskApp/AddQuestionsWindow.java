package profApp.DeskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddQuestionsWindow extends JFrame {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public AddQuestionsWindow() {
		setBackground(new Color(248, 248, 255));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
		lblQuestion.setBounds(560, 39, 106, 22);
		panel.add(lblQuestion);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.BLACK));
		textArea.setBounds(676, 41, 238, 71);
		panel.add(textArea);

		JLabel lblOption = new JLabel("Option 1");
		lblOption.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOption.setBounds(379, 148, 94, 14);
		panel.add(lblOption);

		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK));
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setBounds(504, 136, 174, 40);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblOption_1 = new JLabel("Option 2");
		lblOption_1.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOption_1.setBounds(379, 249, 94, 14);
		panel.add(lblOption_1);

		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(Color.BLACK));
		textField_1.setBounds(504, 237, 174, 40);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblOption_2 = new JLabel("Option 3");
		lblOption_2.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOption_2.setBounds(722, 148, 86, 14);
		panel.add(lblOption_2);

		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(Color.BLACK));
		textField_2.setBounds(859, 136, 174, 40);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBorder(new LineBorder(Color.BLACK));
		textField_3.setBounds(859, 237, 174, 40);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblOption_3 = new JLabel("Option 4");
		lblOption_3.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOption_3.setBounds(722, 249, 99, 14);
		panel.add(lblOption_3);

		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setForeground(Color.BLACK);
		lblCorrectAnswer.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblCorrectAnswer.setBounds(504, 324, 152, 14);
		panel.add(lblCorrectAnswer);

		textField_4 = new JTextField();
		textField_4.setBorder(new LineBorder(Color.BLACK));
		textField_4.setBounds(689, 312, 174, 40);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnAddMoreQuestions = new JButton("Add more questions");
		btnAddMoreQuestions.setForeground(Color.BLACK);
		btnAddMoreQuestions.setBorder(new LineBorder(Color.BLACK));
		btnAddMoreQuestions.setBackground(SystemColor.scrollbar);
		btnAddMoreQuestions.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnAddMoreQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQuestionsWindow addQuestions = new AddQuestionsWindow();
				addQuestions.setVisible(true);
				dispose();
			}
		});
		btnAddMoreQuestions.setBounds(454, 396, 224, 49);
		panel.add(btnAddMoreQuestions);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBorder(new LineBorder(Color.BLACK));
		btnSubmit.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnSubmit.setBackground(SystemColor.scrollbar);
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationWindow appWindow = new ApplicationWindow();
				appWindow.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(830, 396, 117, 49);
		panel.add(btnSubmit);
	}
}
