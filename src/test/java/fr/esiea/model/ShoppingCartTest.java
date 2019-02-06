package fr.esiea.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShoppingCartTest {

    @Test
    public void addItemTestWithoutDiscount(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Product wine = new Product("wine", ProductUnit.Kilo);
        catalog.addProduct(wine,10.00);

        cart.addItem(wine);

        Teller teller = new Teller(catalog);
        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(10.00);

        cart.addItemQuantity(wine,2);
        receipt = teller.checksOutArticlesFrom(cart);
        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(30.00);
    }




}
