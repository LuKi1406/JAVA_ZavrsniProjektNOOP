package view;

public class CreditCardPaymentStrategy implements WayOfPaymentStrategy {

    @Override
    public String payment() {
        return "CreditCardPayment";
    }

    @Override
    public String toString() {
        return "CreditCardPayment";
    }
}
