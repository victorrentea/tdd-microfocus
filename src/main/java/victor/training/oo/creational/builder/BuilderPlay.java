package victor.training.oo.creational.builder;

//import java.util.ArrayList; // INITIAL
//import java.util.List; // INITIAL

import java.util.ArrayList;
import java.util.List;

public class BuilderPlay {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setName("John Doe");
		List<String> labels = new ArrayList<String>();
		labels.add("Label1");
		customer.setLabels(labels);
		Address address = new Address();
		address.setStreetName("Viorele");
		address.setStreetNumber(4);
		address.setCity("Bucharest");
		customer.setAddress(address);
	}
}
