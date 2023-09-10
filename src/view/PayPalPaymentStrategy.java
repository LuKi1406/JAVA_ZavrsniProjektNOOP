package view;

public class PayPalPaymentStrategy implements WayOfPaymentStrategy {

    @Override
    public String payment() {
        return "PayPal";
    }

   
    @Override
    public String toString() {
        return "PayPal";
    }
}
