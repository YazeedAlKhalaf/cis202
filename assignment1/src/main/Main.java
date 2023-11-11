import java.io.IOException;
import java.util.Scanner;

public class Main {
    static LinkedList<String> menu = new LinkedList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String operation = getOperation();
        do {
            System.out.println("========");
            switch (operation) {
                case "1": insertAtFirst(); break;
                case "2": insertAtLast(); break;
                case "3": deleteAtFirst(); break;
                case "4": deleteAtLast(); break;
                case "5": search(); break;
                case "6": insertBeforeElement(); break;
                case "7": insertAfterElement(); break;
                case "8": display(); break;
                case "9": isEmpty(); break;
                case "10": countOfNodes(); break;
                case "q":
                    System.out.println("Good Bye!");
                    System.out.println("========");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry! We don't know how to handle this request, please try again.");
                    System.out.print("Click any key to continue...");
                    input.nextLine();
                    break;
            }
            System.out.println("========");
            operation = getOperation();
        } while(true);
    }

    public static String getOperation() {
        System.out.println("The LinkedList menu:");
        System.out.println("1) Insert at first");
        System.out.println("2) Insert at last");
        System.out.println("3) Delete at first");
        System.out.println("4) Delete at last");
        System.out.println("5) Search");
        System.out.println("6) Insert before element");
        System.out.println("7) Insert after element");
        System.out.println("8) Display");
        System.out.println("9) Is empty?");
        System.out.println("10) Count of nodes");
        System.out.println("q) Exit");
        System.out.print("> Choose an operation: ");

        return input.nextLine();
    }

    public static void insertAtFirst() {}

    public static void insertAtLast() {}

    public static void deleteAtFirst() {}

    public static void deleteAtLast() {}

    public static void search() {}

    public static void insertBeforeElement() {}

    public static void insertAfterElement() {}

    public static void display() {}

    public static void isEmpty() {
        System.out.println(menu.isEmpty() ? "The list is empty." : "The list is not empty.");
    }

    public static void countOfNodes() {}
}
