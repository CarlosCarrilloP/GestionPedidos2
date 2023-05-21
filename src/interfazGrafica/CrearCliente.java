package interfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import conexionBBDD.Conexion;
import conexionBBDD.TestConexion;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private String insertTableSQL;
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement ps = null;
	ResultSet rs = null;
	public static void main(String[] args) {
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement ps = null;
		ResultSet rs = null;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CrearCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Direccion
		textField_4 = new JTextField();
		textField_4.setBounds(345, 219, 200, 44);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero=textField_2.getText();
				 if (validarTelefono(numero)) {
					 String datos = obtenerDatosDelFormulario();
					 String[] datosSeparados = datos.split(",");
					 guardarDatosEnArchivo(datosSeparados[0], datosSeparados[1], datosSeparados[2], datosSeparados[3]);
					 dispose(); // Cierra la ventana actual 
					 RealizarPedido1 realizarPedido1 = new RealizarPedido1();
					 realizarPedido1.setVisible(true);
				 }else {
					 JOptionPane.showMessageDialog(null, "El número de teléfono no es válido");
				 }
				
			}
		});
		btnNewButton.setBounds(219, 285, 173, 52);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("DIRECCION");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(391, 173, 142, 44);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CREAR CLIENTE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(219, 28, 173, 32);
		contentPane.add(lblNewLabel_3);
		
		//Apellido
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(35, 219, 200, 44);
		contentPane.add(textField_3);
		
		//Telefono
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(345, 99, 200, 44);
		contentPane.add(textField_2);
		
		//Nombre
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(35, 99, 200, 44);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(99, 59, 142, 44);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("TELEFONO");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(391, 59, 142, 44);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("APELLIDOS");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(88, 173, 142, 44);
		contentPane.add(lblNewLabel_2_3);
	}

	private boolean validarTelefono(String numero) {
		// Expresión regular para verificar el formato del número de teléfono
		String regex = "^[6-9]\\d{8}$";
		return numero.matches(regex);
	}
	private String obtenerDatosDelFormulario() {
	   
	    String nombre = textField_1.getText();
	    String apellidos = textField_3.getText();
	    String direccion = textField_4.getText();
	    String telefono = textField_2.getText();

	    // Puedes combinar los datos en una sola cadena o darle el formato que desees
	    String datos =  nombre + "," + apellidos + "," + telefono + "," + direccion;

	    return datos;
	}

	private void guardarDatosEnArchivo(String nombre, String apellido, String telefono, String direccion) {

	    PreparedStatement ps = null;

		// Sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO cliente (nombre,apellidos,telefono,direccion) VALUES (?,?,?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, telefono);
			ps.setString(4, direccion);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) { 

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
		
			TestConexion.cerrar_conexion3(cn, ps, rs);
		}
	}

}
