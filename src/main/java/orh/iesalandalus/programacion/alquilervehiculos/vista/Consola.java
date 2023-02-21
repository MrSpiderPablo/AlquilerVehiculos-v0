package orh.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static final String PATRON_FECHA = "dd/MM/yyyy";

	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {
		// Esta clase sólo usa métodos estáticos
	}

	public static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);

		for (int i = 0; i < mensaje.length(); i++) {
			System.out.print("_");
		}
	}

	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);

		String cadena = "";

		cadena = Entrada.cadena();

		return cadena;

	}

	private static Integer leerEntero(String mensaje) {
		System.out.println(mensaje);

		int numero = 0;

		numero = Entrada.entero();

		return numero;

	}

	private static LocalDate leerFecha(String mensaje) {
		System.out.println(mensaje);

		String fecha;

		LocalDate fechaDef;

		fecha = Entrada.cadena();

		while (!(fecha.matches(PATRON_FECHA))) {
			fecha = Entrada.cadena();
		}

		fechaDef = LocalDate.parse(fecha);

		return fechaDef;

	}

	public static Cliente leerCliente() {
		leerNombre();
		leerTelefono();
		leerClienteDni();
		return null;

	}

	public static Cliente leerClienteDni() {

		leerCadena("Introduce el DNI del cliente: ");

		String dni;

		dni = Entrada.cadena();

		Cliente cliente = null;

		cliente = new Cliente("Calamardo Tentáculos", dni, "950141187");

		return cliente;

	}

	public static String leerNombre() {
		leerCadena("Introduce el nombre del cliente: ");
		String nombre = "";

//		System.out.println("Introduce el nombre del cliente: ");
		nombre = Entrada.cadena();

		return nombre;

	}

	public static String leerTelefono() {
		leerCadena("Introduce el teléfono del cliente: ");
		String telefono = "";

		telefono = Entrada.cadena();

		return telefono;

	}

	public static Turismo leerTurismo() {
		leerTurismoMatricula();
		return null;

	}

	public static Turismo leerTurismoMatricula() {
		leerCadena("Introduce la matrícula del turismo: ");

		String matricula;

		matricula = Entrada.cadena();

		Turismo turismo = null;

		turismo = new Turismo("Rolls-Royce", "1111BBB", 2000, matricula);

		return turismo;

	}

	public static LocalDate leerFechaDevolucion() {
		leerFecha("Introduce la fecha de devolución: ");

		String fecha;

		LocalDate fechaDev;

		fecha = Entrada.cadena();

		fechaDev = LocalDate.parse(fecha);

		return fechaDev;

	}

}