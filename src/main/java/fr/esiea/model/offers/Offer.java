package fr.esiea.model.offers;

import fr.esiea.model.Discount;
import fr.esiea.model.Product;
import fr.esiea.model.SupermarketCatalog;

import java.util.Map;

public interface Offer {

    Product[] getProducts();

    Discount getDiscount();

    Map<Product,Double> makeDiscount(Map<Product,Double> productQuantities, SupermarketCatalog catalog);

}

