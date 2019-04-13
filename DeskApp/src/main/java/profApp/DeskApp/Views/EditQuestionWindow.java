package profApp.DeskApp.Views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import profApp.DeskApp.Controller.EditQuizController;
import profApp.DeskApp.model.Question;
import profApp.Utils.QuizConstants;

public class EditQuestionWindow extends JFrame implements ActionListener {

	JButton btnNext;
	JButton btnBack;
	JButton btnCancel;
	EditQuizController editQuiz;
	Question question;
	JFormattedTextField questionTitle;
	JFormattedTextField option1;
	JFormattedTextField option2;
	JFormattedTextField option3;
	JFormattedTextField option4;
	Map<String, String> mapChoices;
	JComboBox<String> correctChoice;
	int index;
	private JButton buttonRemove;

	public EditQuestionWindow(int index, Question question, EditQuizController editQuiz) {
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.editQuiz = editQuiz;
		this.question = question;
		this.index = index;
		this.setBounds(300, 300, 600, 600);
		this.setVisible(true);
		mapChoices = new HashMap<String, String>();

		JLabel lblNewLabel = new JLabel("Question " + (index + 1));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 11, 76, 14);
		getContentPane().add(lblNewLabel);

		questionTitle = new JFormattedTextField();
		questionTitle.setBounds(31, 36, 348, 58);
		getContentPane().add(questionTitle);
		questionTitle.setEditable(true);

		option1 = new JFormattedTextField();
		option1.setBounds(31, 154, 348, 20);
		getContentPane().add(option1);
		option1.setEditable(true);

		option2 = new JFormattedTextField();
		option2.setBounds(31, 206, 348, 20);
		getContentPane().add(option2);
		option2.setEditable(true);

		option3 = new JFormattedTextField();
		option3.setBounds(31, 256, 348, 20);
		getContentPane().add(option3);
		option3.setEditable(true);

		option4 = new JFormattedTextField();
		option4.setBounds(31, 310, 348, 20);
		getContentPane().add(option4);
		option4.setEditable(true);

		String choices[] = null;

		addOptionFields();
		
		correctChoice = new JComboBox<String>();
		if (question != null) {
			for (int i = 0; i < QuizConstants.options.length; i++) {
				if (question.getOptions() != null && question.getOptions().size() > 0)
					mapChoices.put(QuizConstants.options[i], question.getOptions().get(i));
				correctChoice.addItem(QuizConstants.options[i]);
			}
			if (question.getOptions() != null && question.getOptions().size() > 0) {
				option1.setText(question.getOptions().get(0));
				option2.setText(question.getOptions().get(1));
				option3.setText(question.getOptions().get(2));
				option4.setText(question.getOptions().get(3));
				System.out.println(question.getOptions().indexOf(question.getCorrectAnswer()));
				correctChoice.setSelectedItem(
						QuizConstants.options[question.getOptions().indexOf(question.getCorrectAnswer())]);
			}
			questionTitle.setText(question.getTitle());
			choices = QuizConstants.options;
		}

		correctChoice.setBounds(31, 389, 348, 20);
		getContentPane().add(correctChoice);
		correctChoice.setEditable(true);
		setOptionLabels();

		JLabel lblCorrectAnswer = new JLabel("Correct Answer:");
		lblCorrectAnswer.setBounds(31, 364, 97, 14);
		getContentPane().add(lblCorrectAnswer);

		addButtons();

	}

	private void addButtons() {
		btnNext = new JButton("Next");
		btnNext.setBounds(31, 436, 89, 23);
		btnNext.addActionListener(this);
		getContentPane().add(btnNext);

		btnBack = new JButton("Back");
		btnBack.setBounds(153, 436, 89, 23);
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(276, 436, 89, 23);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);

		buttonRemove = new JButton("Remove this Question ?");
		buttonRemove.setBounds(437, 177, 111, 23);
		buttonRemove.addActionListener(this);
		getContentPane().add(buttonRemove);
	}

	private void addOptionFields() {
		option1 = new JFormattedTextField();
		option1.setBounds(31, 154, 348, 20);
		getContentPane().add(option1);
		option1.setEditable(true);
		

		option2 = new JFormattedTextField();
		option2.setBounds(31, 206, 348, 20);
		getContentPane().add(option2);
		option2.setEditable(true);
		

		option3 = new JFormattedTextField();
		option3.setBounds(31, 256, 348, 20);
		getContentPane().add(option3);
		option3.setEditable(true);
		
		option4 = new JFormattedTextField();
		option4.setBounds(31, 310, 348, 20);
		getContentPane().add(option4);
		option4.setEditable(true);
	}

	private void setOptionLabels() {
		JLabel lblOption = new JLabel("Option 1");
		lblOption.setBounds(31, 129, 76, 14);
		getContentPane().add(lblOption);

		JLabel lblOption_1 = new JLabel("Option 2");
		lblOption_1.setBounds(31, 181, 65, 14);
		getContentPane().add(lblOption_1);

		JLabel lblOption_2 = new JLabel("Option 3");
		lblOption_2.setBounds(31, 231, 76, 14);
		getContentPane().add(lblOption_2);

		JLabel lblOption_3 = new JLabel("Option 4");
		lblOption_3.setBounds(31, 285, 76, 14);
		getContentPane().add(lblOption_3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnNext)) {
			if (e.getActionCommand().equalsIgnoreCase("Next")) {

				question.setTitle(questionTitle.getText());
				if (question.getOptions() == null)
					question.setOptionsList();
                    								

				setQuestion();

				editQuiz.setQuestion(index, question);
				editQuiz.setIndex(index + 1);
				editQuiz.startEdit();

			}

		}
		if (e.getSource().equals(btnBack)) {
			if (e.getActionCommand().equalsIgnoreCase("Back")) {

				if(index>0) {
				question.setTitle(questionTitle.getText());
				question.getOptions().set(0, option1.getText());
				question.getOptions().set(1, option2.getText());
				question.getOptions().set(2, option3.getText());
				question.getOptions().set(3, option4.getText());
				question.setCorrectAnswer((String) correctChoice.getSelectedItem());
				String splitter[] = ((String) correctChoice.getSelectedItem()).split(" ");
				question.setCorrectAnswer(question.getOptions().get(Integer.parseInt(splitter[1])));
				editQuiz.setQuestion(index, question);
				editQuiz.setIndex(index - 1);
				editQuiz.startEdit();

				if (e.getActionCommand().equalsIgnoreCase("Back")) {
                    if(index>0) {
					setQuestion();
					editQuiz.setQuestion(index, question);
					editQuiz.setIndex(index - 1);
					editQuiz.startEdit();
                    }
				}
			}

		}
		if (e.getSource().equals(btnCancel)) {
			this.dispose();

		}
		if (e.getSource().equals(buttonRemove)) {
			if (e.getActionCommand().equalsIgnoreCase("Remove this Question ?")) {
				System.out.println("removing");
				this.dispose();
				if (editQuiz.remove(question)) {
					editQuiz.setIndex(index);
					editQuiz.startEdit();
				} else {
					editQuiz.startEdit();
				}
			}
		}

	}
}

	private void setQuestion() {
		question.getOptions().set(0,option1.getText());
		question.getOptions().set(1, option2.getText());
		question.getOptions().set(2, option3.getText());
		question.getOptions().set(3, option4.getText());
		String splitter[] = ((String)correctChoice.getSelectedItem()).split(" ");
		question.setCorrectAnswer(question.getOptions().get(Integer.parseInt(splitter[1])-1));
	}
}
