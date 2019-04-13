package profApp.DeskApp.Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import profApp.DeskApp.model.Question;
import profApp.DeskApp.model.Quiz;
import profApp.Utils.QuizConstants;

/**
 * AddQuestionsWindow class: This class displays option to add question, options
 * and correct answer and saves the quiz.
 * 
 * @author akashkadam, truptikhatavkar
 * @version 1.3
 */
public class AddQuestionsWindow extends JFrame {
	private final String FOLDER_PATH = QuizConstants.directoryName;
	private JTextField questionTitle;
	private JTextField firstOption;
	private JTextField secondOption;
	private JTextField thirdOption;
	private JTextField fourthOption;
	private JTextField correctOption;

	/**
	 * Parametarized constructor that sets background and calls initialize function.
	 * 
	 * @param quizName
	 *            name of the quiz
	 * @param questionsList
	 *            list of all the questions in the quiz
	 */
	public AddQuestionsWindow(String quizName, ArrayList<Question> questionsList) {
		setBackground(new Color(248, 248, 255));
		initialize(quizName, questionsList);
	}

	/**
	 * This method initializes all the components of the UI.
	 * 
	 * @param quizName
	 *            name of the quiz
	 * @param questionsList
	 *            list of all the questions in the quiz
	 */
	private void initialize(final String quizName, final ArrayList<Question> questionsList) {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel question = new JLabel("Question");
		question.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
		question.setBounds(560, 39, 106, 22);
		panel.add(question);

		questionTitle = new JTextField();
		questionTitle.setBorder(new LineBorder(Color.BLACK));
		questionTitle.setFont(new Font("Arial", Font.PLAIN, 11));
		questionTitle.setBounds(676, 41, 238, 71);
		panel.add(questionTitle);
		questionTitle.setColumns(10);

		JLabel OptionFirst = new JLabel("Option 1");
		OptionFirst.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		OptionFirst.setBounds(379, 148, 94, 14);
		panel.add(OptionFirst);

		firstOption = new JTextField();
		firstOption.setBorder(new LineBorder(Color.BLACK));
		firstOption.setFont(new Font("Arial", Font.PLAIN, 11));
		firstOption.setBounds(504, 136, 174, 40);
		panel.add(firstOption);
		firstOption.setColumns(10);

		JLabel OptionSecond = new JLabel("Option 2");
		OptionSecond.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		OptionSecond.setBounds(379, 249, 94, 14);
		panel.add(OptionSecond);

		secondOption = new JTextField();
		secondOption.setBorder(new LineBorder(Color.BLACK));
		secondOption.setBounds(504, 237, 174, 40);
		panel.add(secondOption);
		secondOption.setColumns(10);

		JLabel OptionThird = new JLabel("Option 3");
		OptionThird.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		OptionThird.setBounds(722, 148, 86, 14);
		panel.add(OptionThird);

		thirdOption = new JTextField();
		thirdOption.setBorder(new LineBorder(Color.BLACK));
		thirdOption.setBounds(859, 136, 174, 40);
		panel.add(thirdOption);
		thirdOption.setColumns(10);

		JLabel OptionFourth = new JLabel("Option 4");
		OptionFourth.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		OptionFourth.setBounds(722, 249, 99, 14);
		panel.add(OptionFourth);

		fourthOption = new JTextField();
		fourthOption.setBorder(new LineBorder(Color.BLACK));
		fourthOption.setBounds(859, 237, 174, 40);
		panel.add(fourthOption);
		fourthOption.setColumns(10);

		JLabel CorrectAnswer = new JLabel("Correct Answer");
		CorrectAnswer.setForeground(Color.BLACK);
		CorrectAnswer.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		CorrectAnswer.setBounds(504, 324, 152, 14);
		panel.add(CorrectAnswer);

		correctOption = new JTextField();
		correctOption.setBorder(new LineBorder(Color.BLACK));
		correctOption.setBounds(689, 312, 174, 40);
		panel.add(correctOption);
		correctOption.setColumns(10);

		JButton AddMoreQuestions = new JButton("Add more questions");
		AddMoreQuestions.setForeground(Color.BLACK);
		AddMoreQuestions.setBorder(new LineBorder(Color.BLACK));
		AddMoreQuestions.setBackground(SystemColor.scrollbar);
		AddMoreQuestions.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		AddMoreQuestions.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList<Question> questions = new ArrayList<Question>();
				if (questionsList != null) {
					for (Question question : questionsList) {
						questions.add(question);
					}
				}
				questions = populateQuestionList(questions);
				AddQuestionsWindow addQuestions = new AddQuestionsWindow(quizName, questions);
				addQuestions.setVisible(true);
				dispose();
			}
		});
		AddMoreQuestions.setBounds(454, 396, 224, 49);
		panel.add(AddMoreQuestions);

		JButton Submit = new JButton("Submit");
		Submit.setBorder(new LineBorder(Color.BLACK));
		Submit.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		Submit.setBackground(SystemColor.scrollbar);
		Submit.setForeground(Color.BLACK);
		Submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList<Question> questions = questionsList;
				questions = populateQuestionList(questions);
				createQuiz(quizName, questions);
				ApplicationWindow appWindow = new ApplicationWindow();
				appWindow.setVisible(true);
				dispose();
			}

		});
		Submit.setBounds(830, 396, 117, 49);
		panel.add(Submit);
	}

	/**
	 * This method saves the quiz in JSON file.
	 * 
	 * @param quizName
	 *            name of the quiz
	 * @param questionsList
	 *            list of all the questions in the quiz
	 */
	private void createQuiz(String quizName, ArrayList<Question> questionsList) {
		String filename = FOLDER_PATH + "\\" + quizName + ".json";
		System.out.println(FOLDER_PATH + "::::::" + quizName);
		System.out.println(filename);
		Quiz quiz = new Quiz(questionsList);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(quiz);
		try {
			File file = new File(filename);
			FileWriter writer = new FileWriter(file);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method populates all the questions in questionList
	 * 
	 * @param questionsList
	 *            list of all the questions in the quiz
	 */
	private ArrayList<Question> populateQuestionList(ArrayList<Question> questionsList) {
		Question question = new Question();
		question.setTitle(questionTitle.getText());
		question.setOptions(firstOption.getText());
		question.setOptions(secondOption.getText());
		question.setOptions(thirdOption.getText());
		question.setOptions(fourthOption.getText());
		question.setCorrectAnswer(correctOption.getText());
		if (questionsList != null && questionsList.size() > 0) {
			questionsList.add(question);
		} else {
			questionsList = new ArrayList<Question>();
			questionsList.add(question);
		}

		return questionsList;
	}
}
