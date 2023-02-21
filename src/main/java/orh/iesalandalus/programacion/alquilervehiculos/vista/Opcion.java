package orh.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Opcion {
	SALIR("Salir"), INSERTAR_CLIENTE("Insertar Cliente"), INSERTAR_TURISMO("Insertar Turismo"),
	INSERTAR_ALQUILER("Insertar Alquiler"), BUSCAR_CLIENTE("Buscar Cliente"), BUSCAR_TURISMO("Buscar Turismo"),
	BUSCAR_ALQUILER("Buscar Alquiler"), MODIFICAR_CLIENTE("Modificar Cliente"), DEVOLVER_ALQUILER("Devolver Alquiler"),
	BORRAR_CLIENTE("Borrar Cliente"), BORRAR_TURISMO("Borrar Turismo"), BORRAR_ALQUILER("Borrar Alquiler"),
	LISTAR_CLIENTES("Listar Clientes"), LISTAR_TURISMOS("Listar Turismos"), LISTAR_ALQUILERES("Listar Alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar Alquileres Cliente"), LISTAR_ALQUILERES_TURISMO("Listar Alquileres Turismo");

	private String texto;

	private Opcion(String texto) {
		this.texto = texto;
	}

	private boolean esOrdinalValido(int ordinal) {
		if (ordinal < Opcion.values().length || ordinal > Opcion.values().length) {
			return true;
		}
		return false;

	}

	public Opcion get(int ordinal) throws OperationNotSupportedException {
		Opcion opcion = null;
		esOrdinalValido(ordinal);

		if (!(esOrdinalValido(ordinal))) {
			throw new OperationNotSupportedException("ERROR: El ordinal no es válido.");
		}

		return opcion;
	}

	@Override

	public String toString() {
		return texto;

	}

}
