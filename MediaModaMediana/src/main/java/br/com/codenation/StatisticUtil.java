package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;

		for (int elementos : elements) {
			soma += elementos;
		}
		return (soma / elements.length);
	}

	public static int mode(int[] elements) {
		int moda = elements[0];
		int somatorio = 0;

		for (int i = 0; i < elements.length; i++){
			int contador = 0;
			for(int j = 0; j < elements.length; j++){
				if(elements[j] == elements[i]) {
					contador++;
				}
			}
			if(contador  > somatorio){
				moda = elements[i];
				somatorio = contador;
			}
		}
		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int mediana = elements.length / 2;

		if (elements.length % 2 == 0) {
			return (elements[mediana] + elements[mediana + 1]) / 2;
		} else {
			return elements[mediana];
		}
	}
}