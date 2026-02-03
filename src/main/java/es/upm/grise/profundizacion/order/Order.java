package es.upm.grise.profundizacion.order;

import java.util.ArrayList;
import java.util.Collection;

public class Order {

    private Collection<Item> items;

    /*
     * Constructor
     */
    public Order() {
        this.items = new ArrayList<>();
    }

    /*
     * Method to code / test
     */
    public void addItem(Item item) {

        for (Item existingItem : items) {

            long existingProductId = existingItem.getProduct().getId();
            long newProductId = item.getProduct().getId();

            if (existingProductId == newProductId) {
                // If product already exists, increase quantity
                existingItem.setQuantity(
                    existingItem.getQuantity() + item.getQuantity()
                );
                return;
            }
        }

        // If product does not exist, add new item
        items.add(item);
    }

    /*
     * Setters/getters
     */
    public Collection<Item> getItems() {
        return this.items;
    }
}
