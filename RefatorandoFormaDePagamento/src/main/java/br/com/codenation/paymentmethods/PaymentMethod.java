package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new CashPayment()),
    DEBIT_CARD(new DebitCardPayment()),
    CREDIT_CARD(new CreditCardPayment()),
    TRANSFER(new TransferPayment());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}