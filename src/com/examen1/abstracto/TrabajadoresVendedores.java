package com.examen1.abstracto;

public class TrabajadoresVendedores extends Nomina{
	int salarioVendedores;
	@Override
	public String pagar() {
		return "Se le ha pagado: "+salarioVendedores+" a los vendedores";
	}
	@Override
	public String aumentarSalario(int aumento) {
		salarioVendedores += aumento;
		String res="Se ha aumentado: "+aumento + " a la nomina de los vendedores, salario total: "+salarioVendedores;
		return res;
	}
	@Override
	public String reducirSalario(int monto) {
		salarioVendedores -= monto;
		String res="Se ha reducido: "+monto + " a la nomina de los vendedores, salario total: "+salarioVendedores;
		return res;
	}
}
