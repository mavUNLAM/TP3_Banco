package ar.unlam.Cuenta;

public class CajaAhorro extends Cuenta {

	private Integer cantidadExtraciones = 0;
	final private Integer cantExtracionesParaAdicional = 5;
	final private Double costoAdicional = 6.0;
	
	public CajaAhorro(Integer clienteID) {
		super(clienteID);
	}
	
	public CajaAhorro(Integer clienteID, Double saldo) {
		super(clienteID, saldo);
	}

	@Override
	public Boolean extraerDinero(Double cantidad) {
		comprobarImporte(cantidad);
		if(cantidad > 0) {
			cantidadExtraciones++;
			if(cantidadExtraciones > cantExtracionesParaAdicional)
				cantidad += costoAdicional;
			if(this.saldo - cantidad < 0) {
				cantidadExtraciones--;
				return false;
			}
			this.saldo -= cantidad;
		}
		return true;
	}

}
