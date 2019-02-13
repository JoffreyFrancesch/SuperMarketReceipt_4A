import fr.esiea.ReceiptPrinter;
import fr.esiea.model.*;
import fr.esiea.model.catalog.SupermarketCatalog;
import fr.esiea.model.product.Product;
import fr.esiea.model.product.ProductUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptPrinterTest {

    @Test
    public void testPrinter(){
        SupermarketCatalog catalog = new FakeCatalog();
        ShoppingCart cart = new ShoppingCart();

        Product wine = new Product("wine", ProductUnit.Each);
        Product beer = new Product("beer",ProductUnit.Each);
        Product apple = new Product("Apple",ProductUnit.Kilo);

        catalog.addProduct(wine, 10.00);
        catalog.addProduct(beer, 5.00);
        catalog.addProduct(apple, 0.50);


        Teller teller = new Teller(catalog);
        cart.addItemQuantity(wine,1);
        cart.addItemQuantity(beer,2);
        cart.addItemQuantity(apple,5);



        Receipt receipt = teller.checksOutArticlesFrom(cart);
        ReceiptPrinter printer = new ReceiptPrinter();

        Assertions.assertThat(printer.printReceipt(receipt)).isNotBlank();
    }
}
