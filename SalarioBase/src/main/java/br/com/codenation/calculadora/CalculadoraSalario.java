package br.com.codenation.calculadora;


public class CalculadoraSalario {

    private final double ALIQUOTA_INSS_1500 = 0.08;
    private final double ALIQUOTA_INSS_4000 = 0.09;
    private final double ALIQUOTA_INSS_6000 = 0.11;

    private final double ALIQUOTA_IRPF_0 = 0;
    private final double ALIQUOTA_IRPF_3000 = 0.075;
    private final double ALIQUOTA_IRPF_6000 = 0.15;

	public long calcularSalarioLiquido(double salarioBase) {

		if (salarioBase < 1039) {
			return 0;
		}
		return Math.round(salarioBase - calcularInss(salarioBase) - calcularIrpf(salarioBase));

	}
	
	private double calcularInss(double salarioBase) {

		double inssDiscount;

		if (salarioBase <= 1500){
			inssDiscount = salarioBase * ALIQUOTA_INSS_1500;
		}
		else if (salarioBase <= 4000){
			inssDiscount = salarioBase * ALIQUOTA_INSS_4000;
		}
		else{
			inssDiscount = salarioBase * ALIQUOTA_INSS_6000;
		}
		return inssDiscount;
	}

	private double calcularIrpf(double salarioBase) {

		double irpfDiscount;
		salarioBase = salarioBase - calcularInss(salarioBase);

		if (salarioBase <= 3000) {
			irpfDiscount = ALIQUOTA_IRPF_0;
		} else if (salarioBase <= 6000) {
			irpfDiscount = salarioBase * ALIQUOTA_IRPF_3000;
		} else {
			irpfDiscount = salarioBase * ALIQUOTA_IRPF_6000;
		}
		return irpfDiscount;
	}

}
