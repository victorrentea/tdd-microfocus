package victor.training.oo.creational.builder;

public class AddressBuilder {
	private final Address address = new Address();

	public AddressBuilder withStreetName(String streetName) {
		address.setStreetName(streetName);
		return this;
	}
	

	public Address build() {
		return address;
	}
}