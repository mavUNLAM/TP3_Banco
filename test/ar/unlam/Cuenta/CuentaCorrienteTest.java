package ar.unlam.Cuenta;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaCorrienteTest {

	/*
	 * 
	 */
	@Test
	public void queSeCobreCincoPorcientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldo() {
		final Double deposito1 = 100.0;
		final Double saldoEsperado = deposito1;
		final Double extraccion = 200.0;
		final Double saldoEsperado2 = 0.0;
		final Double descubiertoEsperado1 = 100.0;
		final Double deudaEsperada1 = 5.0;
		final Double deposito2 = 200.0;
		final Double saldoEsperado3 = 95.0;
		final Double descubiertoEsperado2 = 0.0;
		final Double deudaEsperada2 = 0.0;
		
		CuentaCorriente cuentaCorriente = new CuentaCorriente(1, deposito1);
		
		assertEquals(cuentaCorriente.getSaldo(), saldoEsperado);
		
		cuentaCorriente.extraerDinero(extraccion);
		
		assertEquals(saldoEsperado2, cuentaCorriente.getSaldo());
		
		assertEquals(descubiertoEsperado1, cuentaCorriente.getDescubiertoActual());
		
		assertEquals(deudaEsperada1, cuentaCorriente.getDeuda());
		
		cuentaCorriente.depositarDinero(deposito2);
		
		assertEquals(saldoEsperado3, cuentaCorriente.getSaldo());
		
		assertEquals(cuentaCorriente.getDescubiertoActual(), descubiertoEsperado2);
		
		assertEquals(cuentaCorriente.getDeuda(), deudaEsperada2);
	}
	
	@Test
	public void queSeCobreElCincoPorCientoDeComisionPorMasQueElProximoDepositoNoSeaSuficieteParaCubrirElDescubierto() {
		final Double deposito1 = 100.0;
		final Double saldoEsperado1 = deposito1;
		final Double descubiertoEsperado1 = 0.0;
		final Double deudaEsperada1 = 0.0;
		
		final Double extraccion1 = 200.0;
		final Double saldoEsperado2 = 0.0;
		final Double descubiertoEsperado2 = 100.0;
		final Double deudaEsperada2 = 5.0;
		
		final Double deposito2 = 100.0;
		final Double saldoEsperado3 = 0.0;
		final Double descubiertoEsperado3 = 5.0;
		final Double deudaEsperada3 = 0.0;
		
		CuentaCorriente cuentaTest = new CuentaCorriente(1);
		
		assertTrue(cuentaTest.depositarDinero(deposito1));
		assertEquals(saldoEsperado1,cuentaTest.getSaldo());
		assertEquals(descubiertoEsperado1, cuentaTest.getDescubiertoActual());
		assertEquals(deudaEsperada1, cuentaTest.getDeuda());
		
		assertTrue(cuentaTest.extraerDinero(extraccion1));
		assertEquals(saldoEsperado2,cuentaTest.getSaldo());
		assertEquals(descubiertoEsperado2, cuentaTest.getDescubiertoActual());
		assertEquals(deudaEsperada2, cuentaTest.getDeuda());
		
		assertTrue(cuentaTest.depositarDinero(deposito2));
		assertEquals(saldoEsperado3,cuentaTest.getSaldo());
		assertEquals(descubiertoEsperado3, cuentaTest.getDescubiertoActual());
		assertEquals(deudaEsperada3, cuentaTest.getDeuda());
		
	}
	
	@Test
	public void queUnaExtraccionCuandoYaSeTieneDeudaIncrementeLaDeuda() {
		final Double deposito = 100.0;
		final Double saldoEsperado1 = deposito;
		final Double descubiertoEsperado1 = 0.0;
		final Double deudaEsperada1 = 0.0;
		
		final Double extraccion1 = 200.0;
		final Double saldoEsperado2 = 0.0;
		final Double descubiertoEsperado2 = 100.0;
		final Double deudaEsperada2 = 5.0;
		
		final Double extraccion2 = 50.0;
		final Double saldoEsperado3 = 0.0;
		final Double descubiertoEsperado3 = 150.0;
		final Double deudaEsperada3 = 7.50;
		
		CuentaCorriente cajaTest = new CuentaCorriente(1);
		
		assertTrue(cajaTest.depositarDinero(deposito));
		assertEquals(saldoEsperado1, cajaTest.getSaldo());
		assertEquals(descubiertoEsperado1, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperada1, cajaTest.getDeuda());
		
		assertTrue(cajaTest.extraerDinero(extraccion1));
		assertEquals(saldoEsperado2, cajaTest.getSaldo());
		assertEquals(descubiertoEsperado2, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperada2, cajaTest.getDeuda());
		
		assertTrue(cajaTest.extraerDinero(extraccion2));
		assertEquals(saldoEsperado3, cajaTest.getSaldo());
		assertEquals(descubiertoEsperado3, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperada3, cajaTest.getDeuda());
		
	}
	
	@Test
	public void queVariasOperacionesDeDepositoYExtraccionGenerenElSaldoYLaDeudaCorrecto() {
		final Double deposito1 = 100.0;
		final Double saldoEsperadoDep1 = 100.0;
		final Double descubiertoEsperadoDep1 = 0.0;
		final Double deudaEsperadaDep1 = 0.0;
		
		final Double extraccion1 = 200.0;
		final Double saldoEsperadoExt1 = 0.0;
		final Double descubiertoEsperadoExt1 = 100.0;
		final Double deudaEsperadaExt1 = 5.0;
		
		final Double extraccion2 = 50.0;
		final Double saldoEsperadoExt2 = 0.0;
		final Double descubiertoEsperadoExt2 = 150.0;
		final Double deudaEsperadaExt2 = 7.50;
		
		final Double deposito2 = 50.0;
		final Double saldoEsperadoDep2 = 0.0;
		final Double descubiertoEsperadoDep2 = 107.5;
		final Double deudaEsperadaDep2 = 0.0;
		
		final Double extraccion3 = 40.0;
		final Double saldoEsperadoExt3 = 0.0;
		final Double descubiertoEsperadoExt3 = 147.5;
		final Double deudaEsperadaExt3 = 2.0;
		
		final Double deposito3 = 150.0;
		final Double saldoEsperadoDep3 = 0.50;
		final Double descubiertoEsperadoDep3 = 0.0;
		final Double deudaEsperadaDep3 = 0.0;
		
		CuentaCorriente cajaTest = new CuentaCorriente(1);
		
		assertTrue(cajaTest.depositarDinero(deposito1));
		assertEquals(saldoEsperadoDep1, cajaTest.getSaldo());
		assertEquals(descubiertoEsperadoDep1, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperadaDep1, cajaTest.getDeuda());
		
		assertTrue(cajaTest.extraerDinero(extraccion1));
		assertEquals(saldoEsperadoExt1, cajaTest.getSaldo());
		assertEquals(descubiertoEsperadoExt1, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperadaExt1, cajaTest.getDeuda());
		
		assertTrue(cajaTest.extraerDinero(extraccion2));
		assertEquals(saldoEsperadoExt2, cajaTest.getSaldo());
		assertEquals(descubiertoEsperadoExt2, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperadaExt2, cajaTest.getDeuda());
		
		assertTrue(cajaTest.depositarDinero(deposito2));
		assertEquals(saldoEsperadoDep2, cajaTest.getSaldo());
		assertEquals(descubiertoEsperadoDep2, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperadaDep2, cajaTest.getDeuda());
		
		assertTrue(cajaTest.extraerDinero(extraccion3));
		assertEquals(saldoEsperadoExt3, cajaTest.getSaldo());
		assertEquals(descubiertoEsperadoExt3, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperadaExt3, cajaTest.getDeuda());
		
		assertTrue(cajaTest.depositarDinero(deposito3));
		assertEquals(saldoEsperadoDep3, cajaTest.getSaldo());
		assertEquals(descubiertoEsperadoDep3, cajaTest.getDescubiertoActual());
		assertEquals(deudaEsperadaDep3, cajaTest.getDeuda());
		
	}

}
