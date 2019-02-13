package fr.esiea.model.offers;

import fr.esiea.model.Discount;
import fr.esiea.model.Product;
import fr.esiea.model.SupermarketCatalog;

import java.util.Map;

public class TwoForAmount implements Offer {

    public final Product product;
    public final double argument;
    private Discount discount;

    public TwoForAmount(Product product, double argument) {
        this.product = product;
        this.argument = argument;
    }

    @Override
    public Product[] getProducts() {
        return new Product[]{product};
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    //TODO
    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        return null;
    }
}
