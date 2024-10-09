package de.neuefische;

import java.util.HashMap;
import java.util.Map;

public class OrderMapRepo implements OrderRepoInterface {
    Map<Integer, Order> orders = new HashMap<>();


    public OrderMapRepo() {

    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }

    public OrderMapRepo(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.orderID(), order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order.orderID());
    }
}
