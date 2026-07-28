package designpattern;

/*
 	The client can change the algorithm at runtime without changing the code that uses it.
 	avoid multiple if-else or switch
 */
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CashPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Cash");
    }
}

class ShoppingCart {

    private PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class Strategy {

	 public static void main(String[] args) {

	        ShoppingCart cart1 = new ShoppingCart(new CreditCardPayment());
	        cart1.checkout(5000);

	        ShoppingCart cart2 = new ShoppingCart(new UpiPayment());
	        cart2.checkout(2000);

	        ShoppingCart cart3 = new ShoppingCart(new CashPayment());
	        cart3.checkout(1000);
	    }
	 
}
