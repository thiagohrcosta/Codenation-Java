package br.com.codenation.paymentmethods;

public class DebitCardPayment implements PriceStrategy{

    private final static double DISCOUNT_RATE = 0.95;
    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT_RATE;
    }
}
