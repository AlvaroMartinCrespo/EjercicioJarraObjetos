package JarraAgain;

import java.util.*;

public class Main {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int accionMenu;
		boolean bandera = true;

//		CREAMOS LAS JARRAS

		System.out.println("Creacion Jarra A:");
		Jarra A = creacionJarras();
		System.out.println("Creacion Jarra B");
		Jarra B = creacionJarras();

		do {

			try {

//				MENU	

				do {

					menu();
					accionMenu = accionMenu();
					tratarMenu(accionMenu, A, B);
					bandera=true;
				} while (accionMenu != 6);

			} catch (JarraException e) {

				System.out.println(e.getMessage());
				bandera = false;

			}

		} while (!bandera);

	}

	public static Jarra creacionJarras() {

		int capacidad;

		do {

			System.out.println("Introduce la capacidad de la jarra:");
			capacidad = entrada.nextInt();

			if (capacidad <= 0) {

				System.out.println("La jarra no puede tener una capacidad de 0 o negativa");

			}

		} while (capacidad <= 0);

		Jarra nuevaJarra = new Jarra(capacidad);

		return nuevaJarra;
	}

	public static void menu() {

		System.out.println(" ");
		System.out.println(".:MENU:.");
		System.out.println(
				"1.- Llenar jarra \n2.- Vaciar jarra \n3.- Volcar jarra A en B \n4.- Volcar jarra B en A \n5.- Ver estado de las jarras \n6.- Salir");

	}

	public static int accionMenu() throws JarraException {

		int accionMenu;

		System.out.println("¿Que desea hacer:");
		accionMenu = entrada.nextInt();

		if (accionMenu < 1 || accionMenu > 6) {

			throw new JarraException("Opcion equivocada");

		}

		return accionMenu;

	}

	public static void tratarMenu(int accion, Jarra A, Jarra B) throws JarraException {

		String jarra;

		switch (accion) {

		case 1:

			System.out.println("¿Que jarra quiere llenar? -> A - B");
			jarra = entrada.next();

			jarra = jarra.toLowerCase();
			
			if (!jarra.equals("a") && !jarra.equals("b")) {

				throw new JarraException("Opción incorrecta, no ha elegido ninguna jarra");

			}

			if (jarra.equals("a")) {

				A.llenarJarra();

			} else {

				B.llenarJarra();

			}

			break;
			
		case 2:
			 
			System.out.println("¿Que jarra quiere vaciar? -> A - B");
			jarra = entrada.next();

			jarra = jarra.toLowerCase();
			
			if (!jarra.equals("a") && !jarra.equals("b")) {

				throw new JarraException("Opción incorrecta, no ha elegido ninguna jarra");

			}

			if (jarra.equals("a")) {

				A.vaciarJarra();

			} else {

				B.vaciarJarra();

			}
			break;
			
		case 3:
			
			Jarra.volcarJarraAenB(A, B);
			break;
			
		case 4:
			Jarra.volcarJarraBenA(A, B);
			break;
			
		case 5:

			System.out.println("Jarra A: " + A.toString());
			System.out.println("Jarra B: " + B.toString());

			break;
		case 6:
			System.out
					.println("El total de agua que se ha gastado llenando jarras es de " + Jarra.totalAgua + " litros");
			break;

		}

	}

}
