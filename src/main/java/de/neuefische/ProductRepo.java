package de.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    List<Product> productsInStore = new ArrayList<>();

    public ProductRepo() {
    }

    public ProductRepo(List<Product> products) {
        this.productsInStore = products;
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + productsInStore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductRepo that)) return false;
        return Objects.equals(productsInStore, that.productsInStore);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productsInStore);
    }

    public List<Product> getProductsInStore() {
        return productsInStore;
    }

    public void setProductsInStore(List<Product> productsInStore) {
        this.productsInStore = productsInStore;
    }

    public void addProduct(Product product) {
        productsInStore.add(product);
    }

    public void removeProduct(Product product) {
        productsInStore.remove(product);
    }

    public Product getProduct(String productName) {
        return productsInStore.stream().filter(p-> p.name().equals(productName)).findAny().orElse(null);
    }
}
