package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {
	private Clientes clientes;

	private Turismos turismos;

	private Alquileres alquileres;

	public Modelo() {
		clientes = null;

		turismos = null;

		alquileres = null;
	}

	public void comenzar() {
		clientes = new Clientes();

		turismos = new Turismos();

		alquileres = new Alquileres();
	}

	public void terminar() {
		System.out.println("El modelo ha terminado.");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		clientes.insertar(new Cliente(cliente.getNombre(), cliente.getDni(), cliente.getTelefono()));
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}

		turismos.insertar(
				new Turismo(turismo.getMarca(), turismo.getModelo(), turismo.getCilindrada(), turismo.getMatricula()));
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}

		buscar(alquiler.getCliente());
		buscar(alquiler.getTurismo());

		alquileres.insertar(new Alquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler()));
	}

	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}

		clientes.buscar(cliente);

		return new Cliente(cliente.getNombre(), cliente.getDni(), cliente.getTelefono());

	}

	public Turismo buscar(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}

		turismos.buscar(turismo);
		return new Turismo(turismo.getMarca(), turismo.getModelo(), turismo.getCilindrada(), turismo.getMatricula());

	}

	public Alquiler buscar(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}

		alquileres.buscar(alquiler);
		return new Alquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());

	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo. ");
		}

		if (alquiler != null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}

		alquiler.devolver(fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		alquileres.get(cliente);

		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		alquileres.get(turismo);
		turismos.borrar(turismo);

	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
//		borrar(alquiler.getCliente());
//		borrar(alquiler.getTurismo());
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		clientes.get();
		return new ArrayList<>();

	}

	public List<Turismo> getTurismos() {
		turismos.get();
		return new ArrayList<>();

	}

	public List<Alquiler> getAlquileres() {
		alquileres.get();
		return new ArrayList<>();

	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		alquileres.get(cliente);
		return new ArrayList<>();

	}

	public List<Alquiler> getAlquileres(Turismo turismo) {
		alquileres.get(turismo);
		return new ArrayList<>();

	}
}
