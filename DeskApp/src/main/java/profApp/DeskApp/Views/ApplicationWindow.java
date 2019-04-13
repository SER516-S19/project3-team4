package profApp.DeskApp.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;

/**
 * This Class creates the application window.
 * 
 * @author Kumar Kalyan Prabhu, Kirti Jha and Harshita Kajal
 *
 */
public class ApplicationWindow extends JFrame implements ActionListener {
	JButton jButtonCreate;
	JPanel panel;
	JButton jButtonEdit;

	public ApplicationWindow() {
		this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Professor Application");
		this.setBounds(400, 400, 500, 500);

		panel = new JPanel();
		getContentPane().add(panel);
		jButtonEdit = new JButton("Edit Quiz");
		jButtonEdit.addActionListener(this);
		jButtonCreate = new JButton("Create Quiz");
		jButtonCreate.addActionListener(this);
		panel.setLayout(null);
		panel.add(jButtonCreate);
		panel.add(jButtonEdit);

		jButtonCreate.setBounds(99, 179, 124, 23);
		jButtonEdit.setBounds(233, 179, 137, 23);
		
		JLabel jLblWelcome = new JLabel("Welcome to the Quiz");	
		jLblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		jLblWelcome.setFont(new Font("Century Gothic",Font.BOLD | Font.ITALIC, 17));
		jLblWelcome.setBounds(60, 35, 339, 56);
		panel.add(jLblWelcome);
		
		jButtonCreate.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
		        jButtonCreate.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent evt) {
		        jButtonCreate.setBackground(Color.GREEN);
		    }
		});
		jButtonEdit.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
		        jButtonEdit.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent evt) {
		        jButtonEdit.setBackground(Color.GREEN);
		    }
		});	
	};

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Edit Quiz")) {

			JButton buttonPressed = (JButton) arg0.getSource();
			if (buttonPressed.getText().equalsIgnoreCase("Edit Quiz"))
				;
			{
				EditQuizWindow edit = new EditQuizWindow();
				edit.setVisible(true);
			}
		}
	}
}
