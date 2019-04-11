package studApp.DeskApp;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * A directory chooser UI that allow the user to select the folder containing quiz files
 * @author Hongfei Ju
 * @version 1.0
 */
public class QuizDirChooser {
	private JFileChooser chooser = null;
	private String path = null;
	private JFrame frame = null;
	
	public QuizDirChooser() {
		frame = new JFrame();
		chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("select quizzes");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);	    
	    if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) { 
	      path = chooser.getSelectedFile().toString();
	    }
	}
	
	public String getPath() {
		return path;
	}

}
