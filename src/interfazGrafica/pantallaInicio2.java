package interfazGrafica;

import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import conexionBBDD.Conexion;

public class pantallaInicio2 extends JFrame {
	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaInicio2 frame = new pantallaInicio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pantallaInicio2() {
		setTitle("GestionPedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 200, 613, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = textField.getText();

				if (validarTelefono(numero)) {
					List<String> telefonos = existeNumero();
					if (telefonos.contains(numero)) {
						RealizarPedido1 frame = new RealizarPedido1();
						frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "El cliente está registrado");
					} else {
						CrearCliente frame = new CrearCliente();
						frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "El cliente no está registrado");
					}
					dispose(); // Cierra la ventana actual
				} else {
					JOptionPane.showMessageDialog(null, "El número de teléfono no es válido");
				}
			}
		});

		btnNewButton.setBounds(84, 263, 189, 58);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Introduzca su número de teléfono y pulse Continuar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(84, 23, 421, 141);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(172, 151, 243, 58);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		    }
		});
		cancelar.setBounds(294, 263, 189, 58);
		contentPane.add(cancelar);
	}

	// Metodo que comprueba si existe el numero en la BBDD
	private List<String> existeNumero() {
		List<String> telefonos = new ArrayList<>();
		try {
			Conexion conexion3 = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			String selectQuery = "SELECT telefono FROM cliente";
			cn = Conexion.conectar();
			Statement statement = cn.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				String telefono = resultSet.getString("telefono");
				telefonos.add(telefono);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return telefonos;
	}

	private boolean validarTelefono(String numero) {
		// Expresión regular para verificar el formato del número de teléfono
		String regex = "^[6-9]\\d{8}$";
		return numero.matches(regex);
	}
}
