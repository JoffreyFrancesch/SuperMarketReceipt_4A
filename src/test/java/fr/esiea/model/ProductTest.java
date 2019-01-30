package fr.esiea.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ProductTest {

    @Test
    public void testEquals () {
        Product apples = new Product("apples", ProductUnit.Kilo);
        Product raspberry = new Product("raspberry", ProductUnit.Kilo);

        //A REVOIR CAR TOUT LES CAS NE SONT PAS PASSER ;)
        Assertions.assertThat(apples.equals(apples)).isTrue();
        Assertions.assertThat(apples.equals(null)).isFalse();
        Assertions.assertThat(apples.equals(raspberry)).isFalse();
    }

    @Test
    public void testGetName(){
        Product apples = new Product("apples", ProductUnit.Kilo);
        Assertions.assertThat(apples.getName()).isEqualTo("apples");

    }

    @Test
    public void testGetUnit(){
        Product apples = new Product("apples", ProductUnit.Kilo);
        Assertions.assertThat(apples.getUnit()).isEqualTo(ProductUnit.Kilo);
    }

    @Test
    public void testHashCode(){
        Product apples = new Product("apples", ProductUnit.Kilo);
        Assertions.assertThat(apples.hashCode()).isEqualTo(Objects.hash("apples",ProductUnit.Kilo));
    }


}
