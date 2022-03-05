package ie.gmit.dip;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		// InterruptedException -> java.util.concurrent.TimeUnit : Used to delay execution time within the Menu Class on Exit of Application to Display Messages
		Menu m = new Menu();
//		Amortisized Time Expansion
//		100 	-> 6		v 7
//		1000 	-> 26		v 26
//		10000 	-> 356		v 95
//		100000 	->  19511	v 1665
		m.start();
	}
}