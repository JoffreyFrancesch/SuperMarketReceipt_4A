package fr.esiea.model.offers;

import fr.esiea.model.Discount;
import fr.esiea.model.product.Product;
import fr.esiea.model.catalog.SupermarketCatalog;

import java.util.Map;

public interface Offer {

    Product[] getProducts();

    Discount getDiscount();

    Map<Product,Double> makeDiscount(Map<Product,Double> productQuantities, SupermarketCatalog catalog);

}

