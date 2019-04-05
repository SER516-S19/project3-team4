package profApp.DeskApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class editNextFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editNextFrame frame = new editNextFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public editNextFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Please select a quiz to edit:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Quiz 1");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("Rockwell", Font.ITALIC, 15));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroup.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton, BorderLayout.WEST);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Quiz 2");
		rdbtnNewRadioButton_1.setFont(new Font("Rockwell", Font.ITALIC, 15));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		buttonGroup.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Quiz 3");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Rockwell", Font.ITALIC, 15));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(rdbtnNewRadioButton_2, BorderLayout.EAST);
		
//	Box box = Box.createVerticalBox();
//		box.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//		Box sizeBox = Box.createVerticalBox();
//		box.add(rdbtnNewRadioButton);
//		box.add(rdbtnNewRadioButton_1);
//		box.add(rdbtnNewRadioButton_2);
//		box.setSize(300, 267);
//		box.setBorder(BorderFactory.createTitledBorder("Available Quizzes"));
//		box.setAlignmentY(200);
//		box.setAlignmentX(LEFT_ALIGNMENT);
//		box.setVisible(true);
	}

}
