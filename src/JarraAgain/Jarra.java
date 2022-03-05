package JarraAgain;

public class Jarra {

//	ATRIBUTOS Y CONSTANTES
	final static int CANTIDADPORDEFECTO = 0;

	private int capacidad;
	private int cantidad;
	static int totalAgua;

//	CONSTRUCTOR

	public Jarra(int capacidad) {
		this.capacidad = capacidad;
		this.cantidad = CANTIDADPORDEFECTO;
	}

//	METODOS
	public void llenarJarra() throws JarraException {

		int cantidadAgua;

		if (this.cantidad == this.capacidad) {

			throw new JarraException("La jarra ya esta llena");

		}

		cantidadAgua = this.capacidad - this.cantidad;
		this.totalAgua += cantidadAgua;
		this.cantidad = this.capacidad;

		System.out.println("Se ha llenado un total de " + cantidadAgua + " litros de agua");

	}

	public void vaciarJarra() throws JarraException {

		int cantidadAgua;

		if (this.cantidad == 0) {

			throw new JarraException("La jarra ya esta vacía");

		}

		cantidadAgua = this.cantidad;
		System.out.println("Se ha vaciado un total de " + cantidadAgua + " litros de agua");

		this.cantidad = 0;

	}

	public static void volcarJarraAenB(Jarra A, Jarra B) throws JarraException {

		int cantidadAVolcar;
		int cantidadAgua;
		int espacio;
		int aguaNoVolcar;

		if (B.getCantidad() == B.getCapacidad()) {

			throw new JarraException("La jarra B ya esta llena");

		}

		if (A.getCantidad() == 0) {

			throw new JarraException("La jarra A esta vacía");

		}

		cantidadAgua = B.getCantidad();

		espacio = B.getCapacidad() - B.getCantidad();
		cantidadAVolcar = A.getCantidad();

		if (espacio > cantidadAVolcar) {

			B.setCantidad(B.getCantidad() + cantidadAVolcar);
			A.setCantidad(0);

		} else {

			aguaNoVolcar = cantidadAVolcar - espacio;
			B.setCantidad(B.getCantidad() + espacio);
			A.setCantidad(aguaNoVolcar);

		}

		System.out.println("La jarra se ha llenado conrrectamente");

	}

	public static void volcarJarraBenA(Jarra A, Jarra B) throws JarraException {

		int cantidadAVolcar;
		int cantidadAgua;
		int espacio;
		int aguaNoVolcar;

		if (A.getCantidad() == A.getCapacidad()) {

			throw new JarraException("La jarra B ya esta llena");

		}

		if (B.getCantidad() == 0) {

			throw new JarraException("La jarra A esta vacía");

		}

		cantidadAgua = A.getCantidad();

		espacio = A.getCapacidad() - A.getCantidad();
		cantidadAVolcar = B.getCantidad();

		if (espacio > cantidadAVolcar) {

			A.setCantidad(A.getCantidad() + cantidadAVolcar);
			B.setCantidad(0);

		} else {

			aguaNoVolcar = cantidadAVolcar - espacio;
			A.setCantidad(A.getCantidad() + espacio);
			B.setCantidad(aguaNoVolcar);

		}

		System.out.println("La jarra se ha llenado conrrectamente");

	}

//	TOSTRING

	@Override
	public String toString() {
		return "Jarra [capacidad=" + capacidad + ", cantidad=" + cantidad + "]";
	}

//	GETTERS Y SETTERS

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
