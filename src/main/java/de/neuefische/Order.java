package de.neuefische;

import java.util.Map;

public record Order(
        Map<Product, Integer> orderedProducts,
        int orderID

) {
}
