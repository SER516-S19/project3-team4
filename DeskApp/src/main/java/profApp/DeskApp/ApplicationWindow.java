package profApp.DeskApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ApplicationWindow extends JFrame {
	public ApplicationWindow() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton jButtonCreate = new JButton("Create Quiz");
		jButtonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jButtonCreate.setBounds(78, 143, 110, 33);
		panel.add(jButtonCreate);
		
		JButton jButtonEdit = new JButton("Edit Quiz");
	
		jButtonEdit.setBounds(254, 143, 89, 33);
		panel.add(jButtonEdit);
		
		JLabel jLblWelcome = new JLabel("Welcome to the Quiz App");
		jLblWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		jLblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		jLblWelcome.setBounds(42, 37, 339, 56);
		panel.add(jLblWelcome);
	}
}
