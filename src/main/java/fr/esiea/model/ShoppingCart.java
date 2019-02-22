package fr.esiea.model;

import fr.esiea.model.market.Discount;
import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductQuantity;
import fr.esiea.model.offers.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final List<ProductQuantity> items = new ArrayList<>();
    private Map<Product, Double> productQuantities = new HashMap<Product,Double>();


    List<ProductQuantity> getItems() {
        return new ArrayList<>(items);
    }

    void addItem(Product product) {
        this.addItemQuantity(product, 1.0);
    }

    public Map<Product, Double> productQuantities() {
        return productQuantities;
    }


    public void addItemQuantity(Product product, double quantity) {
        items.add(new ProductQuantity(product, quantity));
        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.get(product) + quantity);
        } else {
            productQuantities.put(product, quantity);
        }
    }

    void handleOffers(Receipt receipt, Map<Product[], Offer> offers, SupermarketCatalog catalog) {

        Map<Product,Double> products = productQuantities();

        boucle:
        for (Map.Entry<Product[],Offer> offer : offers.entrySet()){
            for (Product p : offer.getKey()){
                if(!products.containsKey(p)){
                    continue boucle;
                }
            }

            products = offer.getValue().makeDiscount(products,catalog);

            Discount discount = offer.getValue().getDiscount();

            if (discount != null) {
                receipt.addDiscount(discount);
            }
        }
    }
}
