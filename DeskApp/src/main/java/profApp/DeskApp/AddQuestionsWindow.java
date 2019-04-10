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
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import profApp.model.Question;
import profApp.model.Quiz;

public class AddQuestionsWindow extends JFrame {

	private final String FOLDER_PATH = "./quizzes/";
	
	private JTextField questionTitle;
	private JTextField firstOption;
	private JTextField secondOption;
	private JTextField thirdOption;
	private JTextField fourthOption;
	private JTextField correctOption;
	
	/**
	 * Create the application.
	 * @param quizName 
	 */

	public AddQuestionsWindow(String quizName, ArrayList<Question> questionsList) {
		setBackground(new Color(248, 248, 255));
		initialize(quizName,questionsList);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize( final String quizName,final ArrayList<Question> questionsList) {
		
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
		
		questionTitle = new JTextField();
		questionTitle.setBorder(new LineBorder(Color.BLACK));
		questionTitle.setFont(new Font("Arial", Font.PLAIN, 11));
		questionTitle.setBounds(676, 41, 238, 71);
		panel.add(questionTitle);
		questionTitle.setColumns(10);
		
		JLabel lblOptionFirst = new JLabel("Option 1");
		lblOptionFirst.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOptionFirst.setBounds(379, 148, 94, 14);
		panel.add(lblOptionFirst);

		firstOption = new JTextField();
		firstOption.setBorder(new LineBorder(Color.BLACK));
		firstOption.setFont(new Font("Arial", Font.PLAIN, 11));
		firstOption.setBounds(504, 136, 174, 40);
		panel.add(firstOption);
		firstOption.setColumns(10);
		
		JLabel lblOptionSecond = new JLabel("Option 2");
		lblOptionSecond.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOptionSecond.setBounds(379, 249, 94, 14);
		panel.add(lblOptionSecond);

		secondOption = new JTextField();
		secondOption.setBorder(new LineBorder(Color.BLACK));
		secondOption.setBounds(504, 237, 174, 40);
		panel.add(secondOption);
		secondOption.setColumns(10);
		
		
		JLabel lblOptionThird = new JLabel("Option 3");
		lblOptionThird.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOptionThird.setBounds(722, 148, 86, 14);
		panel.add(lblOptionThird);

		thirdOption = new JTextField();
		thirdOption.setBorder(new LineBorder(Color.BLACK));
		thirdOption.setBounds(859, 136, 174, 40);
		panel.add(thirdOption);
		thirdOption.setColumns(10);
		
		JLabel lblOptionFourth = new JLabel("Option 4");
		lblOptionFourth.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblOptionFourth.setBounds(722, 249, 99, 14);
		panel.add(lblOptionFourth);
		
		fourthOption = new JTextField();
		fourthOption.setBorder(new LineBorder(Color.BLACK));
		fourthOption.setBounds(859, 237, 174, 40);
		panel.add(fourthOption);
		fourthOption.setColumns(10);
	
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setForeground(Color.BLACK);
		lblCorrectAnswer.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		lblCorrectAnswer.setBounds(504, 324, 152, 14);
		panel.add(lblCorrectAnswer);

		correctOption = new JTextField();
		correctOption.setBorder(new LineBorder(Color.BLACK));
		correctOption.setBounds(689, 312, 174, 40);
		panel.add(correctOption);
		correctOption.setColumns(10);
		
		
		JButton btnAddMoreQuestions = new JButton("Add more questions");
		btnAddMoreQuestions.setForeground(Color.BLACK);
		btnAddMoreQuestions.setBorder(new LineBorder(Color.BLACK));
		btnAddMoreQuestions.setBackground(SystemColor.scrollbar);
		btnAddMoreQuestions.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnAddMoreQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Question> questions = new ArrayList<>();
				if(questionsList != null) {
					for(Question question : questionsList) {
						questions.add(question);
					}
				}
				
				questions = populateQuestionList(questions);
				AddQuestionsWindow addQuestions = new AddQuestionsWindow(quizName, questions);
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
				ArrayList<Question> questions = questionsList;
				questions = populateQuestionList(questions);
				createQuiz(quizName,questions);
				ApplicationWindow appWindow = new ApplicationWindow();
				appWindow.setVisible(true);
				dispose();
			}


		});
		btnSubmit.setBounds(830, 396, 117, 49);
		panel.add(btnSubmit);
	}
	
	private void createQuiz(String quizName, ArrayList<Question> questionsList) {
		// TODO Auto-generated method stub
		String filename = FOLDER_PATH + quizName + ".json";
		Quiz quiz = new Quiz(questionsList);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(quiz);
		System.out.println(json);
		try {
			File file = new File(filename);
			FileWriter writer = new FileWriter(file);
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<Question> populateQuestionList(ArrayList<Question> questionsList) {
		Question question = new Question();
		 question.setTitle(questionTitle.getText());
		 question.setOptions(firstOption.getText());
		 question.setOptions(secondOption.getText());
		 question.setOptions(thirdOption.getText());
		 question.setOptions(fourthOption.getText());
		 question.setCorrectAnswer(correctOption.getText());
		if(questionsList !=  null && questionsList.size() > 0) {
			questionsList.add(question);
		}else {
			questionsList = new ArrayList<>();
			questionsList.add(question);
		}
		
		return questionsList;
	}
}
