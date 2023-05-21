package carlosPedido;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import conexionBBDD.TestConexion;

public class Pedido {

	// Atributos
	Cliente cliente;
	Producto producto1;
	Producto producto2;
	double importeTotal;
	PasarelaDePago pago;
	Estado estado;
	String codigoPedido;
	String rutaTicket = "C:/Users/Carlos Carrillo/eclipse-workspace/GestionPedidos2/src/carlosPedido/Ticket.txt";
	static int id;
	static java.sql.Date fecha_ticket;
	private static String insertTableSQL;


	// Constructor vacío
	public Pedido() {
	}

	// Constructor con parámetros
	/**
	 * Constructor de la clase Pedido que crea una instancia de Pedido con los parámetros especificados.
	 *
	 * @param cliente       El cliente asociado al pedido.
	 * @param producto1     El primer producto del pedido.
	 * @param producto2     El segundo producto del pedido.
	 * @param importeTotal  El importe total del pedido.
	 * @param pago          La pasarela de pago utilizada para el pedido.
	 * @param estado        El estado actual del pedido.
	 */
	public Pedido(Cliente cliente, Producto producto1, Producto producto2, double importeTotal, PasarelaDePago pago,
			Estado estado) {
		this.cliente = cliente;
		this.producto1 = producto1;
		this.producto2 = producto2;
		this.importeTotal = importeTotal;
		this.pago = pago;
		this.estado = estado;
		this.codigoPedido = generarCodigoPedido();
	}

	// Getters y setters para los atributos de la clase
	public Cliente getCliente() {
		return cliente;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido() {

		this.codigoPedido = generarCodigoPedido();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto1() {
		return producto1;
	}

	public void setProducto1(Producto producto1) {
		this.producto1 = producto1;
	}

	public Producto getProducto2() {
		return producto2;
	}

	public void setProducto2(Producto producto2) {
		this.producto2 = producto2;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public PasarelaDePago getPago() {
		return pago;
	}

	public void setPago(PasarelaDePago pago) {
		this.pago = pago;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public boolean isPagoRealizado() {
		return pagoRealizado;
	}

	public void setPagoRealizado(boolean pagoRealizado) {
		this.pagoRealizado = pagoRealizado;
	}

	// Metodos

	public enum Estado {
		PAGADO, PREPARANDO, LISTO, SERVIDO
	}

	public enum TipoPago {
		EFECTIVO, TARJETA, CUENTA
	}

	private boolean pagoRealizado = false;

	public void pagar(TipoPago tipoPago) {

		if (pagoRealizado == false) {
			pagoRealizado = true;

		}
	}

	public void agregarCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	public void agregarProducto1(Producto producto1) {

		this.producto1 = producto1;
	}

	public void agregarProducto2(Producto producto2) {

		if (this.producto1 != null) {
			this.producto2 = producto2;
		}

	}

	public Producto eliminarProducto(Producto producto) {
		producto = null;
		return producto;
	}

	// Codigo pedido: es la fecha de hoy
	/**
	 * Genera y devuelve el código del pedido basado en la fecha actual.
	 *
	 * @return El código del pedido generado.
	 */
	public String generarCodigoPedido() {
		return String.valueOf(new Date().getTime());

	}

	@Override // Ticket que se imprime por pantalla cuando se realiza el pedido
	/**
	 * Devuelve una representación en formato de texto del objeto Pedido.
	 * Este método también imprime un ticket por pantalla y lo guarda en la base de datos.
	 *
	 * @return Una cadena de texto que representa el objeto Pedido.
	 */
	public String toString() {

		StringBuilder sb = new StringBuilder();

		double totalProducto1 = 0;
		double totalProducto2 = 0;
		String strProducto1 = "";
		String strProducto2 = "";
		if (producto1 != null) {
			totalProducto1 = producto1.getCantidad() * producto1.getPrecio();
			strProducto1 = producto1.getCantidad() + "                  " + producto1.getNombre() + "             "
					+ producto1.getPrecio() + "                  " + totalProducto1 + " € \n";
		}
		if (producto2 != null) {
			totalProducto2 = producto2.getCantidad() * producto2.getPrecio();
			strProducto2 = producto2.getCantidad() + "                  " + producto2.getNombre() + "             "
					+ producto2.getPrecio() + "                   " + totalProducto2 + " € \n";
		}
		double totalPedido = totalProducto1 + totalProducto2;

		sb.append("CANTIDAD            PRODUCTO           PRECIO UD.                TOTAL \n").append(strProducto1)
				.append(strProducto2).append(" TOTAL -------------------------------> ").append(totalPedido)
				.append("  € \n ");

		try (PrintWriter pw = new PrintWriter(new FileWriter(rutaTicket, false))) {
				guardarTicketBBDD(sb.toString());									
																					
			pw.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
	/**
	 * Devuelve el total del pedido como un valor numérico.
	 *
	 * @return El total del pedido.
	 */
	public double toString2() {
		double totalPedido = 0;
		if (producto1 != null) {

			double totalProducto1 = producto1.getCantidad() * producto1.getPrecio();
			totalPedido += totalProducto1;
		}
		if (producto2 != null) {
			double totalProducto2 = producto2.getCantidad() * producto2.getPrecio();
			totalPedido += totalProducto2;
		}

		return totalPedido;
	}

	// Metodo para guardar el ticket en la bbdd
	/**
	 * Guarda el contenido del ticket en la base de datos.
	 *
	 * @param contenidoTicket El contenido del ticket a guardar.
	 */
	public static void guardarTicketBBDD(String contenidoTicket) {

		conexionBBDD.Conexion conexion = new conexionBBDD.Conexion();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs4=null;
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

}
