package fr.esiea.model;

import fr.esiea.ReceiptPrinter;

import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SupermarketTest {

    @Test
    public void testSomething() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.Each);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.Kilo);
        catalog.addProduct(apples, 1.99);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(apples, 2.5);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TenPercentDiscount, toothbrush, 10.0);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(4.975);
    }

    @Test
    public void testReceiptPrinter() {
        SupermarketCatalog catalog = new FakeCatalog();
        Product toothbrush = new Product("toothbrush", ProductUnit.Each);
        catalog.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.Kilo);
        catalog.addProduct(apples, 1.99);

        ShoppingCart cart = new ShoppingCart();
        cart.addItemQuantity(apples, 2.5);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TenPercentDiscount, toothbrush, 10.0);

        Receipt receipt = teller.checksOutArticlesFrom(cart);
        receipt.addDiscount(new Discount(apples, "Reduction pomme", 0.3));

        Assertions.assertThat(new ReceiptPrinter().printReceipt(receipt)).isNotBlank();
    }

    @Test
    public void testProductClass () {
        Product apples = new Product("apples", ProductUnit.Kilo);
        Product raspberry = new Product("raspberry", ProductUnit.Kilo);

        Assertions.assertThat(apples.getName()).isEqualTo("apples");
        Assertions.assertThat(apples.equals(apples)).isTrue();
        Assertions.assertThat(apples.equals(null)).isFalse();
        Assertions.assertThat(apples.equals(raspberry)).isFalse();
        
        
        Assertions.assertThat(apples.getUnit()).isEqualTo(ProductUnit.Kilo);
        Assertions.assertThat(apples.hashCode()).isEqualTo(Objects.hash("apples",ProductUnit.Kilo));
    }



    @Test
    public void testOfferClass(){
        Product haribo = new Product("haribo", ProductUnit.Kilo);
        Offer hariboOffer = new Offer(SpecialOfferType.FiveForAmount, haribo, 7.99);
        Assertions.assertThat(hariboOffer.getProduct()).isEqualTo(haribo);
        Assertions.assertThat(hariboOffer.argument).isEqualTo(7.99);
        Assertions.assertThat(hariboOffer.offerType).isEqualTo(SpecialOfferType.FiveForAmount);
    }

    @Test
    public void testProductQuantityClass(){
        Product chikenWings = new Product("Chiken Wings", ProductUnit.Kilo);
        ProductQuantity chikenQty = new ProductQuantity(chikenWings, 20.500);
        Assertions.assertThat(chikenQty.getQuantity()).isEqualTo(20.500);
        Assertions.assertThat(chikenQty.getProduct()).isEqualTo(chikenWings);
    }
}
