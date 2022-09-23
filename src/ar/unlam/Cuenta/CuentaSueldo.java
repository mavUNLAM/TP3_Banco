package ar.unlam.Cuenta;



public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(Integer clienteID) {
		super(clienteID);
	}
	
	public CuentaSueldo(Integer clienteID, Double saldo) {
		super(clienteID, saldo);
	}

	
	
	@Override
	public Boolean extraerDinero(Double importe) {
		comprobarImporte(importe);
		if(this.saldo - importe < 0)
			return false;
		return true;
	}

}
