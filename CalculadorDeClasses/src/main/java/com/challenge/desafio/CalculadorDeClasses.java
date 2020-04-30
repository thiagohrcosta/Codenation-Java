package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    BigDecimal soma = BigDecimal.ZERO;
    int value = 0;

    @Override
    public BigDecimal somar(Object obj) {

        validadorSoma(obj);

        if (value == 0) {
            return BigDecimal.ZERO;
        } else {
            return soma;
        }
    }

    @Override
    public BigDecimal subtrair(Object obj) {

        validadorSubtracao(obj);

        if (value == 0) {
            return BigDecimal.ZERO;
        } else {
            return soma;
        }
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return somar(obj).subtract(subtrair(obj));
    }

    public void validadorSoma(Object obj) {
        for (Field atributo : obj.getClass().getDeclaredFields()) {
            atributo.setAccessible(true);
            if (atributo.isAnnotationPresent(Somar.class) && atributo.getType().equals(BigDecimal.class)) {
                try {
                    soma = soma.add((BigDecimal) atributo.get(obj));
                    value++;
                } catch (IllegalAccessException e) {
                    System.out.print("Erro");
                }
            }
        }
    }

    public void validadorSubtracao(Object obj) {
        for (Field atributo : obj.getClass().getDeclaredFields()) {
            atributo.setAccessible(true);
            if (atributo.isAnnotationPresent(Subtrair.class) && atributo.getType().equals(BigDecimal.class)) {
                try {
                    soma = soma.add((BigDecimal) atributo.get(obj));
                    value++;
                } catch (IllegalAccessException e) {
                    System.out.print("Erro");
                }
            }
        }
    }

}
