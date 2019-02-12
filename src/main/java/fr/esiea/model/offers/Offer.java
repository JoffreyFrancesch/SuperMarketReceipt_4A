package fr.esiea.model.offers;

import fr.esiea.model.Discount;
import fr.esiea.model.Product;
import fr.esiea.model.SupermarketCatalog;

import java.util.Map;

public interface Offer {

    Product[] getProducts();

    Discount getDiscount();

    Map<Product,Discount> makeDiscount(Map<Product,Discount> items, SupermarketCatalog catalog);

}

