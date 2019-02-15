package fr.esiea.model;

import fr.esiea.model.market.catalog.SupermarketCatalog;
import fr.esiea.model.market.product.Product;
import fr.esiea.model.market.product.ProductQuantity;
import fr.esiea.model.offers.Offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teller {

    private final SupermarketCatalog catalog;
    private Map<Product[], Offer> offers = new HashMap<Product[],Offer>();

    public Teller(SupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    public void addSpecialOffer(Offer offer) {
        this.offers.put(offer.getProducts(), offer);
    }

    public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
        Receipt receipt = new Receipt();
        List<ProductQuantity> productQuantities = theCart.getItems();
        for (ProductQuantity pq: productQuantities) {
            Product p = pq.getProduct();
            double quantity = pq.getQuantity();
            double unitPrice = this.catalog.getUnitPrice(p);
            double price = quantity * unitPrice;
            receipt.addProduct(p, quantity, unitPrice, price);
        }
        theCart.handleOffers(receipt, this.offers, this.catalog);

        return receipt;
    }

}
