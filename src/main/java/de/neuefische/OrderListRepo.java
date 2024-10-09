package de.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepoInterface{
    List<Order> orders = new ArrayList<>();

    public OrderListRepo() {

    }

    public OrderListRepo(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderListRepo that)) return false;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public Order getOrder(int orderIdToFind) {
        return orders.stream().filter(o->o.orderID()==orderIdToFind).findAny().orElse(null);
    }

}
