package victor.training.oo.creational.builder;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerValidatorTest {

    private CustomerValidator validator = new CustomerValidator();

    public CustomerValidatorTest() {
        System.out.println("Uaaa! Uaaa!");
    }

    @Test
    public void validCustomer() {
        validator.validate(aValidCustomer().build());
    }

    // Sharing is good, said mama
    private CustomerBuilder aValidCustomer() {
        return new CustomerBuilder()
                .withName("John Doe")
                .withAddress(aValidAddress());
    }

    private AddressBuilder aValidAddress() {
        return new AddressBuilder()
            .withCity("Cluj");
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsForNoName_nicelyDone() {
        expectedException.expectMessage("customer name");

        validator.validate(aValidCustomer().withName(null).build());
    }

    @Test(expected = CustomerValidator.CustomerWithoutStreetNameException.class)
    public void throwsForNoCity() {
        validator.validate(aValidCustomer()
                .withAddress(aValidAddress()
                        .withCity(null))
                .build());
    }

}