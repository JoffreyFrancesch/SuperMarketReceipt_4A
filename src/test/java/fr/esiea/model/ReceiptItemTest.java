package fr.esiea.model;

import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ReceiptItemTest {

    @Test
    public void testGetPrice() {
        Product product = new Product("Banana", ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(product,10.00,1.50, 15.00);
        Assertions.assertThat(receiptItem.getPrice()).isEqualTo(1.50);
    }

    @Test
    public void testGetProduct(){
        Product product = new Product("Banana",ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(product,10.00,1.50, 15.00);
        Assertions.assertThat(receiptItem.getProduct()).isEqualTo(product);
    }

    @Test
    public void testGetQuantity(){
        Product product = new Product("Banana",ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(product,10.00,1.50, 15.00);
        Assertions.assertThat(receiptItem.getQuantity()).isEqualTo(10.00);
    }

    @Test
    public void testGetTotalPrice(){
        Product product = new Product("Banana",ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(product,10.00,1.50, 15.00);
        Assertions.assertThat(receiptItem.getTotalPrice()).isEqualTo(15.00);
    }

    @Test
    public void testGetHashCode(){
        Product product = new Product("Banana",ProductUnit.Kilo);
        ReceiptItem receiptItem = new ReceiptItem(product,10.00,1.50, 15.00);
        Assertions.assertThat(receiptItem.hashCode()).isEqualTo(Objects.hash(product, 1.50, 15.00, 10.00));
    }

    @Test
    public void testEquals(){
        Product product = new Product("Cacao",ProductUnit.Kilo);
        Product productB = new Product("Chocolate",ProductUnit.Kilo);

        ReceiptItem receiptItem = new ReceiptItem(product,10.00,1.50, 15.00);

        ReceiptItem receiptItem1 = new ReceiptItem(productB,10.00,1.50, 15.00);
        ReceiptItem receiptItem2 = new ReceiptItem(product,11.00,1.50, 15.00);
        ReceiptItem receiptItem3 = new ReceiptItem(product,10.00,2.00, 15.00);
        ReceiptItem receiptItem4 = new ReceiptItem(product,10.00,1.50, 20.00);
        ReceiptItem receiptItem_twin = new ReceiptItem(product,10.00,1.50, 15.00);


        Assertions.assertThat(receiptItem.equals(receiptItem)).isTrue();
        Assertions.assertThat(receiptItem.equals(null)).isFalse();
        Assertions.assertThat(receiptItem.equals(product)).isFalse();

        Assertions.assertThat(receiptItem.equals(receiptItem1)).isFalse();
        Assertions.assertThat(receiptItem.equals(receiptItem2)).isFalse();
        Assertions.assertThat(receiptItem.equals(receiptItem3)).isFalse();
        Assertions.assertThat(receiptItem.equals(receiptItem4)).isFalse();
        Assertions.assertThat(receiptItem.equals(receiptItem_twin)).isTrue();
    }
}
