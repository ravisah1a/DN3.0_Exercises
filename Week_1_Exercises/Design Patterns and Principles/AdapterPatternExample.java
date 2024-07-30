public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypalGateway;
    public PayPalAdapter(PayPalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    public void processPayment() {
        paypalGateway.makePayment();
    }
}
public interface PaymentProcessor {
    void processPayment();
}

public class PayPalGateway {
    public void makePayment() {

        System.out.println("Processing payment via PayPal...");
    }
}

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypalGateway;
public PayPalAdapter(PayPalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    public void processPayment() {
        paypalGateway.makePayment();
    }
}

public class PaymentGatewayTest {
    public static void main(String[] args) {
        PayPalGateway paypalGateway = new PayPalGateway();
        PaymentProcessor paypalAdapter = new PayPalAdapter(paypalGateway);
        paypalAdapter.processPayment();
    }
}
