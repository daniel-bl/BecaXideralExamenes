package com.examen1.interfaces;

public class TrabajadoresRepartidores implements Nomina{
	int salarioRepartidores;
	@Override
	public String pagar() {
		// TODO Auto-generated method stub
		return "Se le ha pagado a los repartidores";
	}

	@Override
	public String aumentarSalario(int aumento) {
		salarioRepartidores += aumento;
		String res="Se ha aumentado: "+aumento + " a la nomina de los trabajadores de oficina, salario total: "+salarioRepartidores;
		return res;
	}
	
	@Override
	public String reducirSalario(int monto) {
		salarioRepartidores -= monto;
		String res="Se ha reducido: "+monto + " a la nomina de los trabajadores de oficina, salario total: "+salarioRepartidores;
		return res;
	}
}
