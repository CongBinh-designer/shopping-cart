package business;
import java.util.ArrayList;
import java.io.Serializable;

public class Cart implements Serializable {
    private ArrayList<LineItem> items = new ArrayList<>();

    public Cart() { this.items = new ArrayList<>(); }

    public Cart(ArrayList<LineItem> Items) {
        this.items = Items != null ? Items : new ArrayList<>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int qty = item.getQuantity();

        for (LineItem lineitem: items) {
            if (lineitem.getProduct().getCode().equals(code)) {
                lineitem.setQuantity(lineitem.getQuantity() + qty);
                return;
            }
        }

        items.add(item);
    }

    public void removeItemById(String code) {
        for (LineItem item: items) {
            if (item.getProduct().getCode().equals(code)) {
                items.remove(item);
                return;
            }
        }
    }

    public void removeItem(LineItem item) {
        items.remove(item);
        return;
    }

    public void updateItem(LineItem item) {
        String code = item.getProduct().getCode();
        int qty = item.getQuantity();

        if (code == null) { return; }

        for (LineItem lineitem: items) {
            if (lineitem.getProduct().getCode().equals(code)) {
                lineitem.setQuantity(qty);
                return;
            }
        }
    }

    public double getCartTotal() {
        double totalCart = 0.0;
        for (LineItem item: items) {
            totalCart += item.getTotal();
        }

        return Math.round(totalCart*100.0)/100.0;
    }
}