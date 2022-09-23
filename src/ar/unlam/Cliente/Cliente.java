package ar.unlam.Cliente;

public class Cliente {
	private Integer clienteID;
	private String nombre;
	
	public Cliente(Integer clienteID, String nombreCliente) {
		setClienteID(clienteID);
		setNombreCliente(nombreCliente);
	}
	
	private void setClienteID(Integer clienteID) {
		if(clienteID == null || clienteID <= 0)
			throw new IllegalArgumentException("El id no puede ser menor, igual a cero o nulo.");
		this.clienteID = clienteID;
	}
	
	private void setNombreCliente(String nombreCliente) {
		if(nombreCliente == null || nombreCliente.isBlank())
			throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o blanco.");
		this.nombre = nombreCliente;
	}

	public Integer getClienteID() {
		return clienteID;
	}

	public String getNombre() {
		return nombre;
	}

}
