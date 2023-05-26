package interfazGrafica;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import conexionBBDD.Conexion;

public class RealizarPedido1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private double precioArticuloSeleccionado;

	private List<String> cargarNombresProductos() {
		List<String> nombresProductos = new ArrayList<>();
		try {
			Conexion conexion3 = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			String selectQuery = "SELECT nombre FROM producto";
			cn = Conexion.conectar();
			Statement statement = cn.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				String nombreProducto = resultSet.getString("nombre");
				nombresProductos.add(nombreProducto);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombresProductos;
	}
	private List<Double> cargarPrecioProductos() {
		List<Double> precioProductos = new ArrayList<>();
		try {
			Conexion conexion3 = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			String selectQuery = "SELECT precio FROM producto";
			cn = Conexion.conectar();
			Statement statement = cn.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				Double precioProducto = resultSet.getDouble("precio");
				precioProductos.add(precioProducto);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return precioProductos;
	}

	public RealizarPedido1() {
		setTitle("Menu Pedidos");
		List<String> nombresProductos = cargarNombresProductos();
		List<Double> precioProductos = cargarPrecioProductos();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 200, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnNewButton = new JButton(nombresProductos.get(0));
		btnNewButton.setBounds(56, 117, 159, 75);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(0), precioProductos.get(0));
				dispose(); // Cierra la ventana actual

			}
		});
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("ELIGE UN PRODUCTO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(194, 43, 219, 39);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_3 = new JButton("Terminar Pedido");
		btnNewButton_3.setBounds(131, 298, 168, 39);
		contentPane.add(btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose(); // Cierra la ventana actual
			}
		});

		JButton btnNewButton_1 = new JButton(nombresProductos.get(1));
		btnNewButton_1.setBounds(223, 117, 176, 75);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(1), precioProductos.get(1));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(nombresProductos.get(2));
		btnNewButton_2.setBounds(408, 117, 146, 75);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(2), precioProductos.get(2));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton(nombresProductos.get(3));
		btnNewButton_4.setBounds(131, 202, 168, 75);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(3), precioProductos.get(3));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton(nombresProductos.get(4));
		btnNewButton_5.setBounds(309, 202, 176, 75);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(4), precioProductos.get(4));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_5);
		
		JButton atras = new JButton("Atras");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pantallaInicio2 pantallaInicio2 = new pantallaInicio2();
				pantallaInicio2.setVisible(true);
			}
		});
		atras.setBounds(309, 298, 168, 39);
		contentPane.add(atras);
	}

	public void solicitarCantidad(String producto, Double precio) {
		this.precioArticuloSeleccionado=precio;
		JDialog dialog = new JDialog(this, "Cantidad", true);
		dialog.setSize(300, 200);
		dialog.getContentPane().setLayout(new FlowLayout());
		dialog.setLocationRelativeTo(null);

		JLabel cantidadLabel = new JLabel("Cantidad para " + producto + ":");
		JTextField cantidadField = new JTextField(10);

		JButton okButton = new JButton("ENVIAR");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cantidad = cantidadField.getText();
				try {
					int cantidadNumerica = Integer.parseInt(cantidad);

					if (cantidadNumerica >= 1 && cantidadNumerica <= 30) {
						JOptionPane.showMessageDialog(null, "Cantidad ingresada para " + producto + ": " + cantidad);
						
						dialog.dispose(); // Cerrar la ventana secundaria
						double resultado = precioArticuloSeleccionado * cantidadNumerica; // Calcula el resultado
						RealizarPedido2 realizarPedido2 = new RealizarPedido2(producto, cantidadNumerica, resultado);
						realizarPedido2.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "La cantidad debe estar entre 1 y 30 unidades.", "Error",
								JOptionPane.ERROR_MESSAGE);
						cantidadField.setText(""); // Limpiar el campo de texto
						cantidadField.requestFocus(); // Colocar el foco en el campo de texto
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "La cantidad ingresada no es un número válido.", "Error",
							JOptionPane.ERROR_MESSAGE);
					// Volver a solicitar la cantidad
					cantidadField.setText(""); // Limpiar el campo de texto
					cantidadField.requestFocus(); // Colocar el foco en el campo de texto
				}
			}
		});

		dialog.getContentPane().add(cantidadLabel);
		dialog.getContentPane().add(cantidadField);
		dialog.getContentPane().add(okButton);
		
		dialog.setVisible(true);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				RealizarPedido1 frame = new RealizarPedido1();
				frame.setVisible(true);
			}
		});
	}
}
