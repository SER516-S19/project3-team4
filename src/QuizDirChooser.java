import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class QuizDirChooser {
	private JFileChooser chooser = null;
	private String path = null;
	public QuizDirChooser(JFrame frame) {		
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
