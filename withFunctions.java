interface PaymentModule {
    public void oldPaymentMethod();
    public boolean createPayment(double amount, String description);
    public String checkPaymentStatus(String paymentId);
}

class OldPaymentModule implements PaymentModule {
    public void oldPaymentMethod() {
        System.out.println("old Payment module Api");
    }
    
    public boolean createPayment(double amount, String description) {
        System.out.println("new payment " + amount + " - " + description);
        return true;
    }
    
    public String checkPaymentStatus(String paymentId) {
        System.out.println("Checking status for: " + paymentId);
        return "uspeshna *palets vverh*";
    }
}

class PaymentAdapter implements PaymentModule {
    private OldPaymentModule oldPaymentModule;

    public PaymentAdapter(OldPaymentModule oldPaymentModule) {
        this.oldPaymentModule = oldPaymentModule;
    }

    public void oldPaymentMethod() {
        System.out.println("new payment module Api");
        oldPaymentModule.oldPaymentMethod();
    }
    
    public boolean createPayment(double amount, String description) {
        // конывертация запроса нью системы в формат старого
        return oldPaymentModule.createPayment(amount, description);
    }
    
    public String checkPaymentStatus(String paymentId) {
        // конвертация запроса нью системы в формат старого
        return oldPaymentModule.checkPaymentStatus(paymentId);
    }
}

class Main {
    public static void main(String[] args) {
        OldPaymentModule oldPaymentModule = new OldPaymentModule();
        PaymentModule paymentModule = new PaymentAdapter(oldPaymentModule);
        
        paymentModule.oldPaymentMethod();
        paymentModule.createPayment(100.0, "Invoice 123");
        System.out.println("Status: " + paymentModule.checkPaymentStatus("PAY-001"));
    }
}