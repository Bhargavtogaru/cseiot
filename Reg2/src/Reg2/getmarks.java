package Reg2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class getmarks {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getmarks window = new getmarks();
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
	public getmarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sno");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(97, 78, 69, 30);
		frame.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(218, 87, 248, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lb1 = new JLabel("name");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb1.setBounds(97, 188, 290, 30);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("marks");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb2.setBounds(97, 248, 290, 30);
		frame.getContentPane().add(lb2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sno=t1.getText();
				int sno=Integer.parseInt(Sno);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec4","root","mrec");
					String q="Select name,marks from registration2 where Sno=?"; 
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name:"+rs.getString(1));
					lb2.setText("Marks:"+rs.getString(2));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(550, 86, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
