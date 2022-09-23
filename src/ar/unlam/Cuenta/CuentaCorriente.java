package ar.unlam.Cuenta;

public class CuentaCorriente extends Cuenta {
	private Double porcentajeRecarga = 0.05;
	private Double descubiertoMaximo = 150.0;
	private Double descubiertoActual = 0.0;
	private Double deuda = 0.0;
	
	
	public CuentaCorriente(Integer clienteID) {
		super(clienteID);
	}

	public CuentaCorriente(Integer clienteID, Double saldo) {
		super(clienteID, saldo);
	}
	
	public CuentaCorriente(Integer clienteID,
			Double saldo,
			Double porcentajeRecarga,
			Double descubiertoMaximo) {
		super(clienteID, saldo);
		setPorcentajeRecarga(porcentajeRecarga);
		setDescubiertoMaximo(descubiertoMaximo);
	}
	
	@Override
	public Double getSaldo() {
		return saldo;
	}
	
	public Double getDeuda( ) {
		return deuda;
	}
	
	public Double getDescubiertoActual() {
		return descubiertoActual;
	}
	
	private void setDescubiertoMaximo(Double descubiertoMax) {
		if(descubiertoMax == null || descubiertoMax <0)
			throw new IllegalArgumentException();
		this.descubiertoMaximo = descubiertoMax;
	}
	
	private void setPorcentajeRecarga(Double porcentaje) {
		if(porcentaje == null || porcentaje < 0.0)
			throw new IllegalArgumentException();
		this.porcentajeRecarga = porcentaje/100;
	}

	@Override
	public Boolean depositarDinero(Double importe) {
		comprobarImporte(importe);
		if(importe > deuda) {
			importe -= deuda;
			deuda = 0.0;
		} else {
			deuda -= importe;
			importe = 0.0;
		}
		if(importe > descubiertoActual) {
			importe -= descubiertoActual;
			descubiertoActual = 0.0;
		} else {
			descubiertoActual -= importe;
			importe = 0.0;
		}
		this.saldo += importe;
		return true;
	}
	/*
	@Override
	public Boolean extraerDinero(Double importe) {
		comprobarImporte(importe);
		if(importe > 0) {
			if(saldo - importe >= 0) {
				saldo -= importe;
				return true;
			}
			if(saldo - importe < 0) {
				if(Math.abs(saldo - importe) < descubiertoMaximo - descubiertoActual) {
					Double descubierto = Math.abs(saldo - importe);
					descubiertoActual += descubierto;
					Double totalRecarga = Math.abs(saldo - importe) * porcentajeRecarga/100;
					saldo -= importe + totalRecarga + descubierto;
					return true;
				}
			}
		}
			
		return false;
	}
*/
	@Override
	public Boolean extraerDinero(Double importe) {
		comprobarImporte(importe);
		if(saldo - importe >= 0) {
			saldo -= importe;
			return true;
		}
		Double saldoFuturo = saldo - importe;
		if(saldoFuturo < 0.0) {
			saldoFuturo *= (-1);
			if(saldoFuturo <= descubiertoMaximo - descubiertoActual) {
				descubiertoActual += saldoFuturo;
				deuda += saldoFuturo * porcentajeRecarga;
				saldo = 0.0;
				return true;
			}
		}
		return false;
	}
}
