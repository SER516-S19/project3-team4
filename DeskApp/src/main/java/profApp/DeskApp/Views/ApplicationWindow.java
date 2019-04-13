package profApp.DeskApp.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;

/**
 * This Class creates the application window.
 * 
 * @author Kumar Kalyan Prabhu, Kirti Jha and Harshita Kajal
 *
 */
public class ApplicationWindow extends JFrame implements ActionListener {
	JButton jButtonCreate;
	JPanel panel;
	JButton jButtonEdit;

	public ApplicationWindow() {
		this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Professor Application");
		this.setBounds(400, 400, 500, 500);

		initializeView();

	}

	/**
	 * This method initializes the Panels and buttons for the application window.
	 */
	private void initializeView() {
		panel = new JPanel();
		getContentPane().add(panel);
		jButtonEdit = new JButton("Edit Quiz");
		jButtonEdit.addActionListener(this);
		jButtonCreate = new JButton("Create Quiz");
		jButtonCreate.addActionListener(this);
		panel.setLayout(null);
		panel.add(jButtonCreate);
		panel.add(jButtonEdit);

		jButtonCreate.setBounds(99, 179, 124, 23);
		jButtonEdit.setBounds(233, 179, 137, 23);
		
		JLabel jLblWelcome = new JLabel("Welcome to the Quiz");	
		jLblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		jLblWelcome.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC, 17));
		jLblWelcome.setBounds(60, 35, 339, 56);
		panel.add(jLblWelcome);

	};

	/**
	 * This method is the event handler for the Frame.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Edit Quiz")) {

			JButton buttonPressed = (JButton) arg0.getSource();
			if (buttonPressed.getText().equalsIgnoreCase("Edit Quiz")) {
				EditQuizWindow edit = new EditQuizWindow();
				edit.setVisible(true);
			}
		}


		if (arg0.getSource().equals(jButtonCreate)) {
			if (arg0.getActionCommand().equals("Create Quiz")) {
				CreateQuizWindow createQuiz = new CreateQuizWindow();
				createQuiz.setVisible(true);
				dispose();
			}
		}

	}
}
