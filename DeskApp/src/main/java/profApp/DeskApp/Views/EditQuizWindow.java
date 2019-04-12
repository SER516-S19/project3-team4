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
		
		JLabel lblNewLabel = new JLabel("Please select quiz to edit :)");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(127, 63, 206, 51);
		editPanel.add(lblNewLabel);
		
		quizSelector = new JComboBox();
		quizSelector.setBounds(155, 194, 138, 33);
		editPanel.add(quizSelector);
		
		 btnOk = new JButton("OK");
		 btnOk.addActionListener(this);
		btnOk.setBounds(116, 306, 89, 23);
		editPanel.add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(257, 306, 89, 23);
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
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(btnOk))
	{
		if(e.getActionCommand().equalsIgnoreCase("Ok")) {
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
