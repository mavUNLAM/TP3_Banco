package ar.unlam.Banco;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.unlam.Cliente.Cliente;
import ar.unlam.Cuenta.CajaAhorro;
import ar.unlam.Cuenta.Cuenta;
import ar.unlam.Cuenta.CuentaCorriente;
import ar.unlam.Cuenta.CuentaSueldo;

public class BancoTest {

	/*
	 * A su vez cada Cliente puede tener una o varias cuentas en el banco. Basado en el saldo que los
	 * clientes tienen en sus cuentas, el banco los clasifica en VIP. Actualmente todos aquellos
	 * clientes con una sumatoria de saldo mayor a $ 1.000.000 y sin tener ninguna cuenta con saldo
	 * negativo, son considerados como VIP. Se solicita tener disponible la lista de clientes VIP.
	 */
	
	@Test
	public void comprobarQueUnClienteSeaVIPDeFormaExitosa() {
		final Cliente clienteTest1 = new Cliente(1, "Pepito El Pistolero");
		final String nombreBanco = "Banco Estafador";
		final Double saldoInicial = 170000.0;
		final Cuenta cuentaTest1 = new CuentaSueldo(clienteTest1.getClienteID(),saldoInicial);
		final Cuenta cuentaTest2 = new CajaAhorro(clienteTest1.getClienteID(),saldoInicial);
		final Cuenta cuentaTest3 = new CuentaCorriente(clienteTest1.getClienteID(),saldoInicial);
		final Cuenta cuentaTest4 = new CuentaSueldo(clienteTest1.getClienteID(),saldoInicial);
		final Cuenta cuentaTest5 = new CajaAhorro(clienteTest1.getClienteID(),saldoInicial);
		final Cuenta cuentaTest6 = new CuentaCorriente(clienteTest1.getClienteID(),saldoInicial);
		final Cuenta cuentaTest7 = new CuentaSueldo(clienteTest1.getClienteID(),saldoInicial);
		
		
		Banco bancoTest = new Banco(nombreBanco);
		
		assertTrue(bancoTest.agregarNuevoCliente(clienteTest1));
		
		assertTrue(bancoTest.agregarCuenta(cuentaTest1));
		assertTrue(bancoTest.agregarCuenta(cuentaTest2));
		assertTrue(bancoTest.agregarCuenta(cuentaTest3));
		assertTrue(bancoTest.agregarCuenta(cuentaTest4));
		assertTrue(bancoTest.agregarCuenta(cuentaTest5));
		assertTrue(bancoTest.agregarCuenta(cuentaTest6));
		assertTrue(bancoTest.agregarCuenta(cuentaTest7));
		
		assertTrue(bancoTest.esClienteVip(clienteTest1.getClienteID()));
		
	}

}
