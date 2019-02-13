package fr.esiea.model;

import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OfferTest {


    @Test
    public void testGetProduc(){
        Product haribo = new Product("haribo", ProductUnit.Kilo);
        Offer hariboOffer = new Offer(SpecialOfferType.FiveForAmount, haribo, 7.99);
        Assertions.assertThat(hariboOffer.getProduct()).isEqualTo(haribo);
    }

    @Test
    public void testArgument(){
        Product haribo = new Product("haribo", ProductUnit.Kilo);
        Offer hariboOffer = new Offer(SpecialOfferType.FiveForAmount, haribo, 7.99);
        Assertions.assertThat(hariboOffer.argument).isEqualTo(7.99);
    }


    @Test
    public void testOfferType(){
        Product haribo = new Product("haribo", ProductUnit.Kilo);
        Offer hariboOffer = new Offer(SpecialOfferType.FiveForAmount, haribo, 7.99);
        Assertions.assertThat(hariboOffer.offerType).isEqualTo(SpecialOfferType.FiveForAmount);
    }
}
