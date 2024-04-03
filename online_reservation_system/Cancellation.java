package online_reservation_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Cancellation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField one;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancellation frame = new Cancellation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cancellation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrCancellation = new JTextArea();
		txtrCancellation.setText("Cancellation Form");
		txtrCancellation.setFont(new Font("Calibri", Font.BOLD, 20));
		txtrCancellation.setBounds(125, 24, 158, 22);
		contentPane.add(txtrCancellation);
		
		JLabel lblNewLabel = new JLabel("PNR No.");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(80, 163, 112, 22);
		contentPane.add(lblNewLabel);
		
		one = new JTextField();
		one.setBounds(233, 162, 85, 22);
		contentPane.add(one);
		one.setColumns(10);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pnr=one.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					String query="DELETE FROM `reservation` WHERE `PNR No`=?";
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","");
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, pnr);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Cancelled Successfully");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
				
				
			}
		});
		ok.setFont(new Font("Calibri", Font.BOLD, 15));
		ok.setBounds(262, 264, 85, 29);
		contentPane.add(ok);
		
		DefaultTableModel dtm=new DefaultTableModel();
		Object col[]= {"PNR No","Passenger Name","Passenger age","Gender","Train No","Train name","Stating place","Ending place","Date of Journey","Mobile no"};
		dtm.setColumnIdentifiers(col);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pnrno=one.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					String query="SELECT * FROM `reservation` WHERE `PNR No`=?";
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","");
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, pnrno);
					ResultSet rs=ps.executeQuery();
				
					
					while(rs.next()) {
						Object row[]=new Object[10];
						row[0]=rs.getString("PNR no");
						row[1]=rs.getString("Name");
						row[2]=rs.getString("Age");
						row[3]=rs.getString("Gender");
						row[4]=rs.getString("Train No");
						row[5]=rs.getString("Train Name");
						row[6]=rs.getString("From");
						row[7]=rs.getString("To");
						row[8]=rs.getString("Date");
						row[9]=rs.getString("mobile no");
						dtm.addRow(row);
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		Submit.setFont(new Font("Calibri", Font.BOLD, 15));
		Submit.setBounds(60, 264, 85, 29);
		contentPane.add(Submit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(409, 60, 469, 379);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(dtm);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main obj=new Main();
				obj.show();
				dispose();
			}
		});
		back.setFont(new Font("Calibri", Font.BOLD, 15));
		back.setBounds(162, 321, 85, 29);
		contentPane.add(back);
	}
}
