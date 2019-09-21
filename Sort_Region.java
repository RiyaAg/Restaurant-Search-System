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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class Sort_Region extends JPanel {

	/**
	 * Create the panel.
	 */
	public Sort_Region() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setSize(550,400);
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblTheRestaurentsAre = new JLabel("The Restaurants are :");
		lblTheRestaurentsAre.setFont(new Font("Sitka Small", Font.PLAIN, 24));
		lblTheRestaurentsAre.setBounds(24, 35, 289, 42);
		add(lblTheRestaurentsAre);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 68, 357, 2);
		add(separator);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rest_Main.main(new String[] {});
				Rest_Main.Cls();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnBack.setBounds(94, 306, 105, 29);
		add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 88, 316, 183);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Sitka Small", Font.ITALIC, 13));
		scrollPane.setViewportView(textArea);
		textArea.setText(new RestControl().retRegion());
		
		JLabel label = new JLabel("");
		label.setBounds(385, 94, 128, 183);
		add(label);
		Image img=new ImageIcon(this.getClass().getResource("/map-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));

	}
}
