package fr.esiea.model.offers.bundles;

import fr.esiea.model.catalog.SupermarketCatalog;
import fr.esiea.model.product.Product;

import java.util.Map;
import java.util.function.BiFunction;

public class AbstractBundle {

    protected int getNumberOfPacks(Map<Product,Integer> products, Map<Product, Double> items){
        int numberOfXs = 100;
        for (Map.Entry<Product,Integer> productIntegerEntry : products.entrySet()){
            int x = productIntegerEntry.getValue();
            double quantity = items.get(productIntegerEntry.getKey());
            int quantityAsInt = (int) quantity;

            numberOfXs = Math.min(numberOfXs,quantityAsInt/x);
        }
        return numberOfXs;
    }

    protected double getTotalDiscount(Map<Product,Integer> products, Map<Product,Double> items, SupermarketCatalog catalog, int numberOfXs, BiFunction<Integer,Double,Double> offerFunction){
        double discountTotal = 0;
        for (Map.Entry<Product,Integer> productIntegerEntry : products.entrySet()){
            Product product = productIntegerEntry.getKey();
            int quantityOffer = productIntegerEntry.getValue();

            double quantity = items.get(product);
            double unitPrice = catalog.getUnitPrice(product);

            discountTotal = discountTotal + offerFunction.apply(quantityOffer,unitPrice);

            items.put(product,quantity - quantityOffer * numberOfXs);
        }
        return discountTotal;
    }
}
