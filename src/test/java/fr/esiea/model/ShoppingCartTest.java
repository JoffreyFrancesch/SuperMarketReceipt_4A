package fr.esiea.model;

import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductUnit;
import fr.esiea.model.offers.bundles.PercentBundle;
import fr.esiea.model.offers.classics.Percent;
import fr.esiea.model.offers.classics.ThreeForTwo;
import fr.esiea.model.offers.classics.TwoForAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


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
    public void ThreeForTwoRefactoring(){
        Product ketchup = new Product("ketchup", ProductUnit.Each);

        SupermarketCatalog catalog = new FakeCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart cart = new ShoppingCart();

        catalog.addProduct(ketchup,3);
        cart.addItemQuantity(ketchup,3);

        teller.addSpecialOffer(new ThreeForTwo(ketchup,10));

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(6);
    }

    @Test
    public void TenPercentRefactoring(){
        Product apples = new Product("apples", ProductUnit.Kilo);

        SupermarketCatalog catalog = new FakeCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart cart = new ShoppingCart();

        catalog.addProduct(apples, 10);
        teller.addSpecialOffer(new Percent(apples, 10));
        cart.addItem(apples);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(9);
    }

    @Test
    public void TwoForAmountRefactoring(){
        Product wine = new Product("wine", ProductUnit.Each);

        SupermarketCatalog catalog = new FakeCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart cart = new ShoppingCart();

        catalog.addProduct(wine, 10);
        teller.addSpecialOffer(new TwoForAmount(wine, 15));
        cart.addItemQuantity(wine,2);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(15);
    }

    @Test
    public void FiveForAmountRefactoring(){
        Product wine = new Product("wine", ProductUnit.Each);

        SupermarketCatalog catalog = new FakeCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart cart = new ShoppingCart();

        catalog.addProduct(wine, 10);
        //teller.addSpecialOffer(new FiveForAmount(wine,35));
        cart.addItemQuantity(wine,5);

        Receipt receipt = teller.checksOutArticlesFrom(cart);

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(35);
    }

    @Test
    public void PercentBundleRefactoring(){
        Product mayo = new Product("mayo", ProductUnit.Each);
        Product ketchup = new Product("ketchup", ProductUnit.Each);

        SupermarketCatalog catalog = new FakeCatalog();
        Teller teller = new Teller(catalog);
        ShoppingCart cart = new ShoppingCart();

        catalog.addProduct(ketchup, 1);
        catalog.addProduct(mayo, 1);

        Map<Product,Integer> products = new HashMap<Product,Integer>();
        products.put(ketchup,2);
        products.put(mayo,1);

        teller.addSpecialOffer(new PercentBundle(products,50));


        cart.addItemQuantity(ketchup, 2);
        cart.addItemQuantity(mayo,1);

        Receipt receipt = teller.checksOutArticlesFrom(cart);
        double current = receipt.getTotalPrice();

        Assertions.assertThat(receipt.getTotalPrice()).isEqualTo(1.50);
    }

    @Test
    public void AmountBundleRefactoring(){
        //TODO NEED TO BE IMPLEMENTED
    }










}
