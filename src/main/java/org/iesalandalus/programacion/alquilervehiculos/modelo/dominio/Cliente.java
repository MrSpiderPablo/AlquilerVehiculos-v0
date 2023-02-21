package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

//import modelo.Cliente;

public class Cliente {
	private static final String ER_NOMBRE = "[A-ZÁÉÍÓÚ][a-záéíóú]* [A-ZÁÉÍÓÚ][a-záéíóú]*";

	private static final String ER_DNI = "\\d{8}[A-Za-z]";

	private static final String ER_TELEFONO = "\\d{9}";

	private String nombre;
	private String dni;
	private String telefono;

	public Cliente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	public Cliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}

		setNombre(cliente.getNombre());
		setDni(cliente.getDni());
		setTelefono(cliente.getTelefono());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
//		if (nombre.trim().isEmpty()) 
//		{
//			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
//		}

		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}

		if (telefono.length() < 9 || telefono.length() > 9) {
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		}

//		if (!telefono.equals(ER_TELEFONO)) 
//		{
//			throw new IllegalArgumentException("ERROR: El telefono no es correcto");
//		}
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}

//		if (dni.length() < 9 || dni.length() > 9) 
//		{
//			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
//		}
		if (!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if (!(comprobarLetraDni(dni))) {
			throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
		}
		comprobarLetraDni(dni);
		this.dni = dni;
	}

	private boolean comprobarLetraDni(String dni) {

		String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numero = Integer.parseInt(dni.substring(0, 8));
		char letra = dni.charAt(8);
		return letra == letrasDni.charAt(numero % 23);

	}

	public static Cliente getClienteConDni(String dni) {
		Cliente cliente = null;

		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}

		if (!dni.isEmpty()) {
			cliente = new Cliente("Calamardo Tentáculos", dni, "950141187");
		}

		return cliente;

	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return String.format("%s - %s (%s)", nombre, dni, telefono);
	}

}
