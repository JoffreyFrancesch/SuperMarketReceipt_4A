package fr.esiea.model.offers.classics;

import fr.esiea.model.market.Discount;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.offers.Offer;

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
    
    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        double quantity = productQuantities.get(product);
        double unitPrice = catalog.getUnitPrice(product);
        int quantityAsInt = (int) quantity;

        int numberOfXs = quantityAsInt / 2;

        if(quantityAsInt >= 2){
            double total = argument * numberOfXs + quantityAsInt % 2 * unitPrice;
            double discountN = unitPrice * quantity - total;
            discount = new Discount(product, "2 for " + argument, discountN);
        }

        productQuantities.put(product,(double)quantityAsInt % 2);

        return productQuantities;
    }
}
