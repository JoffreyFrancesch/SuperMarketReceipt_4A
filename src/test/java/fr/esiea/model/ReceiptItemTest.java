package fr.esiea.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ReceiptItemTest {

    @Test
    public void testGetPrice() {
        Product product = new Product("Banana",ProductUnit.Kilo);
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

    //Need to be implemented
    /*@Test
    public void testEquals(){

    }*/
}
