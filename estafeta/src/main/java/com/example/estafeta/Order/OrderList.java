package com.example.estafeta.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

    private List<Order> orders;

    public OrderList() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
