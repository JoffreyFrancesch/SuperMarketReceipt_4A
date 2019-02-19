package fr.esiea.model.offers.bundles;

import fr.esiea.model.market.Discount;
import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductUnit;
import fr.esiea.model.offers.Offer;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class AmountBundle extends AbstractBundle implements Offer {

    public final Map<Product,Integer> products;
    public final double argument;
    private Discount discount = null;

    public AmountBundle(Map<Product,Integer> products, double argument) {
        this.argument = argument;
        this.products = products;
    }

    @Override
    public Map<Product, Double> makeDiscount(Map<Product, Double> productQuantities, SupermarketCatalog catalog) {
        boolean checkedQuantities = true;
        for(Map.Entry<Product,Integer> product : products.entrySet()){
            if(product.getValue() > productQuantities.get(product.getKey())){
                checkedQuantities = false;
                break;
            }
        }



        if(checkedQuantities){

            int numberOfXs =getNumberOfPacks(products,productQuantities);

            BiFunction<Integer,Double, Double> offer_function = (X, Y) -> X * Y * numberOfXs;

            double discountTotal = getTotalDiscount(products,productQuantities,catalog,numberOfXs,offer_function);

            discountTotal -= argument*numberOfXs;

            String name = products.keySet().stream().map(Product::getName).collect(Collectors.joining( " & " ));
            discount = new Discount(new Product(name, ProductUnit.Each),  "BundleOffer for " + argument, discountTotal);
        }

        return productQuantities;
    }

    @Override
    public Product[] getProducts() {
        return products.keySet().toArray(new Product[products.size()]);
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }
}
