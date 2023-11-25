package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ProductManager {
    ClassLoader classLoader;
    Path productsPath;
    public ProductManager() throws URISyntaxException {
        classLoader = ProductManager.class.getClassLoader();
        productsPath= Paths.get(Objects.requireNonNull(classLoader.getResource("products.txt")).toURI());
    }
    public List<String> getAllProducts() throws URISyntaxException, IOException {

        return Files.readAllLines(productsPath, StandardCharsets.UTF_8);

    }

    public void addProduct(String product) throws URISyntaxException, IOException {
        HashSet<String> products = new HashSet<>(getAllProducts());

                if(!products.contains(product)){
                    Files.writeString(productsPath, System.lineSeparator()+ product, StandardOpenOption.APPEND);
                }else {
                    System.out.println("Pordukt jest juz na liście");
                }
    }

    public void deleteProduct(String product) throws IOException, URISyntaxException {
        HashSet<String> products = new HashSet<>(getAllProducts());

        if(product.contains(product)){
            products.remove(product);
            String productsToSave = String.join(System.lineSeparator(), products);
            Files.writeString(productsPath, productsToSave );
        }else {
            System.out.println("nie masz takiego produktu w lodówce");
        }

    }
}
