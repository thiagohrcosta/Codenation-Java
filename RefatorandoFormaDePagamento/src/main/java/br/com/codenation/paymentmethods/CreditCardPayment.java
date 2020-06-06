package br.com.codenation.paymentmethods;

public class CreditCardPayment implements PriceStrategy {

    private static final double DISCOUNT_RATE = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT_RATE;
    }
}
