package de.neuefische;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Product productInStore1 = new Product("Schere", new BigDecimal("9.95"));
        Product productInStore2 = new Product("Stift", new BigDecimal("4.95"));
        List<Product> productsInStore = Arrays.asList(productInStore1, productInStore2);
        ProductRepo productRepo = new ProductRepo();

        productRepo.setProductsInStore(productsInStore);
        System.out.println(productRepo.getProduct("Schere"));
        System.out.println(productRepo.getProduct("Sofa"));

        ShopService shopService = new ShopService(productRepo);
        shopService.createOrder(productInStore1, 1);
        System.out.println(shopService);


        Product productNotInStore = new Product("Sofa", new BigDecimal("995.50"));
        shopService.createOrder(productNotInStore, 1);

    }

}