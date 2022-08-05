package com.examen1.abstracto;

public abstract class Nomina {
	int salario;
	
	public String pagar() {
		return "Se le ha pagado "+salario+" a los trabajadores de oficina";
	}
	
	
	public String aumentarSalario(int aumento) {
		salario += aumento;
		String res="Se ha aumentado: "+aumento + " a la nomina de los trabajadores de oficina, salario total: "+salario;
		return res;
	}
	
	public String reducirSalario(int monto) {
		salario -= monto;
		String res="Se ha reducido: "+monto + " a la nomina de los trabajadores de oficina, salario total: "+salario;
		return res;
	}
}
