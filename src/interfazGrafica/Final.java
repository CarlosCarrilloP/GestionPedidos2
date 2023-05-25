package interfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexionBBDD.TestConexion;

public class Final extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String nombreProducto1;
	public static int cantidadProducto1;
	public static String nombreProducto2;
	private static String insertTableSQL;
	public static int cantidadProducto2;
	static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final finalFrame = new Final(nombreProducto1, cantidadProducto1, nombreProducto2,
							cantidadProducto2);
					finalFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the frame.
	 */
	public Final(String nombreProducto1, int cantidadProducto1, String nombreProducto2, int cantidadProducto2) {

		this.nombreProducto1 = nombreProducto1;
		this.cantidadProducto1 = cantidadProducto1;
		this.nombreProducto2 = nombreProducto2;
		this.cantidadProducto2 = cantidadProducto2;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("¡Gracias por tu pedido!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(183, 28, 377, 40);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Imprimir ticket");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(239, 94, 136, 40);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirTicket();
			}
		});

		JButton btnNewButton_1 = new JButton("CERRAR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(340, 187, 136, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("ATRAS");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarPedido2 r = new RealizarPedido2(nombreProducto2, cantidadProducto2);
				r.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(144, 187, 136, 40);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
	}

	public static void guardarTicketBBDD(String contenidoTicket) {

		conexionBBDD.Conexion conexion = new conexionBBDD.Conexion();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs4 = null;
		// int id_usuario=null;
		// Crear sentencia SQL para insertar en la base de datos
		insertTableSQL = "INSERT INTO ticket (id,ticket_resume) VALUES (?,?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setInt(1, id);
			ps.setString(2, contenidoTicket);

			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con exito en la base de datos");

		} catch (SQLException e) {

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			TestConexion.cerrar_conexion3(cn, ps, rs4);

		}

	}

	private void imprimirTicket() {
		StringBuilder resumenPedido = new StringBuilder();
		resumenPedido.append(" ¡GRACIAS POR SU PEDIDO! ").append("\n");
		resumenPedido.append(Final.nombreProducto1).append(" ----- ").append(Final.cantidadProducto1).append(" ----- ").append("Poner Precio").append("\n");
		resumenPedido.append(Final.nombreProducto2).append(" ------").append(Final.cantidadProducto2).append(" ----- ").append("Poner Precio").append("\n");

		JOptionPane.showMessageDialog(null, resumenPedido.toString(), "Resumen del Pedido",
				JOptionPane.INFORMATION_MESSAGE);

	}

}
