package fr.esiea.model.offers.bundles;

import fr.esiea.model.market.Discount;
import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.ProductUnit;
import fr.esiea.model.offers.Offer;
import fr.esiea.model.market.product.Product;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

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

    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> items, SupermarketCatalog catalog) {

        boolean presentQuantities = true;
        for(Map.Entry<Product,Integer> product : products.entrySet()){
            if(product.getValue() > items.get(product.getKey())){
                presentQuantities = false;
                break;
            }
        }

        if(presentQuantities){
            int numberOfXs = getNumberOfPacks(products,items);

            BiFunction<Integer,Double, Double> offerFunction = (X, Y) -> X * Y * numberOfXs * (100 - argument)/100;

            double discountTotal = getTotalDiscount(products,items,catalog,numberOfXs,offerFunction);

            String name = products.keySet().stream().map(Product::getName).collect(Collectors.joining( " & " ));
            Product p = new Product(name, ProductUnit.Each);
            discount = new Discount(p,  "Bundle Percent Offer for " + argument, discountTotal);
        }

        return items;
    }
}
