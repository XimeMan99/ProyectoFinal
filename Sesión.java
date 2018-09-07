import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

import javax.swing.JCheckBox;
import java.awt.Toolkit;

public class Sesión {

	private JFrame frmBienvenidousuario;
	private JButton btnCerrar; 

	/*//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sesión window = new Sesión();
					window.frmBienvenidousuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Sesión() {
		initialize();
	}
	public void hacerVisible1(boolean si) {
		this.frmBienvenidousuario.setVisible(si);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Oyente miOyente = new Oyente();
		
		frmBienvenidousuario = new JFrame();
		frmBienvenidousuario.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jiio2\\Desktop\\logo-universidad-del-valle-de-guatemala.png"));
		frmBienvenidousuario.setTitle("Bienvenido + \"Usuario\"");
		frmBienvenidousuario.setBounds(100, 100, 563, 457);
		frmBienvenidousuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBienvenidousuario.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblUsuario = new JLabel("Usuario");
		panel.add(lblUsuario);
		
		JPanel panel_1 = new JPanel();
		frmBienvenidousuario.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(257, 0, 2, 383);
		panel_1.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(257, 161, 294, 2);
		panel_1.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 547, 2);
		panel_1.add(separator_1);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 243, 372);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cursos que est\u00E1 llevando");
		lblNewLabel.setBounds(10, 11, 174, 14);
		panel_2.add(lblNewLabel);
		
		btnCerrar = new JButton("Cerrar Sesi\u00F3n");
		btnCerrar.setBounds(10, 338, 223, 23);
		btnCerrar.addActionListener(miOyente);
		panel_2.add(btnCerrar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(263, 11, 274, 152);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Agregar Cursos");
		lblNewLabel_1.setBounds(10, 11, 112, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblSeleccioneSuCarrera = new JLabel("Seleccione su Carrera");
		lblSeleccioneSuCarrera.setBounds(10, 36, 132, 14);
		panel_3.add(lblSeleccioneSuCarrera);
		
		JLabel lblAoDeCursamiento = new JLabel("A\u00F1o en Curso");
		lblAoDeCursamiento.setBounds(10, 61, 132, 14);
		panel_3.add(lblAoDeCursamiento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica"}));
		comboBox.setBounds(152, 33, 112, 20);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(152, 58, 112, 20);
		panel_3.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Buscar Cursos");
		btnNewButton.setBounds(72, 120, 143, 23);
		panel_3.add(btnNewButton);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setBounds(10, 86, 132, 14);
		panel_3.add(lblSemestre);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_2.setBounds(152, 89, 112, 20);
		panel_3.add(comboBox_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(263, 174, 274, 209);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cursos Encontrados");
		lblNewLabel_2.setBounds(10, 11, 129, 14);
		panel_4.add(lblNewLabel_2);
		
		JButton btnAadirCursoos = new JButton("A\u00F1adir Cursos");
		btnAadirCursoos.setBounds(70, 175, 143, 23);
		panel_4.add(btnAadirCursoos);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(10, 36, 254, 20);
		panel_4.add(comboBox_3);
	}
	private class Oyente implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnCerrar) {
				S0Y101 principal = new S0Y101();
				principal.hacerVisible(true);
				hacerVisible1(false);
			}
		}
		
	}
}
