import java.util.Scanner;




/**
 * Link Shortener Application
 * Author: Sarada pradhan 
 * Date: 04/01/2024
 */


public class CLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShortenerService shortenerService = new ShortenerService();

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longURL = scanner.nextLine();
                    String shortURL = shortenerService.shortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;

                case 2:
                    System.out.print("Enter the short URL: ");
                    String inputShortURL = scanner.nextLine();
                    String expandedURL = shortenerService.expandURL(inputShortURL);
                    System.out.println("Expanded URL: " + expandedURL);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
