package fr.esiea.model;

import fr.esiea.model.product.Product;
import fr.esiea.model.product.ProductUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ProductTest {

    @Test
    public void testEquals () {
        Product apples = new Product("apples", ProductUnit.Kilo);

        Discount discount = new Discount(apples,"fake description",1.00);
        Product raspberry = new Product("raspberry", ProductUnit.Kilo);
        Product apples_twin = new Product("apples", ProductUnit.Kilo);
        Product apples_each = new Product("apples", ProductUnit.Each);

        Assertions.assertThat(apples.equals(apples)).isTrue();
        Assertions.assertThat(apples.equals(null)).isFalse();
        Assertions.assertThat(apples.equals(discount)).isFalse();
        Assertions.assertThat(apples.equals(raspberry)).isFalse();
        Assertions.assertThat(apples.equals(apples_twin)).isTrue();
        Assertions.assertThat(apples.equals(apples_each)).isFalse();

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
