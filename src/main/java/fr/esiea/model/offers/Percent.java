package fr.esiea.model.offers;

import fr.esiea.model.Discount;
import fr.esiea.model.Product;
import fr.esiea.model.SupermarketCatalog;

import java.util.Map;

public class Percent implements Offer {

    public final Product product;
    public final double argument;
    private Discount discount;

    public Percent(Product product, double argument) {
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

    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        double quantity = productQuantities.get(product);
        double unitPrice = catalog.getUnitPrice(product);

        discount = new Discount(product, argument + "% off", quantity * unitPrice * argument / 100.0);

        productQuantities.remove(product);
        return productQuantities;
    }
}
