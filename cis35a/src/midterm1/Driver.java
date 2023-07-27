package midterm1;

public class Driver {

	public static void main(String[] args) {

		Order order1 = new Order();

		order1.displayMenu();

		order1.getInputs();

		order1.calculate();

		order1.printBill();
	}

}
