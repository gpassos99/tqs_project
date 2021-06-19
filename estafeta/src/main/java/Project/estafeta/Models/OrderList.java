package Project.estafeta.Models;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

    private List<Order> orders;

    public OrderList() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
