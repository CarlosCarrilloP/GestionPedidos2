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
import javax.swing.SwingConstants;
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
		setTitle("CREAR CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Direccion
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(250, 215, 200, 32);
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
		btnNewButton.setBounds(99, 285, 173, 52);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("INTRODUCE TUS DATOS");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(99, 23, 411, 32);
		contentPane.add(lblNewLabel_3);
		
		//Apellido
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(250, 118, 200, 32);
		contentPane.add(textField_3);
		
		//Telefono
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(250, 168, 200, 32);
		contentPane.add(textField_2);
		
		//Nombre
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(250, 70, 200, 32);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2_3 = new JLabel("APELLIDOS");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(137, 113, 92, 44);
		contentPane.add(lblNewLabel_2_3);
		
		JButton cancelar = new JButton("CANCELAR");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pantallaInicio2 pantallaInicio2 = new pantallaInicio2();
				 pantallaInicio2.setVisible(true);
			}
		});
		cancelar.setBounds(337, 285, 173, 52);
		contentPane.add(cancelar);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("NOMBRE");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3_1.setBounds(137, 65, 92, 44);
		contentPane.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("TELEFONO");
		lblNewLabel_2_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3_2.setBounds(137, 163, 92, 44);
		contentPane.add(lblNewLabel_2_3_2);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("DIRECCION");
		lblNewLabel_2_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3_3.setBounds(137, 215, 92, 44);
		contentPane.add(lblNewLabel_2_3_3);
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
