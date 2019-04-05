package profApp.DeskApp;

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

public class ApplicationWindow extends JFrame {
	public ApplicationWindow() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		final JButton jButtonCreate = new JButton("Create Quiz");
		jButtonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jButtonCreate.setBounds(78, 143, 110, 33);
		panel.add(jButtonCreate);
		
		final JButton jButtonEdit = new JButton("Edit Quiz");
		jButtonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editNextFrame editWindow=new editNextFrame();
				editWindow.setVisible(true);
			}
		});
	
		jButtonEdit.setBounds(254, 143, 89, 33);
		panel.add(jButtonEdit);
		
		jButtonEdit.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
		        jButtonEdit.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent evt) {
		        jButtonEdit.setBackground(Color.GREEN);
		    }
		});
		
		jButtonCreate.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent event) {
		        jButtonCreate.setBackground(UIManager.getColor("control"));
		    }
		    public void mouseEntered(MouseEvent event) {
		    	jButtonCreate.setBackground(Color.GREEN);
		    }
		});
		
		JLabel jLblWelcome = new JLabel("Welcome to the Quiz App: Professor View");		
		jLblWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		jLblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		jLblWelcome.setBounds(60, 35, 339, 56);
		panel.add(jLblWelcome);
		
	}
}


