package fr.esiea.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ProductTest {

    @Test
    public void testEquals () {
        Product apples = new Product("apples", ProductUnit.Kilo);

        Discount discount = new Discount(apples,"fake description",1.00);
        Product raspberry = new Product("raspberry", ProductUnit.Kilo);

        Assertions.assertThat(apples.equals(apples)).isTrue();
        Assertions.assertThat(apples.equals(null)).isFalse();
        Assertions.assertThat(apples.equals(discount)).isFalse();
        // A Revoir la couverture n'est toujours pas a 100%
        Assertions.assertThat(apples.equals(raspberry)).isEqualTo(Objects.equals(apples.getName(),raspberry.getName()) && apples.getUnit() == raspberry.getUnit());

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
