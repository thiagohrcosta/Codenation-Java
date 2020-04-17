package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		if (salarioBase < 1039 || salarioBase < 0) {
			return 0;
		}
		else {
			return Math.round(salarioBase - calcularInss(salarioBase) - calcularIrpf(salarioBase));
		}

	}
	
	private double calcularInss(double salarioBase) {

		double inssDiscount;

		if (salarioBase <= 1500){
			inssDiscount = salarioBase * 0.08;
		}
		else if (salarioBase > 1500 && salarioBase <= 4000){
			inssDiscount = salarioBase * 0.09;
		}
		else{
			inssDiscount = salarioBase * 0.11;
		}
		return inssDiscount;
	}

	private double calcularIrpf(double salarioBase) {

		double irpfDiscount;
		salarioBase = salarioBase - calcularInss(salarioBase);

		if (salarioBase <= 3000) {
			irpfDiscount = 0;
		} else if (salarioBase > 3000 && salarioBase <= 6000) {
			irpfDiscount = salarioBase * 0.075;
		} else {
			irpfDiscount = salarioBase * 0.15;
		}
		return irpfDiscount;
	}

}


