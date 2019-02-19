package fr.esiea.model.offers.classics;

import fr.esiea.model.market.Discount;
import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.offers.Offer;

import java.util.Map;

public class FiveForAmount implements Offer {

    public final Product product;
    public final double argument;
    private Discount discount;

    public FiveForAmount(Product product, double argument) {
        this.product = product;
        this.argument = argument;
    }

    @Override
    public Product[] getProducts() {
        return new Product[0];
    }

    @Override
    public Discount getDiscount() {
        return null;
    }

    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        return null;
    }
}
