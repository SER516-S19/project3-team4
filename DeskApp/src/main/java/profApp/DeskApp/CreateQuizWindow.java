package profApp.DeskApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * CreateQuizWindow class: This class displays the option to enter quiz title
 * and checks if the quiz already exists.
 * @author akashkadam, truptikhatavkar
 * @version 1.3
 */
public class CreateQuizWindow extends JFrame {

	private JFrame frame;
	private JTextField quizTitleInput;
	private final String FOLDER_PATH = "./quizzes/";

	/**
	* Constructor to initialize all the components of UI.
	*/
	public CreateQuizWindow() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel createQuizHeader = new JLabel("Create Quiz");
		createQuizHeader.setForeground(new Color(139, 0, 0));
		createQuizHeader.setFont(new Font("Arial", Font.BOLD, 28));
		createQuizHeader.setBounds(604, 60, 243, 61);
		panel.add(createQuizHeader);

		JLabel enterQuizTitle = new JLabel("Enter Quiz Title");
		enterQuizTitle.setFont(new Font("Arial", Font.BOLD, 16));
		enterQuizTitle.setBounds(629, 161, 205, 48);
		panel.add(enterQuizTitle);

		quizTitleInput = new JTextField();
		quizTitleInput.setBorder(new LineBorder(Color.BLACK));
		quizTitleInput.setBounds(524, 221, 335, 55);
		panel.add(quizTitleInput);
		quizTitleInput.setColumns(10);

		final JLabel quizExists = new JLabel(" ");
		quizExists.setForeground(new Color(128, 0, 0));
		quizExists.setFont(new Font("Arial", Font.BOLD, 16));
		quizExists.setBounds(648, 264, 205, 48);
		panel.add(quizExists);

		JButton submit = new JButton("Submit");
		submit.setBorder(new LineBorder(Color.BLACK));
		submit.setForeground(Color.BLACK);
		submit.setBackground(SystemColor.scrollbar);
		submit.setFont(new Font("Arial", Font.BOLD, 14));
		submit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		String fileName = FOLDER_PATH + quizTitleInput.getText() + ".json";
		File file = new File(fileName);
		if (file.exists() && file.isFile()) {
			quizExists.setText("Quiz exists");
		} else {
			AddQuestionsWindow addQuestions = new AddQuestionsWindow(quizTitleInput.getText(), null);
			addQuestions.setVisible(true);
			dispose();
		}
		}
		});
		submit.setBounds(587, 332, 230, 40);
		panel.add(submit);
	}
}
