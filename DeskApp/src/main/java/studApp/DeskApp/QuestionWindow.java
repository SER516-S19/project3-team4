package studApp.DeskApp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Application window for asking a question. This version is just a 
 * skeleton for the UI. It will need to be updated to take in a quiz
 * question and re-render the components. 
 * @author paulhorton
 * @version 1.1
 */
public class QuestionWindow {

	private JFrame frame;
	private ButtonGroup answerButtons = new ButtonGroup();
	private JTextArea txtrQuestion = new JTextArea();


	/**
	 * Launch the application. TODO: This is for testing and will need to be deleted in the final version
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionWindow window = new QuestionWindow();
					String question = "Here is a question. The question may be super long or not. "
							+ "Who cares? I sure don't!";
					String[] answers = {
							"Here is an answer", 
							"Here is another answer", 
							"Here is yet another answer", 
							"Here is the final answer"
							};
					window.update(question, answers);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuestionWindow() {
		initialize();
	}
	
	/**
	 * Updates the frame to include new question and answer information. 
	 * @param question String of a question
	 * @param answers Array of strings of answers
	 */
	public void update(String question, String[]answers) {
		txtrQuestion.setText(question);
		int i = 0;
		Enumeration<AbstractButton> buttons = answerButtons.getElements();
		while(buttons.hasMoreElements()) {
        	buttons.nextElement().setText(answers[i]);
        	i++;
		}
	}
	
	/**
	 * Initializes the JFrame with all the necessary components.
	 * No text is populated initially and must be done with an update.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Panel for Question at the top of the page
		JPanel questionPanel = new JPanel();
		frame.getContentPane().add(questionPanel, BorderLayout.NORTH);
		
		txtrQuestion.setWrapStyleWord(true);
		txtrQuestion.setOpaque(false);
		txtrQuestion.setRequestFocusEnabled(false);
		txtrQuestion.setEditable(false);
		txtrQuestion.setLineWrap(true);
		GroupLayout gl_questionPanel = new GroupLayout(questionPanel);
		gl_questionPanel.setHorizontalGroup(
			gl_questionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_questionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrQuestion, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_questionPanel.setVerticalGroup(
			gl_questionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_questionPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtrQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		questionPanel.setLayout(gl_questionPanel);
		
		// Panel for buttons at the bottom of the page
		JPanel buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton giveUpButton = new JButton("Give Up");
		giveUpButton.setMargin(new Insets(0, 2, 0, 0));
		giveUpButton.setMinimumSize(new Dimension(100, 29));
		giveUpButton.setMaximumSize(new Dimension(100, 29));
		giveUpButton.setPreferredSize(new Dimension(100, 29));
		giveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Create controller with give up method to close window. 
			}
		});
		
		JButton skipButton = new JButton("Skip");
		skipButton.setMargin(new Insets(0, 0, 0, 2));
		skipButton.setMinimumSize(new Dimension(100, 29));
		skipButton.setMaximumSize(new Dimension(100, 29));
		skipButton.setPreferredSize(new Dimension(100, 29));
		skipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Create controller with skip method to skip a question and leave it unanswered. 
			}
		});
		
		JButton nextButton = new JButton("Next");
		nextButton.setPreferredSize(new Dimension(100, 29));
		nextButton.setMinimumSize(new Dimension(100, 29));
		nextButton.setMaximumSize(new Dimension(100, 29));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Create controller with next method to update to next question and check if current question is correct;
			}
		});
		GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
		gl_buttonPanel.setHorizontalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(giveUpButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(skipButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_buttonPanel.setVerticalGroup(
			gl_buttonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonPanel.createSequentialGroup()
					.addGroup(gl_buttonPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(giveUpButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(skipButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		buttonPanel.setLayout(gl_buttonPanel);
		
		// Panel for answers in the middle of the page 
		JPanel answerPanel = new JPanel();
		frame.getContentPane().add(answerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_answerPanel = new GridBagLayout();
		gbl_answerPanel.columnWidths = new int[]{0, 0, 0};
		gbl_answerPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_answerPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_answerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		answerPanel.setLayout(gbl_answerPanel);
		
		for(int i = 0; i < 4; i++) {
			JRadioButton answerButton = new JRadioButton();
			answerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			answerButtons.add(answerButton);
			GridBagConstraints gbc_answerButton = new GridBagConstraints();
			gbc_answerButton.anchor = GridBagConstraints.WEST;
			gbc_answerButton.insets = new Insets(0, 0, 5, 0);
			gbc_answerButton.gridx = 1;
			gbc_answerButton.gridy = 1 + i;
			answerPanel.add(answerButton, gbc_answerButton);
		}
	}
}
