package org.example;

import javax.security.sasl.SaslClient;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("wybierz opcję");
            System.out.println("1. wyświetl produkty");
            System.out.println("2. dodaj produkt");
            System.out.println("3. usun produkt");
            System.out.println("4. daj mi trzy pomysły na śniadanie");
            System.out.println("5. daj mi trzy pomysły na obiad");
            System.out.println("6. poleć mi zdrowe produkty, które moge kupić");
            System.out.println();
            System.out.println("7. Koniec");

            int choice = Integer.parseInt(scanner.nextLine());
            ProductManager productManager = new ProductManager();

            switch (choice){
                case 1 -> {
                    System.out.println("Produkty: ");
                    productManager.getAllProducts().forEach(System.out::println);
                }
                case 2 ->{
                    System.out.println("Jakie produkt chcesz dodać?");
                    String product = scanner.nextLine();
                    productManager.addProduct(product);
                }
                case 3 ->{
                    System.out.println("Jaki produkt chcesz usunąć?");
                    String product = scanner.nextLine();
                    productManager.deleteProduct(product);
                }
                case 4 -> {
                    System.out.println("Pomysły na sniadanie z chatGPT");
                    ChatGTPHelper chatGTPHelper = new ChatGTPHelper();
                    String breakfastIdea = chatGTPHelper.getBreakfastIdea(productManager.getAllProducts());
                    System.out.println(breakfastIdea);
                }
                case 5 -> {
                    System.out.println("Pomysły na obiad");
                }
                case 6 -> {
                    System.out.println("Zdrowe produkty");
                }
                case 7 -> {
                    System.out.println("Dzięki za dzisiaj");
                    System.exit(0);
                }
            }
        }
    }
}