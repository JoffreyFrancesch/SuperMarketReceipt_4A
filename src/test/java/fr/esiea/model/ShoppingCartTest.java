package fr.esiea.model;

import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductUnit;
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
    public void ThreeForTwoRefactoring(){
        //TODO NEED TO BE IMPLEMENTED
    }

    @Test
    public void TenPercentRefactoring(){
        //TODO NEED TO BE IMPLEMENTED
    }

    @Test
    public void TwoForAmountRefactoring(){
        //TODO NEED TO BE IMPLEMENTED
    }

    @Test
    public void FifForAmountRefactoring(){
        //TODO NEED TO BE IMPLEMENTED
    }

    @Test
    public void PercentBundleRefactoring(){
        //TODO NEED TO BE IMPLEMENTED
    }

    @Test
    public void AmountBundleRefactoring(){
        //TODO NEED TO BE IMPLEMENTED
    }










}
