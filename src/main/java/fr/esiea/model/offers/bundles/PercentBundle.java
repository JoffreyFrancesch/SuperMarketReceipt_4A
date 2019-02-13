package fr.esiea.model.offers.bundles;

import fr.esiea.model.Discount;
import fr.esiea.model.catalog.SupermarketCatalog;
import fr.esiea.model.offers.Offer;
import fr.esiea.model.product.Product;

import java.util.Map;

public class PercentBundle extends AbstractBundle implements Offer {

    public final Map<Product,Integer> products;
    public final double argument;
    private Discount discount;

    public PercentBundle(Map<Product, Integer> products, double argument) {
        this.products = products;
        this.argument = argument;
    }

    @Override
    public Product[] getProducts() {
        return products.keySet().toArray(new Product[products.size()]);
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    //TODO NEED TO BE IMPLEMENTED
    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        return null;
    }
}
