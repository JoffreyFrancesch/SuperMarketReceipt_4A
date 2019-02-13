package fr.esiea.model;

import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductQuantity;
import fr.esiea.model.market.product.ProductUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductQuantityTest {

    @Test
    public void testGetProduct(){
        Product chikenWings = new Product("Chiken Wings", ProductUnit.Kilo);
        ProductQuantity chikenQty = new ProductQuantity(chikenWings, 20.500);
        Assertions.assertThat(chikenQty.getProduct()).isEqualTo(chikenWings);
    }

    @Test
    public void testGetQuantity(){
        Product chikenWings = new Product("Chiken Wings", ProductUnit.Kilo);
        ProductQuantity chikenQty = new ProductQuantity(chikenWings, 20.500);
        Assertions.assertThat(chikenQty.getQuantity()).isEqualTo(20.500);
    }
}
