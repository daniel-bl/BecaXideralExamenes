package com.examen1.abstracto;

public class TrabajadoresRepartidores extends Nomina{
	int salarioRepartidores;
	@Override
	public String pagar() {
		return "Se le ha pagado a los repartidores";
	}

	@Override
	public String aumentarSalario(int aumento) {
		salarioRepartidores += aumento;
		String res="Se ha aumentado: "+aumento + " a la nomina de los repartidores, salario total: "+salarioRepartidores;
		return res;
	}
	@Override
	public String reducirSalario(int monto) {
		salarioRepartidores -= monto;
		String res="Se ha reducido: "+monto + " a la nomina de los repartidores, salario total: "+salarioRepartidores;
		return res;
	}

}
