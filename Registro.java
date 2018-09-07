import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro {

	private JFrame frmRegistroDeCuenta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnRegresarAlMen;
	private JButton btnCrearCuenta;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Registro window = new Registro();
					
					window.frmRegistroDeCuenta.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Registro() {
		initialize();
	}
	
	public void hacerVisible(boolean si) {
		this.frmRegistroDeCuenta.setVisible(si);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Oyente miOyente = new Oyente();
		frmRegistroDeCuenta = new JFrame();
		
		frmRegistroDeCuenta.setTitle("Registro de Cuenta");
		frmRegistroDeCuenta.setBounds(100, 100, 365, 394);
		frmRegistroDeCuenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmRegistroDeCuenta.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblRegistreSuCuenta = new JLabel("Registre su Cuenta ");
		panel.add(lblRegistreSuCuenta);
		
		JPanel panel_1 = new JPanel();
		frmRegistroDeCuenta.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNuevoNombreDe = new JLabel("Nombre de Usuario");
		lblNuevoNombreDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNuevoNombreDe.setBounds(10, 127, 135, 14);
		panel_1.add(lblNuevoNombreDe);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(155, 126, 185, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrasea.setBounds(10, 203, 135, 14);
		panel_1.add(lblContrasea);
		
		JLabel lblRepitaContrasea = new JLabel("Repita la Contrase\u00F1a");
		lblRepitaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRepitaContrasea.setBounds(10, 228, 135, 14);
		panel_1.add(lblRepitaContrasea);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		textField_1.setBounds(155, 202, 185, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		textField_2.setBounds(154, 228, 185, 20);
		panel_1.add(textField_2);
		
		JButton btnNewButton = new JButton("Verificar Usuario");
		btnNewButton.addActionListener(new Oyente());
		btnNewButton.setBounds(155, 157, 185, 23);
		panel_1.add(btnNewButton);
		
		JButton btnVerificarContrasea = new JButton("Verificar Contrase\u00F1a");
		btnVerificarContrasea.setBounds(155, 249, 185, 23);
		panel_1.add(btnVerificarContrasea);
		
		JLabel lblNewLabel = new JLabel("(usuario vrificado si/no)");
		lblNewLabel.setBounds(10, 152, 135, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblcontraseaVrificadaSino = new JLabel("(contrase\u00F1a vrificada si/no)");
		lblcontraseaVrificadaSino.setBounds(10, 253, 135, 14);
		panel_1.add(lblcontraseaVrificadaSino);
		
		btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setBounds(10, 303, 135, 23);
		panel_1.add(btnCrearCuenta);
		btnCrearCuenta.addActionListener(miOyente);
		
		btnRegresarAlMen = new JButton("Regresar al men\u00FA");
		btnRegresarAlMen.addActionListener(miOyente);
		btnRegresarAlMen.setBounds(204, 303, 135, 23);
		panel_1.add(btnRegresarAlMen);
		
		JLabel lblIngreseSuNombre = new JLabel("Ingrese su Nombre");
		lblIngreseSuNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseSuNombre.setBounds(10, 11, 135, 14);
		panel_1.add(lblIngreseSuNombre);
		
		JLabel lblNmeroDeCarn = new JLabel("N\u00FAmero de Carn\u00E9");
		lblNmeroDeCarn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmeroDeCarn.setBounds(10, 69, 135, 14);
		panel_1.add(lblNmeroDeCarn);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setColumns(10);
		textField_3.setBounds(155, 10, 185, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setColumns(10);
		textField_4.setBounds(155, 68, 185, 20);
		panel_1.add(textField_4);
	}
	
	private class Oyente implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnRegresarAlMen || e.getSource() == btnCrearCuenta) {
				S0Y101 principal = new S0Y101();
				principal.hacerVisible(true);
				hacerVisible(false);
			}
		}
		
	}
}
