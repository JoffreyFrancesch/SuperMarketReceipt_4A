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
        return new Product[]{product};
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        double quantity = productQuantities.get(product);
        int quantityAsInt = (int) quantity;

        int numberOfXs = quantityAsInt / 5;

        if(quantityAsInt >= 5){
            double unitPrice = catalog.getUnitPrice(product);

            double discountTotal = unitPrice * quantity - (argument * numberOfXs + quantityAsInt % 5 * unitPrice);
            discount = new Discount(product,"5 for " + argument, discountTotal);
        }

        productQuantities.put(product,(double)quantityAsInt % 5);
        return productQuantities;
    }
}
