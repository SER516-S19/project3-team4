package profApp.DeskApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateQuizWindow extends JFrame {
	private JFrame frame;
	private JTextField textField;

	public CreateQuizWindow() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Quiz Title");
		lblNewLabel.setBounds(95, 53, 156, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(95, 81, 196, 33);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQuestionsWindow addQuestions = new AddQuestionsWindow();
				addQuestions.setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(307, 172, 89, 23);
		panel.add(btnSubmit);
	}
}
