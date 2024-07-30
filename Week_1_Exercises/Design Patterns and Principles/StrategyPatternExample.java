public interface PaymentStrategy {
    void pay(double amount);
}
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using credit card (" + cardNumber + ")");
    }
}
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal (Email: " + email + ")");
    }
}
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
public class TestPaymentStrategy {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");

        PaymentContext context1 = new PaymentContext(creditCard);
        context1.executePayment(100.0);

        PaymentContext context2 = new PaymentContext(payPal);
        context2.executePayment(50.0);
    }
}