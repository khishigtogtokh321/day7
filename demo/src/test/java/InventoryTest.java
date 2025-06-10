import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Inventory;
import com.example.Product;

class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    // too shirheg 0 uyd zuw nemegdej bui shalgana
    void testAddProductWithZeroQuantity() {
        Product p = new Product("Бат", "Scanner", "S001", 0, 150000);
        inventory.addProduct(p);

        assertEquals(1, inventory.getProducts().size());
        assertEquals(0, inventory.getProducts().get(0).getQuantity());
   }
//    surug too shirheg oruulah uyrd aldaa zaan
    @Test
    void testAddProductWithNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product p = new Product("Бат", "Printer", "P001", -5, 200000);
            inventory.addProduct(p);
    });
}
// hooson too shirheg oruulah uyd 
   @Test
    void testGetProductFromEmptyInventory() {
        Product request = new Product("Сараа", "Mouse", "M005", 1, 30000);
        boolean result = inventory.getProduct(request);

        assertFalse(result);
        assertEquals(0, inventory.getProducts().size());
   }
// baraa yg tootoi tentsuugeer ywahad nuuts 0
   @Test
    void testGetProductWithExactQuantity() {
        Product p = new Product("Бат", "Headset", "H001", 3, 80000);
        inventory.addProduct(p);

        Product request = new Product("Сараа", "Headset", "H001", 3, 80000);
        boolean success = inventory.getProduct(request);

        assertTrue(success);
        assertEquals(0, inventory.getProducts().get(0).getQuantity());
    }

    @Test
    void testGetProductNonExistingCode() {
        Product p = new Product("Бат", "Camera", "C001", 4, 500000);
        inventory.addProduct(p);

        Product request = new Product("Сараа", "Camera", "C999", 1, 500000);
        boolean result = inventory.getProduct(request);

        assertFalse(result);
        assertEquals(4, inventory.getProducts().get(0).getQuantity());
    }



    @Test
    void testAddNewProduct() {
        Product p = new Product("Бат", "Printer", "P001", 5, 200000);
        inventory.addProduct(p);

        assertEquals(1, inventory.getProducts().size());
        assertEquals(5, inventory.getProducts().get(0).getQuantity());
    }

    @Test
    void testAddExistingProductIncreasesQuantity() {
        Product p1 = new Product("Бат", "Printer", "P001", 5, 200000);
        Product p2 = new Product("Бат", "Printer", "P001", 3, 200000);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        assertEquals(1, inventory.getProducts().size());
        assertEquals(8, inventory.getProducts().get(0).getQuantity());
    }

    @Test
    void testGetProductSuccessfully() {
        Product p = new Product("Бат", "Monitor", "M001", 10, 300000);
        inventory.addProduct(p);

        Product requested = new Product("Сараа", "Monitor", "M001", 5, 300000);
        boolean success = inventory.getProduct(requested);

        assertTrue(success);
        assertEquals(5, inventory.getProducts().get(0).getQuantity());
    }

    @Test
    void testGetProductFailsIfInsufficientStock() {
        Product p = new Product("Бат", "Monitor", "M001", 2, 300000);
        inventory.addProduct(p);

        Product requested = new Product("Сараа", "Monitor", "M001", 5, 300000);
        boolean success = inventory.getProduct(requested);

        assertFalse(success);
        assertEquals(2, inventory.getProducts().get(0).getQuantity());
    }

}
