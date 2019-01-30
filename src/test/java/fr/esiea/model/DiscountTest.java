package fr.esiea.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    @Test
    public void testGetDescription(){
        Product apples = new Product("apples",ProductUnit.Kilo);
        Discount testDiscount = new Discount(apples, "discount for apples", 2.3);
        Assertions.assertThat(testDiscount.getDescription()).isEqualTo("discount for apples");
    }

    @Test
    public void testGetDiscountAmount(){
        Product apples = new Product("apples",ProductUnit.Kilo);
        Discount testDiscount = new Discount(apples, "discount for apples", 2.3);
        Assertions.assertThat(testDiscount.getDiscountAmount()).isEqualTo(2.3);
    }

    @Test
    public void testGetProduct(){
        Product apples = new Product("apples",ProductUnit.Kilo);
        Discount testDiscount = new Discount(apples, "discount for apples", 2.3);
        Assertions.assertThat(testDiscount.getProduct()).isEqualTo(apples);
    }


}
