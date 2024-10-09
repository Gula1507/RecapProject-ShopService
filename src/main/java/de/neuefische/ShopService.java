package de.neuefische;

import java.util.HashMap;
import java.util.Map;

public class ShopService {
    private OrderListRepo orderListRepo = new OrderListRepo();
    private ProductRepo productRepo = new ProductRepo();

    public ShopService() {

    }

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ShopService(OrderListRepo orderListRepo, ProductRepo productRepo) {
        this.orderListRepo = orderListRepo;
        this.productRepo = productRepo;
    }

    public ShopService(OrderListRepo orderListRepo) {
        this.orderListRepo = orderListRepo;
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "orderListRepo=" + orderListRepo +
                ", productRepo=" + productRepo +
                '}';
    }

    public Order createOrder(Product product1, int pieces) {
        if (productInCatalog(product1)) {
            int generatedOrderID = initialiseOrderID();
            int finalGeneratedOrderID = generatedOrderID;
            while (orderListRepo.getOrders().stream().anyMatch(order -> order.orderID() == finalGeneratedOrderID)) {
                generatedOrderID = initialiseOrderID();
            }
            Map<Product, Integer> orderedProducts = new HashMap<>();
            orderedProducts.put(product1, pieces);
            Order createdOrder = new Order(orderedProducts, generatedOrderID);
            orderListRepo.addOrder(createdOrder);
            return createdOrder;
        } else {
            System.out.println("There is no product with name: " + product1.name());
            return null;
        }
    }


    public Order createOrder(Map<Product, Integer> boughtProducts) {
        for (Product product : boughtProducts.keySet()) {
            if (!productInCatalog(product)) {
                System.out.println("There are no product with name: " + product.name());
                return null;
            }
        }
        int generatedOrderID = initialiseOrderID();
        int finalGeneratedOrderID = generatedOrderID;
        while (orderListRepo.getOrders().stream().anyMatch(order -> order.orderID() == finalGeneratedOrderID)) {
            generatedOrderID = initialiseOrderID();
        }
        Order createdOrder=new Order(boughtProducts, generatedOrderID);
        orderListRepo.addOrder(createdOrder);
        return new Order(boughtProducts, generatedOrderID);
    }


    private boolean productInCatalog(Product product) {
        return productRepo.productsInStore.contains(product);
    }

    private static int initialiseOrderID() {

        int min = 10000;
        int max = 90000;
        return (int) (Math.random() * (max - min) + min);
    }
}
