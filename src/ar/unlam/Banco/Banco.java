package ar.unlam.Banco;

import java.util.LinkedList;
import java.util.List;

import ar.unlam.Cliente.Cliente;
import ar.unlam.Cuenta.Cuenta;
import ar.unlam.Cuenta.CuentaCorriente;

public class Banco {

	private String nombreBanco;
	private List<Cliente> listaCliente = new LinkedList<>();
	private List<Cuenta> listaCuenta = new LinkedList<>();
	private final Double saldoMinimoVip = 1000000.0;

	public Banco(String nombreBanco) {
		setNombreBanco(nombreBanco);
	}
	
	private void setNombreBanco(String nombreBanco) {
		if(nombreBanco == null || nombreBanco.isBlank())
			throw new IllegalArgumentException("El nombre del banco no puede ser nulo o vacío.");
		this.nombreBanco = nombreBanco;
	}

	public boolean agregarNuevoCliente(Cliente nuevoCliente) {
		if(nuevoCliente == null)
			throw new IllegalArgumentException("El cliente no puede ser null.");
		for(Cliente cliente : listaCliente) {
			if(cliente.getClienteID() == nuevoCliente.getClienteID())
				return false;
		}
		listaCliente.add(nuevoCliente);
		return true;
	}
	
	private Boolean clienteExiste(Integer clienteID) {
		if(clienteID == null || clienteID <= 0)
			throw new IllegalArgumentException("El id del cliente no puede ser nulo o menor a cero.");
		for(Cliente cliente : listaCliente) {
			if(cliente.getClienteID() == clienteID)
				return true;
		}
		return false;
	}

	public boolean agregarCuenta(Cuenta cuentaNueva) {
		if(cuentaNueva == null)
			throw new IllegalArgumentException("La cuenta no puede ser nula");
		if(!clienteExiste(cuentaNueva.getClienteID()))
			return false;
		listaCuenta.add(cuentaNueva);
		return true;
	}

	public boolean esClienteVip(Integer clienteID) {
		if(clienteID == null || clienteID <= 0)
			throw new IllegalArgumentException("El cliente no puede ser nulo, menor o igual a cero.");
		if(!clienteExiste(clienteID)) {
			return false;
		}
		Double saldoTotal = 0.0;
		for(Cuenta cuenta : listaCuenta) {
			if(cuenta.getClienteID() == clienteID) {
				if(cuenta instanceof CuentaCorriente) {
					CuentaCorriente test = (CuentaCorriente)cuenta;
					if(test.getDescubiertoActual() + test.getDeuda() >0) {
						return false;
					}
				}
				saldoTotal += cuenta.getSaldo();
			}
		}
		return saldoTotal > saldoMinimoVip;
	}

}
