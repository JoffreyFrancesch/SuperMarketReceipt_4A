package fr.esiea.model;

import java.util.HashMap;
import java.util.Map;

public class FakeCatalog implements SupermarketCatalog {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();

    @Override
    public void addProduct(Product product, double price) {
        this.products.put(product.getName(), product);
        this.prices.put(product.getName(), price);
    }

    @Override
    public double getUnitPrice(Product p) {
        return this.prices.get(p.getName());
    }

    @Override
    public void removeProduct(String name) {
        products.remove(name);
        prices.remove(name);
    }

    @Override
    public Map<String, Product> getProducts() {
        return products;
    }

    @Override
    public Map<String, Double> getPrices() {
        return prices;
    }
}
