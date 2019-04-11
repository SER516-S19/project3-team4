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
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import studApp.DeskApp.dao.Question;

/**
 * Application window for asking a question.
 * @author paulhorton
 * @version 1.2
 */
public class QuestionWindow {

	private JFrame frame;
	private ButtonGroup answerButtons = new ButtonGroup();
	private JTextArea txtrQuestion = new JTextArea();
	private QuestionController questionController;

	/**
	 * Create the application.
	 */
	public QuestionWindow(QuestionController questionController) {
		this.questionController = questionController;
		createFrame();
	}
	
	/**
	 * Renders the frame with the first question
	 */
	public void render() {
		Question question = this.questionController.getCurrentQuestion();
		update(question.getTitle(),question.getOptions());
		setVisible(true);
	}
	/**
	 * @return the questionController for this panel
	 */
	public QuestionController getController() {
		return questionController;
	}
	
	/**
	 * Sets the visibility of the frame.
	 * @param isVisible
	 */
	public void setVisible(boolean isVisible) {
		frame.setVisible(isVisible);
	}
	
	/**
	 * Updates the frame to include new question and answer information. 
	 * @param question String of a question
	 * @param answers Array of strings of answers
	 */
	public void update(String question, List<String>answers) {
		txtrQuestion.setText(question);
		int i = 0;
		Enumeration<AbstractButton> buttons = answerButtons.getElements();
		answerButtons.clearSelection();
		while(buttons.hasMoreElements()) {
			AbstractButton button = buttons.nextElement();
        	button.setText(answers.get(i));
        	button.setActionCommand(answers.get(i));
        	i++;
		}
	}
	
	/**
	 * Initializes the JFrame with all the necessary components.
	 * No text is populated initially and must be done with an update.
	 */
	private void createFrame() {
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
				System.exit(0);
			}
		});
		
		JButton skipButton = new JButton("Skip");
		skipButton.setMargin(new Insets(0, 0, 0, 2));
		skipButton.setMinimumSize(new Dimension(100, 29));
		skipButton.setMaximumSize(new Dimension(100, 29));
		skipButton.setPreferredSize(new Dimension(100, 29));
		skipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Question question = questionController.getNextQuestion();
				if(question != null){
					update(question.getTitle(), question.getOptions());
				} else {
					//TODO: End screen
				}
			}
		});
		
		JButton nextButton = new JButton("Next");
		nextButton.setPreferredSize(new Dimension(100, 29));
		nextButton.setMinimumSize(new Dimension(100, 29));
		nextButton.setMaximumSize(new Dimension(100, 29));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonModel answer = answerButtons.getSelection();
				if(answer != null) {
					Question question = questionController.submitAnswer(
							answer.getActionCommand());
					if(question != null){
						update(question.getTitle(), question.getOptions());
					} else {
						//TODO: End screen
					}
				} else {
					skipButton.doClick();
				}
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
