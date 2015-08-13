package org.akritiko.misslemon.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ConversationWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversationWindow frame = new ConversationWindow();
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
	public ConversationWindow() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(25, 25, 112)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMessageGoesHere = new JLabel("Message Goes Here!");
		lblMessageGoesHere.setBounds(12, 12, 284, 158);
		lblMessageGoesHere.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMessageGoesHere);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(75, 182, 160, 25);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.getParent().setVisible(false);
				dispose();
			}
		});
		contentPane.add(btnOk);
	}

}
