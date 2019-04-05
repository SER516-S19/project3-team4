package profApp.DeskApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddQuestionsWindow extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the application.
	 */
	public AddQuestionsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(45, 27, 54, 22);
		panel.add(lblQuestion);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(143, 27, 217, 40);
		panel.add(textArea);

		JLabel lblOption = new JLabel("Option 1");
		lblOption.setBounds(45, 98, 46, 14);
		panel.add(lblOption);

		textField = new JTextField();
		textField.setBounds(118, 95, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblOption_1 = new JLabel("Option 2");
		lblOption_1.setBounds(45, 147, 46, 14);
		panel.add(lblOption_1);

		textField_1 = new JTextField();
		textField_1.setBounds(118, 144, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblOption_2 = new JLabel("Option 3");
		lblOption_2.setBounds(256, 98, 46, 14);
		panel.add(lblOption_2);

		textField_2 = new JTextField();
		textField_2.setBounds(326, 95, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(326, 144, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblOption_3 = new JLabel("Option 4");
		lblOption_3.setBounds(256, 147, 46, 14);
		panel.add(lblOption_3);

		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(118, 185, 106, 14);
		panel.add(lblCorrectAnswer);

		textField_4 = new JTextField();
		textField_4.setBounds(216, 182, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnAddMoreQuestions = new JButton("Add more questions");
		btnAddMoreQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQuestionsWindow addQuestions = new AddQuestionsWindow();
				addQuestions.setVisible(true);
				dispose();
			}
		});
		btnAddMoreQuestions.setBounds(69, 227, 179, 23);
		panel.add(btnAddMoreQuestions);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationWindow appWindow = new ApplicationWindow();
				appWindow.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(271, 227, 89, 23);
		panel.add(btnSubmit);
	}
}
