import java.awt.Component;
import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;

public class MainFrame {

	private JFrame frame;
	private QuizDirChooser qdChooser = null;
	private static List<QuizDAO> quizzes = null;
	private QuizListPanel panel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					
					
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
		stylize();
		assemble();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		qdChooser = new QuizDirChooser(frame);
		quizzes = getQuizzes(qdChooser.getPath());		
		panel = new QuizListPanel(quizzes, "DummyQuestionPanel");
	}
	
	private void stylize() {
		frame.setBounds(100, 100, 450, 300);
		panel.setSize(frame.getSize());
	}
	
	private void assemble() {
		frame.getContentPane().add(panel);
	}
	
	private static List<QuizDAO> getQuizzes(String path){
        List<QuizDAO> quizDAOList = JSONParser.parseDirectory(path);
        return quizDAOList;
	}
}
