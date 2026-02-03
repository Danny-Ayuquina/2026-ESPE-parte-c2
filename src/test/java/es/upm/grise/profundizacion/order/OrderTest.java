package es.upm.grise.profundizacion.order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        System.out.println("\n========================================");
        System.out.println("Inicializando nueva orden para la prueba");
        System.out.println("========================================");
    }

    @Test
    void testOrderStartsEmpty() {

        System.out.println("PRUEBA: testOrderStartsEmpty");
        System.out.println("Datos de entrada: nueva orden creada");

        int expected = 0;
        int obtained = order.getItems().size();

        System.out.println("Resultado esperado: " + expected);
        System.out.println("Resultado obtenido: " + obtained);

        assertEquals(expected, obtained);

        System.out.println("Estado de la prueba: CORRECTA ✅");
    }

    @Test
    void testAddNewItem() {

        System.out.println("PRUEBA: testAddNewItem");

        Product product = new Product();
        product.setId(1L);

        Item item = new FakeItem(product, 2, 10.0);

        System.out.println("Datos de entrada:");
        System.out.println("- Producto ID: 1");
        System.out.println("- Cantidad: 2");
        System.out.println("- Precio: 10.0");

        order.addItem(item);

        int expected = 1;
        int obtained = order.getItems().size();

        System.out.println("Resultado esperado (número de items): " + expected);
        System.out.println("Resultado obtenido (número de items): " + obtained);

        assertEquals(expected, obtained);

        System.out.println("Estado de la prueba: CORRECTA ✅");
    }

    @Test
    void testAddSameProductIncreasesQuantity() {

        System.out.println("PRUEBA: testAddSameProductIncreasesQuantity");

        Product product = new Product();
        product.setId(1L);

        Item item1 = new FakeItem(product, 2, 10.0);
        Item item2 = new FakeItem(product, 3, 10.0);

        System.out.println("Datos de entrada:");
        System.out.println("- Producto ID: 1");
        System.out.println("- Primera cantidad: 2");
        System.out.println("- Segunda cantidad: 3");

        order.addItem(item1);
        order.addItem(item2);

        Item storedItem = order.getItems().iterator().next();

        int expected = 5;
        int obtained = storedItem.getQuantity();

        System.out.println("Resultado esperado (cantidad total): " + expected);
        System.out.println("Resultado obtenido (cantidad total): " + obtained);

        assertEquals(expected, obtained);

        System.out.println("Estado de la prueba: CORRECTA ✅");
    }

    @Test
    void testAddDifferentProductsCreatesMultipleItems() {

        System.out.println("PRUEBA: testAddDifferentProductsCreatesMultipleItems");

        Product product1 = new Product();
        product1.setId(1L);

        Product product2 = new Product();
        product2.setId(2L);

        Item item1 = new FakeItem(product1, 1, 10.0);
        Item item2 = new FakeItem(product2, 1, 20.0);

        System.out.println("Datos de entrada:");
        System.out.println("- Producto ID: 1, Cantidad: 1");
        System.out.println("- Producto ID: 2, Cantidad: 1");

        order.addItem(item1);
        order.addItem(item2);

        int expected = 2;
        int obtained = order.getItems().size();

        System.out.println("Resultado esperado (número de items): " + expected);
        System.out.println("Resultado obtenido (número de items): " + obtained);

        assertEquals(expected, obtained);

        System.out.println("Estado de la prueba: CORRECTA ✅");
    }

    /*
     * Fake implementation of Item for testing purposes
     */
    private static class FakeItem implements Item {

        private final Product product;
        private int quantity;
        private final double price;

        FakeItem(Product product, int quantity, double price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public Product getProduct() {
            return product;
        }

        @Override
        public int getQuantity() {
            return quantity;
        }

        @Override
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public double getPrice() {
            return price;
        }
    }
}
