package fr.esiea.model.offers;

import fr.esiea.model.market.Discount;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.catalog.SupermarketCatalog;

import java.util.Map;

public interface Offer {

    Product[] getProducts();

    Discount getDiscount();

    Map<Product,Double> makeDiscount(Map<Product,Double> productQuantities, SupermarketCatalog catalog);

}

