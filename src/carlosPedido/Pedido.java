package carlosPedido;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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

	// Constructor vacío
	public Pedido() {
	}

	// Constructor con parámetros
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
	public String generarCodigoPedido() {
		return String.valueOf(new Date().getTime());

	}
	@Override // Ticket que se imprime por pantalla cuando se realiza el pedido
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

	    sb.append("CANTIDAD            PRODUCTO           PRECIO UD.                TOTAL \n")
	        .append(strProducto1)
	        .append(strProducto2)
	        .append(" TOTAL -------------------------------> ")
	        .append(totalPedido)
	        .append("  € \n ");

	    try (PrintWriter pw = new PrintWriter(new FileWriter(rutaTicket, false))) {//False para que no me guarde los tickets, solo 1, si no cambiar a true
	        pw.print(sb.toString());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return sb.toString();
	}


	public double toString2() {
		double totalPedido = 0;
		if (producto1 != null) {
			
			double totalProducto1 = producto1.getCantidad() * producto1.getPrecio();
			totalPedido+=totalProducto1;
		}
		if (producto2 != null) {
			double totalProducto2 = producto2.getCantidad() * producto2.getPrecio();
			totalPedido += totalProducto2;
		}
		
		
		return totalPedido;
	}

}
