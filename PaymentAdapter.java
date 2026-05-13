class OldPaymentModule implements PaymentModule{
    public void oldPaymentMethod(){
        System.out.println("old Payment module API");
    }
}

interface PaymentModule{
    public void oldPaymentMethod();
}
 class Main{
    public static void main(String[] args){
        //test 
        OldPaymentModule oldPaymentModule = new OldPaymentModule();
        PaymentModule paymentModule = new PaymentAdapter(oldPaymentModule);
        paymentModule.oldPaymentMethod();
    }
 }
class PaymentAdapter implements PaymentModule{
    private OldPaymentModule oldPaymentModule;

    public PaymentAdapter(OldPaymentModule oldPaymentModule) {
        this.oldPaymentModule = oldPaymentModule;
    }

    
    public void oldPaymentMethod() {
        System.out.println("new payment module Api");
        oldPaymentModule.oldPaymentMethod();
    }

}

