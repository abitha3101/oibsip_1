package online_reservation_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Reservation extends JFrame {
	Connection con=null;
	


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox two;
	private JComboBox three;
	private JTextArea Four;
	private JTextArea five;
	private JDateChooser seven;
	private JComboBox six;
	private JTextField eight;
	private JTextArea one ;
	private JTextField nine;
	private JComboBox eleven ;
	private JTextArea twelve;
	private JTextArea mob ;
	private JComboBox ten;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillcombo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="SELECT * FROM `train` ";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				two.addItem(rs.getString("start place"));
			
				
			}
		
	}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
	public void fillcombo1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="SELECT * FROM `train` ";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				three.addItem(rs.getString("destination"));
			
				
			}
		
	}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
	public void load() {
		String sp=two.getSelectedItem().toString();
		String ep=three.getSelectedItem().toString();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="SELECT * FROM `train` WHERE `start place`= ? and `destination`= ?";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, sp);
			ps.setString(2, ep);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==true) {
				Four.setText(rs.getString("tno"));
				five.setText(rs.getString("tname"));
				one.setText(rs.getString("PNR No"));
			}
			else {
				JOptionPane.showMessageDialog(null, "Not found");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Create the frame.
	 */
	public Reservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 776);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("PNR No");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 418, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		one = new JTextArea();
		one.setEditable(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 4, SpringLayout.NORTH, one);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, one);
		sl_contentPane.putConstraint(SpringLayout.WEST, one, 492, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, one, -69, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, one, 40, SpringLayout.NORTH, contentPane);
		contentPane.add(one);
		
		JLabel lblTrainNo = new JLabel("From");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTrainNo, 89, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTrainNo, 136, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTrainNo, -425, SpringLayout.EAST, contentPane);
		lblTrainNo.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblTrainNo);
		
		JLabel lblTrainName = new JLabel("To");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTrainName, 12, SpringLayout.SOUTH, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTrainName, 0, SpringLayout.WEST, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTrainName, 0, SpringLayout.EAST, lblTrainNo);
		lblTrainName.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblTrainName);
		
		JLabel lblClass = new JLabel("Train No");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblClass, 17, SpringLayout.SOUTH, lblTrainName);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblClass, 0, SpringLayout.WEST, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblClass, 0, SpringLayout.EAST, lblTrainNo);
		lblClass.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblClass);
		
		JLabel lblDateOfJourney = new JLabel("Train Name");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDateOfJourney, 0, SpringLayout.WEST, lblTrainNo);
		lblDateOfJourney.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblDateOfJourney);
		
		JLabel lblForm = new JLabel("Date of Journey");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblForm, 0, SpringLayout.WEST, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblForm, -439, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblForm, 0, SpringLayout.EAST, lblTrainNo);
		lblForm.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblForm);
		
		JLabel lblTo = new JLabel("Category");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTo, 0, SpringLayout.WEST, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTo, 0, SpringLayout.EAST, lblTrainNo);
		lblTo.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblTo);
		
	    Four = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.WEST, Four, 107, SpringLayout.EAST, lblClass);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Four, 0, SpringLayout.SOUTH, lblClass);
		sl_contentPane.putConstraint(SpringLayout.EAST, Four, -189, SpringLayout.EAST, contentPane);
		contentPane.add(Four);
		
		JButton next = new JButton("Clear");
		sl_contentPane.putConstraint(SpringLayout.EAST, next, -269, SpringLayout.EAST, contentPane);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservation obj=new Reservation();
				obj.show();
				dispose();
			}
		});
		next.setFont(new Font("Calibri", Font.BOLD, 17));
		contentPane.add(next);
		
		JButton insert = new JButton("Reserve");
		sl_contentPane.putConstraint(SpringLayout.NORTH, next, 0, SpringLayout.NORTH, insert);
		sl_contentPane.putConstraint(SpringLayout.WEST, next, 112, SpringLayout.EAST, insert);
		sl_contentPane.putConstraint(SpringLayout.WEST, insert, 104, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, insert, -42, SpringLayout.EAST, lblTrainNo);
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String pnr=one.getText();
				String from=two.getSelectedItem().toString();
				String to= three.getSelectedItem().toString();
				String train_no=Four.getText();
				String train_name=five.getText();
				String classes=six.getSelectedItem().toString();
				String date=seven.getDateFormatString();
				String name=eight.getText();
				String age=nine.getText();
				String gender= ten.getSelectedItem().toString();
				String category=eleven.getSelectedItem().toString();
				String address=twelve.getText();
				String mobileno=mob.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");
				String query="INSERT INTO `reservation`(`PNR no`, `From`, `To`, `Train No`, `Train Name`, `class`, `Date`, `Name`, `Age`, `Gender`, `Category`, `Address`, `mobile no`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/details","root","");
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,pnr);
				ps.setString(2, from);
				ps.setString(3, to);
				ps.setString(4,train_no);
				ps.setString(5, train_name);
				ps.setString(6, classes);
				ps.setString(7, date);
				ps.setString(8, name);
				ps.setString(9, age);
				ps.setString(10, gender);
				ps.setString(11, category);
				ps.setString(12, address);
				ps.setString(13, mobileno);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Reserved Successfully");
			
			}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		insert.setFont(new Font("Calibri", Font.BOLD, 17));
		contentPane.add(insert);
		
		seven = new JDateChooser();
		sl_contentPane.putConstraint(SpringLayout.WEST, seven, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, seven, 0, SpringLayout.SOUTH, lblForm);
		sl_contentPane.putConstraint(SpringLayout.EAST, seven, -1, SpringLayout.EAST, lblNewLabel);
		contentPane.add(seven);
		
		eleven = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTo, 1, SpringLayout.NORTH, eleven);
		sl_contentPane.putConstraint(SpringLayout.WEST, eleven, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.EAST, eleven, 0, SpringLayout.EAST, lblNewLabel);
		eleven.setModel(new DefaultComboBoxModel(new String[] {"", "General", "Ladies", "Senior Citizen"}));
		contentPane.add(eleven);
		
	    five = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.WEST, five, 357, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, five, -184, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDateOfJourney, 4, SpringLayout.NORTH, five);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblDateOfJourney, -107, SpringLayout.WEST, five);
		sl_contentPane.putConstraint(SpringLayout.NORTH, five, 22, SpringLayout.SOUTH, Four);
		contentPane.add(five);
		
		
		
		two = new JComboBox();
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, two, 11, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, two, 107, SpringLayout.EAST, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, two, -189, SpringLayout.EAST, contentPane);
		contentPane.add(two);
		fillcombo();
		
		three = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, three, -2, SpringLayout.NORTH, lblTrainName);
		sl_contentPane.putConstraint(SpringLayout.WEST, three, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.EAST, three, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(three);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		search.setFont(new Font("Calibri", Font.BOLD, 13));
		sl_contentPane.putConstraint(SpringLayout.NORTH, search, 38, SpringLayout.SOUTH, one);
		sl_contentPane.putConstraint(SpringLayout.WEST, search, 41, SpringLayout.EAST, three);
		contentPane.add(search);
		
		JLabel lblClass_1 = new JLabel("Class");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblForm, 6, SpringLayout.SOUTH, lblClass_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblClass_1, 16, SpringLayout.SOUTH, lblDateOfJourney);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblClass_1, 0, SpringLayout.WEST, lblTrainNo);
		lblClass_1.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblClass_1);
		
		six = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, six, -1, SpringLayout.NORTH, lblClass_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, six, -1, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.EAST, six, 0, SpringLayout.EAST, lblNewLabel);
		six.setModel(new DefaultComboBoxModel(new String[] {"", "1A", "2A", "3A", "CC", "FC", "SL", "2S"}));
		contentPane.add(six);
		
		eight = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, eight, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.EAST, eight, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(eight);
		eight.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, eight, -1, SpringLayout.NORTH, lblName);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblName, 17, SpringLayout.SOUTH, lblForm);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblName, -455, SpringLayout.EAST, contentPane);
		lblName.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblName);
		
		JLabel lblTrainNo_1_1 = new JLabel("Age");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTrainNo_1_1, 136, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTrainNo_1_1, 6, SpringLayout.SOUTH, lblName);
		lblTrainNo_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblTrainNo_1_1);
		
		nine = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTrainNo_1_1, -157, SpringLayout.WEST, nine);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nine, -1, SpringLayout.NORTH, lblTrainNo_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, nine, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.EAST, nine, 0, SpringLayout.EAST, lblNewLabel);
		nine.setColumns(10);
		contentPane.add(nine);
		
		JLabel lblTrainNo_1_1_1 = new JLabel("Gender");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTrainNo_1_1_1, 17, SpringLayout.SOUTH, lblTrainNo_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTrainNo_1_1_1, 136, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTrainNo_1_1_1, -480, SpringLayout.EAST, contentPane);
		lblTrainNo_1_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblTrainNo_1_1_1);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(SystemColor.activeCaption);
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(new SpringLayout());
		
		JLabel lblTrainNo_1_1_1_1 = new JLabel("Address");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTrainNo_1_1_1_1, 17, SpringLayout.SOUTH, lblTo);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTrainNo_1_1_1_1, -10, SpringLayout.WEST, lblTrainNo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTrainNo_1_1_1_1, 0, SpringLayout.EAST, lblTrainNo_1_1);
		lblTrainNo_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblTrainNo_1_1_1_1);
		
		twelve = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, twelve, 0, SpringLayout.NORTH, lblTrainNo_1_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, twelve, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, twelve, 61, SpringLayout.NORTH, lblTrainNo_1_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, twelve, -130, SpringLayout.EAST, contentPane);
		contentPane.add(twelve);
		
		JLabel lblTrainNo_1_1_1_1_1 = new JLabel("Mobile No");
		sl_contentPane.putConstraint(SpringLayout.NORTH, insert, 37, SpringLayout.SOUTH, lblTrainNo_1_1_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTrainNo_1_1_1_1_1, 58, SpringLayout.SOUTH, lblTrainNo_1_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTrainNo_1_1_1_1_1, 121, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTrainNo_1_1_1_1_1, 0, SpringLayout.EAST, lblTrainNo_1_1);
		lblTrainNo_1_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(lblTrainNo_1_1_1_1_1);
		
		mob = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, mob, -4, SpringLayout.NORTH, lblTrainNo_1_1_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, mob, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.EAST, mob, -3, SpringLayout.EAST, five);
		contentPane.add(mob);
		
		ten = new JComboBox();
		ten.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female", "Others"}));
		sl_contentPane.putConstraint(SpringLayout.NORTH, eleven, 16, SpringLayout.SOUTH, ten);
		sl_contentPane.putConstraint(SpringLayout.NORTH, ten, -2, SpringLayout.NORTH, lblTrainNo_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, ten, 0, SpringLayout.WEST, Four);
		sl_contentPane.putConstraint(SpringLayout.EAST, ten, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(ten);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main obj=new Main();
				obj.show();
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBack, 74, SpringLayout.SOUTH, twelve);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBack, 0, SpringLayout.EAST, one);
		btnBack.setFont(new Font("Calibri", Font.BOLD, 17));
		contentPane.add(btnBack);
		fillcombo1();
		
		
	}
}
