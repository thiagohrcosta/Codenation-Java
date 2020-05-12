package br.com.codenation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) IntStream.of(elements).average().getAsDouble();
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
		int tamanhoArray = elements.length;
		int mediana;
		int divisao = tamanhoArray / 2;

		if (elements.length % 2 == 0) {
			return (elements[divisao] + elements[divisao - 1]) / 2;
		} else {
			mediana = elements[divisao];
		}
		return mediana;
	}
}