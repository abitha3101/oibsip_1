package online_reservation_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrOnlineReservation = new JTextArea();
		txtrOnlineReservation.setEditable(false);
		txtrOnlineReservation.setBackground(SystemColor.activeCaption);
		txtrOnlineReservation.setFont(new Font("Calibri", Font.BOLD, 16));
		txtrOnlineReservation.setText("ONLINE RESERVATION");
		txtrOnlineReservation.setBounds(130, 23, 196, 27);
		contentPane.add(txtrOnlineReservation);
		
		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNewLabel.setBounds(72, 60, 107, 27);
		contentPane.add(lblNewLabel);
		
		JTextArea a = new JTextArea();
		a.setBackground(SystemColor.window);
		a.setBounds(252, 60, 107, 22);
		contentPane.add(a);
		
		JLabel lblPaaword = new JLabel("Password");
		lblPaaword.setFont(new Font("Calibri", Font.BOLD, 17));
		lblPaaword.setBounds(72, 129, 107, 27);
		contentPane.add(lblPaaword);
		
		JTextArea b = new JTextArea();
		b.setBackground(SystemColor.window);
		b.setBounds(252, 129, 107, 22);
		contentPane.add(b);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(a.getText().equals("admin") & b.getText().equals("123")) {
					Main obj=new Main();
					obj.show();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		btnNewButton.setBounds(164, 189, 85, 21);
		contentPane.add(btnNewButton);
	}
}
