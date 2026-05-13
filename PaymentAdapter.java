interface PaymentModule{
    public void oldPaymentMethod();
}



class OldPaymentModule implements PaymentModule{
    public void oldPaymentMethod(){
        System.out.println("old Payment module API");
    }
}


//  данный адаптер позволяет использовать новый модуль поверх старого, не меня при этом исходный код.
class PaymentAdapter implements PaymentModule{
    private OldPaymentModule oldPaymentModule;

    public PaymentAdapter(OldPaymentModule oldPaymentModule) {
        this.oldPaymentModule = oldPaymentModule;
    }

    
    public void oldPaymentMethod() {
        System.out.println("new payment module Api"); // мы пишем обертку над старым методом сохраняя исходник. 
        // oldPaymentModule.oldPaymentMethod(); при желании так же можно оставить и старый модуль. 
    }


}



 class Main{
    public static void main(String[] args){
        //test 
        OldPaymentModule oldPaymentModule = new OldPaymentModule();
        PaymentModule paymentModule = new PaymentAdapter(oldPaymentModule);
        paymentModule.oldPaymentMethod();
    }
 }
