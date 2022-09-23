package ar.unlam.Cuenta;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaSueldoTest {

	/*
		Es el tipo de cuenta más simple, ya que se rige por la premisa
		de que en tanto y en cuanto se tenga tanto o más dinero en
		cuenta del que se quiere extraer, la operación se debe
		efectuar correctamente.
	 */
	
	@Test
	public void extraerDeFormaExitosaCuandoSeTieneSaldoSuficiente() {
		final Double saldo = 1000.0;
		final Double extraccion = 500.0;
		final Integer clienteID = 1;
		final Double saldoEsperado = saldo - extraccion;
		
		Cuenta cuentaSaldo = new CajaAhorro(clienteID, saldo);
		
		assertTrue(cuentaSaldo.extraerDinero(extraccion));
		assertEquals(cuentaSaldo.getSaldo(), saldoEsperado);
	}
	
	@Test
	public void depositarDineroYRevisarQueElSaldoSeaCorrectoAlFinalizar() {
		final Double saldo = 1000.0;
		final Double deposito = 600.0;
		final Integer clienteID = 1;
		final Double saldoEsperado = saldo + deposito;
		
		Cuenta cuentaSaldo = new CajaAhorro(clienteID, saldo);
		assertTrue(cuentaSaldo.depositarDinero(deposito));
		assertEquals(cuentaSaldo.getSaldo(), saldoEsperado);
	}

}
