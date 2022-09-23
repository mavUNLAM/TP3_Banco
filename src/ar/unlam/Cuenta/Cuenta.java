package ar.unlam.Cuenta;

public abstract class Cuenta {
	protected Double saldo = 0.0;
	protected Integer clienteID = null;
	
	public Cuenta(Integer clienteID) {
		setClienteID(clienteID);
	}
	
	public Cuenta(Integer clienteID, Double saldo) {
		this(clienteID);
		setSaldo(saldo);
	}
	
	protected void comprobarImporte(Double importe) throws IllegalArgumentException {
		if(importe == null || importe < 0)
			throw new IllegalArgumentException("la cantidad no puede ser negativa o nula");
	}
	
	public abstract Boolean extraerDinero(Double importe);
	
	public Boolean depositarDinero(Double importe) {
		comprobarImporte(importe);
		this.saldo += importe;
		return true;
	}
	
	protected void setSaldo(Double saldo) {
		comprobarImporte(saldo);
		this.saldo = saldo;
	}
	
	protected void setClienteID(Integer clienteID) {
		if(clienteID == null || clienteID <= 0)
			throw new IllegalArgumentException("El id del cliente no puede ser 0 o negativo.");
		this.clienteID = clienteID;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public Integer getClienteID() {
		return clienteID;
	}

}
