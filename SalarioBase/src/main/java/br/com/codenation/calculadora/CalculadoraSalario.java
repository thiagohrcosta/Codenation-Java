package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		if (salarioBase < 1039) {
			return 0;
		}
		return Math.round(salarioBase - calcularInss(salarioBase) - calcularIrpf(salarioBase));

	}

	private double calcularInss(double salarioBase) {

		double inssDiscount;

		if (salarioBase <= 1500){
			inssDiscount = salarioBase * Aliquotas.INSS_1500.getAliquota();
		}
		else if (salarioBase <= 4000){
			inssDiscount = salarioBase * Aliquotas.INSS_4000.getAliquota();
		}
		else{
			inssDiscount = salarioBase * Aliquotas.INSS_6000.getAliquota();
		}
		return inssDiscount;
	}

	private double calcularIrpf(double salarioBase) {

		double irpfDiscount;
		salarioBase = salarioBase - calcularInss(salarioBase);

		if (salarioBase <= 3000) {
			irpfDiscount = Aliquotas.IRPF_0.getAliquota();
		} else if (salarioBase <= 6000) {
			irpfDiscount = salarioBase * Aliquotas.IRPF_3000.getAliquota();
		} else {
			irpfDiscount = salarioBase * Aliquotas.IRPF_6000.getAliquota();
		}
		return irpfDiscount;
	}


	public enum Aliquotas {

		INSS_1500(0.08),
		INSS_4000(0.09),
		INSS_6000(0.11),
		IRPF_0(0),
		IRPF_3000(0.075),
		IRPF_6000(0.15);

		private double aliquota;

		Aliquotas(double aliquota){
			this.aliquota = aliquota;
		}
		public double getAliquota(){
			return this.aliquota;
		}
	}
}