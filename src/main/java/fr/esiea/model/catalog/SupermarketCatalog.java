package fr.esiea.model.catalog;

import fr.esiea.model.product.Product;

import java.util.Map;

public interface SupermarketCatalog {
    void addProduct(Product product, double price);

    double getUnitPrice(Product product);

    void removeProduct(String name);

    Map<String, Product> getProducts();

    Map<String, Double> getPrices();
}
