package online_reservation_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 382);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton a = new JButton("Reservation");
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Reservation obj=new Reservation();
			obj.show();
			dispose();
			}
		});
		a.setFont(new Font("Calibri", Font.BOLD, 14));
		a.setBounds(48, 95, 136, 33);
		contentPane.add(a);
		
		JButton b = new JButton("Cancellation");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancellation obj=new Cancellation();
				obj.show();
				dispose();
			}
		});
		b.setFont(new Font("Calibri", Font.BOLD, 14));
		b.setBounds(274, 95, 136, 33);
		contentPane.add(b);
		
		JButton d = new JButton("Exit");
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		d.setFont(new Font("Calibri", Font.BOLD, 14));
		d.setBounds(165, 184, 136, 33);
		contentPane.add(d);
	}

}
