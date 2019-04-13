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

/**
 * This class is the view class for Save options dialog.
 * @author kumar
 *
 */
public class SaveDialog extends JDialog implements ActionListener{

	JButton buttonYes;
	JButton buttonNo;
	JButton buttonCancel;
	EditQuizController editQuizController;
	private JButton btnNewButton;
	private JButton buttonAddQuestion;
	JButton buttonPreview;
	/**
	 * This constructor initializes the view.
	 * @param editQuizController
	 * @param message
	 */
	public SaveDialog(EditQuizController editQuizController,String message) {
		getContentPane().setLayout(null);
		this.editQuizController =editQuizController;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);

		JLabel lblDoYouWish = new JLabel(message);
		lblDoYouWish.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		lblDoYouWish.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoYouWish.setBounds(42, 40, 484, 36);
		getContentPane().add(lblDoYouWish);
		
		addButtons();
				
		this.setVisible(true);
	}

	/**
	 * This method adds buttons to the views.
	 */
	private void addButtons() {
		buttonYes = createButtons("Yes", 81, 105, 126, 23);
		getContentPane().add(buttonYes);
		
		buttonNo = createButtons("No",248, 105, 118, 23);
		getContentPane().add(buttonNo);
		
		buttonCancel = createButtons("Cancel", 399, 105, 110, 23);
		getContentPane().add(buttonCancel);
		
		buttonAddQuestion = createButtons("Add Question", 104, 170, 163, 23);
		getContentPane().add(buttonAddQuestion);
		
	    buttonPreview = createButtons("Preview Quiz", 332, 170, 126, 23);
		getContentPane().add(buttonPreview);
	}
	
	/**
	 * This is a helper method to create buttons.
	 * @param name
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public JButton createButtons(String name,int x, int y,int width, int height) {
		JButton newButton = new JButton(name);
		newButton.addActionListener(this);
		newButton.setBounds(x, y, width, height);		
		return newButton;
	}

	/**
	 * This method is the event handler for the view.
	 */
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
			if(event.getSource().equals(buttonPreview))
			{
				if(event.getActionCommand().equalsIgnoreCase("Preview Quiz"));
				OnSavePreviewWindow previewWindow = new OnSavePreviewWindow(editQuizController);
			}
		}
		this.dispose();
		}
}
