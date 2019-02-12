package victor.training.oo.creational.builder;

//import java.util.ArrayList; // INITIAL
//import java.util.List; // INITIAL

import java.util.ArrayList;
import java.util.List;

public class BuilderPlay {

    public static void main(String[] args) {


        Customer customer = new CustomerBuilder()
                .withName("John Doe")
                .withLabel("Label1")
                .withAddress(new AddressBuilder()
                        .withStreetName("Viorele")
                        .withStreetNumber(4)
                        .withCity("Cluj")
                        .build())
                .build();
    }
}
