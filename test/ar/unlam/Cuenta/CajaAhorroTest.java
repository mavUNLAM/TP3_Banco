package ar.unlam.Cuenta;

import static org.junit.Assert.*;

import org.junit.Test;

public class CajaAhorroTest {

	/*
	 * Similar a la anterior, pero se pide que luego de la
	 * quinta extracción de dinero se cobre un costo adicional
	 * por extracción de $6
	 */
	
	@Test
	public void luedoDeLaQuintaExtraccionSeCobraUnCostoAdicionalDe6() {
		final Integer clienteID = 1;
		final Double saldo = 20000.0;
		final Double extraccion1 = 100.0;
		final Double extraccion2 = 100.0;
		final Double extraccion3 = 100.0;
		final Double extraccion4 = 100.0;
		final Double extraccion5 = 100.0;
		final Double extraccion6 = 100.0;
		final Double costoAdicional = 6.0;
		final Double saldoEsperado = saldo -
				extraccion1 - extraccion2 - extraccion3
				- extraccion4 - extraccion5 - extraccion6
				- costoAdicional;
		Cuenta cajaAhorro = new CajaAhorro(clienteID, saldo);
		assertTrue(cajaAhorro.extraerDinero(extraccion1));
		assertTrue(cajaAhorro.extraerDinero(extraccion2));
		assertTrue(cajaAhorro.extraerDinero(extraccion3));
		assertTrue(cajaAhorro.extraerDinero(extraccion4));
		assertTrue(cajaAhorro.extraerDinero(extraccion5));
		assertTrue(cajaAhorro.extraerDinero(extraccion6));
		assertEquals(cajaAhorro.getSaldo(), saldoEsperado);
				
	}

	
}
