package dbs_project;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class Sort_Cuisine extends JPanel {

	/**
	 * Create the panel.
	 */
	public Sort_Cuisine() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setSize(550,400);
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblTheRestaurentsAre = new JLabel("The Restaurants are: ");
		lblTheRestaurentsAre.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		lblTheRestaurentsAre.setBounds(31, 23, 304, 29);
		add(lblTheRestaurentsAre);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 47, 286, 2);
		add(separator);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rest_Main.main(new String[] {});
				Rest_Main.Cls();
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnNewButton.setBounds(99, 318, 105, 29);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 63, 267, 224);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Sitka Small", Font.ITALIC, 13));
		scrollPane.setViewportView(textArea);
		textArea.setText(new RestControl().retCuisine());
		
		JLabel label = new JLabel("");
		label.setBounds(330, 45, 190, 174);
		add(label);
		Image img=new ImageIcon(this.getClass().getResource("/ramen.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(350, 213, 137, 105);
		add(label_1);
		Image img1=new ImageIcon(this.getClass().getResource("/Steak-icon.png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
	}
}