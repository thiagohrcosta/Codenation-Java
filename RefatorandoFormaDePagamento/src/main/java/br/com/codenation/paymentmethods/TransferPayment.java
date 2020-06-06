package br.com.codenation.paymentmethods;

public class TransferPayment implements PriceStrategy {

    private static final double DISCOUNT_RATE = 0.92;
    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT_RATE;
    }
}
