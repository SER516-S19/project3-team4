package profApp.DeskApp.Views;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import profApp.DeskApp.Controller.EditQuizController;
import profApp.DeskApp.model.Question;
import profApp.Utils.QuizConstants;
import javax.swing.JScrollPane;

public class OnSavePreviewWindow extends JFrame {
	EditQuizController editQuiz;
	private JTable table;
	


	public OnSavePreviewWindow(EditQuizController editQuiz) {
		getContentPane().setLayout(null);

		
		this.setBounds(300, 300, 500, 500);
		this.editQuiz = editQuiz;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTable();
	}

	public void setTable() {
		DefaultTableModel tableModel = null;

		List<Question> questions = editQuiz.getQuiz().getQuestionList();

		if (questions != null && !questions.isEmpty()) {
			System.out.println("Setting table");
			String[][] rowData = new String[questions.size() + 1][QuizConstants.columnNames.length + 1];
			for (int j = 0; j < questions.size(); j++) {
				rowData[j][0] = questions.get(j).getTitle();
				for (int i = 0; i < questions.get(j).getOptions().size()
						&& !questions.get(j).getOptions().isEmpty(); i++)
					rowData[j][1 + 1] = questions.get(j).getOptions().get(i);
				rowData[j][5] = questions.get(j).getCorrectAnswer();

			}
			tableModel = new DefaultTableModel(rowData, QuizConstants.columnNames);
			table = new JTable(tableModel);
			table.setBounds(10, 10, 400, 400);
			this.getContentPane().add(table);
			

			this.setVisible(true);

		}

	}
}
