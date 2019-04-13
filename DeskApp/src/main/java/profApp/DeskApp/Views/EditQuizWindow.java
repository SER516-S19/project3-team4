package profApp.DeskApp.Views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.commons.io.FilenameUtils;

import profApp.DeskApp.Controller.EditQuizController;
import profApp.DeskApp.Error.ErrorScreen;
import profApp.Utils.QuizConstants;
import profApp.Utils.QuizUtils;

import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;

/**
 * This class provides Edit window after user clicks on edit button.
 * 
 * @author Kumar Kalyan and Kirti Jha
 *
 */
public class EditQuizWindow extends JFrame implements ActionListener {
	
	JPanel editPanel;
	List<JButton> listButtons ;
	JComboBox<String> quizSelector;
	JButton btnOk;
	JButton btnCancel;
	Map<String,String> mapChoice;
	public EditQuizWindow() {
		editPanel = new JPanel();
		getContentPane().add(editPanel);
		editPanel.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = createLabels("Please select a quiz to edit! ");
		editPanel.add(lblNewLabel);
		
		quizSelector = new JComboBox();
		quizSelector.setBounds(155, 194, 138, 33);
		editPanel.add(quizSelector);
		
		btnOk = createButtons("OK");
		editPanel.add(btnOk);
		
		btnCancel = createButtons("Cancel");
		editPanel.add(btnCancel);
				
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(400, 400, 500, 500);
		File[] listFiles = QuizUtils.listFiles(QuizConstants.directoryName);
		System.out.println(listFiles.length);
		System.out.println(QuizConstants.directoryName);
		String quizzes [] = new String[listFiles.length];
		String fileName =null;
		mapChoice = new HashMap();
		int k =0;
		if(listFiles.length>0) {
		for(int i=0;i<listFiles.length;i++)
		{
			System.out.println(listFiles[i].getName());
			if(FilenameUtils.getExtension(listFiles[i].getName()).equalsIgnoreCase("json") && k<listFiles.length) {
			fileName = FilenameUtils.getBaseName(FilenameUtils.getName(listFiles[i].getName()));
			quizzes[k] = fileName;
			mapChoice.put(fileName, listFiles[i].getAbsolutePath());
			quizSelector.addItem(fileName);
			k++;
			}
		}
				
		quizSelector.addActionListener(this);
		editPanel.add(quizSelector);
		editPanel.setVisible(true);
		getContentPane().add(editPanel);
		}else {
			ErrorScreen error =  new ErrorScreen("No quizzes added, Please add them");
		}
	}
	
	public JLabel createLabels(String content) {
		JLabel newLabel = new JLabel(content);
		newLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		newLabel.setBackground(Color.GRAY);
		newLabel.setBounds(127, 63, 206, 51);
		return newLabel;
	}
	
	public JButton createButtons(String name) {
		JButton newButton = new JButton(name);
		newButton.addActionListener(this);
		newButton.setBounds(185, 309, 89, 23);		
		return newButton;
	}
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(btnOk))
	{
		if(e.getActionCommand().equalsIgnoreCase("Done")) {
			this.dispose();
			EditQuizController edit = new EditQuizController(mapChoice.get(quizSelector.getSelectedItem()));
		}
	}
		if(e.getSource().equals(btnCancel)) {
			if(e.getActionCommand().equalsIgnoreCase("Cancel"))
			{
				this.dispose();
			}
		}
	}
}
