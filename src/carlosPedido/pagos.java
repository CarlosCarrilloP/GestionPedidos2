package carlosPedido;

import java.util.Scanner;

public class pagos {
	public pagos() {
	
	/*
	 Crea un pequeño programa que sirva para validar el pago dentro de un
	 restaurante. Un cliente puede pagar en efectivo o con tarjeta. El programa
	 debe hacer los siguiente en cada caso:

	Preguntar el tipo de pago.

	 Si se paga en efectivo, comprobar si la cantidad es exacta, en caso contrario
	 devolver el mínimo dinero posible.

	 ANOTACIÓN

	 Si seleccionamos la forma de pago en efectivo, el programa nos pedirá que
	 introduzcamos la cantidad que vamos a entregar para realizar el pago. El
	 programa nos devolverá el dinero sobrante en billetes de 50€, 20€, 10€ y 5€,
	 y también devolverá monedas de euro y céntimos. Las cantidades devueltas será
	 en base a la premisa de devolver la menor cantidad de billetes posibles, es
	 decir, debe devolver siempre todos los billetes de mayor importe que se
	 pueda.
	 Por ejemplo, vamos a suponer que tiene que cobrar 123'45 €, una posible
	 devolución podría ser 10 billetes de 10 euros, 1 billete de 20, 3 euros y 45
	 céntimos. Pero estaría incorrecto, ya que estamos devolviendo muchos
	 billetes. Lo correcto sería devolver 2 billetes de 50, un billete de 20, y 3
	 euros y 45 céntimos.

	 Si se paga con tarjeta realizar las siguientes comprobaciones:

	 Sólo debe aceptar números y espacios en blanco.
	 Acepta tarjetas VISA, MasterCard y American Express.
	 16 dígitos Para VISA y Mastercard separados de 4 en 4 dígitos. (19 huecos)
	 Para American Express debe aceptar 15 dígitos y estar separados por 4, 6 y 5
	 dígitos. (18 huecos)
	 ANOTACIÓN

	 El primer dígito indica el tipo de tarjeta:
	 si es un 3 la tarjeta es American Express
	 si es un 4 la tarjeta es Visa
	 si es un 5 la tarjeta es MasterCard
	 */
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Elija el metodo de pago: 1-Efectivo, 2- tarjeta");
	int metodopago = Integer.parseInt(sc.nextLine());
	int i = 0; // Compruebo si es efectivo o tarjeta
	if(metodopago==1)
	{
		System.out.println("Ha elegido efectivo");
		System.out.println("Introduzca la cantidad que va a introducir");

		float cantidad = sc.nextFloat();
		System.out.println("Ha introducido " + cantidad + "€");

		if (cantidad >= 50) {
			while (cantidad >= 50) {

				cantidad = cantidad - 50;
				i++;
			}
			System.out.println(i + " Billetes de 50€");
		}
		if (cantidad <= 50 && cantidad >= 20) {
			int v = 0;
			while (cantidad >= 20) {

				cantidad = cantidad - 20;
				v++;
			}
			System.out.println(v + " Billetes de 20€");
		}
		if (cantidad <= 20 && cantidad >= 10) {
			int d = 0;
			while (cantidad >= 10) {

				cantidad = cantidad - 10;
				d++;
			}
			System.out.println(d + " Billetes de 10€");
		}
		if (cantidad <= 10 && cantidad >= 5) {
			int e = 0;
			while (cantidad >= 5) {

				cantidad = cantidad - 5;
				e++;
			}
			System.out.println(e + " Billetes de 5€");
		}
		if (cantidad <= 5 && cantidad >= 2) {
			int r = 0;
			while (cantidad >= 2) {

				cantidad = cantidad - 2;
				r++;
			}
			System.out.println(r + " Monedas de 2€");
		}
		if (cantidad <= 2 && cantidad >= 1) {
			int t = 0;
			while (cantidad >= 1) {

				cantidad = cantidad - 1;
				t++;
			}
			System.out.println(t + " Monedas de 1€");
		}
		if (cantidad <= 1 && cantidad >= 0.5) {
			int q = 0;
			while (cantidad >= 0.5) {

				cantidad = (float) (cantidad - 0.5);
				q++;
			}
			System.out.println(q + " Monedas de 0.50€");
		}
		if (cantidad <= 0.5 && cantidad >= 0.2) {
			int y = 0;
			while (cantidad >= 0.2) {

				cantidad = (float) (cantidad - 0.2);
				y++;
			}
			System.out.println(y + " Monedas de 0.20€");
		}
		if (cantidad <= 0.2 && cantidad >= 0.1) {
			int u = 0;
			while (cantidad >= 0.1) {

				cantidad = (float) (cantidad - 0.1);
				u++;
			}
			System.out.println(u + " Monedas de 0.10€");
		}
		if (cantidad <= 0.1 && cantidad >= 0.05) {
			int p = 0;
			while (cantidad >= 0.05) {

				cantidad = (float) (cantidad - 0.05);
				p++;
			}
			System.out.println(p + " Monedas de 0.05€");
		}
		if (cantidad <= 0.05 && cantidad >= 0.02) {
			int o = 0;
			while (cantidad >= 0.02) {

				cantidad = (float) (cantidad - 0.02);
				o++;
			}
			System.out.println(o + " Monedas de 0.02€");
		}
		if (cantidad <= 0.02 && cantidad >= 0.01) {
			int l = 0;
			while (cantidad >= 0.01) {

				cantidad = (float) (cantidad - 0.01);
				l++;
			}
			System.out.println(l + " Monedas de 0.01€");

		}
	}else if(metodopago==2)
	{
		System.out.println("Ha elegido tarjeta");

		System.out.println("Escriba el numero de su tarjeta");

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
}}
