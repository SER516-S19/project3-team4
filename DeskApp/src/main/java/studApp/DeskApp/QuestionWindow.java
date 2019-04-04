package studApp.DeskApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

/**
 * Application window for asking a question. I
 * @author paulhorton
 *
 */
public class QuestionWindow {

	private JFrame frame;
	private final ButtonGroup answerButtons = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionWindow window = new QuestionWindow();
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
		// TODO: These values are temporary and will be grabbed from the database business objects
		String question = "Here is a question. The question may be super long or not. Who cares? I sure don't!";
		String[] answers = {"Here is an answer", "Here is another answer", "Here is yet another answer", "Here is the final answer"};
		initialize(question,answers);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String question, String[] answers) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel questionPanel = new JPanel();
		frame.getContentPane().add(questionPanel, BorderLayout.NORTH);
		
		JTextArea txtrQuestion = new JTextArea();
		txtrQuestion.setWrapStyleWord(true);
		txtrQuestion.setOpaque(false);
		txtrQuestion.setRequestFocusEnabled(false);
		txtrQuestion.setEditable(false);
		txtrQuestion.setLineWrap(true);
		txtrQuestion.setText(question);
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
		
		JPanel buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton giveUpButton = new JButton("Give Up");
		giveUpButton.setMargin(new Insets(0, 2, 0, 0));
		giveUpButton.setMinimumSize(new Dimension(100, 29));
		giveUpButton.setMaximumSize(new Dimension(100, 29));
		giveUpButton.setPreferredSize(new Dimension(100, 29));
		giveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton skipButton = new JButton("Skip");
		skipButton.setMargin(new Insets(0, 0, 0, 2));
		skipButton.setMinimumSize(new Dimension(100, 29));
		skipButton.setMaximumSize(new Dimension(100, 29));
		skipButton.setPreferredSize(new Dimension(100, 29));
		skipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton nextButton = new JButton("Next");
		nextButton.setPreferredSize(new Dimension(100, 29));
		nextButton.setMinimumSize(new Dimension(100, 29));
		nextButton.setMaximumSize(new Dimension(100, 29));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JPanel answerPanel = new JPanel();
		frame.getContentPane().add(answerPanel, BorderLayout.CENTER);
		GridBagLayout gbl_answerPanel = new GridBagLayout();
		gbl_answerPanel.columnWidths = new int[]{0, 0, 0};
		gbl_answerPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_answerPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_answerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		answerPanel.setLayout(gbl_answerPanel);
		
		JRadioButton answerButtonA = new JRadioButton(answers[0]);
		answerButtonA.setAlignmentX(Component.CENTER_ALIGNMENT);
		answerButtons.add(answerButtonA);
		GridBagConstraints gbc_answerButtonA = new GridBagConstraints();
		gbc_answerButtonA.anchor = GridBagConstraints.WEST;
		gbc_answerButtonA.insets = new Insets(0, 0, 5, 0);
		gbc_answerButtonA.gridx = 1;
		gbc_answerButtonA.gridy = 1;
		answerPanel.add(answerButtonA, gbc_answerButtonA);
		
		JRadioButton answerButtonB = new JRadioButton(answers[1]);
		answerButtonB.setAlignmentX(Component.CENTER_ALIGNMENT);
		answerButtons.add(answerButtonB);
		GridBagConstraints gbc_answerButtonB = new GridBagConstraints();
		gbc_answerButtonB.anchor = GridBagConstraints.WEST;
		gbc_answerButtonB.insets = new Insets(0, 0, 5, 0);
		gbc_answerButtonB.gridx = 1;
		gbc_answerButtonB.gridy = 2;
		answerPanel.add(answerButtonB, gbc_answerButtonB);
		
		JRadioButton answerButtonC = new JRadioButton(answers[2]);
		answerButtonC.setAlignmentX(Component.CENTER_ALIGNMENT);
		answerButtons.add(answerButtonC);
		GridBagConstraints gbc_answerButtonC = new GridBagConstraints();
		gbc_answerButtonC.anchor = GridBagConstraints.WEST;
		gbc_answerButtonC.insets = new Insets(0, 0, 5, 0);
		gbc_answerButtonC.gridx = 1;
		gbc_answerButtonC.gridy = 3;
		answerPanel.add(answerButtonC, gbc_answerButtonC);
		
		JRadioButton answerButtonD = new JRadioButton(answers[3]);
		answerButtonD.setHorizontalAlignment(SwingConstants.LEFT);
		answerButtons.add(answerButtonD);
		GridBagConstraints gbc_answerButtonD = new GridBagConstraints();
		gbc_answerButtonD.anchor = GridBagConstraints.WEST;
		gbc_answerButtonD.gridx = 1;
		gbc_answerButtonD.gridy = 4;
		answerPanel.add(answerButtonD, gbc_answerButtonD);
	}
}
