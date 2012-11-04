package org.akritiko.misslemon.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.akritiko.misslemon.MissLemon;

public class CommandWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommandWindow frame = new CommandWindow();
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
	public CommandWindow() {

		setTitle("Miss Lemon's Command Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(35);

		JButton btnNewButton = new JButton("Have your say!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// String preparation
				String command = textField.getText();
				String[] items = command.trim().toLowerCase().split(" ");

				// Spy functionality
				if (items[0].equals("spy")) {
					String url = "http://builtwith.com/";
					if (items[1].contains("http")) {
						String[] subItems = items[1].trim().split("//");
						url += subItems[1];
					} else {
						url += items[1];
					}
					MissLemon.visit(url, items[0]);
				}

				// Visit url functionality
				else if (items[0].equals("visit")) {
					MissLemon.visit(items[1], items[0]);
				}

				// Calculate using Google functionality
				else if (items[0].equals("calculate")) {
					String url = "https://www.google.com/search?q=";
					String temp = items[1].replaceAll("\\+", "%2B");
					url += temp;
					MissLemon.visit(url, items[0]);
				}

				// Search using Google functionality
				else if (items[0].equals("search")) {
					String url = "https://www.google.com/search?q=";
					for (int i = 0; i < items.length; i++) {
						String temp = items[i].replaceAll("\\+", "%2B")
								.replaceAll(" ", "+");
						url += temp;
						if((i+1) != items.length)
						{
							url += "+";
						}
					}
					MissLemon.visit(url, items[0]);
				}

				// Else invalid command
				else {
					MissLemon.reportFail();
				}
			}
		});
		panel.add(btnNewButton);
	}
}
