package carlosPedido;

import java.util.Date;
import java.util.Scanner;

public class PasarelaDePago {

	// Atributos
	Double importe; // Limitar a dos decimales.
	String codigoPago;

	// Get and Set

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago() {

		this.codigoPago = this.generarCodigoPago();

	}

	// Constructores
	public PasarelaDePago() {

	}

	public PasarelaDePago(Double importe) {

		this.importe = importe;
		this.codigoPago = this.generarCodigoPago();
	}

	// Metodos

	// Efectivo
	
	public void efectivopago(double importe) {
	    this.importe = importe;
	    this.codigoPago = generarCodigoPago();

	    System.out.println("Ha elegido efectivo.");
	    System.out.printf("El total es de %.2f€.%n", importe);
	    System.out.println("Necesitas:");

	    float[] denominaciones = {50, 20, 10, 5, 2, 1, (float) 0.50, (float) 0.20, (float) 0.10,(float) 0.05,(float) 0.02, (float)0.01};
	    String[] billetesMonedas = {"Billetes de 50€", "Billetes de 20€", "Billetes de 10€", "Billetes de 5€", "Monedas de 2€", "Monedas de 1€", "Monedas de 0.50€", "Monedas de 0.20€", "Monedas de 0.10€", "Monedas de 0.05€", "Monedas de 0.02€", "Monedas de 0.01€"};

	    for (int i = 0; i < denominaciones.length; i++) {
	        int cantidadDenominacionActual = 0;
	        while (importe >= denominaciones[i]) {
	            importe -= denominaciones[i];
	            cantidadDenominacionActual++;
	        }
	        if (cantidadDenominacionActual > 0) {
	            System.out.println(cantidadDenominacionActual + " " + billetesMonedas[i]);
	        }
	    }
	}


	// Tarjeta
	public void tarjeta(String numeroTarjeta) {

		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();
		System.out.println("Ha elegido tarjeta");

		System.out.println("Escriba el numero de su tarjeta");
		Scanner sc = new Scanner(System.in);
		String tarjeta = sc.nextLine();
		char var = tarjeta.charAt(0);

		switch (var) {
		case '3': // 16 dígitos Para VISA y Mastercard separados de 4 en 4 dígitos.
			System.out.println("La tarjeta es American Express");
			if (var == '3') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 8);
					String distancia3 = cadenaString.substring(8, 12);
					String distancia4 = cadenaString.substring(12, 16);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3
							+ " " + distancia4);

				} else {
					System.out.println("Su numero de tarjeta no es valido");
				}
			} else {
				System.out.println("Su numero de tarjeta no es valido");
			}
			break;

		case '4':
			System.out.println("La tarjeta es Visa");
			if (var == '4') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 8);
					String distancia3 = cadenaString.substring(8, 12);
					String distancia4 = cadenaString.substring(12, 16);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3
							+ " " + distancia4);
				} else {
					System.out.println("Su numero de tarjeta no es valido");
				}
			} else {
				System.out.println("Su numero de tarjeta no es valido");
			}
			break;
		case '5': // Para American Express debe aceptar 15 dígitos y estar separados por 4, 6 y 5
					// dígitos.
			System.out.println("La tarjeta es Mastercard");
			if (var == '5') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 15) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 10);
					String distancia3 = cadenaString.substring(10, 15);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3);

				} else {
					System.out.println("Su numero de tarjeta no es valido");
				}
			} else {
				System.out.println("Su numero de tarjeta no es valido");
			}
			break;
		default:
			System.out.println("La tarjeta introducida no es valida");

		}

	}

	// Cuenta
	public void cuenta(String numeroCuenta) {

		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();

	}

	public String generarCodigoPago() {
		return String.valueOf(new Date().getTime());

	}

}
