package profApp.DeskApp.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import profApp.DeskApp.Controller.EditQuizController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;

public class SaveDialog extends JDialog implements ActionListener{

	JButton buttonYes;
	JButton buttonNo;
	JButton buttonCancel;
	EditQuizController editQuizController;
	private JButton btnNewButton;
	private JButton buttonAddQuestion;
	public SaveDialog(EditQuizController editQuizController,String message) {
		getContentPane().setLayout(null);
		this.editQuizController =editQuizController;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JLabel lblDoYouWish = new JLabel(message);
		lblDoYouWish.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		lblDoYouWish.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoYouWish.setBounds(-26, 40, 484, 36);
		getContentPane().add(lblDoYouWish);
		
		buttonYes = new JButton("Yes");
	buttonYes.setBounds(20, 105, 126, 23);
		getContentPane().add(buttonYes);
		buttonYes.addActionListener(this);
		
		buttonNo = new JButton("No");
		buttonNo.setBounds(168, 105, 118, 23);
		getContentPane().add(buttonNo);
		buttonNo.addActionListener(this);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(this);
		buttonCancel.setBounds(302, 105, 110, 23);
		getContentPane().add(buttonCancel);
		
		buttonAddQuestion = new JButton("Add Question");
		
		buttonAddQuestion.setBounds(143, 165, 163, 23);
		buttonAddQuestion.addActionListener(this);
		getContentPane().add(buttonAddQuestion);
		
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(buttonYes))
		{
			if(event.getActionCommand().equalsIgnoreCase("Yes"))
			editQuizController.writeToFile();
			editQuizController.disposeWindow();
			
			
		}else {
			if(event.getSource().equals(buttonNo)) {
				if(event.getActionCommand().equalsIgnoreCase("No"))
			    editQuizController.disposeWindow();		
			}else if(event.getSource().equals(buttonCancel))
				{
					if(event.getActionCommand().equalsIgnoreCase("Cancel"));
					this.dispose();
				}
			else if(event.getSource().equals(buttonAddQuestion));
			{
				if(event.getActionCommand().equalsIgnoreCase("Add Question")) {
					editQuizController.addQuestion();
				}
			}
			
		}
		this.dispose();
			
		}
		
	

	
}
