package view;

public class GooglePayPaymentStrategy implements WayOfPaymentStrategy {

 
    @Override
    public String payment() {
        return "GooglePay";
    }

 
    @Override
    public String toString() {
        return "GooglePay";
    }
}
