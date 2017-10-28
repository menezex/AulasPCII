package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import etec.persistence.ConexaoFactory;
import etec.persistence.PessoaDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Painel extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Painel frame = new Painel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Painel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					Connection Con = new ConexaoFactory().getMysqlConnection();
					PessoaDAO pessoadao = new PessoaDAO<>(Con);
					
				if(pessoadao.checkLogin(txtLogin.getText())){
					System.out.println("PESSOA LOGADA COM SUCESSO");
				}
				
				else
				{
					
					System.out.println("ERRO NO LOGIN");
				}
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnLogar.setBounds(120, 182, 89, 23);
		contentPane.add(btnLogar);
		
		JLabel lblLogin = new JLabel("LOGIN:");
		lblLogin.setBounds(41, 78, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setBounds(41, 116, 46, 14);
		contentPane.add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(88, 75, 158, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(88, 113, 158, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
	}
}
