package br.com.codenation.paymentmethods;

public class CashPayment implements PriceStrategy{

    public static final double DISCOUNT_RATE = 0.9;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT_RATE;
    }
}
