package fr.esiea.model;

import fr.esiea.model.catalog.SupermarketCatalog;
import fr.esiea.model.product.Product;
import fr.esiea.model.product.ProductUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShoppingCartTest {

    @Test
    public void addItemTestWithoutDiscount(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Product wine = new Product("wine", ProductUnit.Each);
        catalog.addProduct(wine,10.00);

        cart.addItem(wine);

        Teller teller = new Teller(catalog);
        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(10.00);

        cart.addItemQuantity(wine,2);
        receipt = teller.checksOutArticlesFrom(cart);
        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(30.00);
    }

    @Test
    public void ThreeForTwo(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Product wine = new Product("wine", ProductUnit.Each);
        catalog.addProduct(wine, 10.00);

        cart.addItemQuantity(wine,2);
        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.ThreeForTwo,wine,2.00);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(20.00);

        cart.addItemQuantity(wine,1);
        receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(20.00);

    }

    @Test
    public void TenPercentDiscount(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Product wine = new Product("wine", ProductUnit.Each);
        catalog.addProduct(wine, 10.00);

        cart.addItemQuantity(wine,1);
        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TenPercentDiscount,wine,10.00);

        Receipt receipt = teller.checksOutArticlesFrom(cart);
        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(9.00);
    }

    @Test
    public void TwoForAmount(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Product wine = new Product("wine", ProductUnit.Each);
        catalog.addProduct(wine, 10.00);

        cart.addItemQuantity(wine,1);
        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.TwoForAmount,wine,15.00);

        Receipt receipt = teller.checksOutArticlesFrom(cart);
        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(10.00);

        cart.addItemQuantity(wine,1);
        receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(15.00);
    }

    @Test
    public void FiveForAmount(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Product wine = new Product("wine", ProductUnit.Each);
        catalog.addProduct(wine, 10.00);

        Teller teller = new Teller(catalog);
        teller.addSpecialOffer(SpecialOfferType.FiveForAmount,wine,30.00);


        cart.addItemQuantity(wine,1);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(10.00);

        cart.addItemQuantity(wine,4);
        receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(30.00);

        cart.addItemQuantity(wine,1);
        receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(40.00);

    }








}
