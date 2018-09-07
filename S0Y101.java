import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class S0Y101 {

	private JFrame frmLoggin;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnRegistrarse;
	private JButton btnIngresar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					S0Y101 window = new S0Y101();
					window.frmLoggin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public S0Y101() {
		initialize();
	}
	
	public void hacerVisible(boolean si) {
		this.frmLoggin.setVisible(si);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoggin = new JFrame();
		frmLoggin.setTitle("Loggin");
		frmLoggin.setBounds(100, 100, 230, 288);
		frmLoggin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmLoggin.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblMenDeEntrada = new JLabel("Men\u00FA de Entrada");
		panel.add(lblMenDeEntrada);
		
		JPanel panel_1 = new JPanel();
		frmLoggin.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new Oyente());
		btnRegistrarse.setBounds(10, 127, 188, 41);
		panel_1.add(btnRegistrarse);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario: ");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreDeUsuario.setBounds(10, 11, 149, 14);
		panel_1.add(lblNombreDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(10, 77, 149, 14);
		panel_1.add(lblContrasea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 31, 188, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 96, 188, 20);
		panel_1.add(textField_1);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new Oyente());
		btnIngresar.setBounds(10, 179, 188, 41);
		panel_1.add(btnIngresar);
	}
	private class Oyente implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnRegistrarse) {
				Registro reg = new Registro();
				reg.hacerVisible(true);
				hacerVisible(false);
				
			}
			else if (e.getSource() == btnIngresar) {
				Sesión ses = new Sesión();
				ses.hacerVisible1(true);
				hacerVisible(false);	
			}
		}
		
	}
}
