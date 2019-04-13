package profApp.DeskApp.Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import profApp.DeskApp.Controller.EditQuizController;
import profApp.DeskApp.model.Question;
import profApp.Utils.QuizConstants;

/**
 * This Class creates edit question window and its basic functions.
 * 
 * @author Kumar Kalyan Prabhu, Kirti Jha and Harshita Kajal
 *
 */
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
		setFields();
		addOptionFields();
		setCorrectAnswerChoices(question);
		setLabels();
		addButtons();

	}
	
	private void setCorrectAnswerChoices(Question question) {
		String choices[] = null;
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
				System.out.println(question.getOptions().
						indexOf(question.getCorrectAnswer()));
				correctChoice.setSelectedItem(
						QuizConstants.options[question.getOptions().
						                      indexOf(question.getCorrectAnswer())]);
			}
			questionTitle.setText(question.getTitle());
			choices = QuizConstants.options;
		}

		correctChoice.setBounds(31, 389, 348, 20);
		getContentPane().add(correctChoice);
		correctChoice.setEditable(true);
	}

	private void setFields() {
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
	}

	private void addButtons() {
		btnNext = new JButton(QuizConstants.BUTTON_LABEL_NEXT);
		btnNext.setBounds(31, 436, 89, 23);
		btnNext.addActionListener(this);
		getContentPane().add(btnNext);

		btnBack = new JButton(QuizConstants.BUTTON_LABEL_BACK);
		btnBack.setBounds(153, 436, 89, 23);
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);

		btnCancel = new JButton(QuizConstants.BUTTON_LABEL_CANCEL);
		btnCancel.setBounds(276, 436, 89, 23);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);

		buttonRemove = new JButton(QuizConstants.BUTTON_LABEL_REMOVE);
		buttonRemove.setBounds(416, 177, 145, 23);
		buttonRemove.addActionListener(this);
		getContentPane().add(buttonRemove);
		
		btnNext.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
				btnNext.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent evt) {
		    	btnNext.setBackground(Color.GREEN);
		    }
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
				btnBack.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent evt) {
		    	btnBack.setBackground(Color.GREEN);
		    }
		});
		
		btnCancel.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
				btnCancel.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent evt) {
		    	btnCancel.setBackground(Color.GREEN);
		    }
		});
		
		buttonRemove.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
				buttonRemove.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent evt) {
		    	buttonRemove.setBackground(Color.GREEN);
		    }
		});	
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

	private void setLabels() {
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

		JLabel lblNewLabel = new JLabel("Question " + (index + 1));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 11, 76, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblCorrectAnswer = new JLabel(QuizConstants.LABEL_CORRECT_ANSWER);
		lblCorrectAnswer.setBounds(31, 364, 97, 14);
		getContentPane().add(lblCorrectAnswer);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnNext)) {
			if (e.getActionCommand().equalsIgnoreCase(QuizConstants.BUTTON_LABEL_NEXT)) {

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
			if (e.getActionCommand().equalsIgnoreCase(QuizConstants.BUTTON_LABEL_BACK)) {

				if (index > 0) {
					setQuestion();
					editQuiz.setQuestion(index, question);
					editQuiz.setIndex(index - 1);
					editQuiz.startEdit();
				}
			}
		}
		if (e.getSource().equals(btnCancel)) {
			if (e.getActionCommand().equalsIgnoreCase(QuizConstants.BUTTON_LABEL_CANCEL))
				this.dispose();

		}
		if (e.getSource().equals(buttonRemove)) {
			if (e.getActionCommand().equalsIgnoreCase(QuizConstants.BUTTON_LABEL_REMOVE)) {
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

	private void setQuestion() {
		question.getOptions().set(0, option1.getText());
		question.getOptions().set(1, option2.getText());
		question.getOptions().set(2, option3.getText());
		question.getOptions().set(3, option4.getText());
		String splitter[] = ((String) correctChoice.getSelectedItem()).split(" ");
		question.setCorrectAnswer(question.getOptions().get(Integer.parseInt(splitter[1]) - 1));
	}
}
