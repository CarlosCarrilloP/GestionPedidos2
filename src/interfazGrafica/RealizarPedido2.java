package interfazGrafica;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class RealizarPedido2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String nombreProductoSeleccionado1;
	public static int cantidadProductoSeleccionada1;
	public static double precioArticuloSeleccionado ;
	public static double precioArticuloSeleccionado2 ;

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

	public RealizarPedido2(String nombreProductoSeleccionado1, int cantidadProductoSeleccionada1, double precioArticuloSeleccionado1) {
		setTitle("Menu Pedidos");

		RealizarPedido2.nombreProductoSeleccionado1 = nombreProductoSeleccionado1;
		RealizarPedido2.cantidadProductoSeleccionada1 = cantidadProductoSeleccionada1;
		RealizarPedido2.precioArticuloSeleccionado = precioArticuloSeleccionado1;
		

		List<String> nombresProductos = cargarNombresProductos();
		List<Double> precioProductos = cargarPrecioProductos();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 200, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton(nombresProductos.get(0));
		btnNewButton.setBounds(51, 117, 158, 75);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(0),precioProductos.get(0));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("ELIGE UN 2º PRODUCTO");
		lblNewLabel_1.setBounds(170, 51, 297, 20);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_3 = new JButton("Terminar Pedido");
		btnNewButton_3.setBounds(129, 285, 168, 39);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Cerrar la ventana secundaria
				// Crear y mostrar el JFrame "Final"
				Final Final = new Final(nombreProductoSeleccionado1, cantidadProductoSeleccionada1, precioArticuloSeleccionado, nombreProductoSeleccionado1, cantidadProductoSeleccionada1, precioArticuloSeleccionado);
				Final.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton(nombresProductos.get(1));
		btnNewButton_1.setBounds(219, 117, 159, 75);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(1),precioProductos.get(1));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(nombresProductos.get(2));
		btnNewButton_2.setBounds(392, 117, 158, 75);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(2),precioProductos.get(2));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_4 = new JButton(nombresProductos.get(3));
		btnNewButton_4.setBounds(129, 202, 168, 61);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(3),precioProductos.get(3));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton(nombresProductos.get(4));
		btnNewButton_5.setBounds(307, 202, 168, 61);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				solicitarCantidad(nombresProductos.get(4),precioProductos.get(4));
				dispose(); // Cierra la ventana actual
			}
		});
		contentPane.add(btnNewButton_5);
		
		JButton atras = new JButton("Atras");
		atras.setBounds(307, 285, 168, 39);
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RealizarPedido1 RealizarPedido1 = new RealizarPedido1();
				RealizarPedido1.setVisible(true);
			}
		});
		contentPane.add(atras);
	}


	public void solicitarCantidad(String producto, double precio) {
		
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
						double resultado = precio * cantidadNumerica; // Calcula el resultado
						dialog.dispose(); // Cerrar la ventana secundaria
						Final Final = new Final(nombreProductoSeleccionado1, cantidadProductoSeleccionada1, precioArticuloSeleccionado , producto,
								cantidadNumerica, resultado);
						Final.setVisible(true);
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
		cantidadField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            okButton.doClick();
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
				RealizarPedido2 frame = new RealizarPedido2(nombreProductoSeleccionado1, cantidadProductoSeleccionada1, precioArticuloSeleccionado);
				frame.setVisible(true);
			}
		});
	}
}
