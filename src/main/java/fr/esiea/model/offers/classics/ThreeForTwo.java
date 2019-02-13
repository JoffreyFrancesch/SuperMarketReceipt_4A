package fr.esiea.model.offers.classics;

import fr.esiea.model.market.Discount;
import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.offers.Offer;

import java.util.Map;

public class ThreeForTwo implements Offer {

    public final Product product;
    private final double argument;
    private Discount discount;

    public ThreeForTwo(Product product, double argument) {
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
        double base_quantity = productQuantities.get(product);
        double base_unitPrice = catalog.getUnitPrice(product);
        int base_quantity_int = (int) base_quantity;

        int x = base_quantity_int / 3;


        if (base_quantity_int > 2) {
            double discountAmount = base_quantity * base_unitPrice - ((x * 2 * base_unitPrice) + base_quantity_int % 3 * base_unitPrice);
            discount = new Discount(product, "3 for 2", discountAmount);
        }

        productQuantities.put(product,(double)base_quantity_int%3);

        return productQuantities;
    }
}
