package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        Field [] fields = obj.getClass().getDeclaredFields();
        return calcularBigDecimal(fields,"somar", obj);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        Field [] fields = obj.getClass().getDeclaredFields();
        return calcularBigDecimal(fields, "subtrair", obj);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return somar(obj).subtract(subtrair(obj));
    }

    public BigDecimal calcularBigDecimal(Field[] fields, String annotation, Object obj){
        BigDecimal bigDec = BigDecimal.ZERO;

        for (Field field: fields) {
            field.setAccessible(true);
            if (annotation.contains("somar")) {
                if (field.isAnnotationPresent(Somar.class) && field.getType().equals(BigDecimal.class)) {
                    try {
                        bigDec = bigDec.add((BigDecimal) field.get(obj));
                    } catch (IllegalAccessException e) {
                        System.out.print(e.getMessage());
                    }
                }
            }
            else{
                if(field.isAnnotationPresent(Subtrair.class) && field.getType().equals(BigDecimal.class)){
                    try {
                        bigDec = bigDec.add((BigDecimal) field.get(obj));
                    } catch (IllegalAccessException e) {
                        System.out.print(e.getMessage());
                    }
                }
            }
        }
        return bigDec;
    }


}
